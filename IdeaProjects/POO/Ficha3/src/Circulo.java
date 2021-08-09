public class Circulo {

    private double x;
    private double y;
    private double raio;

    public Circulo(){
        this.x = 1;
        this.y = 1;
        this.raio = 1;
    }

    public Circulo(int x, double y, double raio){
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    public Circulo(Circulo cir){
        this.x = cir.getX();
        this.y = cir.getY();
        this.raio = cir.getRaio();
    }

    public void alteraCentro (double x, double y){
        setX(x);
        setY(y);
    }

    public double calculaArea(){
        return Math.PI*getRaio()*getRaio();
    }

    public double calculaPerimetro(){
         return 2*Math.PI*getRaio();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
}


