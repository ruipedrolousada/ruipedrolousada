package Viagens;

public class Cidade {
    String nome;

    public Cidade(String nome)
    {
        this.nome = nome;
    }
    public Cidade(){
        nome = this.getNome();
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof Cidade))
            return false;
        Cidade c = (Cidade) obj;

        return c.getNome().toLowerCase().equals( nome.toLowerCase());
    }
    //As cidadas iguais estavam a ter hash diferentes, metodo teve de ser reescrito para definir a hash apenas como o nome
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + nome.hashCode();
        return result;
    }
    
}