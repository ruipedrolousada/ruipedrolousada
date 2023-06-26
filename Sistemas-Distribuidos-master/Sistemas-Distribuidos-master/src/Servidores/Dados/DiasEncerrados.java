package Servidores.Dados;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiasEncerrados {
    List<LocalDate> diasEncerrados = new ArrayList<>(); //dias encerrados pelo adm


    Lock lockDiasEncerrados = new ReentrantLock();  
    
    public void addDiaEncerrado(LocalDate data){
        try{
            lockDiasEncerrados.lock();
            diasEncerrados.add(data);
        }finally {
            lockDiasEncerrados.unlock();
        }
    }

    public void getAllDiasEncerrados()
    {

    }

    public boolean hasData(LocalDate data) {
        try{
            lockDiasEncerrados.lock();
            for (LocalDate localDate : diasEncerrados) {
                if (localDate.equals(data))
                    return true;
            }
            return false;
        }finally {
            lockDiasEncerrados.unlock();
        }
    }
}
