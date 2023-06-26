package bin;

import bin.Controller;
import bin.Pedido.Pedido;
import bin.Pessoas.Cliente;
import bin.Pessoas.FuncionarioBalcao;
import bin.Pessoas.FuncionarioReparacao;
import bin.Pessoas.Gestor;
import bin.Pessoas.Pessoa;
import bin.Phase;
import bin.Phase1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Phase9 extends Phase {
    public Phase9(){

        List<String> mensagens = new ArrayList<String>();
        mensagens.add("Verificar Centro");
        mensagens.add("");

        mensagens.add("LISTA FUNCIONARIOS REPARAÇÃO:");
        mensagens.add("");
        for (Pessoa p : Controller.allPessoas) {
            if (p instanceof FuncionarioReparacao )
                mensagens.add(p.getNome() + " ,(password) " + p.getPassword());
        }
        mensagens.add("");
        mensagens.add("LISTA FUNCIONARIOS BALCÃO:");
        mensagens.add("");
        for (Pessoa p : Controller.allPessoas) {
            if (p instanceof FuncionarioBalcao )
                mensagens.add(p.getNome() + " ,(password) " + p.getPassword());
        }
        mensagens.add("");
        mensagens.add("LISTA DE CLIENTES:");
        mensagens.add("");
        /*for (Pessoa p : Controller.allPessoas) {
            if (p instanceof Cliente )
            mensagens.add(p.getNome() + " ,(password) " + p.getPassword() + " ,(nif)" + ((Cliente) p).getNIF());
        }*/

        for (Cliente cs : Controller.clientes) {
            mensagens.add(cs.getNome() + " ,(nif)" + cs.getNIF());
        }
        
        
        String[] meuArray = new String[mensagens.size()];
        Messages = mensagens.toArray(meuArray);

        // Messages =  new String[]{ "Verificar centro"," " };
        TipForInput = "";
        InputForStages = new String[]{ };
        numberStages = InputForStages.length +1;
    }

    @Override
    public Phase HandleCommand(List<String> s) {

        return new Phase1();

    }
}