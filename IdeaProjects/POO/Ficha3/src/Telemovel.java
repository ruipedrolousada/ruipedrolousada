import java.lang.Math;
import java.lang.String;
import java.util.Arrays;


public class Telemovel {

    private String marca;
    private String modelo;
    private int resoluçãoX;
    private int resoluçãoY;
    private int armazenamentoTotal;
    private int armazenamentoFotos;
    private int armazenamentoApp;
    private int armazenamentoOcupado;
    private int fotos;
    private int app;
    private int msg;
    private String[] nomeApp;
    private String[] armazenamentoMsg;

    public Telemovel() {
        this.marca = "Xiaomi";
        this.modelo = "mi9";
        this.resoluçãoX = 500;
        this.resoluçãoY = 500;
        this.armazenamentoTotal = 10000;
        this.armazenamentoFotos = 0;
        this.armazenamentoApp = 0;
        this.armazenamentoOcupado = 0;
        this.fotos = 0;
        this.app = 0;
        this.msg = 0;
        this.nomeApp = new String[10];
        this.armazenamentoMsg = new String[10];
    }

    public Telemovel(String marca, String modelo, int resoluçãoX, int resoluçãoY, int armazenamentoTotal, int armazenamentoFotos, int armazenamentoApp,
                     int armazenamentoOcupado, int fotos, int app,int msg, String[] nomeApp, String[] armazenamentoMsg) {

        this.marca = marca;
        this.modelo = modelo;
        this.resoluçãoX = resoluçãoX;
        this.resoluçãoY = resoluçãoY;
        this.armazenamentoTotal = armazenamentoTotal;
        this.armazenamentoFotos = armazenamentoFotos;
        this.armazenamentoApp = armazenamentoApp;
        this.armazenamentoOcupado = armazenamentoOcupado;
        this.fotos = fotos;
        this.app = app;
        this.msg = msg;
        this.nomeApp = nomeApp;
        this.armazenamentoMsg = armazenamentoMsg;
    }

    public Telemovel(Telemovel tele) {
        this.marca = tele.getMarca();
        this.modelo = tele.getModelo();
        this.resoluçãoX = tele.getResoluçãoX();
        this.resoluçãoY = tele.getResoluçãoY();
        this.armazenamentoTotal = tele.getArmazenamentoTotal();
        this.armazenamentoFotos = tele.getArmazenamentoFotos();
        this.armazenamentoApp = tele.getArmazenamentoApp();
        this.armazenamentoOcupado = tele.getArmazenamentoOcupado();
        this.fotos = tele.getFotos();
        this.app = tele.getApp();
        this.msg = tele.getMsg();
        this.nomeApp = tele.getNomeApp();
        this.armazenamentoMsg = tele.getArmazenamentoMsg();
    }

    public boolean existeEspaço(int numeroBytes) {
        return ((numeroBytes + getArmazenamentoOcupado()) <= getArmazenamentoTotal());
    }

    public void instalaApp(String nome, int tamanho) {
        if (existeEspaço(tamanho)) {

            setArmazenamentoOcupado(this.armazenamentoOcupado + tamanho);
            setArmazenamentoApp(this.armazenamentoApp + tamanho);

            //setApp(this.app + 1);

            if (this.app > this.nomeApp.length) {
                String[] nomeApp = Arrays.copyOf(this.nomeApp, (this.nomeApp.length) + 1);
            }
            this.nomeApp[this.app] = nome;
            setApp(this.app + 1);
        }
    }

    public void recebeMsg(String msg){
        if (this.msg > this.armazenamentoMsg.length) {
            String[] armazenamentoMsg = Arrays.copyOf(this.armazenamentoMsg, (this.armazenamentoMsg.length) * 2);
        }
        this.armazenamentoMsg[this.msg]= msg;
        setMsg(this.msg++);
    }


    public double tamMedioApps() {
        return (double)(this.armazenamentoApp / this.app);
    }

    public String maiorMsg(){
        int aux=0,count=0;

        for(int i=0;i< this.msg; i++){

            if ((this.armazenamentoMsg[i].length()) > aux){
                aux = (this.armazenamentoMsg[i].length());

            }
        this.app -= 1;
    }

    //SETTERS
    /*public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setResoluçãoX(int resoluçãoX) {
        this.resoluçãoX = resoluçãoX;
    }

    public void setResoluçãoY(int resoluçãoY) {
        this.resoluçãoY = resoluçãoY;
    }

    public void setArmazenamentoTotal(int armazenamentoTotal) {
        this.armazenamentoTotal = armazenamentoTotal;
    }

    public void setArmazenamentoFotos(int armazenamentoFotos) {
        this.armazenamentoFotos = armazenamentoFotos;
    }

    public void setArmazenamentoApp(int armazenamentoApp) {
        this.armazenamentoApp = armazenamentoApp;
    }

    public void setArmazenamentoOcupado(int armazenamentoOcupado) {
        this.armazenamentoOcupado = armazenamentoOcupado;
    }

    public void setFotos(int fotos) {
        this.fotos = fotos;
    }

    public void setApp(int app) {
        this.app = app;
    }

    public void setMsg(int app) {
        this.msg = msg;
    }

    public void setNomeApp(String[] nomeApp) {
        this.nomeApp = nomeApp;
    }

    public void setArmazenamentoMsg(String[] armazenamentoMsg) {
        this.armazenamentoMsg = armazenamentoMsg;
    }*/



    @Override
    public String toString() {
        return "Telemovel{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", resoluçãoX=" + resoluçãoX +
                ", resoluçãoY=" + resoluçãoY +
                ", armazenamentoTotal=" + armazenamentoTotal +
                ", armazenamentoFotos=" + armazenamentoFotos +
                ", armazenamentoApp=" + armazenamentoApp +
                ", armazenamentoOcupado=" + armazenamentoOcupado +
                ", fotos=" + fotos +
                ", app=" + app +
                ", msg=" + msg +
                ", nomeApp=" + Arrays.toString(nomeApp) +
                ", armazenamentoMsg=" + Arrays.toString(armazenamentoMsg) +
                '}';
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

    public int getResoluçãoX() {
        return resoluçãoX;
    }

    public void setResoluçãoX(int resoluçãoX) {
        this.resoluçãoX = resoluçãoX;
    }

    public int getResoluçãoY() {
        return resoluçãoY;
    }

    public void setResoluçãoY(int resoluçãoY) {
        this.resoluçãoY = resoluçãoY;
    }

    public void setArmazenamentoTotal(int armazenamentoTotal) {
        this.armazenamentoTotal = armazenamentoTotal;
    }

    public void setArmazenamentoFotos(int armazenamentoFotos) {
        this.armazenamentoFotos = armazenamentoFotos;
    }

    public int getArmazenamentoApp() {
        return armazenamentoApp;
    }

    public void setArmazenamentoApp(int armazenamentoApp) {
        this.armazenamentoApp = armazenamentoApp;
    }

    public int getArmazenamentoOcupado() {
        return armazenamentoOcupado;
    }

    public void setArmazenamentoOcupado(int armazenamentoOcupado) {
        this.armazenamentoOcupado = armazenamentoOcupado;
    }

    public int getFotos() {
        return fotos;
    }

    public void setFotos(int fotos) {
        this.fotos = fotos;
    }

    public int getApp() {
        return app;
    }

    public void setApp(int app) {
        this.app = app;
    }

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }

    public String[] getNomeApp() {
        return nomeApp;
    }

    public void setNomeApp(String[] nomeApp) {
        this.nomeApp = nomeApp;
    }

    public String[] getArmazenamentoMsg() {
        return armazenamentoMsg;
    }

    public void setArmazenamentoMsg(String[] armazenamentoMsg) {
        this.armazenamentoMsg = armazenamentoMsg;
    }