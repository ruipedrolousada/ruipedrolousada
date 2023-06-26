package Servidores.Dados;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

import Viagens.Cidade;
class InfoVoo{
    public Cidade destino;
    public int capacidadeMaxima;
    public InfoVoo(Cidade c,int capacidade)
    {
        destino = c;
        capacidadeMaxima = capacidade;
    }
}
public class GrafoCidades {
    List<Cidade> allCidades = new ArrayList<>();
    Map<Cidade,List<InfoVoo>> allVoos = new HashMap<>();
    Lock lock = new ReentrantLock();
    


    public void addCidade(Cidade cidade)
    {
        try {
            lock.lock();
            allCidades.add(cidade);
        } finally  {lock.unlock();}
    }
     //Se pudemos fazer um voo de origem para destino tambem pudemos fazer um de destino para origem
     public void addVoo(Cidade origem,Cidade destino,int capacidade)
     {
         try{
             lock.lock();
             List<InfoVoo> allVoosDestino = allVoos.get(origem);
             if (allVoosDestino == null)
             {
                 List<InfoVoo> l = new ArrayList<InfoVoo>();
                 InfoVoo info = new InfoVoo(destino, capacidade);
                 l.add(info);
                 allVoos.put(origem,l);
             }
            else {
                boolean found = false;
                for (InfoVoo infoVoo : allVoosDestino) {
                    if (infoVoo.destino.equals(destino))
                    {
                        found = true;
                    }
                }
                if (!found) allVoosDestino.add(new InfoVoo(destino, capacidade));
            }
             
             
             List<InfoVoo> allVoosOrigem = allVoos.get(destino);
             if (allVoosOrigem == null)
             {
                 List<InfoVoo> l = new ArrayList<InfoVoo>();
                 InfoVoo info = new InfoVoo(origem, capacidade);
                 l.add(info);
                 allVoos.put(destino,l);
             }
             else {
                boolean found = false;
                for (InfoVoo infoVoo : allVoosDestino) {
                    if (infoVoo.destino.equals(origem))
                    {
                        found = true;
                    }
                }
                if (!found) allVoosDestino.add(new InfoVoo(origem, capacidade));
            }
         }
         finally{ lock.unlock();}
     }


     public List<Cidade> GetPossibleVoo(Cidade origem)
     {
         try{
             lock.lock();
             var lista = allVoos.get(origem);
             List<Cidade> l = new ArrayList<>();

             for (InfoVoo infoVoo : lista) {
                 l.add( infoVoo.destino);
             }

             return l;
         }finally{ lock.unlock();}
     }

     public List<Cidade> GetAllCidades()
     {
         try{
             lock.lock();
             return allVoos.keySet().stream().collect(Collectors.toList());
         }finally{ lock.unlock();}
     }

     public int GetSizeVoo(Cidade origem,Cidade destino)
     {
         try{
            lock.lock();
            for (var info :allVoos.get(origem))
            {
                if (info.destino.equals(destino))
                    return info.capacidadeMaxima;      
            }
            return -1;
        }finally{lock.unlock();}

    }


     public void PrintVoos()
     {
         try
         {
             lock.lock();
             System.out.println("-------------------------\nPrinting All Voos");
             System.out.println("CIDADE ORIGEM -> CIDADE DESTINO");
             for (var entry : allVoos.entrySet()) {
                 System.out.println(entry.getKey().getNome()+" -> ");
                 //("Cidades destino);
                 for (var info : entry.getValue()) {
                     System.out.print(info.destino.getNome());
                 }
                 System.out.print("\n-------------------------\n");
             }
 
         }finally{ lock.unlock();}
     }
}
