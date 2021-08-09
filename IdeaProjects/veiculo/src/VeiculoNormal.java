public class VeiculoNormal extends Veiculo{

    public VeiculoNormal(){
        super();
    }

    public VeiculoNormal(String marca, String modelo, String matricula,int ano,double velocidademedia, double kmperco,ArrayList<Integer> classificacao,int kms,int KmsUltimo,int taxa){
        super(marca,modelo,matricula,ano,velocidademedia,kmperco,classificacao,kms,kmsUltimo);

    }

    public VeiculoNormal clone(){
        return new VeiculoNormal(this);
    }
