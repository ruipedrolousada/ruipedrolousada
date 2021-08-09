import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DriveIt implements Serializable {

    private String matricula;
    private Map<String, Veiculo> viaturas;
    private Map<String, Comparator<Veiculo>> mapComp;

    public DriveIt() {
        this.matricula = "";
        this.viaturas = new HashMap<>();
        this.mapComp = new HashMap<>();
    }

    public DriveIt(String matricula, Map<String, Veiculo> viaturas, Map<String, Comparator<Veiculo>> mapComp) {
        this.matricula = matricula;
        for (Map.Entry<String, Veiculo> map : viaturas.entrySet()) {
            this.viaturas.put(map.getKey(), map.getValue().clone());
        }
        this.viaturas = viaturas.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,a->a.getValue().clone()));
        this.mapComp = mapComp.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public DriveIt(DriveIt drive) {

        this.viaturas = drive.getViaturas();
        this.mapComp = drive.getMapComp();

    }

    public Map<String, Veiculo> getViaturas() {
        Map<String, Veiculo> newMap = new HashMap<>();

        for (Map.Entry<String, Veiculo> map : this.viaturas.entrySet()) {
            newMap.put(map.getKey(), map.getValue().clone());

        }
        return newMap;

    }

    public Map<String, Comparator<Veiculo>> getMapComp(){
        return this.mapComp.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,a->a.getValue()));
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean existeVeiculo(String cod) {
        return (this.viaturas.containsKey(cod));
    }

    public int quantos() {
        int r = 0;
        for (Map.Entry<String, Veiculo> map : this.viaturas.entrySet()) {
            r++;
        }
        return r;
    }
    // return this.viaturas.size();

    public int quantos(String marca){
        int r=0;
        for (Map.Entry<String, Veiculo> map : this.viaturas.entrySet()){
            if(map.getValue().getMarca().equals(marca)) r++;

        }
        return r;
    }

    public Veiculo getveiculo(String cod) throws VeiculoNãoExiste{
        /*for (Map.Entry<String, Veiculo> map : this.viaturas.entrySey) {
            if (map.getKey().equals(cod)) return map.getValue();
        }*/
        if(this.viaturas.containsKey(cod)){
            return this.viaturas.get(cod).clone();
        }
        else throw new VeiculoNãoExiste(cod + "não existe\n");
    }

    public void adiciona(Veiculo v) throws VeiculoNãoExiste{
        if(existeVeiculo(v.getMatricula())){

            this.viaturas.put(v.getMatricula(), v.clone());

        }else throw new VeiculoNãoExiste(v.getMatricula() + "não existe\n");
    }

    public void List<Veiculo> getVeiculos(){
        return this.viaturas.values().stream().map(Veiculo::clone).collect(Collectors.toList());

    }

    public void adiciona(Set<Veiculo> vs) throws VeiculoNãoExiste{
        for(Veiculo v: vs){
            adiciona(v);
        }
    }

    public void registarAluguer(String codVeiculo, int numKms){
        if(this.viaturas.containsKey(codVeiculo)){
            this.viaturas.get(codVeiculo).addViagem(numKms);
        }
    }

    public void classificarVeiculo(String cod, int classificação){
        if(this.viaturas.containsKey(cod)){
            this.viaturas.get(cod).addClassificacao(classificação);
        }

    }

    public double custoRealKm(String cod){

        if(this.viaturas.containsKey(cod)){
            return this.viaturas.get(cod).custoRealKM();
        }
    }

    public int quantosT (String tipo){
        int r=0;
        for(Veiculo v: this.viaturas.values()){
            if(v.getClass().getSimpleName().equals(tipo)) r++;
        }
        return r;
    }

    public List<Veiculo> veiculosOrdenadosCusto(){
        return this.viaturas.values()
                .stream()
                .sorted(Comparator.comparingDouble(Veiculo::custoRealKM).reversed())
                .map(Veiculo::clone)
                .collect(Collectors.toList())


    }

    public Veiculo veiculoMaisBarato(){
        return this.viaturas.values()
                .stream()
                .sorted(Comparator.comparingDouble(Veiculo::custoRealKM))
                .collect(Collectors.toList())
                .get(0)
                .clone();

    }

    public Veiculo veiculoMenosUtilizado(){
        return this.viaturas.values()
                .stream()
                .sorted(Comparator.comparingDouble(Veiculo::getKms))
                .collect(Collectors.toList())
                .get(0)
                .clone();

    }


    public void alteraPromocao(boolean estado){
        for(Veiculo v : this.viaturas.values()){
            if(v instanceof VeiculosOcasiao){
                ((VeiculosOcasiao) v).setPromocao(estado);
            }
        }
    }

    public Set<Veiculo> ordenarVeiculos(){
        Set<Veiculo> res = new TreeSet<>();
        for(Veiculo v : this.viaturas.values()){
            res.add(v.clone());
        }
        //eturn new TreeSet<>(this.viaturas.values());
    }

    public List<Veiculo> ordenarVeiculoss(){
        return this.viaturas.values().stream().map(Veiculo::clone).collect(Collectors.toList());
    }

    public Set<Veiculo> ordenarVeiculos(Comparator<Veiculo> c){
        return  this.viaturas.values().stream().sorted(c).map(Veiculo::clone).collect(Collectors.toSet());
    }

    public Iterator<Veiculo> ordenarVeiculo(String criterio){
        Comparator<Veiculo> comp = this.mapComp.get(criterio);

        if(comp==null) return null;

        return this.viaturas.values().stream().sorted(comp).map(Veiculo::clone).iterator();
    }

    public List<BonificaKms> daoPontos(){
        return this.viaturas.values().stream().filter(v-> v instanceof BonificaKms).map(v->(BonificaKms)v.clone()).collect(Collectors.toList());
    }

    public void escreve (String filename) throws IOException{
        PrintWriter novo = new PrintWriter(filename);

        novo.println(this.toString());

        novo.flush();
        novo.close();
    }

    public void gravar(String filename) throws IOException, FileNotFoundException{

        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        //oos.writeObject(viaturas);
        //oos.writeObject(mapComp);
        //oos.writeObject(matricula);

        oos.writeObject(this);

        oos.flush();
        oos.close();

    }

    public DriveIt ler(String filename) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);

        //DriveIt.viaturas = (Map<String, Veiculo>)ois.readObject();
        //DriveIt.mapComp = (Map<String, Comparator<Veiculo>>)ois.readObject();
        //DriveIt.String = (String)ois.readObject();
        fis.close();
        ois.close();

        return (DriveIt) ois.readObject();
    }














}
