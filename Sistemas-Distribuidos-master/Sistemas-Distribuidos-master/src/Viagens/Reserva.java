package Viagens;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {

    public String idReserva;
    public List<Voo> travel = new ArrayList<>();
    public LocalDate data;
    //public Boolean diaEncerrado;

    public Reserva(){
        this.idReserva = "";
        this.travel = new ArrayList<>();
        this.data = LocalDate.now();
        //this.diaEncerrado = diaE;
    }
    public Reserva(String id, List<Voo> v, LocalDate d){
        this.idReserva = id;
        this.travel = v;
        this.data = d;
        //this.diaEncerrado = diaE;
    }

    /*public Boolean getDiaEncerrado() {
        return diaEncerrado;
    }

    public void setDiaEncerrado(Boolean diaEncerrado) {
        this.diaEncerrado = diaEncerrado;
    }*/

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public List<Voo> getTravel() {
        return travel;
    }

    public void setTravel(List<Voo> travel) {
        this.travel = travel;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
