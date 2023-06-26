package Clientes.Menu.Phases;

import java.util.List;

import Connections.Demultiplexer;

public class PhaseMainMenu extends Phase{
    static boolean isAdmin= false;
    public PhaseMainMenu(Demultiplexer dm,boolean adminValue)
    {
        this(dm);

        isAdmin = adminValue;
        SetMessages();

    }
    public PhaseMainMenu(Demultiplexer dm,String sucessMessage)
    {
        this(dm);
        ChangeSucessMessage(sucessMessage);
    }

    public PhaseMainMenu(Demultiplexer dm)
    {
        super(dm);

        SetMessages();
        TipForInput = "$";
        InputForStages = new String[]{};
        numberStages = InputForStages.length +1;
    }
    private void SetMessages() {
        if (isAdmin)
        { 
            Messages = new String[]{
            "Trabalho Pratico SD",
            "",
            "Menu",
            "quit -> Sair do programa",
            "add -> adicionar um novo voo",
            "cancel -> cancelar uma reserva",
            "close -> encerrar as reservas um dia",
            "register -> registar um usuario",
            };

        }
        else
        {
            Messages =  new String[]{
                "Trabalho Pratico SD",
                "",
                "Menu",
                "quit -> Sair do programa",
                "book -> fazer uma reserva",
                "show -> mostrar voos",
                "cancel -> cancelar uma reserva"
            };
        }
        
    }

    @Override
    public Phase HandleCommand(List<String> s) {
        String command = s.get(0);

        return HandleConsole(command,isAdmin);
    }

    public Phase HandleConsole(String command,boolean admin)
    {
        if (isAdmin){
            switch (command) {
                case "book":
                    return new PhaseBooking(dm);
                case "add":
                    return new PhaseAdmInserirVoo(dm);
                case "close":
                    return new PhaseEncerrarDia(dm);
                case "cancel":
                    return new PhaseCancelarReserva(dm);
                case "register":
                    return new PhaseRegisto(dm);
                default:
                    break;
            }
        }
        else{
            switch (command) {
                case "book":
                    return new PhaseBooking(dm);
                case "show":
                    return new PhaseShowVoos(dm);
                case "cancel":
                    return new PhaseCancelarReserva(dm);
                default:
                    break;
            }
        }

        return null;
    }
}
