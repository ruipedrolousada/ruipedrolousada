package Clientes.Menu.Phases;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Clientes.ThreadClient.ThreadGetInfoServer;
import Connections.Demultiplexer;

public class PhaseAutenticaçao extends Phase{
    static Thread threadGetInfoServer;
    public PhaseAutenticaçao(Demultiplexer dm)
    {
        super(dm);
        Messages =  new String[]{
            "Autenticação",
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

        if (username.isEmpty() || password.isEmpty()) return null;
        
        String message = username + ";" + password + ";";
        
        dm.send(1, message.getBytes());
        try {
            byte[] answerFromServer = dm.receive(1);
            String answerString = new String(answerFromServer);

            ChangeWarningMessage(answerString);
            Scanner sc = new Scanner(answerString).useDelimiter(";");
            String sucessCode;String isAdminString;
            try {
                sucessCode = sc.next();
                isAdminString =  sc.next();
            } catch (Exception e) {
                ChangeWarningMessage("Autenticação falhou...\n");
                sc.close();
                return null;
            }
            sc.close();
            boolean isAdmin;
            if (isAdminString.equals("1"))
                isAdmin = true;
            else   isAdmin = false;
            if (sucessCode.equals("200"))
            {
                //Cliente entrou com sucesso no servidor
                //Cliente demonstra que quer comunicar com o servidor
                dm.send(3, "Show".getBytes());
             
               
                Thread getInfoServer = new ThreadGetInfoServer(dm);
                getInfoServer.start();

                return new PhaseMainMenu(dm,isAdmin);
            }
            else
            {
               ChangeWarningMessage("Autenticaçao do cliente falhou");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
