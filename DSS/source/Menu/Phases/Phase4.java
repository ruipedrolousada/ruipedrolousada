package bin;

import bin.Main;
import bin.Pedido.Pedido;
import bin.Pedido.ReadLoadPedidos;
import bin.Pessoas.Cliente;
import bin.Pessoas.FuncionarioBalcao;
import bin.Pessoas.Pessoa;
import bin.Controller;

import java.time.LocalDate;
import java.util.List;

public class Phase4 extends Phase {
    public Phase4(){

        Messages =  new String[]{ "Novo pedido"," " };
        TipForInput = "Insira o NIF do Cliente";
        InputForStages = new String[]{ "Insira o identificador do Pedido"};
        numberStages = InputForStages.length +1;
    }

    @Override
    public Phase HandleCommand(List<String> s) {

        String NIF = s.get(0);
        String nomeEquipamento = s.get(1);



        for(Cliente p : Controller.clientes){
            if( p.getNIF().equals(NIF)){

                Pedido pdd = new Pedido();
                pdd.setId(nomeEquipamento);
                pdd.setNIF(NIF);
                pdd.setDataRegisto(LocalDate.now());

                ReadLoadPedidos.WritePedido(pdd);
                
                Controller.allPedidos.add(pdd);

                //Se foi feito com sucesso
                return new Phase1("Pedido adicionado com sucesso!\n");
            }
        }

        String warning = "Só existem os seguintes Clientes (NIF) -> ";

        for (Cliente cs : Controller.clientes) {
            warning += cs.getNIF() + " ";
        }

        warning += " !\n";
        ChangeWarningMessage(warning);
        return null;
    }
}