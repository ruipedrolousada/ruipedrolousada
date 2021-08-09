
/**
 * Escreva a descrição da classe GuardaRedes aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class GuardaRedes extends Jogador{
    public int elas;
    
     public GuardaRedes(){
        super();
        this.elas = 0;
    }
    
    public GuardaRedes(String nome, int num, int vel, int res, int des, int imp, int jCab, int rem, int cPas,int cruzamento){
        super(nome,num,vel,res,des,imp,jCab,rem,cPas);
        this.elas = cruzamento;
    }
    
    public GuardaRedes(GuardaRedes m){
        super(m);
        this.elas = m.getElas();
    }
    
    public int getElas(){
        return this.elas;
    }
    
    public GuardaRedes clone(){
        return new GuardaRedes(this.getNome(), this.getNum(), this.getVel() , this.getRes() , this.getDes(), this.getImp(), this.getJCab(),this.getRem(), this.getCPas(),this.elas);
    }
    
    public static GuardaRedes loadLine(String s){
        String[] div = s.split(",");  
        if (div.length >= 10)
        return new GuardaRedes(div[0],Integer.parseInt(div[1]),
        Integer.parseInt(div[2]),Integer.parseInt(div[3]),
        Integer.parseInt(div[4]),Integer.parseInt(div[5]),
        Integer.parseInt(div[6]),Integer.parseInt(div[7]),
        Integer.parseInt(div[8]),Integer.parseInt(div[9]));
        else 
        return new GuardaRedes();
    }
    
    public int getPontos(){
        int pontos = (int)((this.getVel()*0.9f + this.getRes()*0.8f + this.getDes()*1.2f + this.getImp()*1.2f + this.getJCab()*0.8f + this.getRem()*0.8f + this.getCPas()*1.1f + this.elas*1.3f) / 8);
        if (pontos >99) pontos = 99;
        return pontos;
    }
    
    public String toString(){
        return super.toString() + " elas:" + this.elas + "\n";
    }
}