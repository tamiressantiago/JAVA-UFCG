package dicas;

/**
 * A classe Referencia implementa a interface Elemento e representa uma referência em uma dica.
 * 
 * @author Tamires Santiago Oliveira - 123210205
 */
public class Referencia implements Elemento{
    private String titulo;
    private String fonte;
    private int ano;
    private int importancia;
    private boolean conferida;

    /**
     * Construtor para a classe Referencia.
     *
     * @param titulo O título da referência.
     * @param fonte A fonte da referência.
     * @param ano O ano da referência.
     * @param conferida Um booleano indicando se a referência foi conferida.
     * @param importancia A importância da referência.
     */
    public Referencia(String titulo, String fonte, int ano, boolean conferida, int importancia) {
        this.titulo = titulo;
        this.fonte = fonte;
        this.ano = ano;
        this.importancia = importancia;
        this.conferida = conferida;
    }

    /**
     * Retorna uma representação em String da referência.
     *
     * @return Uma String contendo o título, a fonte, o ano e se a referência foi conferida.
     */
    public String toString() {
        String conf = "Não Conferida";
        if(conferida)
            conf = "Conferida";
        return "Título: " + titulo + "\nFonte: " + fonte + ", ano: " + ano + "\n" + conf;
    }

    /**
     * Retorna uma representação detalhada em String da referência.
     *
     * @return Uma String contendo o título, a fonte, o ano, se a referência foi conferida e a importância.
     */
    @Override
    public String detalhes() {
        return toString() + ". Importância: " + importancia;
    }

    /**
     * Calcula e retorna o valor da referência.
     *
     * @return Um inteiro representando o valor da referência. Se a referência foi conferida, o valor é 15, caso contrário, é 0.
     */
    @Override
    public int valor() {
        if(conferida)
            return 15;
        return 0;
    }
}