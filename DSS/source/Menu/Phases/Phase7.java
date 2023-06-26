package bin;

import bin.Controller;
import bin.Pedido.Pedido;
import bin.Pedido.ReadLoadPedidos;
import bin.Pedido.ReadLoadPedidosFinalizados;
import bin.Phase;
import bin.Phase1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Phase7 extends Phase {
    public Phase7(){

        Messages =  new String[]{ "Finalizar pedido"," " };
        TipForInput = "Insira o identificador do Pedido";
        InputForStages = new String[]{ "Insira o NIF do cliente" };
        numberStages = InputForStages.length +1;
    }

    @Override
    public Phase HandleCommand(List<String> s) {

        String idPedido = s.get(0);
        String NIF = s.get(1);

        for(Pedido pdd : Controller.allPedidos){
            if(pdd.getId().equals(idPedido) && pdd.getNIF().equals(NIF)) {

                if(LocalDate.now().equals(pdd.getFim()) || LocalDate.now().compareTo(pdd.getFim())>0){

                    Controller.pedidosFinalizados.add(pdd);
                    Controller.allPedidos.remove(pdd);

                    RemoveAndWriteToFile(pdd);

                    return new Phase1("Pedido finalizado com sucesso!\n");
                }

                ChangeWarningMessage("A reparação ainda não está concluida!\n");
                return null;
            }
        }

        
        String warning = "Apenas os seguintes pedidos podem ser dados como finalizados -> \n";
       
        if (Controller.allPedidos.size() == 0)
            warning = "Não existem pedidos no sistema";

        for (Pedido p : Controller.allPedidos) {
            if((LocalDate.now().equals(p.getFim()) || LocalDate.now().compareTo(p.getFim())>0) && !Controller.pedidosFinalizados.contains(p)){
                warning +="NIF = " + p.getNIF() + " ID = " + p.getId() + "\n";
            }

        }
        warning += "\n";
        ChangeWarningMessage(warning);
        return null;
    }

    private void RemoveAndWriteToFile(Pedido pdd)
    {
        ReadLoadPedidosFinalizados.WritePedido(pdd);

        ReadLoadPedidos.RemovePedido(pdd);
    }
}
