package bin;

import bin.Controller;
import bin.Pedido.Pedido;
import bin.Pessoas.Cliente;
import bin.Pessoas.FuncionarioBalcao;
import bin.Pessoas.FuncionarioReparacao;
import bin.Pessoas.Pessoa;
import bin.Phase;
import bin.Phase1;

import java.util.ArrayList;
import java.util.List;

public class Phase10 extends Phase {
    public Phase10(){

        List<String> mensagens = new ArrayList<String>();
        mensagens.add("Listar Pedidos");
        mensagens.add("");

        mensagens.add("LISTA DE PEDIDOS:");
        mensagens.add("");
        for (Pedido p : Controller.allPedidos) {
            mensagens.add("ID: "+p.getId()+" ,NIF do cliente: "+ p.getNIF());
        }


        mensagens.add("LISTA DE PEDIDOS FINALIZADOS:");
        mensagens.add("");
        for (Pedido pf : Controller.pedidosFinalizados) {
            mensagens.add("ID: "+pf.getId()+" ,NIF do cliente: "+ pf.getNIF());
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