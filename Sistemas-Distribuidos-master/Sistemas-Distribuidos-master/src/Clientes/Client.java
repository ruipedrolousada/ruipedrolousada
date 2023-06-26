package Clientes;

import java.io.IOException;
import java.net.Socket;

import Clientes.Menu.Interpreter;
import Connections.Demultiplexer;
import Connections.TaggedConnection;

public class Client {
    private static ClientData clientData;

    public static void main(String[] args) throws IOException {
        
        TaggedConnection tag = InitializeClient();
        
        if (tag == null) return;

        Demultiplexer demultiplexer = new Demultiplexer(tag);
        demultiplexer.start();

        
        Interpreter it = new Interpreter(demultiplexer);
        it.Initialize();
        
        demultiplexer.close();
        System.out.println("Client shutted down");
        tag.close();
    }


    private static TaggedConnection InitializeClient() { 
        Socket socketClient=null;
        int i =0;
        while(i<10)
        {
            try {
                socketClient= new Socket("localhost", 1234);
                if (socketClient !=null) break;
            }
            catch (IOException e) { 
                System.out.println("Failed to connect to server, Going to sleep 1s...");
                i++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {}
            }
        }
        if (socketClient == null) return null;
        TaggedConnection tag = new TaggedConnection(socketClient);
        clientData = new ClientData();
        return tag;
    }

    public static ClientData GetClientData()
    {
        return clientData;
    }

    // private static void test1(TaggedConnection tag)
    // {

    //  Runnable tw = new ThreadWorker(tag);
        
    //     tw.run();
    // }
}
