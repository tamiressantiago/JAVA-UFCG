package dicas;

/**
 * A classe Multimidia implementa a interface Elemento e representa um elemento multimídia em uma dica.
 * 
 * @author Tamires Santiago Oliveira - 123210205
 */

public class Multimidia implements Elemento{
    private String cabecalho;
    private String link;
    private int tamanhoSegundos;

    /**
     * Construtor para a classe Multimidia.
     *
     * @param link O link para o conteúdo multimídia.
     * @param cabecalho O cabeçalho ou título do conteúdo multimídia.
     * @param tempo O tempo de duração do conteúdo multimídia em segundos.
     */
    public Multimidia(String link, String cabecalho, int tempo) {
        this.link = link;
        this.cabecalho = cabecalho;
        this.tamanhoSegundos = tempo;
    }

    /**
     * Retorna uma representação em String do conteúdo multimídia.
     *
     * @return Uma String contendo o cabeçalho e o link para o conteúdo multimídia.
     */
    public String toString() {
        return cabecalho + "\n" + link;
    }

    /**
     * Retorna uma representação detalhada em String do conteúdo multimídia.
     *
     * @return Uma String contendo o cabeçalho, o link e a duração do conteúdo multimídia.
     */
    @Override
    public String detalhes() {
        return toString() + " " + tamanhoSegundos;
    }

    /**
     * Calcula e retorna o valor do conteúdo multimídia.
     *
     * @return Um inteiro representando o valor do conteúdo multimídia.
     */
    @Override
    public int valor() {
        int pontos = (tamanhoSegundos/60) * 5;
        if(pontos > 50)
            pontos = 50;
        return pontos;
    }
}