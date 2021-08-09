import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AutocarroInteligente extends Veiculo implements BonificaKms{
    private double ocupacao;
    private double pontos;

    public AutocarroInteligente (){
        super();
        this.ocupacao = 0;
        this.pontos = 0;
    }

    public AutocarroInteligente(String marca, String modelo, String matricula, int ano, double velociademedia, double precokm, List<Integer> classificacao, int kms, int kmsUltimo, double ocupacao, double pontos){
        super(marca,modelo,matricula,ano,velociademedia,precokm,classificacao,kms,kmsUltimo);
        this.ocupacao = ocupacao;
        this.pontos = pontos;
    }

    public AutocarroInteligente(AutocarroInteligente a){
        super(a);
        this.ocupacao = a.getOcupacao();
        this.pontos = a.getPontos();
    }

    public double getOcupacao(){
        return this.ocupacao;
    }

    public double custoRealKM(){
        double custo = 0;

        if(this.ocupacao<0.61 && this.ocupacao>=0) {
            custo = super.getKms() * super.getPrecokm() * 1.1 * 0.5;
        } else if(this.ocupacao>=0.61 && this.ocupacao<=1){
            custo = super.getKms() * super.getPrecokm() * 1.1 * 0.25;
        }
        return custo;
    }

    public double getPontos(){return pontos;}

    public void SetPontos(double pontos){
        this.pontos = pontos;
    }

    public double getPontosAcumulados(){
        return super.getKms()*this.pontos;
    }



}
