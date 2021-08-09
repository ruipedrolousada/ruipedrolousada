import java.util.*;
/**
 * Escreva a descrição da classe Controller aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Controller implements cFM{
    private mFM model;
    private vFM view;
    
    public Controller (){}
    public Controller (mFM model,vFM view){
        this.model = model;
        this.view = view;
    }
    
    public void addModel(mFM model){
        this.model = model;
    }
    public void addView(vFM view){
        this.view = view;
    }
    
    public List<String> stringTeamsnome(){
        return model.stringTeamsnome();
    }
    public List<String> stringTeams(){
        return model.stringTeams();
    }
    public List<String> stringJogadores(){
        return model.stringJogadores();
    }
    public List<String> stringJogos(){
        return model.stringJogos();
    }
    
    public void newJogador(JogadorType type,String name,int idade,List<Integer> valores){
        Jogador j;
        switch (type){
            case AVANCADO: 
                j = new Avancado(name,idade,
                                 valores.get(0),valores.get(1),
                                 valores.get(2),valores.get(3),
                                 valores.get(4),valores.get(5),
                                 valores.get(6));
            break;    
            case LATERAL:
                j = new Lateral(name,idade,
                                valores.get(0),valores.get(1),
                                valores.get(2),valores.get(3),
                                valores.get(4),valores.get(5),
                                valores.get(6),valores.get(7));
            break;    
            case MEDIO:
                j = new Medio(name,idade,
                              valores.get(0),valores.get(1),
                              valores.get(2),valores.get(3),
                              valores.get(4),valores.get(5),
                              valores.get(6),valores.get(7));
            break;    
            case DEFESA:
                 j = new Defesa(name,idade,
                                valores.get(0),valores.get(1),
                                valores.get(2),valores.get(3),
                                valores.get(4),valores.get(5),
                                valores.get(6));
            break;
            case GUARDAREDES:
                 j = new GuardaRedes(name,idade,
                                     valores.get(0),valores.get(1),
                                     valores.get(2),valores.get(3),
                                     valores.get(4),valores.get(5),
                                     valores.get(6),valores.get(7));
            break;
            default: 
                j = new Jogador(); 
            break;
        }
        model.addJogador(j);
    }
    public void addEquipa(String equipa){
        model.addEquipa(new Equipa(equipa));
    }
    public void addJogador(String equipa,String jogador) throws NoTeamJogadorException{
        try{
            model.addJogador(equipa,jogador);
        }
        catch(NoTeamJogadorException e){
            throw e;
        }
    }
    public void removeJogador (String equipa,String jogador) throws NoTeamJogadorException{
        try{
            model.removeJogador(equipa,jogador);
        }
        catch(NoTeamJogadorException e){
            throw e;
        }
    }
    public String getHist(String nome) throws NoTeamJogadorException{
        try{
            return this.model.getHist(nome);
        }catch(NoTeamJogadorException e){
            throw e; 
        }
    }
    public Equipa getEquipa(String equipa)throws NoTeamJogadorException{
        try{
            return model.getEquipa(equipa);
        }catch(NoTeamJogadorException e){
            throw e;
        }
    }
    
    public List<Integer> getNumjogadoresequipa(String equipa) throws NoTeamJogadorException{
        try{
            return model.getNumjogadoresequipa(equipa);
        }catch(NoTeamJogadorException e){
            throw e;
        }
    } 
    
    public boolean containsNumJogador(String equipa,Integer numJogador) throws NoTeamJogadorException{
        try{
            return model.containsNumJogador(equipa,numJogador);
        }catch(NoTeamJogadorException e){
            throw e;
        }
    }
    
    public void addJogo(Jogo j){
        model.addJogo(j);
    }
}
