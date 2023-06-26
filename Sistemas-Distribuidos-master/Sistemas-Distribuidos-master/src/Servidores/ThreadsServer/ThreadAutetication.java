package Servidores.ThreadsServer;

import java.io.IOException;
import java.util.Scanner;

import Connections.Demultiplexer;
import Connections.TaggedConnection;
import Servidores.Server;
import Servidores.Dados.Users;

public class ThreadAutetication extends Thread {
    TaggedConnection taggedConnection;
    private static final String SucessCode = "200";
    boolean isAdmin = false; 
    
    private String serverMessage = "start";
    
    public ThreadAutetication(TaggedConnection taggedConnection)
    {
        this.taggedConnection = taggedConnection;
    }

    @Override
    public void run() {
        Demultiplexer demultiplexer = new Demultiplexer(taggedConnection);
        demultiplexer.start();
            String data = null;
            do {
                    demultiplexer.send(1, serverMessage.getBytes());

                    //Enviar ao cliente para iniciar a fase de Autenticação
                try {
                    byte[] arr = demultiplexer.receive(1);
                    data = new String(arr);
                } catch (IOException | InterruptedException e1) { e1.printStackTrace();}
            
            } while (CheckNonValidUser(data));
            
            HandleAuteticationSucess(demultiplexer);
    }

    private void HandleAuteticationSucess(Demultiplexer demultiplexer) {
        String messageToClient = SucessCode + ";" + (isAdmin ? "1" : "0") + ";"; 
        demultiplexer.send(1, messageToClient);
        
        //Passar para a fase seguinte -> Atender pedidos do utilizador
        Thread tShowMenu = new ThreadShowMenu(demultiplexer);
        tShowMenu.start();
       

        if (isAdmin)
        {
            Thread tAdminInserir = new ThreadAdmInserirVoo(demultiplexer);
            tAdminInserir.start();
            Thread tRegisto = new ThreadRegisto(demultiplexer);
            tRegisto.start();
            Thread tEncerrar = new ThreadEncerrarDia(demultiplexer);
            tEncerrar.start();
        }
        else
        {
            Thread tHandlevoos = new ThreadHandleVoos(demultiplexer);
            tHandlevoos.start();
            Thread tCancelaReserva = new ThreadCancelaReserva(demultiplexer);
            tCancelaReserva.start();
        }

        //Resetar o valor para o admin
        isAdmin = false;
        System.out.println("Thread de autenticação foi concluida...");
    }

    private boolean CheckNonValidUser(String data) {
        Scanner sc = new Scanner(data).useDelimiter(";");
        String username = sc.next();
        String password = sc.next();
        Users users = Server.getDataBase().GetUsers();
        boolean valid = users.checkUser(username, password);
        sc.close();

        if (!valid) {
            serverMessage = "Dados inseridos estao incorretos\n";
            return true;
        }
        
        isAdmin = users.isAdmin(username);
        return false;
    }
}
