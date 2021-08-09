import java.time.LocalDateTime;

public class TicketSuporte {
    private String nomeO ; // quem originou o pedido
    private LocalDateTime horaOcorrencia ; // instante do report do ticket
    private String assunto ;
    private String descricao ;
    private String identTecnico ; // t´ecnico que resolveu o ticket
    private LocalDateTime horaFecho ; // instante do fecho do ticket

    // m´etodo que efectua a resolu¸c~ao de um ticket .
//O algoritmo de resolu¸c~ao est´a codificado neste m´etodo .
    public void executaTarefa () {...}

    public TicketSuporte(){
        this.nomeO = "";
        this.horaOcorrencia = null;
        this.assunto = "";
        this.descricao = "";
        this.identTecnico = "";
        this.horaFecho = null;
    }

    public TicketSuporte (TicketSuporte ts){
        this.nomeO = ts.getNomeO();
        this.horaOcorrencia = ts.getHoraOcorrencia();
        this.assunto = ts.getAssunto();
        this.descricao =  ts.getDescricao();
        this.identTecnico =  ts.getIdentTecnico();
        this.horaFecho = ts.getHoraFecho();
    }

    public String getNomeO() {
        return nomeO;
    }

    public LocalDateTime getHoraOcorrencia() {
        return horaOcorrencia;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getIdentTecnico() {
        return identTecnico;
    }

    public LocalDateTime getHoraFecho() {
        return horaFecho;
    }

    public TicketSuporte clone(){
        return new TicketSuporte(this);
    }
}
