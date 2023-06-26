package bin;


import java.util.List;
import java.util.ArrayList;

import bin.Phase;
import bin.Phase1;
import bin.Pessoas.Pessoa;
import bin.Pessoas.ReadLoadPessoas;
import bin.Controller;

public class Phase3 extends Phase {
    public Phase3(){

    Messages =  new String[]{ "Registe-se no Sistema"," " };
    TipForInput = "Insira o nome";
    InputForStages = new String[]{ 
        "Insira o encargo",
        "Insira uma password" };
    numberStages = InputForStages.length +1;
    }

    @Override
    public Phase HandleCommand(List<String> s) {
        
        String name =     s.get(0);
        String cargo =    s.get(1);
        String password = s.get(2);

        //Se nao existir esse usuario na base de dados
        for (Pessoa p : Controller.allPessoas) {
            if (p.getNome().equals(name))
            {
                //Já existe um usuario com esse nome :(
                ChangeWarningMessage("Já existe um usuario com esse nome!\n");
                return null;
            }
        } 

        //Se o cargo nao existir na nossa base de dados
        if (!ReadLoadPessoas.stringPessoas.containsKey(cargo))
        {
            String messageTemp = "Encargos disponiveis -> ";
            for (String string : ReadLoadPessoas.stringPessoas.keySet()) {
                messageTemp += string + " ";
            }
            messageTemp += "\n";
            ChangeWarningMessage(messageTemp);
            return null;
        }
        
        Pessoa p = ReadLoadPessoas.BuildPessoaFromString(cargo, name, "randomID", password);

        //Guardar na base de dados
        ReadLoadPessoas.WritePessoa(p);
        
        Phase1.currentPessoa = p;
        //Se foi feito com sucesso        
        return new Phase1("Registo efetuado com Sucesso!\n");

    }
}
