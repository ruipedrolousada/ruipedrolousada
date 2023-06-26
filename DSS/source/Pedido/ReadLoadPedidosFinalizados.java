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

public class ReadLoadPedidosFinalizados {
    public static String nameFile = "dados/pedidosFinalizados.txt";


    public static void WritePedido(Pedido p){
        var fwriter = GetFileWriter();

        String writePedido = "";
        writePedido += GetNameClassPedido(p) + ";";
        writePedido += p.getId() + ";";
        writePedido += p.getNIF() + ";";
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

    public static List<Pedido> ReadAllPedidosFinalizados() {
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
            LocalDate inicio = LocalDate.parse(sc.next());
            LocalDate fim =  LocalDate.parse(sc.next());
            Integer orcamento = Integer.parseInt( sc.next());

            Plano pl = new Plano(0, orcamento);

            Pedido pI = new Pedido(id, NIF, inicio, inicio, fim, orcamento, pl);

            
            if (pI != null)
            allPedidos.add(pI);
        }
        if (sc != null)
            sc.close();
        
            return allPedidos;
    }

//.......



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
