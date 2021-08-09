public class Futebol {

    private estado e;
    private int golos1;
    private int golos2;

    public enum estado{
        INICIAR,
        DECORRER,
        TERMINADO;
    }

    public Futebol(){
        this.e = estado.TERMINADO;
        this.golos1 = 0;
        this.golos2 = 0;
    }

    public Futebol(estado e, int golo1, int golo2){
        this.e = e;
        this.golos1 = golo1;
        this.golos2 = golo2;
    }

    public Futebol(Futebol fute){
        this.e = fute.getE();
        this.golos1 = fute.getGolos1();
        this.golos2 = fute.getGolos2();
    }

    public void startGame(){
        if (this.e == estado.INICIAR) {
            setE(estado.DECORRER);
            setGolos2(0);
            setGolos2(0);
        }
        else System.out.println("O jogo ja começou!");
    }

    public void endGame(){
        if (this.e != estado.TERMINADO){
            setE(estado.TERMINADO);
            System.out.println("resultado: "+getGolos1()+ "-"+getGolos2());
        }
        else System.out.println("O jogo ja terminou!");
    }

    public void goloVisitado(){
        setGolos1(getGolos1()+1);
    }

    public void goloVisitante(){
        setGolos2(getGolos2()+1);
    }

    public String resultadoActual(){
        if(this.e != estado.INICIAR) {
            return ("resultado: " + getGolos1() + "-" + getGolos2());
        }
        else return("O jogo ainda não começou!");
    }





    public estado getE() {
        return e;
    }

    public void setE(estado e) {
        this.e = e;
    }

    public int getGolos1() {
        return golos1;
    }

    public void setGolos1(int golos1) {
        this.golos1 = golos1;
    }

    public int getGolos2() {
        return golos2;
    }

    public void setGolos2(int golos2) {
        this.golos2 = golos2;
    }




}
