package Servidores;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import Connections.TaggedConnection;
import Servidores.Dados.ServerData;
import Servidores.ThreadsServer.ThreadAutetication;

public class Server {
    private static ServerData database;

    public static void main(String[] args) {

        ServerSocket ss = InitializeServer();


        while(true)
        {
            System.out.println("Esperando por Cliente...");
            Socket clientSocket = null;
            
            try {
                clientSocket = ss.accept();
                System.out.println("Cliente foi aceito com sucesso...");
            } catch (IOException e) { e.printStackTrace();        }


            TaggedConnection taggedConnection = new TaggedConnection(clientSocket);
            Thread client = new ThreadAutetication(taggedConnection);
            client.start();
        }

    }

 

    private static ServerSocket InitializeServer() {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(1234);
        } catch (IOException e) { e.printStackTrace();}

        database = new ServerData();
        
        return ss;
    }

    public static ServerData getDataBase()
    {
        return database;
    }
}


