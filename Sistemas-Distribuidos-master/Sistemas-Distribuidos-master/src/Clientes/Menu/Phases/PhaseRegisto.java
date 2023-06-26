package Clientes.Menu.Phases;

import Connections.Demultiplexer;

import java.io.IOException;
import java.util.List;

public class PhaseRegisto extends Phase{

    public PhaseRegisto(Demultiplexer dm)
    {
        super(dm);
        Messages =  new String[]{
                "Registo",
                "",
        };
        TipForInput = "Username";

        InputForStages = new String[]{
                "Password",
        };
        numberStages = InputForStages.length +1;
    }

    @Override
    public Phase HandleCommand(List<String> s) {
        String username = s.get(0);
        String password = s.get(1);
        String message = username + ";" + password + ";";

        //pinheiro;123;
        dm.send(10, message);
        try {
            String responseServer = new String( dm.receive(10));
            if (responseServer.equals("200"))
                return new PhaseMainMenu(dm,"Utilizador registado com sucesso");
            return null;
        } catch (IOException | InterruptedException e) {}
        
        return null;
    }

}
