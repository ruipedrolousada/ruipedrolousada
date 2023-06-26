package bin.Pessoas;

import bin.Pessoas.Pessoa;

public class Cliente {
    private String NIF;

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public Cliente(String NIF, String nome) {
        //super(nome, ID, password);
        this.NIF = NIF;
        this.nome = nome;
    }
    
}
