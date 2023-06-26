import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.logging.Level;

public class SocketUDP extends Thread {
    private DatagramSocket socket;
    private InetAddress client;
    private File folder;
    private List<File> files;
    private Map<String,List<Byte>> receberFicheiros = new HashMap<>();
    private boolean temp = false;
    private final int porta = 3000;
    private final int bytesReserva = 264;
    private final int bytesSize = bytesReserva + 5000;
    private final Map<String,Date> mapa = new HashMap<>();//tempo de tranferencia
    private final Map<String,Integer> mapa2 = new HashMap<>();//taxa de tranferencia


    public SocketUDP(File folder, InetAddress client){
        try {
            this.socket = new DatagramSocket(porta);
            Main.logger.info("Socket UDP aberto na porta 3000.");
            this.folder = folder;
            this.client = client;
        } catch (SocketException e) {
            Main.logger.severe("Erro ao criar a porta.");
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        // primeiro byte - tipo de mensagem (0 - controlo, 1 - data)
        // 0 controlo
        // restantes bytes sao o nome dos ficheiros separados por ;
        //
        // 1 Data
        //  255 - Nome do ficheiro (255 limite de cada componente de uma diretoria)
        //  4 - Número de partes (-2147483648 to 2147483647)(Int)
        //  4 - Número da parte que está a ser enviada
        //  restantes sao os bytes do ficheiro.

        /*new Thread(() -> {
            
        }).start();*/

        new Thread(() -> {
            Date date = new Date();
            while(true){
                Date agora = new Date();
                if(date.getTime() + 1500 >= agora.getTime() && !temp){
                    date = agora;
                    updateFiles();
                    if(receberFicheiros.size() == 0){ // Se não está a receber ficheiros, está a enviar mensagens de controlo
                        byte[] status = new byte[bytesSize];
                        status[0] = 0;
                        StringBuilder ficheiros = new StringBuilder();
                        for(File file : this.files)
                            ficheiros.append(file.getName()).append(';');
                        if(ficheiros.length() > 0)
                            ficheiros.setLength(ficheiros.length()-1);
                        byte[] bytes = ficheiros.toString().getBytes(StandardCharsets.US_ASCII);
                        for(int i = 1; i < status.length && (i-1) < bytes.length; i++)
                            status[i] = bytes[i-1];
                        sendBytes(status);
                    }
                }
            }
        }).start();

        while(true){
            byte[] buffer = new byte[bytesSize];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            while (true) {
                try {
                    this.socket.receive(packet);
                    temp = true;
                    byte[] bytes = packet.getData();
                    if(bytes[0] == 0){
                        byte[] data = Arrays.copyOfRange(bytes, 1, bytes.length);
                        String ficheiros = new String(data, StandardCharsets.US_ASCII);
                        List<String> nomes = List.of(ficheiros.split(";"));
                        for(File f : this.files){
                            String fName = f.getName();
                            Main.logger.info(fName);
                            if(!nomes.contains(fName)){
                                new Thread(() -> {
                                    try {
                                        byte[] b = Files.readAllBytes(f.toPath());
                                        int bytesEnviados = 0;
                                        byte[] nome = fName.getBytes(StandardCharsets.US_ASCII);
                                        int partes = (int) Math.ceil((double) b.length / ((double) this.bytesSize - (double) this.bytesReserva));
                                        byte[] partes1 = ByteBuffer.allocate(4).putInt(partes).array();
                                        for(int i = 0; i < partes; i++){
                                            byte[] packetFicheiro = new byte[bytesSize];
                                            packetFicheiro[0] = 1;
                                            for(int j = 0; j < fName.length() && j < 256; j++){
                                                packetFicheiro[j+1] = nome[j];
                                            }
                                            byte[] id = ByteBuffer.allocate(4).putInt(i).array();
                                            for(int j = 0, p = 257; j < 4; j++){
                                                packetFicheiro[p] = partes1[j];
                                                packetFicheiro[p+4] = id[j];
                                                p++;
                                            }
                                            for(int p = 265; p < packetFicheiro.length && bytesEnviados < b.length; p++){
                                                packetFicheiro[p] = b[bytesEnviados++];
                                            }
                                            sendBytes(packetFicheiro);
                                            try{
                                                Thread.sleep(100);
                                            }catch(Exception e){

                                            }
                                        }
                                    } catch (IOException e) {
                                        Main.logger.log(Level.SEVERE, "Erro!", e);
                                    }
                                }).start();
                            }
                        }
                    }else if(bytes[0] == 1){

                        byte[] nome = Arrays.copyOfRange(bytes, 1, 257);
                        
                        int nomeLen = 0;
                        for (byte b : nome) {
                            if (b == 0) break;
                            else nomeLen++;
                        }
                        byte[] partes = Arrays.copyOfRange(bytes, 257, 261);
                        byte[] id = Arrays.copyOfRange(bytes, 261, 265);
                        byte[] data = Arrays.copyOfRange(bytes, 265, bytes.length+1);
                        String n = new String(nome, StandardCharsets.US_ASCII).substring(0, nomeLen);
                        int p = ByteBuffer.wrap(partes).getInt();
                        int i = ByteBuffer.wrap(id).getInt();
                        byte[] byteList = new byte[p * (this.bytesSize-this.bytesReserva)];
                        int l = 0;
                        if (!mapa.containsKey(n)) {
                            this.mapa.put(n,new Date());

                        }
                        if (!mapa2.containsKey(n)) {
                            mapa2.put(n,0);
                        }

                        if(this.receberFicheiros.containsKey(n)){
                            List<Byte> list = receberFicheiros.get(n);
                            for(Byte b : list){
                                byteList[l++] = b;
                                mapa2.put(n,mapa2.get(n)+1);
                            }
                        }

                        System.arraycopy(data, 0, byteList, i * (this.bytesSize - this.bytesReserva), data.length);

                        Main.logger.info(n + " " + i + "/" + p + " ");

                        if((1+i) == p){
                            if(receberFicheiros.containsKey(n)){
                                this.receberFicheiros.remove(n);
                            }

                            File outputFile = new File(folder.getPath() + "/" + n);
                            try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {

                                double tempo = (new Date().getTime() - mapa.get(n).getTime())/1000;
                                double rate = (double)(mapa2.get(n) / tempo);

                                Main.logger.info("Tempo de trasnferência: "+ tempo + " s ; Taxa de transferência: " + rate + "bytes/s");

                                outputStream.write(byteList);
                            }
                            return;
                        }else{
                            List<Byte> bs = new ArrayList<>();
                            for(byte b : byteList){
                                bs.add(b);
                            }
                            this.receberFicheiros.put(n, bs);
                        }
                    }else{
                        Main.logger.severe("Packet inválido.");
                    } temp = false;
                } catch (IOException e) {
                    Main.logger.severe("Erro a receber o packet.");
                    e.printStackTrace();
                }
            }
        }
    }

    private void sendBytes(byte[] bytes){
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, this.client, porta);
        try {
            socket.send(packet);
        } catch (IOException e) {
            Main.logger.severe("Packet não enviado.");
            e.printStackTrace();
        }
    }

    private void updateFiles(){
        List<File> filess = new ArrayList<>();
        File[] files = folder.listFiles();
        if(files == null) return;
        for(File file : files)
            if(file.isFile())
                filess.add(file);
        this.files = filess;
    }
}