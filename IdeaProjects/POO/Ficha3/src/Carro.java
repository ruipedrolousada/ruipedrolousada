public class Carro {

    private String marca;
    private String modelo;
    private int anoConstrucao;
    private double consumo;
    private double kmTotais;
    private double kmUltimoPercurso;
    private double mediaConsumoTotal;
    private double mediaConsumoUltimoPercurso;
    private estado e;

    public enum estado{
        LIGADO,
        DESLIGADO;
    }

    public Carro(){
        this.marca = "";
        this.modelo = "";
        this.anoConstrucao = 2000;
        this.consumo = 5;
        this.kmTotais = 0;
        this.kmUltimoPercurso = 0;
        this.mediaConsumoTotal = 0;
        this.mediaConsumoUltimoPercurso = 0;
        this.e = estado.DESLIGADO;
    }

    public Carro ( String marca, String modelo, int anoConstrucao, double consumo, double kmTotais, double kmUltimoPercurso,double mediaConsumoTotal,double mediaConsumoUltimoPercurso, estado e){
       this.marca = marca;
       this.modelo = modelo;
       this.anoConstrucao = anoConstrucao;
       this.consumo =  consumo;
       this.kmTotais = kmTotais;
       this.kmUltimoPercurso = kmUltimoPercurso;
       this.mediaConsumoTotal =  mediaConsumoTotal;
       this.mediaConsumoUltimoPercurso = mediaConsumoUltimoPercurso;
       this.e = e;
    }

    public Carro (Carro car){
        this.marca = car.getMarca();
        this.modelo = car.getModelo();
        this.anoConstrucao =  car.getAnoConstrucao();
        this.consumo = car.getConsumo();
        this.kmTotais = car.getKmTotais();
        this.kmUltimoPercurso = car.getKmUltimoPercurso();
        this.mediaConsumoTotal = car.getMediaConsumoTotal();
        this.mediaConsumoUltimoPercurso = car.getMediaConsumoUltimoPercurso();
        this.e = car.getE();
    }

    public void ligaCarro(){
        if (e == estado.DESLIGADO){
            setE(estado.LIGADO);
            setKmUltimoPercurso(0);
            setMediaConsumoUltimoPercurso(0);
        }
        else System.out.println("O carro já está ligado!");
    }

    public void desligaCarro(){
        if(e == estado.LIGADO){
            setE(estado.DESLIGADO);
        }
        else System.out.println("O carro já está desligado!");
    }

    public void resetUltimaViagem(){
        setMediaConsumoUltimoPercurso(0);
        setKmUltimoPercurso(0);
    }

    public void avancaCarro (double metros, double velocidade){
        if (this.e == estado.LIGADO){
            double km = metros/1000;
            setKmTotais(getKmTotais()+km);
            setKmUltimoPercurso(km);
            setMediaConsumoUltimoPercurso((this.consumo*velocidade)/100);
            setMediaConsumoTotal(getMediaConsumoTotal());

        }
        else System.out.println("O carro está desligado!");
    }

    public void travaCarro(double metros){
        if (this.e == estado.LIGADO){
            double km = metros/1000;
            setKmTotais(getKmTotais()+km);


        }
        else System.out.println("O carro está desligado!");

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoConstrucao() {
        return anoConstrucao;
    }

    public void setAnoConstrucao(int anoConstrucao) {
        this.anoConstrucao = anoConstrucao;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public double getKmTotais() {
        return kmTotais;
    }

    public void setKmTotais(double kmTotais) {
        this.kmTotais = kmTotais;
    }

    public double getKmUltimoPercurso() {
        return kmUltimoPercurso;
    }

    public void setKmUltimoPercurso(double kmUltimoPercurso) {
        this.kmUltimoPercurso = kmUltimoPercurso;
    }

    public double getMediaConsumoTotal() {
        return mediaConsumoTotal;
    }

    public void setMediaConsumoTotal(double mediaConsumoTotal) {
        this.mediaConsumoTotal = mediaConsumoTotal;
    }

    public double getMediaConsumoUltimoPercurso() {
        return mediaConsumoUltimoPercurso;
    }

    public void setMediaConsumoUltimoPercurso(double mediaConsumoUltimoPercurso) {
        this.mediaConsumoUltimoPercurso = mediaConsumoUltimoPercurso;
    }

    public estado getE() {
        return e;
    }

    public void setE(estado e) {
        this.e = e;
    }
}
