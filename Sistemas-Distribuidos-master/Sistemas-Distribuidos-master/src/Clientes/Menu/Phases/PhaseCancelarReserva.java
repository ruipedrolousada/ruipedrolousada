package Clientes.Menu.Phases;

import Clientes.Client;
import Connections.Demultiplexer;
import Viagens.Cidade;

import java.io.IOException;
import java.util.List;

public class PhaseCancelarReserva extends Phase {

    public PhaseCancelarReserva(Demultiplexer dm)
    {
        super(dm);

        List<Cidade> allCities = Client.GetClientData().GetAllCidades();

        String arr[] = new String[allCities.size() +1];
        arr[0] = "Cancelar Reserva";
        for (int i = 0; i < allCities.size(); i++) {
            arr[i+1] = allCities.get(i).getNome();
        }

        Messages =arr;

        TipForInput = "ID de reserva";

        numberStages = 1;
        this.dm = dm;
    }

    @Override
    public Phase HandleCommand(List<String> s) {
        if (s.get(0).isEmpty())
            return null;
        String id = s.get(0);

        dm.send(8, id+ ";");

        try {
            String responseServer =new String (dm.receive(8));
            if (responseServer.equals("200"))
                return new PhaseMainMenu(dm, "Reserva cancelada com sucesso\n");
            else
                return new PhaseMainMenu(dm,"Esse id nao existe\n");
        } catch (IOException | InterruptedException e) {e.printStackTrace();return null;}

    }

  

}