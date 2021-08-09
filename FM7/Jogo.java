import java.time.LocalDate;
import java.util.*;
import java.io.Serializable;
import java.util.stream.Collectors;
import java.util.Random;

/**
 * Escreva a descrição da classe Jogo aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Jogo implements Serializable{
    private Equipa eq1, eq2;
    
    private Map<Integer,Integer> tEq1 = new HashMap<Integer,Integer>(); 
    private Map<Integer,Integer> sEq1 = new HashMap<Integer,Integer>(); 

    private Map<Integer,Integer> tEq2 = new HashMap<Integer,Integer>(); 
    private Map<Integer,Integer> sEq2 = new HashMap<Integer,Integer>();
    
    private int[] score = new int[2];
    private static int maxTime = 5400;
    private int time; private LocalDate day;


    public Jogo(){
        this.eq1 = new Equipa();
        this.eq2 =  new Equipa();
        this.time = 0;
        this.day = LocalDate.now();
    }

    public Jogo(Equipa eq1,Equipa eq2, Map<Integer, Integer> tEq1, Map<Integer, Integer> sEq1, Map<Integer, Integer> tEq2, Map<Integer, Integer> sEq2, int[] score, int time, LocalDate day) {
        this.eq1 =  eq1.clone();
        this.eq2 =  eq2.clone();
        this.tEq1 = tEq1.values().stream().collect(Collectors.toMap(x->x,x->x));
        this.sEq1 = sEq1.values().stream().collect(Collectors.toMap(x->x,x->x));
        this.tEq2 = tEq2.values().stream().collect(Collectors.toMap(x->x,x->x));
        this.sEq2 = sEq2.values().stream().collect(Collectors.toMap(x->x,x->x));
        this.score = score;
        this.time = time;
        this.day = day;
    }

    public Jogo (Jogo g){
        this.eq1 = g.getEq1();
        this.eq2 = g.getEq2();
        this.tEq1 = g.gettEq1();
        this.sEq1 = g.getsEq1();
        this.tEq2 = g.gettEq2();
        this.sEq2 = g.getsEq2();
        this.score = g.getScore();
        this.time = g.getTime();
        this.day = g.getDay();
    }


    public Equipa getEq1() { return eq1; }

    public void setEq1(Equipa eq1) { this.eq1 = eq1; }

    public Equipa getEq2() { return eq2; }

    public void setEq2(Equipa eq2) { this.eq2 = eq2; }

    public Map<Integer, Integer> gettEq1() { return tEq1.values().stream().collect(Collectors.toMap(x->x,x->x)); }

    public void settEq1(Map<Integer, Integer> tEq1) { this.tEq1 = tEq1.values().stream().collect(Collectors.toMap(x->x,x->x)); }

    public Map<Integer, Integer> getsEq1() { return sEq1.values().stream().collect(Collectors.toMap(x->x,x->x)); }

    public void setsEq1(Map<Integer, Integer> sEq1) { this.sEq1 = sEq1.values().stream().collect(Collectors.toMap(x->x,x->x)); }

    public Map<Integer, Integer> gettEq2() { return tEq2.values().stream().collect(Collectors.toMap(x->x,x->x)); }

    public void settEq2(Map<Integer, Integer> tEq2) { this.tEq2 = tEq2.values().stream().collect(Collectors.toMap(x->x,x->x)); }

    public Map<Integer, Integer> getsEq2() { return sEq2.values().stream().collect(Collectors.toMap(x->x,x->x)); }

    public void setsEq2(Map<Integer, Integer> sEq2) { this.sEq2 = sEq2.values().stream().collect(Collectors.toMap(x->x,x->x)); }

    public int getTime(){
        return this.time;
    }
    public void setTime(int time){
        this.time = time;
    }
    public LocalDate getDay(){
        return this.day;
    }
    public void setDay(LocalDate l){
        this.day = l;    
    }
    public int[] getScore(){
        int[] r = {score[0],score[1]};
        return r;
    }
    public void setScore(int[] score){
        this.score[0] = score[0];
        this.score[1] = score[1];
    }

    public Jogo clone() {

        Map<Integer,Integer> tq1 = new HashMap<Integer, Integer>();
        for (Map.Entry<Integer,Integer> entry : tEq1.entrySet()) {
            tq1.put(entry.getKey(), entry.getValue());
        }

        Map<Integer,Integer> sq1 = new HashMap<Integer, Integer>();
        for (Map.Entry<Integer,Integer> entry : sEq1.entrySet()) {
            sq1.put(entry.getKey(), entry.getValue());
        }

        Map<Integer,Integer> tq2 = new HashMap<Integer, Integer>();
        for (Map.Entry<Integer,Integer> entry : tEq2.entrySet()) {
            tq2.put(entry.getKey(), entry.getValue());
        }

        Map<Integer,Integer> sq2 = new HashMap<Integer, Integer>();
        for (Map.Entry<Integer,Integer> entry : sEq2.entrySet()) {
            sq2.put(entry.getKey(), entry.getValue());
        }

        return new Jogo(this.eq1,this.eq2,tq1,sq1,tq2,sq2, this.score, this.time, this.day);
    }

    public static Jogo Loadline(String input,Map<String,Equipa> equipas) {
        String[] str = input.split(",");
        String[] date = str[4].split("-");

        Map<Integer, Integer> tEq1 = new HashMap<>();
        Map<Integer, Integer> sEq1 = new HashMap<>();
        Map<Integer, Integer> tEq2 = new HashMap<>();
        Map<Integer, Integer> sEq2 = new HashMap<>();

        for (int i = 5; i < 16; i++) {//titulares
            tEq1.put(Integer.parseInt(str[i]), Integer.parseInt(str[i]));
        }
        for (int i = 16; i < 19; i++) {//sub eq1
            String[] sub = str[i].split("->");
            sEq1.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        for (int i = 19; i < 30; i++) {//titulares eq2
            tEq2.put(Integer.parseInt(str[i]), Integer.parseInt(str[i]));
        }
        for (int i = 30; i < 33; i++) {//sub eq2
            String[] sub = str[i].split("->");
            sEq2.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }

        int[] r = new int[] {Integer.parseInt(str[2]), Integer.parseInt(str[3])};
        return new Jogo(equipas.get(str[0]), equipas.get(str[1]), 
        tEq1, sEq1, tEq2, sEq2, 
        r, 5400, LocalDate.of(Integer.parseInt(date[0]), 
        Integer.parseInt(date[1]), Integer.parseInt(date[2])));

    }

    public void finalGame(){
        int a,b,c,d;
        int g1=0,g2=0;
        int[] score = new int[2];
        Random rand = new Random();
        a=tEq1.values().stream().mapToInt(x->eq1.getJogador(x).getPontos()).sum();
        b=tEq2.values().stream().mapToInt(x->eq2.getJogador(x).getPontos()).sum();
        c=(int)((a-b)/11);
        d=c;
        c=Math.abs(c);
        for(int i=0;i<90;i++){
                a=rand.nextInt(1000)+1;
                b=rand.nextInt(1000)+1;
                if(c<10&&c>=5){
                    if(a<41)g1++;
                    if(b<31)g2++;
                }
                if(c<15&&c>=10){
                    if(a<51)g1++;
                    if(b<26)g2++;
                }
                if(c<20&&c>=15){
                    if(a<56)g1++;
                    if(b<26)g2++;
                }
                if(c>=20){
                    if(a<61)g1++;
                    if(b<21)g2++;
                }
        }
        if(d<0){a=g1;g1=g2;g2=a;}
        this.score[0]=g1;
        this.score[1]=g2;
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(day.toString()+" "+eq1.getNome()+" "+this.score[0]+":"+this.score[1]+" "+eq2.getNome()+"\n");
        s.append(eq1.getNome()+" Titulares:");
        for(Integer i : tEq1.keySet()){
            s.append(i+",");
        }
        s.append("\n");
        s.append(eq2.getNome()+" Titulares:");
        for(Integer i : tEq2.keySet()){
            s.append(i+",");
        }
        s.append("\n");
        return s.toString();
    }
}