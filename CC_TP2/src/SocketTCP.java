import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP extends Thread {
    private ServerSocket serverSocket;

    public SocketTCP(){
        try {
            this.serverSocket = new ServerSocket(8888);
            Main.logger.info("Socket TCP aberto na porta 8888");
        } catch (IOException e) {
            Main.logger.severe("Erro ao criar a porta.");
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                Socket socket = this.serverSocket.accept();
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                printWriter.write("HTTP/1.1 200 OK\r\n");
                printWriter.write("\r\n");
                printWriter.flush();
                printWriter.close();
                socket.close();
            } catch (IOException e) {
                Main.logger.severe("Erro de conexão.");
                e.printStackTrace();
            }
        }
    }
}