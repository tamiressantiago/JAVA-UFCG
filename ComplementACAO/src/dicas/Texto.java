package dicas;
/**
 * A classe Texto implementa a interface Elemento e representa um texto em uma dica.
 * 
 * @author Tamires Santiago Oliveira - 123210205
 */
public class Texto implements Elemento{
    private String texto;

    /**
     * Construtor para a classe Texto.
     *
     * @param texto O texto da dica. Deve ter no máximo 500 caracteres.
     * @throws IllegalArgumentException Se o texto tiver mais de 500 caracteres.
     */
    public Texto(String texto) {
        if(texto.length() > 500)
            throw new IllegalArgumentException("Limite de caracteres excedido.");
        this.texto = texto;
    }

    /**
     * Retorna uma representação em String do texto.
     *
     * @return O texto da dica.
     */
    public String toString() {
        return texto;
    }

    /**
     * Retorna uma representação detalhada em String do texto.
     *
     * @return Uma String contendo o texto e o número de caracteres.
     */
    @Override
    public String detalhes() {
        return toString() + "\n" + texto.length() + " caracteres.";
    }

    /**
     * Calcula e retorna o valor do texto.
     *
     * @return Um inteiro representando o valor do texto. Se o texto tiver 100 caracteres ou mais, o valor é o número de caracteres dividido por 10, até um máximo de 50.
     */
    @Override
    public int valor() {
        int valor = 0;
        if(texto.length() >= 100)
            valor = texto.length() / 10;
        if(valor > 50)
            valor = 50;
        return valor;
    }
}