import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

public class parque {

    private String nome;
    private Map<String,Lugar> lugares;

    public parque(String nome, Map<String,Lugar> lugares){
        this();
        this.nome = nome;

        for (Map.Entry<String, Lugar> map : this.lugares.entrySet()){
            this.lugares.put(map.getKey(), map.getValue().clone());
        }

    }
    public parque (parque p){
        this.nome = p.getNome();
        this.lugares = p.getLugares();
    }
    public parque (){
        this.nome = "";
        this.lugares = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<String ,Lugar> getLugares() {

        Map<String, Lugar> newMap = new HashMap<>();

        for (Map.Entry<String, Lugar> map : this.lugares.entrySet()){
            newMap.put(map.getKey(), map.getValue().clone());
        }

        return newMap;

       // return this.lugares.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, l -> l.getValue().clone()));
    }

    public void setLugares(Map<String,Lugar> spot) {

        this.lugares = new HashMap<>();

        for (Map.Entry<String, Lugar> map : spot.entrySet()){
            lugares.put(map.getKey(), map.getValue().clone());
        }
    }

    public ArrayList<String> devolveMatriculaOcupados(){

        ArrayList<String> newL = new ArrayList<>();

        for (Map.Entry<String, Lugar> map : lugares.entrySet()){
            newL.add(map.getKey());
        }

        return newL;

        //return this.lugares.keySet().stream().collect(ArrayList::new);
    }

    public void novoLugar(Lugar l){
        this.lugares.put(l.getMatricula(), l.clone());

    }

    public void removeLugar(String matricula){
        this.lugares.remove(matricula);
    }

    public void alteraTempo (String matricula, int tempo) {
        //Iterator<Lugar> it = this.lugares.values().iterator();

        for (Map.Entry<String, Lugar> map : this.lugares.entrySet()){
            if (map.getKey().equals(matricula)) map.getValue().setMinutos(tempo);
        }
    }

    public int totalMinutos (){
    /*
        int r=0;

        for (Map.Entry<String,Lugar> map : lugares.entrySet()){
            r += map.getValue().getMinutos();
        }

        return r; */

        return this.lugares
                .values()
                .stream()
                .mapToInt(Lugar::getMinutos)
                .sum();
    }

    public boolean lookupMatricula (String matricula){

        return this.lugares.containsKey(matricula);

        //for (Map.Entry<String, Lugar> map : this.lugares.entrySet()){

        // return r;

    }

    public ArrayList<String> listaMatriculas (int x){

        ArrayList<String> newL = new ArrayList<>();
        for (Map.Entry<String,Lugar> map : this.lugares.entrySet()){

            if(map.getValue().getMinutos()>x && map.getValue().getPermanente()){
                newL.add(map.getKey());
            }

        }
        return newL;
    }

    public Map<String,Lugar> cloneLugares (){

       return this.lugares
               .entrySet()
               .stream()
               .collect(Collectors.toMap(Map.Entry :: getKey, lugar -> lugar.getValue().clone()));
    }

    public String info(String matricula){

        for (String mat : this.lugares.keySet()){
            if (mat.equals(matricula)) return mat;
        }
        return null;
    }

}
