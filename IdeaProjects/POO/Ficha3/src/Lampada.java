import java.time.LocalDate;

public class Lampada {

    private Boolean on;
    private Boolean off;
    private Boolean eco;
    private double consumoON;
    private double consumoOFF;
    private double consumoECO;
    private LocalDate date;
    private Boolean[] historico;

    public Lampada(){
        this.on = false;
        this.off = true;
        this.eco = false;
        this.consumoON = 5;
        this.consumoOFF = 0;
        this.consumoECO = 2;
    }

    public Lampada (Boolean on, Boolean off, Boolean eco, double consumoON, double consumoOFF, double consumoECO){
        this.on = on;
        this.off = off;
        this.eco = eco;
        this.consumoON = consumoON;
        this.consumoOFF =  consumoOFF;
        this.consumoECO =  consumoECO;
    }
    public enum meda{
        ON,
        OFF,
        ECO;
    }


    public Lampada (Lampada l){
        this.on = l.getOn();
        this.off = l.getOff();
        this.eco =  l.getEco();
        this.consumoON = l.getConsumoON();
        this.consumoOFF = l.getConsumoOFF();
        this.consumoECO = l.getConsumoECO();
    }

    public void lampON(){
        setOn(true);
        setOff(false);
        setEco(false);
    }

    public void lampOFF(){
        setOn(false);
        setOff(true);
        setEco(false);
    }

    public void lampECO(){
        setOff(false);
        setEco(true);
        setOn(false);
    }

    public Boolean getOn() {
        return on;
    }

    public void setOn(Boolean on) {
        this.on = on;
    }

    public Boolean getOff() {
        return off;
    }

    public void setOff(Boolean off) {
        this.off = off;
    }

    public Boolean getEco() {
        return eco;
    }

    public void setEco(Boolean eco) {
        this.eco = eco;
    }

    public double getConsumoON() {
        return consumoON;
    }

    public void setConsumoON(double consumoON) {
        this.consumoON = consumoON;
    }

    public double getConsumoOFF() {
        return consumoOFF;
    }

    public void setConsumoOFF(double consumoOFF) {
        this.consumoOFF = consumoOFF;
    }

    public double getConsumoECO() {
        return consumoECO;
    }

    public void setConsumoECO(double consumoECO) {
        this.consumoECO = consumoECO;
    }
}
