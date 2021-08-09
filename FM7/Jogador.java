import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Escreva a descrição da classe Jogador aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Jogador implements Serializable{
    private String nome; private int num;
    private int vel, res, des; 
    private int imp, jCab, rem, cPas;
    
    List<String> hist = new ArrayList<String>();
    
    public Jogador(){
        this.nome = ""; this.num = 0;
        this.vel = this.res = this.des = this.imp = this.jCab = this.rem = this.cPas = 0;
    }
    public Jogador(String nome, int num){
        this.nome = nome; this.num = num;
        this.vel = this.res = this.des = this.imp = this.jCab = this.rem = this.cPas = 0;
    }
    public Jogador(String nome, int num,int vel,int res,int des,int imp,int jCab,int rem,int cPas){
        this.nome = nome; this.num = num;
        this.vel = vel; this.res = res; this.des = des; this.imp = imp; this.jCab = jCab ; this.rem=rem ;this.cPas = cPas;
    }
    public Jogador(String nome, int num,int vel,int res,int des,int imp,int jCab,int rem,int cPas,List<String> hist){
        this.nome = nome; this.num = num;
        this.vel = vel; this.res = res; this.des = des; this.imp = imp; this.jCab = jCab ; this.rem=rem ;this.cPas = cPas;
        this.hist = hist.stream().collect(Collectors.toList());
    }
    public Jogador(Jogador j){
        new Jogador(j.getNome(),j.getNum(),j.getVel(),j.getRes(),j.getDes(),j.getImp(),j.getJCab(),j.getRem(),j.getCPas());
    }
    
    public String getNome(){return nome;}
    public int getNum(){return num;}
    public int getVel(){return vel;}
    public int getRes(){return res;}
    public int getDes(){return des;}
    public int getImp(){return imp;}
    public int getRem(){return rem;}
    public int getJCab(){return jCab;}
    public int getCPas(){return cPas;}
    public List<String> getHist(){return this.hist.stream().collect(Collectors.toList());}
    
    public void setNum(int num){this.num = num;}    
    
    public String toString (){
        String s = "Num:" + num + " Nome:" + nome +  " Vel:" + vel + " Res:" + res + " Des:" + des + " Imp:" + imp + " jcab:" + jCab + " cpas:" + cPas ;
        return s;
    }
    public boolean equals (Object o){
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        Jogador j = (Jogador) o;
        return (this.nome == j.getNome() && this.num == j.getNum());
    }
    public Jogador clone (){
        return new Jogador (this.nome,this.num,this.vel,this.res,this.des,this.imp,this.jCab,this.rem,this.cPas,this.hist);
    }
    
    public void addEquipaName(String nome){
        this.hist.add(nome);
    }
    
    public int getPontos(){
        int pontos = (int)((vel + res + des + imp + jCab+ rem + cPas) / 7);
        return pontos;
    }
}