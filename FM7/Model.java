import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Map;

/**
 * Escreva a descrição da classe Model aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Model implements mFM{
    private Gestor jogo = new Gestor();
    private cFM controller;

    public Model(Gestor jogo,cFM controller){
        this.jogo = jogo;
        this.controller = controller;
    }
    
    public void addJogo(Gestor g){
        this.jogo = jogo;
    }
    public void addController(cFM controller){
        this.controller = controller;
    }
    
    public List<String> stringTeamsnome(){
        Map<String,Equipa> equipas = jogo.getEquipas();
        return equipas.values().stream().map(x -> x.getNome()).collect(Collectors.toList());
    }
    public List<String> stringTeams(){
        Map<String,Equipa> equipas = jogo.getEquipas();
        return equipas.values().stream().map(x -> x.toString()).collect(Collectors.toList());
    }
    public List<String> stringJogadores(){
        Map<String,Jogador> jogadores = jogo.getJogadores();
        return jogadores.values().stream().map(x -> x.toString()).collect(Collectors.toList());
    }
    public List<String> stringJogos(){
        List<Jogo> jogos = jogo.getJogos();
        return jogos.stream().map(x -> x.toString()).collect(Collectors.toList());
    }
    
    public void addJogador (Jogador j){
        jogo.addJogador(j);
    }
    public void addEquipa (Equipa equipa){
        jogo.addEquipa(equipa);
    }
    public void addJogador(String equipa,String jogador) throws NoTeamJogadorException{
        try{
            jogo.addJogador(equipa,jogador);
        }
        catch(NoTeamJogadorException e){
            throw e;
        }
    }
    public void removeJogador (String equipa,String jogador) throws NoTeamJogadorException{
        try{
            jogo.removeJogador(equipa,jogador);
        }
        catch(NoTeamJogadorException e){
            throw e;
        }
    }
    public String getHist(String nome)throws NoTeamJogadorException{
        try{
            return jogo.getHist(nome);
        }catch(NoTeamJogadorException e){
            throw e;
        }
    }
    public Equipa getEquipa(String equipa)throws NoTeamJogadorException{
        try{
            return jogo.getTeam(equipa);
        }catch(NoTeamJogadorException e){
            throw e;
        }
    }
    
    public List<Integer> getNumjogadoresequipa(String equipa) throws NoTeamJogadorException{
        try{
            return jogo.getNumjogadoresequipa(equipa);
        }catch(NoTeamJogadorException e){
            throw e;
        }
    } 
    
    
    public boolean containsNumJogador(String equipa,Integer numJogador) throws NoTeamJogadorException{
        try{
            return jogo.containsNumJogador(equipa,numJogador);
        }catch(NoTeamJogadorException e){
            throw e;
        }
    }
    
    public void addJogo(Jogo j){
        jogo.addJogo(j);
    }
}