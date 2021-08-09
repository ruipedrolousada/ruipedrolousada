import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class YouTube {

    private String nome;
    private int conteudo;
    private LocalDate data;
    private int resolucao;
    private int minutos;
    private int segundos;
    private String[] comentarios;
    private int likes;
    private int dislikes;

    public YouTube(){
        this.nome = "aeiou";;
        this.conteudo =1234;
        this.data = LocalDate.of(2001,5,23);
        this.resolucao = 1080;
        this.minutos = 360;
        this.segundos = 0;
        this.comentarios = new String[0];
        this.likes = 0;
        this.dislikes = 0;
    }

    public YouTube (String nome, int conteudo, LocalDate data, int resolucao, int minutos, int segundos, String[] comentarios, int likes, int dislikes){
        this.nome = nome;
        this.conteudo =  conteudo;
        this.data = data;
        this.resolucao =  resolucao;
        this.minutos = minutos;
        this.segundos = segundos;
        this.comentarios = comentarios;
        this.likes = likes;
        this.dislikes =dislikes;
    }

    public YouTube (YouTube you){
        this.nome = you.getNome();
        this.conteudo = you.getConteudo();
        this.data = you.getData();
        this.resolucao = you.getResolucao();
        this.minutos = you.getMinutos();
        this.segundos = you.getSegundos();
        this.comentarios = you.getComentarios();
        this.likes = you.getLikes();
        this.dislikes =  you.getDislikes();
    }

    public void insereComentario (String comentario){

        String[] comentarios = Arrays.copyOf(this.comentarios, this.comentarios.length + 1);
        int k = this.comentarios.length;
        comentarios[k] = comentario;
    }

    public long qtsDiasDepois(){
        LocalDate data = LocalDate.now();
        return ChronoUnit.DAYS.between(data, this.data);
    }

    public void thumbsUp(){
        setLikes(getLikes()+1);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getConteudo() {
        return conteudo;
    }

    public void setConteudo(int conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getResolucao() {
        return resolucao;
    }

    public void setResolucao(int resolucao) {
        this.resolucao = resolucao;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public String[] getComentarios() {
        return comentarios;
    }

    public void setComentarios(String[] comentarios) {
        this.comentarios = comentarios;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }
}


