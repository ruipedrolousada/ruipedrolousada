
/**
 * Escreva a descrição da classe Avancado aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Avancado extends Jogador {
     public Avancado(){
        super();
    }
    
    public Avancado(String nome, int num, int vel, int res, int des, int imp, int jCab,int rem, int cPas){
        super(nome,num,vel,res,des,imp,jCab,rem,cPas);
    }
    
    public Avancado(Avancado m){
        super(m);
    }
    
    public Avancado clone(){
        return new Avancado(this.getNome(), this.getNum(), this.getVel() , this.getRes() , this.getDes(), this.getImp(), this.getJCab(),this.getRem(), this.getCPas());
    }
        
    public static Avancado loadLine(String s){
        String[] div = s.split(",");  
        if (div.length >= 9)
        return new Avancado(div[0],Integer.parseInt(div[1]),
        Integer.parseInt(div[2]),Integer.parseInt(div[3]),
        Integer.parseInt(div[4]),Integer.parseInt(div[5]),
        Integer.parseInt(div[6]),Integer.parseInt(div[7]),
        Integer.parseInt(div[8]));
        else 
        return new Avancado();
    }
    
    public int getPontos(){
        int pontos = (int)((this.getVel()*1.2f + this.getRes()*0.9f + this.getDes() + this.getImp()*1.1f + this.getJCab()*1.2f + this.getRem()*1.2f + this.getCPas()*0.9f) / 7);
        if(pontos>99) pontos=99;
        return pontos;
    }
    
    public String toString (){
        return super.toString()+ "\n";
    }
}
