import java.util.*;
import java.util.stream.Collectors;
import java.io.Serializable;

/**
 * Escreva a descrição da classe Gestor aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Gestor implements Serializable{
    Map<String,Equipa> equipas = new HashMap<String,Equipa>();
    Map<String,Jogador> jogadores = new HashMap<String,Jogador>();
    List<Jogo> jogos = new ArrayList<Jogo>();
    
    public Gestor(){}
    public Gestor(Map<String,Equipa> equipas,Map<String,Jogador> jogadores,List<Jogo> jogos){
        this.equipas = equipas.entrySet().stream().map(c -> c.getValue().clone()).collect(Collectors.toMap(x->x.getNome(),x->x));
        this.jogadores = jogadores.entrySet().stream().map(c -> c.getValue().clone()).collect(Collectors.toMap(x->x.getNome(),x->x));
        this.jogos = jogos.stream().map(c -> c.clone()).collect(Collectors.toList());
    }
    public Gestor(Gestor g){
        this.equipas = g.getEquipas();
        this.jogadores = g.getJogadores();
        this.jogos = g.getJogos();
    }
    
    public Map<String,Equipa> getEquipas(){
        return this.equipas.entrySet().stream().map(c -> c.getValue().clone()).collect(Collectors.toMap(x->x.getNome(),x->x));
    }
    public Map<String,Jogador> getJogadores(){
        return this.jogadores.entrySet().stream().map(c -> c.getValue().clone()).collect(Collectors.toMap(x->x.getNome(),x->x));
    }
    public List<Jogo> getJogos(){
        return this.jogos.stream().map(c -> c.clone()).collect(Collectors.toList());
    }
    
    public void addJogador(String equipa,String jogador) throws NoTeamJogadorException{
        Jogador j = this.jogadores.get(jogador);
        Equipa eq = this.equipas.get(equipa);
        if (j == null) throw new NoTeamJogadorException ("Jogador " + jogador);
        if (eq == null) throw new NoTeamJogadorException ("Equipa " + equipa);
        eq.addJogador(j);
        this.equipas.get("").removeJogador(j); 
    }
    
    public void removeJogador (String equipa,String jogador) throws NoTeamJogadorException{
        Jogador j = this.jogadores.get(jogador);
        Equipa eq = this.equipas.get(equipa);
        if (j == null) throw new NoTeamJogadorException ("Jogador " + jogador);
        if (eq == null) throw new NoTeamJogadorException ("Equipa " + equipa);
        eq.removeJogador(j);
        this.equipas.get("").addJogador(j);
    }
    
    public void addEquipa(Equipa equipa){
        this.equipas.put(equipa.getNome(),equipa.clone());
    }
    
    public Gestor clone(){
        return new Gestor (this.equipas,this.jogadores,this.jogos);
    }
    
    public void addJogador(Jogador j){
        Jogador k = j.clone();
        this.jogadores.put(k.getNome(),k);
        this.equipas.get("").addJogador(k);
    }
    
    public Equipa getTeam(String equipa)throws NoTeamJogadorException{
        Equipa eq = this.equipas.get(equipa);
        if (eq == null) throw new NoTeamJogadorException();
        return eq;
    }
    public Jogador getJogador(String jogador)throws NoTeamJogadorException{
        Jogador j = this.jogadores.get(jogador);
        if (j == null) throw new NoTeamJogadorException();
        return j;
    }
    
    public boolean containsNumJogador(String equipa,Integer numJogador) throws NoTeamJogadorException{
        Equipa eq = this.equipas.get(equipa);
        if (eq == null) throw new NoTeamJogadorException ("Equipa " + equipa);
        return eq.containsNumJogador(numJogador);
    }
    // rever a funcao abaixo do comentario
    public List<Integer> getNumjogadoresequipa(String equipa) throws NoTeamJogadorException{
        Equipa e=this.equipas.get(equipa);
        if (e == null) throw new NoTeamJogadorException ("Equipa " + equipa);
        return e.getNumjogadoresList();
    } 
    
    public String getHist(String nome) throws NoTeamJogadorException{
        Jogador j = this.jogadores.get(nome);
        if (j == null) throw new NoTeamJogadorException(nome);
        StringBuilder b = new StringBuilder();
        j.getHist().stream().forEach(x -> b.append(x + " | "));
        return b.toString();
    }
    
    public void addJogo(Jogo j){
        this.jogos.add(j.clone());
    }
}