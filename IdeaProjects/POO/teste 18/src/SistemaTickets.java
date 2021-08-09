import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SistemaTickets<TicketSuporte> {
    private Map<String ,Tecnico> funcionarios ; // funcionarios da empresa
    private List<TicketSuporte> ticketsPorResolver ; // tickets ainda n~ao tratados
    private List<TicketSuporte> ticketsResolvidos ; // tickets j´a satisfeitos

    public void adicionaTicket(TicketSuporte t){

        //List<TicketSuporte> sk = new ArrayList<>();
        ticketsPorResolver.add(t.clone());

    }

    public void resolveTicket(String ident) throws TecnicoNaoExisteException{
        ticketsPorResolver.remove(ident.clone)
    }
}
