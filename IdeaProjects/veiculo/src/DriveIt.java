import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DriveIt {

    private String nome;
    private Map<String,Veiculo> veiculos;
    private boolean promocao;

    public DriveIt(){
        this.nome = "";
        this.veiculos = new HashMap<>();
        this.promocao = false;
    }

    public DriveIt(String n, Map<String , Veiculo> vs){
        this.nome = n;
        setVeiculos(vs);
        this.promocao = false;
    }

    public DriveIt(DriveIt di){
        this.nome = di.getNome();
        this.veiculos = di.getVeiculos();
        this.promocao = di.getPromocao();
    }


    public String getNome(){ return this.nome; }

    public Map<String,Veiculo> getVeiculos (){
        Map<String,Veiculo> aux = new HashMap<>();
        for(Veiculo v : this.veiculos.values())
            aux.put(v.getMatricula(),v.clone());
        return aux;
    }

    public boolean getPromocao(){ return this.promocao; }

    public void setVeiculos(Map<String,Veiculo> vs){
        this.veiculos = new HashMap<>();
        for(Veiculo v : vs.values())
            this.veiculos.put(v.getMatricula(),v.clone());
    }

    public void setPromocao(boolean p){
        this.promocao = p;
    }

    // clone, equals, toString

    //1
    // a)
    public boolean existeVeiculo(String cod){
        return this.veiculos.containsKey(cod);
    }

    // b)
    public int quantos(){
        return this.veiculos.size();
    }

    // c)
    public int quantos(String marca){
        return (int) this.veiculos.values().stream()
                .filter(v->v.getMarca().equals(marca))
                .count();
    }

    // d)
    public Veiculo getVeiculo(String cod){
        return this.veiculos.get(cod);
    }

    // e)  RESOLVER COM PUT
    public void adiciona(Veiculo v){}

    // f)
    public List<Veiculo> getVeiculosAsList(){
        return this.veiculos.values().stream()
                .map(Veiculo::clone)
                .collect(Collectors.toList());
    }

    // g)
    public void adiciona(Set<Veiculo> vs){}

    // h)
    public void registarAluguer(String codVeiculo, int numKms){}

    // i)
    public void classificarVeiculo(String cod, int classificacao){}

    // j)
    public int custoRealKm(String cod){ return 0;}

}