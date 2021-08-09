import java.util.List;

public class VeiculoPremium extends Veiculo implements BonificaKms{

    private double taxaLuxo;
    private double pontos;

    public VeiculoPremium (){
        super();
        this.taxaLuxo = 0;
        this.pontos = 0;

    }

    public VeiculoPremium(String marca, String modelo, String matricula, int ano, double velociademedia, double precokm, List<Integer> classificacao, int kms, int kmsUltimo, double taxaLuxo, double pontos){
        super(marca,modelo,matricula,ano,velociademedia,precokm,classificacao,kms,kmsUltimo);
        this.taxaLuxo = taxaLuxo;
        this.pontos =  pontos;
    }

    public VeiculoPremium(VeiculoPremium v){
        super(v);
        this.taxaLuxo = v.getTaxaLuxo();
        this.pontos = v.getPontos();
    }

    public double getTaxaLuxo(){
        return taxaLuxo;
    }


    public double custoRealKM (){
        return super.getPrecokm()*taxaLuxo;
    }

    public double getPontos(){return pontos;}

    public void SetPontos(double pontos){
        this.pontos = pontos;
    }

    public double getPontosAcumulados(){
        return super.getKms()*this.pontos;
    }






}
