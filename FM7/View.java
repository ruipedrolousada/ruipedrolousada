import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Map;
import java.util.stream.*;
import java.util.HashMap;
import java.time.LocalDate;

/**
 * Escreva a descrição da classe View aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class View implements vFM{
    private cFM controller;
    
    public View(cFM controller){
        this.controller = controller;
    } 
    
    public void addController(cFM controller){
        this.controller = controller;
    }
    
    public void run(){
        System.out.println("-----------------WC to FM-------------------------");
        String comand,is,nome,eq;
        int numero=0;
        boolean stay = true;
        Scanner in = new Scanner(System.in);
        while(stay){
        System.out.println("Comandos disponiveis:\n-simular um jogo(jogo);\n-criar jogador(criajogador);\n-criar equipa(criaequipa);\n-historial de equipas de um jogaodr(joHist);\n-adicionar a equipa um jogador(adiconaje);\n-trocar de equipa um jogador(trocaje);\n-remover de uma equipa um jogador(removeje);\n-listar todos os jogadores(jogadores);\n-listar todas as equipas e seus jogadores(equipas);\n-listar o nome todas as equipas(equipasnome);\n-listar todos os jogos(todosjogos);\n-sair(exit);");
        comand=in.nextLine();  
        switch(comand){
        case "criajogador":
           JogadorType tipo;
          System.out.println("Escreva o nome do jogador \n"); 
           nome = in.nextLine();
          System.out.println("Escreva o numero do jogador \n"); 
           is = in.nextLine();
           numero = Integer.parseInt(is); 
          System.out.println("Digite o numero correspondente a posiçao do jogador,1 para avançado,2 para medio,3 para lateral,4 para defesa e 5 para guarda redes\n");
            String type = in.nextLine();
            int i = Integer.parseInt(type);
           switch(i){
              case 1 :
                tipo = JogadorType.AVANCADO;
                break;
              case 2 :
                tipo = JogadorType.MEDIO;
                break;
              case 3 :
                tipo = JogadorType.LATERAL;
                break;
              case 4 :
                tipo = JogadorType.DEFESA;
                break;
              case 5 :
                tipo = JogadorType.GUARDAREDES;
                break;
              default :
                 System.out.println("numero mal escolhido ,por default o jogador criado e um avançado\n");
                 tipo = JogadorType.AVANCADO;
                 i=1;
                 break;
           }
           System.out.println("Escreva ajuda para saber os atributos a introduzir do jogador ou random para serem gerados aleatoriamente \n"); 
            String g = in.nextLine();
            List<Integer> val = new ArrayList<>();
            int at;
            Random rand = new Random();
           if(g.equals("ajuda")){
            if(i==1){System.out.println("Escreva os atributos separados por virgula do avançado que sao velocidade,resistencia,destreza,impulsao,jogo de cabeça,remate,passe \n");}
            if(i==2){System.out.println("Escreva os atributos separados por virgula do medio que sao velocidade,resistencia,destreza,impulsao,jogo de cabeça,remate,passe,recuperaçao \n");}
            if(i==3){System.out.println("Escreva os atributos separados por virgula do lateral que sao velocidade,resistencia,destreza,impulsao,jogo de cabeça,remate,passe,cruzamento \n");}
            if(i==4){System.out.println("Escreva os atributos separados por virgula do defesa que sao velocidade,resistencia,destreza,impulsao,jogo de cabeça,remate,passe \n");}
            if(i==5){System.out.println("Escreva os atributos separados por virgula do guardaredes que sao velocidade,resistencia,destreza,impulsao,jogo de cabeça,remate,passe,elasticidade \n");}
            String atributos = in.nextLine();
            String[] l = atributos.split(",");
            if((i==1)||(i==4)&&(l.length==7)){
                 for(int j=0;j<7;j++)val.add(Integer.parseInt(l[i]));
             }
            else if((l.length==8)){
                 for(int j=0;j<8;j++)val.add(Integer.parseInt(l[i]));
            }
            else{
                System.out.println("O comando foi mal introduzido os atributos foram gerados aleatoriamente");
                if((i==1)||(i==4)){
                 for(int j=0;j<7;j++)val.add(rand.nextInt(61)+40);
                }
                else{
                  for(int j=0;j<8;j++)val.add(rand.nextInt(61)+40);  
                }
            }
           }
           else{
             if(!(g.equals("random"))){System.out.println("O comando foi mal introduzido os atributos foram gerados aleatoriamente");}
             if((i==1)||(i==4)){
                 for(int j=0;j<7;j++)val.add(rand.nextInt(61)+40);
             }
             else{
                 for(int j=0;j<8;j++)val.add(rand.nextInt(61)+40);
             }
             System.out.println("Os valores dos atributos sao " + val.toString());
           }
           controller.newJogador(tipo,nome,numero,val);
           break;
        case "criaequipa":
            System.out.println("Escreva o nome da equipa\n"); 
            nome = in.nextLine();
            controller.addEquipa(nome);
            break;
        case "adicionaje":
            System.out.println("Escreva o nome da equipa\n");
            is = in.nextLine();
            System.out.println("Escreva o nome do jogador\n");
            nome = in.nextLine();
            try{
            controller.addJogador(is,nome);
           }
           catch(NoTeamJogadorException e){
              System.out.println("Houve um problema devido "+ e.getMessage() +" nao existir");
           }
           break;
        case "trocaje":
            System.out.println("Escreva o nome da equipa onde esta o jogador\n");
            is = in.nextLine();
            System.out.println("Escreva o nome da equipa de destino\n");
            eq = in.nextLine();
            System.out.println("Escreva o nome do jogador\n");
            nome = in.nextLine();
            try{
              controller.removeJogador(is,nome);
            }
            catch(NoTeamJogadorException e){
              System.out.println("Houve um problema devido "+ e.getMessage() +" nao existir");
            }
            try{
             controller.addJogador(eq,nome);
            }
            catch(NoTeamJogadorException e){
              System.out.println("Houve um problema devido "+ e.getMessage() +" nao existir");
            }
            break;
        case "removeje":
            System.out.println("Escreva o nome da equipa\n");
            is = in.nextLine();
            System.out.println("Escreva o nome do jogador\n");
            nome = in.nextLine();
           try{
            controller.removeJogador(is,nome);
           }
           catch(NoTeamJogadorException e){
              System.out.println("Houve um problema devido "+ e.getMessage() +" nao existir");
           }
           break;
        case "joHist":
            System.out.println("Escreva o nome do jogador\n");
            nome = in.nextLine();
            String hist;
            try{
                hist = controller.getHist(nome);
            }catch(NoTeamJogadorException e){
                hist = ("Jogador " + e.getMessage() + " nao Exite");
            }
            System.out.println(hist+"\n");
            break;
            
        case "jogo":
            Equipa eq1= null;
            Equipa eq2= null;
            System.out.println("Escreva o nome da primeira equipa\n");
            eq = null;
            while(eq1 == null){
                eq = in.nextLine();
                try {
                    eq1 = controller.getEquipa(eq);
                }catch(NoTeamJogadorException e){
                    System.out.println("Equipa " + eq + "nao existe");
                }
            }
            System.out.println(eq1.toString());
            boolean t = false;
            List<Integer> l1i= new ArrayList<>();
            while(!t){
            System.out.println(eq + ": Escreva a lista dos numeros dos jogadores separando-os por uma virgula\n");
            String lista1 = in.nextLine();
            String[] l1 = lista1.split(",");
            for(int k=0;k<l1.length && k < 11;k++){
                l1i.add(Integer.parseInt(l1[k]));
            }
            for(int k=0;k<l1i.size();k++){
              try{
               t = controller.containsNumJogador(eq,l1i.get(k));
              }catch(NoTeamJogadorException e){
               System.out.println(e);
              }
              if(!t){System.out.println("Um dos numeros escolhidos nao pertence a equipa");break;}
            }
            }
            
           List<Integer> eq1j=new ArrayList<>();
           try{eq1j= controller.getNumjogadoresequipa(eq);}
           catch(NoTeamJogadorException e){System.out.println(e);}
           Map<Integer,Integer> t1= new HashMap<>();
           Map<Integer,Integer> s1= new HashMap<>();
            for(int y=0;y<eq1j.size();y++){
                if(l1i.contains(eq1j.get(y))){t1.put(eq1j.get(y),eq1j.get(y));}
                else{s1.put(eq1j.get(y),eq1j.get(y));}
            }
            
            System.out.println("Escreva o nome da segunda equipa\n");
            is = null;
            while(is == null){
                is = in.nextLine();
                try {
                    eq2 = controller.getEquipa(is);
                }catch(NoTeamJogadorException e){
                    System.out.println("Equipa " + is + "nao existe");
                }
            }
            System.out.println(eq2.toString());
           t = false;
           List<Integer> l2i= new ArrayList<>();
           while(!t){
            System.out.println(is + ": Escreva a lista dos numeros dos jogadores separando-os por uma virgula\n");
            String lista2 = in.nextLine();
            String[] l2 = lista2.split(",");
            for(int k=0;k < l2.length && k < 11;k++){
                l2i.add(Integer.parseInt(l2[k]));
            }
            for(int k=0;k<l2i.size();k++){
              try{
               t=controller.containsNumJogador(eq2.getNome(),l2i.get(k));
              }catch(NoTeamJogadorException e){
               System.out.println(e);
              }
              if(!t){System.out.println("Um dos numeros escolhidos nao pertence a equipa");break;}
            }
          }
           List<Integer> eq2j=new ArrayList<>();
           try{eq2j= controller.getNumjogadoresequipa(is);}
           catch(NoTeamJogadorException e){System.out.println(e);}
           Map<Integer,Integer> t2= new HashMap<>();
           Map<Integer,Integer> s2= new HashMap<>();
            for(int y=0;y<eq2j.size();y++){
                if(l2i.contains(eq2j.get(y))){t2.put(eq2j.get(y),eq2j.get(y));}
                else{s2.put(eq2j.get(y),eq2j.get(y));}
            }
            int score[] = new int[2];score[0]=0;score[1]=0;
            LocalDate date = LocalDate.now();
            Jogo j = new Jogo (eq1,eq2,t1,s1,t2,s2,score,0,date);
            j.finalGame();
            controller.addJogo(j);
            System.out.println(j.toString());
            break;
        case "jogadores":
            List<String> jogadores = controller.stringJogadores();
            jogadores.stream().forEach(x -> System.out.println(x.toString()));
            break;
        case "equipas":
             List<String> teams = controller.stringTeams();
             teams.stream().forEach(x -> System.out.println(x.toString()));
             break;
        case "equipasnome":
             List<String> teamsnome = controller.stringTeamsnome();
             teamsnome.stream().forEach(x -> System.out.println(x.toString()));
             System.out.println("\n");
             break;
        case "todosjogos":
             List<String> jogos = controller.stringJogos();
             jogos.stream().forEach(x -> System.out.println(x.toString()));
             break;
        case "exit": 
            stay = false;
            break;
        default:
             System.out.println("Comando mal escrito");
             break;
       }
    }
   }
}
