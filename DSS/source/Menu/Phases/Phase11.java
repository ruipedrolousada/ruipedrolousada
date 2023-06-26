package bin;

import bin.Controller;
import bin.Pessoas.Cliente;
import bin.Pessoas.Pessoa;
import bin.Pessoas.ReadLoadClientes;
import bin.Pessoas.ReadLoadPessoas;
import bin.Phase;
import bin.Phase1;

import java.util.List;

public class Phase11 extends Phase {
    public Phase11(){

        Messages =  new String[]{ "Adicionar novo Cliente"," " };
        TipForInput = "Insira o nome";
        InputForStages = new String[]{
                "Insira o NIF",};
        numberStages = InputForStages.length +1;
    }

    @Override
    public Phase HandleCommand(List<String> s) {

        String name = s.get(0);
        String nif =  s.get(1);

        if (!nif.matches("[0-9]+")){
            ChangeWarningMessage("Insira um NIF válido!\n");
            return null;
        }

        //Se nao existir esse usuario na base de dados
        for (Cliente c : Controller.clientes) {
            if (c.getNIF().equals(nif))
            {
                //Já existe um usuario com esse nome :(
                ChangeWarningMessage("Já existe um usuario com esse nif!\n");
                return null;
            }
        }

        Cliente cs = ReadLoadClientes.BuildClienteFromString(name, nif);

        Controller.clientes.add(cs);
        //Guardar na base de dados
        ReadLoadClientes.WriteCliente(cs);


        return new Phase1("Cliente adicionado com Sucesso!\n");

    }
}