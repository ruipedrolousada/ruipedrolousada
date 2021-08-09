import java.security.AllPermission;
import java.util.*;
import java.util.stream.Collectors;

public class TurmaAlunos {

    private Map<String, Aluno> turma;

    public TurmaAlunos(){
        this.turma = new HashMap<>();
    }

    public TurmaAlunos(Map<String, Aluno> turma){
        this();
        for (Map.Entry<String, Aluno> map : turma.entrySet()){
            this.turma.put(map.getKey(), map.getValue().clone());
        }
    }

    public TurmaAlunos(TurmaAlunos turmaAlunos){
        this.turma = turmaAlunos.getTurma();
    }

    public Map<String, Aluno> getTurma() {
        Map<String, Aluno> newMap = new HashMap<>();

        for (Map.Entry<String, Aluno> map : this.turma.entrySet()){
            newMap.put(map.getKey(), map.getValue().clone());
        }

        return newMap;
    }

    public void insereAluno(Aluno a){
        if(a != null){
            this.turma.put(a.getNumero(), a.clone());
        }
    }

    public Aluno getAluno(String codAluno){
        if (this.turma.containsKey(codAluno)){
            return this.turma.get(codAluno).clone();
        }
        return null;
    }

    public void removeAluno(String codAluno){
        this.turma.remove(codAluno);
    }

    public Set<String> todosOsCodigos() {
        Set<String> ola = new HashSet<>();

        for (Aluno map : this.turma.values()) {
            ola.add(map.toString());
        }
    }

    public int qtsAlunos(){

        /*int r=0;
        for (String map : this.turma.keySet()){
            r++;
        }*/

        return this.turma.keySet().size();

    }

    public Collection<Aluno> alunosOrdemAlfabetica(){
        /**
        Collection<Aluno> ole = new ArrayList<>();

        for (Map.Entry<String, Aluno> map : this.turma.entrySet()){
            ole.add(map.getValue());
        }
        return ole.stream().sorted().collect(Collectors.toList()); */

        return this.turma
                .values()
                .stream()
                .sorted(Aluno::compareTo)
                .collect(Collectors.toList());
    }

    public Set<Aluno> alunosOrdemDescrescenteNumero() {
        Set<Aluno> set1 = new TreeSet<>();

        for (Aluno map : this.turma.values()) {
            set1.add(map.clone());
        }

        set1.stream().sorted(Comparator.reverseOrder());
        return set1;

        //return this.turma.values().stream().sorted(Comparator.comparing(Aluno::getNome)).map(Aluno::clone)
    }


}
