package bin.Pessoas;

public abstract class Pessoa {
    protected String nome;
    protected String ID;
    protected String password;

    public Pessoa(String nome,String ID,String password)
    {
        this.nome = nome;
        this.ID = ID;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
