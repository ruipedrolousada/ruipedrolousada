package Clientes.Menu.Phases;

import Clientes.Client;
import Connections.Demultiplexer;
import Viagens.Cidade;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class PhaseEncerrarDia extends Phase {

    public PhaseEncerrarDia(Demultiplexer dm)
    {
        super(dm);

        List<Cidade> allCities = Client.GetClientData().GetAllCidades();

        String arr[] = new String[allCities.size() +1];
        arr[0] = "Encerrar Dia";
        for (int i = 0; i < allCities.size(); i++) {
            arr[i+1] = allCities.get(i).getNome();
        }

        Messages =arr;

        TipForInput = "Insira uma data do tipo (yyyy-mm-dd)";
        
        numberStages = 1;
        this.dm = dm;
    }

    @Override
    public Phase HandleCommand(List<String> s) {
        if (s.get(0).isEmpty())
            return null;
        LocalDate data;
        try {
            data= LocalDate.parse(s.get(0));
        } catch (Exception e) {return null;}


        dm.send(11, data.toString()+ ";");

        try {
            String responseServer = new String(dm.receive(11));
            String sucess = "Foi com sucesso encerrado o dia " + data.toString()+ "\n";
            if (responseServer.equals("200"))
                return new PhaseMainMenu(dm,sucess);
            return null;
        } catch (IOException | InterruptedException e) {return null;}

    }


}