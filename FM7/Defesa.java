
/**
 * Escreva a descrição da classe Defesa aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Defesa extends Jogador{    
    public Defesa(){
        super();
    }
    
    public Defesa(String nome, int num, int vel, int res, int des, int imp, int jCab,int rem, int cPas){
        super(nome,num,vel,res,des,imp,jCab,rem,cPas);
    }
    
    public Defesa(Defesa m){
        super(m);
    }
    
    public Defesa clone(){
        return new Defesa(this.getNome(), this.getNum(), this.getVel() , this.getRes() , this.getDes(), this.getImp(), this.getJCab(),this.getRem(), this.getCPas());
    }
    
    public static Defesa loadLine(String s){
        String[] div = s.split(",");  
        if (div.length >= 9)
        return new Defesa(div[0],Integer.parseInt(div[1]),
        Integer.parseInt(div[2]),Integer.parseInt(div[3]),
        Integer.parseInt(div[4]),Integer.parseInt(div[5]),
        Integer.parseInt(div[6]),Integer.parseInt(div[7]),
        Integer.parseInt(div[8]));
        else 
        return new Defesa();
    }
    
    public int getPontos(){
        int pontos = (int)((this.getVel()*0.8f + this.getRes()*0.9f + this.getDes() + this.getImp()*1.1f + this.getJCab()*1.2f + this.getRem()*0.7f + this.getCPas()*1.2f) / 7);
        if(pontos>99)pontos=99;
        return pontos;
    }
    
    public String toString (){
        return super.toString()+ "\n";
    }
}