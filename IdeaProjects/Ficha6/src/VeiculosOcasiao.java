import java.util.ArrayList;
import java.util.List;

public class VeiculosOcasiao extends Veiculo{

    private boolean promocao;

    public VeiculosOcasiao(){
        super();
        this.promocao = false;
    }

    public VeiculosOcasiao(String marca, String modelo, String matricula, int ano, double velociademedia, double precokm, List<Integer> classificacao, int kms, int kmsUltimo, boolean promocao) {
        super(marca,modelo,matricula,ano,velociademedia,precokm,classificacao,kms,kmsUltimo);
        this.promocao =  promocao;
    }

    public VeiculosOcasiao(VeiculosOcasiao v) {
        super(v);
        this.promocao = v.getPromocao();

    }

    public boolean getPromocao(){
        return promocao;
    }
    public void setPromocao(boolean promocao){
        this.promocao = promocao;

    }
    public VeiculosOcasiao clone(){
        return new VeiculosOcasiao(this);
    }

    public double custoRealKM() {
        double custo = 0;
        if (promocao) {
            custo = super.getKms() * 1.1 * 0.75;
        } else {
            custo = super.getKms() * 1.1;
        }
        return custo;
    }



}
