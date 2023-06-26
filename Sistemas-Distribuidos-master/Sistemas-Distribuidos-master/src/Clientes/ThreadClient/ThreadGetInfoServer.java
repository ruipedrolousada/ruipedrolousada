package Clientes.ThreadClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Clientes.Client;
import Clientes.ClientData;
import Connections.Demultiplexer;
import Viagens.Cidade;

public class ThreadGetInfoServer extends Thread {
    private ClientData clientData;
    private Demultiplexer dm;
    
    public ThreadGetInfoServer(Demultiplexer dm)
    {
        this.dm = dm;
        clientData = Client.GetClientData();
    }
    @Override
    public void run() {
        try {
            while(true)
            {

                var answer = dm.receive(3);
                clientData.wait = true;
                int size =ParseFirstMessageShow(answer);
                answer = dm.receive(3);
                ParseSecondMessageShow(answer,size);
                clientData.wait = false;
            }
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

       
    }

  

    private int ParseFirstMessageShow(byte[] answer) {
        Scanner sc = new Scanner(new String( answer));
        sc.useDelimiter(";");
        int size = Integer.parseInt( sc.next());
        var mapVoos = clientData.GetAllVoos();
        var allCidades = clientData.GetAllCidades();

        for (int i = 0; i < size; i++) {
            Cidade cidade = new Cidade( sc.next());
            
            //Se a cidade ja existir no mapa ela nao é adicionada
            if (allCidades.contains(cidade))
                continue;
            mapVoos.put(cidade, new ArrayList<>());
            allCidades.add(cidade);    
        }
        sc.close();
        return size;
    }

    private void ParseSecondMessageShow(byte[] answer,int size) {

        var allCidades = clientData.GetAllCidades();

        Scanner sc = new Scanner(new String( answer));
        sc.useDelimiter("@");
        for (int i = 0; i < size; i++) {
            String lineDestination = sc.next();

            Scanner scVooDestino = new Scanner(lineDestination);
            // System.out.println("got line " + lineDestination);
            scVooDestino.useDelimiter(";");
            while(scVooDestino.hasNext())
            {
                String destino = scVooDestino.next();
                // System.out.println("Adding " + allCidades.get(i).getNome() + " -> " + destino);
                clientData.addVoo(allCidades.get(i) ,new Cidade( destino) );
            }
            scVooDestino.close();
        }
        sc.close();
    }
}
