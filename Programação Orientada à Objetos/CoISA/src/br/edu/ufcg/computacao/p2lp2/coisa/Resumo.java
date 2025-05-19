package br.edu.ufcg.computacao.p2lp2.coisa;

/**
 * Cria um resumo. Um resumo contém um tema e um texto referente ao tema.
 *
 *@author Tamires Santiago Oliveira
 */
public class Resumo {
	private String tema;
	private String texto;
	
	/**
	 * Contrói um resumo a partir de um tema e do texto a ser armazenado
	 * @param tema tema do resumo
	 * @param texto conteúdo do resumo
	 */
	public Resumo(String tema, String texto) {
		this.tema = tema;
		this.texto = texto;	
	}

	public String getTema() {
		return this.tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	/**
	 * Gera e retorna uma String contendo o tema e o texto do resumo.
	 * @return conteúdo do resumo
	 */
	public String toString() {
		return tema+": "+texto;
	}

	
}
