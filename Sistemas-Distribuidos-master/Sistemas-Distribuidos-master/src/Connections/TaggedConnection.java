package Connections;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaggedConnection implements AutoCloseable {
   DataInputStream inputSocket = null;
    DataOutputStream outputSocket = null;
    Socket socket = null;
    private final Lock sendLock    = new ReentrantLock();
    private final Lock receiveLock = new ReentrantLock();


    public TaggedConnection(Socket socket) { 
        
        try {
            inputSocket = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            outputSocket = new DataOutputStream(new BufferedOutputStream( socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.socket = socket;
    }

    public void send(Frame f){
        send(f.tag,f.data);
    }
    public void send(int tag,byte[] data){
        sendLock.lock();
        try {
            /*
                FORMATO -> Length | Tag | Data
            */
            outputSocket.writeInt(4 +data.length);
            outputSocket.writeInt(tag);
            outputSocket.write(data);
            outputSocket.flush();
            System.out.println("Sent [" + tag + "] " + new String(data));
        }
        catch(Exception e){
            
        } finally {
            sendLock.unlock();
        }
    }

    public Frame receive() throws IOException { 
        receiveLock.lock();
        try {
            int length = inputSocket.readInt();
            int tag = inputSocket.readInt();
            byte[] data = new byte[length-4];
            inputSocket.readFully(data);
            return new Frame(tag,data);
        } finally {
            receiveLock.unlock();
        }
        
    }
    public void close() throws IOException { 
        inputSocket.close();
        outputSocket.close();
        socket.close();
    }
}
