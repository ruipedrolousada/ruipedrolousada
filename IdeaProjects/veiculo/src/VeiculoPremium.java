import java.util.ArrayList;
public class VeiculoPremium extends Veiculo{

    private int taxa;

    public VeiculoPremium(){
        super();
        this.taxa = 0;
    }

    public VeiculoPremium(String marca, String modelo, String matricula,int ano,double velocidademedia, double kmperco,ArrayList<Integer> classificacao,int kms,int KmsUltimo,int taxa){
        super(marca,modelo,matricula,ano,velocidademedia,kmperco,classificacao,kms,kmsUltimo);
        this.taxa = taxa;

    }

    public VeiculoPremium clone(){
        return new VeiculoPremium(this);
    }


}
