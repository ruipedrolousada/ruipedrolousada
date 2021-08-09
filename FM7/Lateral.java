
/**
 * Escreva a descrição da classe Lateral aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Lateral extends Jogador{
    public int cruzamento;
    
    public Lateral(){
        super();
        this.cruzamento = 0;
    }
    
    public Lateral(String nome, int num, int vel, int res, int des, int imp, int jCab,int rem, int cPas,int cruzamento){
        super(nome,num,vel,res,des,imp,jCab,rem,cPas);
        this.cruzamento = cruzamento;
    }
    
    public Lateral(Lateral m){
        super(m);
        this.cruzamento = m.getCruz();
    }
    
    public int getCruz(){
        return this.cruzamento;
    }
    
    public Lateral clone(){
        return new Lateral(this.getNome(), this.getNum(), this.getVel() , this.getRes() , this.getDes(), this.getImp(), this.getJCab(), this.getRem(), this.getCPas(),this.cruzamento);
    }
    
    public static Lateral loadLine(String s){
        String[] div = s.split(",");  
        if (div.length >= 10)
        return new Lateral(div[0],Integer.parseInt(div[1]),
        Integer.parseInt(div[2]),Integer.parseInt(div[3]),
        Integer.parseInt(div[4]),Integer.parseInt(div[5]),
        Integer.parseInt(div[6]),Integer.parseInt(div[7]),
        Integer.parseInt(div[8]),Integer.parseInt(div[9]));
        else 
        return new Lateral();
    }
    
    public int getPontos(){
        int pontos = (int)((this.getVel()*1.2f + this.getRes()*1.2f + this.getDes() + this.getImp() + this.getJCab() +  this.getRem() + this.getCPas() + this.cruzamento) / 8);
        if(pontos>99)pontos=99;
        return pontos;
    }
    
    public String toString(){
        return super.toString() + " cruzamento:" + this.cruzamento + "\n";
    }
}