package Clientes.Menu.Phases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Stack;

import Clientes.Client;
import Connections.Demultiplexer;
import Connections.BreadthFirst;
import Viagens.Cidade;

public class PhaseBooking extends Phase {
    
    public PhaseBooking(Demultiplexer dm)
    {
        super(dm);

        List<Cidade> allCities = Client.GetClientData().GetAllCidades();

        String arr[] = new String[allCities.size() +1];
        arr[0] = "Fazer Reserva";
        for (int i = 0; i < allCities.size(); i++) {
            arr[i+1] = allCities.get(i).getNome();
        }

        Messages =arr;
        
        TipForInput = "Origem";

        InputForStages = new String[]{
            "Destino",
            "Dia(dd-MM-YYYY)",
        };
        numberStages = InputForStages.length +1;
        this.dm = dm;
    }

    @Override
    public Phase HandleCommand(List<String> s) {
        if (s.get(0).isEmpty() || s.get(1).isEmpty())
            return null;
        
        //Converter braga para Braga
        String origin = ConvertToUpperCase(s.get(0));
        String destiny = ConvertToUpperCase(s.get(1));

        Cidade origem = new Cidade(origin);
        Cidade destino = new Cidade(destiny);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date;
        try {
            date = LocalDate.parse(s.get(2), formatter);
        } catch (Exception e) {
            ChangeWarningMessage("Data nao é valida\n");
            return null;
        }

        try {
            String reservationID = HandleVooConnections(origem,destino,date);
            if (reservationID.equals("-1"))
            {
                 //Id de reserva nao é valido, tratar da reserva falhada
                 ChangeWarningMessage("Voo com lotação maxima, tente outra data\n");
                 return null;
            }
            if(reservationID.equals("-2"))
            {
                ChangeWarningMessage("O voo nao existe, peça ao admin para introduzir esse voo\n");
                return null;
            }
            if(reservationID.equals("encerrado")) ChangeWarningMessage("Erro: O dia já se encontra encerrado!");
            String sucessMessage = "Reserva de "+ origin + " para o destino " + destiny + " foi adicionada com sucesso!\n"
             + "ID de Reserva: "+reservationID+"\n";
            return new PhaseMainMenu(dm,sucessMessage);

        } catch (Exception e) {
            ChangeWarningMessage(e.getMessage()+"\n");
            return null;
        }

    }

    private String HandleVooConnections(Cidade origem, Cidade destino, LocalDate dia) throws Exception {
        Stack<Cidade> caminhoStack = null;
        
        caminhoStack = BreadthFirst.BFS(clientData.GetAllVoos(), origem, destino);

        StringBuilder sb = new StringBuilder();
        sb.append(caminhoStack.size()).append(";");
        while(!caminhoStack.empty())
        {
            sb.append(caminhoStack.pop().getNome()).append(";");
        }

        sb.append(dia).append(";");

        //4;Braga;Veneza;Turim;Nevada;12-01-2001;
        String message = sb.toString();
        System.out.println(message);

        dm.send(4,message.getBytes());
        String idReserva = new String( dm.receive(4));

        return idReserva;
    }

    private String ConvertToUpperCase(String s1) {
        return Character.toUpperCase(s1.charAt(0)) + s1.substring(1);
    }
}
