package mrbet;

import java.util.Objects;

public class Time {
	private String codigo;
	private String nome;
	private String mascote;
	
	/**
	 * Cria um Time. Não aceita entradas nulas ou vazias.
	 * @param codigo do time
	 * @param nome do time
	 * @param mascote do time
	 */
	public Time(String codigo, String nome, String mascote) {
		if(nome == null || codigo == null || mascote == null)
			throw new NullPointerException("Entrada nula inválida!");
		else if(codigo.isBlank() || nome.isBlank() || mascote.isBlank())
			throw new IllegalArgumentException("Entrada vazia!");
		
		this.codigo = codigo;
		this.nome = nome;
		this.mascote = mascote;
	}

	/**
	 * Gera o HashCode do objeto levando em consideração apenas o atributo codigo.
	 * 
	 * @return int que contém o HashCode.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	/**
	 * Método que compara se dois times são iguais. Leva em consideração apenas o código do time.
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
		Time other = (Time) obj;
		return Objects.equals(codigo, other.codigo);
	}

	/**
	 * Método que cria e retorna uma String que apresenta todas as informações que o Time armazena.
	 * 
	 * @return String com as informações do time
	 */
	@Override
	public String toString() {
		return String.format("[%s] %s / %s", codigo, nome, mascote);
	}


	public String getCodigo() {
		return codigo;
	}


	public String getNome() {
		return nome;
	}

	
}
