import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Encomenda {

    private String nome;
    private String morada;
    private int numeroCliente;
    private int numeroEncomenda;
    private LocalDate data;
    private ArrayList<LinhaEncomenda> linhas;

    public Encomenda() {
        this.nome = "Maria";
        this.morada = "Avenida dos Lusiadas";
        this.numeroCliente = 232406471;
        this.numeroEncomenda = 4321;
        this.data = LocalDate.now() ;
        this.linhas = new ArrayList<>();
    }

    public Encomenda(String nome, String morada, int numeroCliente, int numeroEncomenda, LocalDate data, ArrayList<LinhaEncomenda> linhas) {

        this.nome = nome;
        this.morada = morada;
        this.numeroCliente = numeroCliente;
        this.numeroEncomenda = numeroEncomenda;
        this.data = data;
        this.linhas = linhas;
    }

    public Encomenda(Encomenda enc) {
        this.nome = enc.getNome();
        this.morada = enc.getMorada();
        this.numeroCliente = enc.getNumeroCliente();
        this.numeroEncomenda = enc.getNumeroEncomenda();
        this.data = enc.getData();
        this.linhas = enc.getLinhas();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public int getNumeroEncomenda() {
        return numeroEncomenda;
    }

    public void setNumeroEncomenda(int numeroEncomenda) {
        this.numeroEncomenda = numeroEncomenda;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public ArrayList<LinhaEncomenda> getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList<LinhaEncomenda> linhas) {
        this.linhas = linhas;
    }

    public double calculaValorTotal(){
        /*double x=0;
        for(LinhaEncomenda l : this.linhas) x += l.calculaValorLinhaEnc();
        return x;*/
        return this.linhas.stream().mapToDouble(LinhaEncomenda :: calculaValorLinhaEnc).sum();
    }

    public double calculaValorDesconto(){
        double x=0;
        for(LinhaEncomenda l : this.linhas) x += l.calculaValorDesconto();
        return x;
    }

    public int numeroTotalProdutos(){
        int x=0;
        for(LinhaEncomenda l : this.linhas) x += l.getQuantidade();
        return x;
    }

    public boolean existeProdutoEncomenda(String refProduto){

        for (LinhaEncomenda l : this.linhas) {
            if(l.getReferencia().equals(refProduto)) return true;
        }
        return false;
    }

    public void adicionaLinha(LinhaEncomenda linha){
        this.linhas.add(linha);
    }

    public void removeProduto(String codProd){
        for (LinhaEncomenda l : this.linhas){
            if(l.getReferencia().equals(codProd)) this.linhas.remove(l);
        }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Encomenda encomenda = (Encomenda) o;
        return numeroCliente == encomenda.numeroCliente && numeroEncomenda == encomenda.numeroEncomenda && data == encomenda.data && Objects.equals(nome, encomenda.nome) && Objects.equals(morada, encomenda.morada) && Objects.equals(linhas, encomenda.linhas);
    }


    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /*public Encomenda clone(){
        return new Encomenda(this);
    } */

    public String toString() {
        return "Encomenda{" +
                "nome='" + this.nome + '\'' +
                ", morada='" + this.morada + '\'' +
                ", numeroCliente=" + this.numeroCliente +
                ", numeroEncomenda=" + this.numeroEncomenda +
                ", data=" + this.data +
                ", linhas=" + this.linhas +
                '}';
    }
}


