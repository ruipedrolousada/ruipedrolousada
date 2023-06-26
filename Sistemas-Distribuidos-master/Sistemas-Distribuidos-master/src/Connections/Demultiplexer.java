package Connections;

import java.util.HashMap;
import java.util.Map;

import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demultiplexer{
    public TaggedConnection tagConnection;
    public Lock lock ;
    private  Map<Integer,Entry> bufferMensagens = new HashMap<>();

    private Entry get(int tag){
        Entry e = bufferMensagens.get(tag);
        return e;
    }

    public Demultiplexer(TaggedConnection taggedConnection) {
        tagConnection = taggedConnection;
        lock = new ReentrantLock();
    }
    private Thread ReadingSocketThread;
    public void start() {
        bufferMensagens.put(1, new Entry());
        bufferMensagens.put(2, new Entry());
        bufferMensagens.put(3, new Entry());
        bufferMensagens.put(4, new Entry());//Receber voos do cliente
        bufferMensagens.put(8, new Entry());//Cancelar uma Reserva
        bufferMensagens.put(9, new Entry());//Admin adicionar voos
        bufferMensagens.put(10, new Entry());//Registar usuarios
        bufferMensagens.put(11, new Entry());//Encerrar o dia



        ReadingSocketThread = new Thread(() -> {
            try  {
                while(true)
                {
                    var f = tagConnection.receive();
                    System.out.println("Received ["+ f.tag +"] " + new String(f.data));
                    Entry e=null;
                    try{
                         //Adicionar a frame à nossa queue
                         e = get(f.tag);  
                         //Fechar o acesso desta entry pois estamos prestes a escrever
                         e.lock.lock();
                         e.queue.add(f.data);
                         //Acordar thread que está à espera da informaçao
                         e.cond.signal();
                    }finally{
                        e.lock.unlock();
                   }
                }
            }  
            catch (Exception e) {
                System.out.println("DeMultiplexer foi interrompido");
                for (var entrada : bufferMensagens.values()) {
                    entrada.lock.lock();
                    entrada.alive = false;
                    entrada.cond.signalAll();
              }
            }
        });

        ReadingSocketThread.start();
    }
    public void send(int i, String s){
        tagConnection.send(i,s.getBytes());
    }
    
    public void send(int i, byte[] bytes) {
        tagConnection.send(i, bytes);
    }

    public byte[] receive(int i)throws IOException, InterruptedException {
        
        Entry e = get(i);
        e.lock.lock();
        while(e.alive){
            if (! e.queue.isEmpty())
            {
                byte[] b = e.queue.poll();
            
                return b;
            }
            //Este await liberta automaticamente o lock;
            e.cond.await();
        }
        throw new InterruptedException();
    }

    public void close() {
        try {
            tagConnection.close();
        } catch (Exception e) {}

    }
    
}

