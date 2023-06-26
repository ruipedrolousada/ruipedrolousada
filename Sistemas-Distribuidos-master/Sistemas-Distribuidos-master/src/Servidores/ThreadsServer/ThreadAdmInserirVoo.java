package Servidores.ThreadsServer;

import Connections.Demultiplexer;
import Servidores.Server;
import Servidores.Dados.ServerData;
import Viagens.Cidade;

import java.io.IOException;
import java.util.*;

public class ThreadAdmInserirVoo extends Thread {
    Demultiplexer dm;
    private ServerData db;

    public ThreadAdmInserirVoo(Demultiplexer demultiplexer) {
        this.dm = demultiplexer;
        db = Server.getDataBase();
    }

    @Override
    public void run() {
        while(true)
        {
            try {
                String message =new String( dm.receive(9));
                HandleVoosFromClient(message);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private void HandleVoosFromClient(String message) throws IOException, InterruptedException {
        Scanner sc = new Scanner(message);
        sc.useDelimiter(";");

        Cidade origem = new Cidade(sc.next());
        Cidade destino = new Cidade(sc.next());
        Integer capac = Integer.parseInt( sc.next());

        String isValid  =  AdicionarVoo(origem,destino,capac);
        dm.send(9, isValid);
        sc.close();
    }

    private String AdicionarVoo(Cidade origem, Cidade destino, Integer capacidade) {
        var grafo = db.GetGrafoCidades();

        if (!grafo.GetAllCidades().contains(origem) && !grafo.GetAllCidades().contains(destino))
            return "naoExiste";
        
        grafo.addVoo(origem, destino, capacidade);

        return "200";
    }
}
