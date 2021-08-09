import java.util.ArrayList;
import java.util.List;

/**
 * Escreva a descrição da classe Main aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Main{
    public static void main(String[] args) throws Exception {
        Gestor g = new Gestor();
        try{ 
            g = LoadWrite.loadTextFile(args[0]);
        }catch(LinhaInvalidaException e){
            System.out.println("Ficheiro " + args[0] + "esta mal formado."); 
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Nao foi passado ficheiro , inicializando um gestor vazio.");
        }
        cFM controller = new Controller();
        mFM model = new Model(g,controller);
        vFM view = new View(controller);
        controller.addModel(model);
        controller.addView(view);
        view.run();
    }
}
