package Servidores.ThreadsServer;

import java.io.IOException;
import java.util.List;

import Connections.Demultiplexer;
import Servidores.Server;
import Servidores.Dados.ServerData;
import Viagens.Cidade;

public class ThreadShowMenu extends Thread {
    Demultiplexer dm;
    ServerData db;
    public ThreadShowMenu(Demultiplexer dm)
    {
        this.dm = dm;
        db = Server.getDataBase();
    }

    @Override
    public void run() {
        while(true)
        {
            try {
                var nextAnswer = dm.receive(3);
                String answer = new String(nextAnswer);
                if (answer.equals("Show"));
                {
                    HandleShowServertoClient();
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                dm.close();
            }
        }
    }


    private void HandleShowServertoClient() {
        List<Cidade> allCities = db.GetGrafoCidades().GetAllCidades();
        
        StringBuilder sBuilder = new StringBuilder();

        sBuilder.append(allCities.size()).append(";");
        for (int i = 0; i < allCities.size(); i++) {
            sBuilder.append(allCities.get(i).getNome()).append(";");
        }

        //9;Hong Kong;Madrid;Turim;Veneza;New York;Pyongyang;Nevada;Braga;Porto;
        dm.send(3,sBuilder.toString().getBytes());

        sBuilder.delete(0, sBuilder.length());

        for (int i = 0; i < allCities.size(); i++) {
            List<Cidade> allDestinos = db.GetGrafoCidades().GetPossibleVoo(allCities.get(i));
            for (Cidade cidade : allDestinos) {
                sBuilder.append(cidade.getNome()).append(";");
            }
            sBuilder.append("@");
        }

        dm.send(3,sBuilder.toString().getBytes());
    }
}
