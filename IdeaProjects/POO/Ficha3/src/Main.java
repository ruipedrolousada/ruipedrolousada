public class Main {

    public static void circulo(){

        Circulo c1 = new Circulo();

        c1.setRaio(3);
        c1.alteraCentro(2,5);
        System.out.println(c1.calculaArea());
        System.out.println("O perimetro é: "+c1.calculaPerimetro());
        System.out.println("o novo raio é: "+c1.getRaio());
    }

    public static void futebol(){
        Futebol f1 = new Futebol();

        f1.startGame();
        f1.goloVisitado();
        f1.goloVisitado();
        f1.goloVisitante();
        f1.resultadoActual();
        f1.endGame();
    }

    public static void main (String[]args){
        futebol();
    }
}
