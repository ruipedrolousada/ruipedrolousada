package Servidores.Dados;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import Viagens.Cidade;
import Viagens.Voo;

public class ViagensPossiveis {
    List<Voo> allViagensPossiveis = new ArrayList<>();

    Lock lock = new ReentrantLock();

    public void AddVoo(Voo v)
    {
        try{
            lock.lock();
            allViagensPossiveis.add(v);
        }finally{lock.unlock();}
    }
    public List<Voo> GetAllVoosPossiveis()
    {
        try
        {
            lock.lock();
            return allViagensPossiveis;
        }finally {lock.unlock();}
    }

    
    public Integer getVooLugares(Cidade origem,Cidade destino)
    {
        try
        {
            lock.lock();

            for(Voo v : this.allViagensPossiveis){
            if(v.getOrigem().equals(origem) && v.getDestino().equals(destino))
                return v.getLugaresLivres();
            }
            return -1;

        }finally{ lock.unlock();}
        
            
    }

    public Voo DecrementVooLugares(Cidade origem,Cidade destino) throws Exception
    {
        lock.lock();
        try{
            for (Voo voo : allViagensPossiveis) {
                if (voo.origem.equals(origem) && voo.destino.equals(destino))
                {
                    if (voo.lugaresLivres > 0)
                    {
                        voo.lugaresLivres--;
                        return voo;
                    }
                    throw new Exception();
                }
            }
            return null;
        }finally{lock.unlock();}
    }

    public void allVoosPossiveisAddVoo(Voo v){
        try{
            lock.lock();

            this.GetAllVoosPossiveis().add(v);
        }finally {
            lock.unlock();
        }
    }
}
