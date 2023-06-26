package bin;

import bin.Controller;
import bin.Pedido.Pedido;
import bin.Pedido.Plano;
import bin.Pedido.PlanoExpress;
import bin.Pedido.ReadLoadPedidos;
import bin.Pessoas.Cliente;
import bin.Pessoas.FuncionarioBalcao;
import bin.Pessoas.Pessoa;
import bin.Phase;
import bin.Phase1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Phase8 extends Phase {
    public Phase8() {

        Messages = new String[]{"Novo pedido EXPRESS", " "};
        TipForInput = "Insira o NIF do Cliente";
        InputForStages = new String[]{"Insira o identificador do Pedido"};
        numberStages = InputForStages.length + 1;
    }

    @Override
    public Phase HandleCommand(List<String> s) {

        String NIF = s.get(0);
        String nomeEquipamento = s.get(1);


        int pddPorFinalizar = 0;
        for (Pedido pdd : Controller.allPedidos) {
            if (LocalDate.now().compareTo(pdd.getFim()) < 0) {
                pddPorFinalizar++;
            }
        }
        /*for(Pessoa p : Controller.allPessoas){
>>>>>>> 61932bb940790da05df66b3cfcb3558a99a7f224
            if((p instanceof Cliente) && ((Cliente) p).getNIF().equals(NIF)) {

         */
        for(Cliente cs : Controller.clientes){
            if(cs.getNIF().equals(NIF)) {
                //pedido express pode ser realizado?????
                if (pddPorFinalizar < 4) {

                    Pedido pdd = new Pedido();
                    pdd.setNIF(NIF);
                    pdd.setId(nomeEquipamento);
                    pdd.setDataRegisto(LocalDate.now());

                    Plano pll = new PlanoExpress();
                    pdd.setPl(pll);
                    pdd.setOrcamento(pll.getCusto() + 10);//mao de obra + custo

                    ReadLoadPedidos.WritePedido(pdd);

                    Controller.allPedidos.add(pdd);

                    //Se foi feito com sucesso
                    return new Phase1("Pedido EXPRESS adicionado com sucesso!\n");
                }else{
                    ChangeWarningMessage("O pedido EXPRESS não pode ser efetuado devido a sobrecarga de pedidos\n");
                    return null;
                }
            }
        }
        String warning = "Só existem os seguintes Clientes (NIF) -> ";
        /*for (Pessoa p : Controller.allPessoas) {

            if ( ! (p instanceof Cliente))continue;
            warning += ((Cliente) p).getNIF() + " ";
        }*/
        for (Cliente cs : Controller.clientes) {
            warning += cs.getNIF() + " ";

        }
        warning += " !\n";
        ChangeWarningMessage(warning);
        return null;
    }
}