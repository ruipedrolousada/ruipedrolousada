package Servidores.ThreadsServer;

import Connections.Demultiplexer;
import Servidores.Server;
import Servidores.Dados.ServerData;

import java.io.IOException;
import java.util.*;

public class ThreadCancelaReserva extends Thread {
    Demultiplexer dm;
    private ServerData db;

    public ThreadCancelaReserva(Demultiplexer demultiplexer) {
        this.dm = demultiplexer;
        db = Server.getDataBase();
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = new String(dm.receive(8));
                HandleCancelaReserva(message);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private void HandleCancelaReserva(String message) throws IOException, InterruptedException {
        Scanner sc = new Scanner(message).useDelimiter(";");
        String id = sc.next();

        boolean removed =db.GetReservas().RemoveReserva(id);
        if (removed) {
            dm.send(8, "200".getBytes());
        } 
        else
            dm.send(8, "100".getBytes());
        sc.close();
    }

    
}