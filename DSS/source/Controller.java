package bin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bin.Pedido.Pedido;
import bin.Pedido.ReadLoadPedidos;
import bin.Pessoas.Cliente;
import bin.Pedido.ReadLoadPedidosFinalizados;
//import bin.Pessoas.Cliente;
import bin.Pessoas.Cliente;
import bin.Pessoas.Pessoa;
import bin.Pessoas.ReadLoadClientes;
import bin.Pessoas.ReadLoadPessoas;

public class Controller {
    public  static List<Pessoa> allPessoas = new ArrayList<Pessoa>();
    public static List<Pedido> allPedidos = new ArrayList<>();
    public static List<Pedido> pedidosFinalizados = new ArrayList<>();
    public static List<Cliente> clientes = new ArrayList<>();


    public Controller()
    {
        LoadDataBase();
    }
    public static void LoadDataBase()
    {
        allPessoas = ReadLoadPessoas.ReadAllPessoa();
        allPedidos = ReadLoadPedidos.ReadAllPedidos();
        pedidosFinalizados = ReadLoadPedidosFinalizados.ReadAllPedidosFinalizados();
        clientes = ReadLoadClientes.ReadAllCliente();
    }

}
