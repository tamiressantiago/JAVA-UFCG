package filmnow;

import java.util.Objects;

/**
 * Cria um objeto Filme que apresenta um nome, ano de lançamento e local em que foi assistido. 
 * Apresenta também uma String que sinaliza se o filme foi cadastrado na HotList ou não.
 * 
 * @author Tamires Santiago Oliveira - 123210205
 */
public class Filme {
	private String nome;
	private String ano;
	private String local;
	private String hot;
	
	/**
	 * Constrói um objeto Filme.
	 * 
	 * @param nome nome do filme
	 * @param ano ano de lançamento do filme
	 * @param local local em que o filme foi assistido
	 */
	public Filme(String nome, String ano, String local) {
		this.nome = nome;
		this.ano = ano;
		this.local = local;
		this.hot = "";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
	public void setHot(String string) {
		this.hot = string;
	}

	/**
	 * Método que compara se dois filmes são iguais. Leva em consideração apenas o nome do filme e o ano de lançamento.
	 * 
	 * @param objeto a ser comparado
	 * @return boolean que informa se os dois objetos são iguais ou não
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		return Objects.equals(ano, other.ano) && Objects.equals(nome, other.nome);
	}

	/**
	 * Gera o HashCode do objeto levando em consideração apenas os atributos ano e nome.
	 * 
	 * @return int que contém o HashCode.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(ano, nome);
	}
	
	/**
	 * Método que cria e retorna uma String que apresenta todas as informações que o Filme armazena.
	 * 
	 * @return String com as informações do filme
	 */
	@Override
	public String toString() {
		return this.hot + this.nome + ", " + this.ano + "\n" + this.local;
	}


	
	

}
