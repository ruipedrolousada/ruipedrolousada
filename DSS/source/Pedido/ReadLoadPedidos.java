package bin.Pedido;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import bin.Pessoas.*;

public class ReadLoadPedidos {
    public static String nameFile = "dados/pedidos.txt";


    public static void WritePedido(Pedido p){
        var fwriter = GetFileWriter();

        String writePedido = "";
        writePedido += GetNameClassPedido(p) + ";";
        writePedido += p.getId() + ";";
        writePedido += p.getNIF() + ";";
        writePedido += p.getDataRegisto() + ";";
        writePedido += p.getInicio() + ";";
        writePedido += p.getFim() + ";";
        writePedido += p.getOrcamento() + ";\n";
     
        System.out.println(writePedido);

        try {
            fwriter.write(writePedido);
            fwriter.flush();
            fwriter.close();
        } catch (Exception e) {e.printStackTrace();}

    }

    public static List<Pedido> ReadAllPedidos() {
        var br =  GetFileReader();
        var allLines=  br.lines().collect(Collectors.toList());
        List<Pedido> allPedidos = new ArrayList<Pedido>();
        Scanner sc= null;
        
        for (int i = 0; i < allLines.size(); i++) {
            sc = new Scanner(allLines.get(i));
            sc.useDelimiter(";");

            String className = sc.next();
            String id = sc.next();
            String NIF = sc.next();
            LocalDate registo = LocalDate.parse(sc.next());
            LocalDate inicio = LocalDate.parse(sc.next());
            LocalDate fim =  LocalDate.parse(sc.next());
            Integer orcamento = Integer.parseInt( sc.next());

            Plano pl = new Plano(0, orcamento);

            Pedido pI = new Pedido(id, NIF, registo, inicio, fim, orcamento, pl);

            
            if (pI != null)
            allPedidos.add(pI);
        }
        if (sc != null)
            sc.close();
        
            return allPedidos;
    }

    public static void RemovePedido(Pedido pdd)
    {
        var br =  GetFileReader();
        var allLines=  br.lines().collect(Collectors.toList());
        List<Pedido> allPedidos = new ArrayList<Pedido>();
        Scanner sc= null;

        File f = null;
        FileWriter filePedidos = null;
        //Abrir um ficheiro temporario
        try {
            f = new File("temp.txt");
            filePedidos = new FileWriter(f,true);


        
        for (int i = 0; i < allLines.size(); i++) {
            sc = new Scanner(allLines.get(i));
            sc.useDelimiter(";");
            sc.next();
            String id = sc.next();
            if (id.equals(pdd.getId()))
                continue;
            filePedidos.write(allLines.get(i) + "\n");
        }

        File inFile = new File(nameFile);
        inFile.delete();

        f.renameTo(inFile);
        filePedidos.close();
        sc.close();
    } catch (Exception e) { e.printStackTrace();}   
}


    private static FileWriter GetFileWriter()
    {
        try {
            File f = new File(nameFile);
            FileWriter filePedidos = new FileWriter(f,true);

            return filePedidos;
        } catch (Exception e) { e.printStackTrace(); return null;       }
    }
    private static BufferedReader GetFileReader()
    {
        try {
            File f = new File(nameFile);
            FileReader filePedidos = new FileReader(f);
            BufferedReader br = new BufferedReader(filePedidos);

            return br;
        } catch (Exception e) {e.printStackTrace(); return null;        }
    }

    private static String GetNameClassPedido(Pedido p)
    {
        String s;
        try {
            s = p.getClass().getSimpleName();
        } catch (Exception e) {
            s = "";
        }
        return s;
    }
}