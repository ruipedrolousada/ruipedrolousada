package Servidores.ThreadsServer;

import Connections.Demultiplexer;
import Servidores.Server;
import Servidores.Dados.ServerData;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class ThreadEncerrarDia extends Thread {
    Demultiplexer dm;
    private ServerData db;

    public ThreadEncerrarDia(Demultiplexer demultiplexer) {
        this.dm = demultiplexer;
        db = Server.getDataBase();
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = new String(dm.receive(11));
                HandleEncerraDia(message);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private void HandleEncerraDia(String message) throws IOException, InterruptedException {
        Scanner sc = new Scanner(message).useDelimiter(";");
        LocalDate date;
        try {
            date = LocalDate.parse(sc.next());
        } catch (Exception e) {
            dm.send(11, "100");
            sc.close();
            return;
        }
        db.GetDiasEncerrados().addDiaEncerrado(date);

        db.GetReservas().RemoveReservasDia(date);
        dm.send(11, "200");
        sc.close();
    }

  
}