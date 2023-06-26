package bin;

import bin.*;
import bin.Pedido.Pedido;
import bin.Pedido.Plano;
import bin.Phase;
import bin.Phase1;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Phase5 extends Phase {
    public Phase5(){

        Messages =  new String[]{ "Definir tempo de reparação e custo de peças (Pedido mais antigo)"," " };
        TipForInput = "Insira o tempo de reparação em horas";
        InputForStages = new String[]{ "Insira o custo total das peças"};
        numberStages = InputForStages.length +1;
    }

    @Override
    public Phase HandleCommand(List<String> s) {
        String tempoReparacao = s.get(0);
        String c = s.get(1);

        int tempo;
        int custo;
        try {
            tempo = Integer.parseInt(tempoReparacao);
            custo = Integer.parseInt(c);
         
        } catch (Exception e) {
            ChangeWarningMessage("Por favor insira números !\n");
            return null;
        }
       
        if (Controller.allPedidos.size() == 0)
        {
            ChangeWarningMessage("Não existem pedidos no sistema!\n");
            return null;
        }
        
        Controller.allPedidos.sort(Comparator.comparing(Pedido::getDataRegisto));
        Pedido pdd = Controller.allPedidos.get(0);

        Plano pll = new Plano();
        pll.setTotalHoras(tempo);
        pll.setCusto(custo);
        pdd.setPl(pll);
        pdd.setOrcamento(pll.getCusto()+10);//custo das peças + mão de obra


        //Se foi feito com sucesso
        return new Phase1("Plano adicionado com sucesso!\n");


    }
}