package bin;
import java.time.LocalDate;
import java.util.*;

import bin.Controller;
import bin.Interpreter;
import bin.Pedido.*;
import bin.Pessoas.*;
public class Main {
    
    public static void main(String[] args) {

        Controller.LoadDataBase();
        
        Interpreter it = new Interpreter();
        it.Initialize();
    }

}
