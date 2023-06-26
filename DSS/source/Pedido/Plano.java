package bin.Pedido;

import java.util.Random;

public class Plano {

    protected Integer totalHoras;
    protected Integer custo;

    public Plano(){
        this.custo = 0;
        this.totalHoras = 0;
    }

    public Plano(Integer totalHoras, Integer custo) {
        this.totalHoras = totalHoras;
        this.custo = custo;
    }

    public Integer getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(Integer totalHoras) {
        this.totalHoras = totalHoras;
    }

    public Integer getCusto() {
        return custo;
    }

    public void setCusto(Integer custo) {
        this.custo = custo;
    }

    //random???? 10 a 100 euros?
    public static Integer calculaCusto(){
        Random random = new Random();
        return random.nextInt(101 - 10) + 10;
    }

    //random???? 1 a 5 dias?
    public static Integer calculaHoras(){
        Random random = new Random();
        return random.nextInt(121 - 24) + 24;
    }
}
