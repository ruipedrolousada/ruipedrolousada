import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Veiculo implements Comparable<Veiculo>{
    private String marca;
    private String modelo;
    private String matricula;
    private int ano;
    private double velocidademedia;
    private double precokm;
    private ArrayList<Integer> classificacao;
    private int kms;
    private int kmsUltimo; // kms da última viagem??

    public Veiculo() {
        this.marca = "";
        this.modelo = "";
        this.matricula = "";
        this.ano = 0;
        this.velocidademedia = 0;
        this.precokm = 0;
        this.classificacao = new ArrayList<>();
        this.kms = 0;
        this.kmsUltimo = 0;
    }

    public Veiculo(String marca, String modelo, String matricula, int ano, double velocidademedia, double precokm, List<Integer> classificacao, int kms, int kmsUltimo) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.ano = ano;
        this.velocidademedia = velocidademedia;
        this.precokm = precokm;
        this.classificacao = new ArrayList<>(classificacao);
        this.kms = kms;
        this.kmsUltimo = kmsUltimo;
    }

    public Veiculo(Veiculo v) {
        this.marca = v.getMarca();
        this.modelo = v.getModelo();
        this.matricula = v.getMatricula();
        this.ano = v.getAno();
        this.velocidademedia = v.getVelocidademedia();
        this.precokm = v.getPrecokm();
        this.classificacao = v.getClassificacao();
        this.kms = v.getKms();
        this.kmsUltimo = v.getKmsUltimo();
    }

    public String getMarca() {
        return marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public double getVelocidademedia() {
        return velocidademedia;
    }

    public double getPrecokm() {
        return precokm;
    }

    public ArrayList<Integer> getClassificacao() {
        return new ArrayList<>(classificacao);
    }

    public int getKms() {
        return kms;
    }

    public int getKmsUltimo() {
        return kmsUltimo;
    }

    public Veiculo clone() {
        return new Veiculo(this);
    }


    public void setVelociademedia(double velocidademedia) {
        this.velocidademedia = velocidademedia;
    }

    public void setPrecokm(double precokm) {
        this.precokm = precokm;
    }

    public int classificacao() {
        return (int) this.classificacao.stream().mapToInt(k -> k.intValue()).average().getAsDouble();
    }

    public void addClassificacao(int v) {
        this.classificacao.add(v);
    }

    public void addViagem(int km){
        this.kms += km;
        this.kmsUltimo = km;
    }

    public abstract double custoRealKM();

    public int compareTo(Veiculo v) {
        if(this.marca.compareTo(v.getMarca()) == 0)
            return (this.modelo.compareTo(v.getModelo()));
        else
            return (this.marca.compareTo(v.getMarca()));
    }





}


