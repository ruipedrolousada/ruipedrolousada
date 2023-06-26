package bin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public abstract class Phase {
    protected  String[] Messages;
    protected  String TipForInput;
    public  int numberStages = 1;
    protected  String[] InputForStages;
    protected String warningMessageTop = "";
    protected String sucessMessage = "";

    public String Show(Scanner sc)
    {
        if (!warningMessageTop.isEmpty())
            System.out.print(warningMessageTop);
        
        ShowMenu.Print(Messages,TipForInput,sucessMessage);
        System.out.print(":");  
        return sc.nextLine();
    }

    public String Next(Scanner sc,int i)
    {
        System.out.print(InputForStages[i] + ":");            
        return sc.nextLine();
    }

    public abstract Phase HandleCommand(List<String> s);

    protected void ChangeWarningMessage(String s) {
        warningMessageTop = s;
    }
    protected void ChangeSucessMessage(String s)
    {
        sucessMessage = s;
    }
  
}
