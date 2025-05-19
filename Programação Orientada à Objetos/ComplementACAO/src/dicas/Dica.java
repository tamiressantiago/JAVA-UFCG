package dicas;

import java.util.ArrayList;
import java.util.List;

import estudante.Estudante;

/**
 * A classe Dica representa uma dica que contém uma lista de elementos.
 * Cada dica é associada a um autor e um tema.
 * 
 * @author Tamires Santiago Oliveira - 123210205
 */
public class Dica {
    private Estudante autor;
    private String tema;
    private List<Elemento> elementos;

    /**
     * Construtor para a classe Dica.
     *
     * @param autor O autor da dica.
     * @param tema O tema da dica.
     */
    public Dica(Estudante autor, String tema) {
        this.elementos = new ArrayList<>();
        this.tema = tema;
        this.autor = autor;
    }

    /**
     * Retorna uma representação em String da dica.
     *
     * @return Uma String contendo o nome do autor e os elementos da dica.
     */
    public String toString() {
        String saida = autor.getNome() + "\n";
        for(Elemento e: elementos) {
            saida += "\n" + e.toString();
        }
        return saida;
    }

    /**
     * Retorna uma representação detalhada em String da dica.
     *
     * @return Uma String contendo o nome do autor, o tema e os detalhes dos elementos da dica.
     */
    public String detalhes() {
        String saida = autor.getNome() + "\nTema: " + tema;
        for(Elemento e: elementos) {
            saida += "\n" + e.detalhes();
        }
        return saida;
    }

    /**
     * Adiciona um elemento de texto à dica.
     *
     * @param texto O texto do elemento.
     * @param autor O autor do elemento.
     * @return Um booleano indicando se o elemento foi adicionado com sucesso.
     */
    public boolean adicionarElementoTextoDica(String texto, Estudante autor) {
    	if(texto == null)
	    		throw new NullPointerException("Entrada inválida");
	    else if(texto.isBlank())
	    		throw new IllegalArgumentException("Entrada inválida");
	    else if(autor.equals(this.autor)) {
				Texto novo = new Texto(texto);
				elementos.add(novo);
				autor.adicionaBonus(novo.valor());
				return true;
		}
		return false;
	 }

    /**
     * Adiciona um elemento multimídia à dica.
     *
     * @param link O link para o conteúdo multimídia.
     * @param cabecalho O cabeçalho ou título do conteúdo multimídia.
     * @param tempo O tempo de duração do conteúdo multimídia em segundos.
     * @param autor O autor do elemento.
     * @return Um booleano indicando se o elemento foi adicionado com sucesso.
     */
	  public boolean adicionarElementoMultimidiaDica(String link, String cabecalho, int tempo, Estudante autor) { 
		  if(link == null || cabecalho == null)
			  throw new NullPointerException("Entrada inválida");
		  else if(link.isBlank() || cabecalho.isBlank())
			  throw new IllegalArgumentException("Entrada inválida");
		  else if(tempo < 0)
			  throw new IllegalArgumentException("Tempo inválido!");
		  else if(autor.equals(this.autor)) {
			  Multimidia novo = new Multimidia(link, cabecalho, tempo);
			  elementos.add(novo);
			  autor.adicionaBonus(novo.valor());
			  return true;
		  }
		  return false;
	  }

		/**
		 * Adiciona um elemento de referência à dica.
		 *
		 * @param titulo O título da referência.
		 * @param fonte A fonte da referência.
		 * @param ano O ano da referência.
		 * @param conferida Um booleano indicando se a referência foi conferida.
		 * @param importancia A importância da referência.
		 * @param autor O autor do elemento.
		 * @return Um booleano indicando se o elemento foi adicionado com sucesso.
		 */
	  public boolean adicionarElementoReferenciaDica(String titulo, String fonte, int ano, boolean conferida, int importancia, Estudante autor) { 
		  if(titulo == null || fonte == null)
	    		throw new NullPointerException("Entrada inválida");
		  else if(titulo.isBlank() || fonte.isBlank())
	    		throw new IllegalArgumentException("Entrada inválida");
		  else if(autor.equals(this.autor)) {
			  Referencia novo = new Referencia(titulo, fonte, ano, conferida, importancia);
			  elementos.add(novo);
			  autor.adicionaBonus(novo.valor());
			  return true;
		  }
		  return false;
	  }

	/**
	 * Retorna o autor da dica.
	 * @return O autor da dica.	
	*/
	public Estudante getAutor() {
		return autor;
	}
	  
}
