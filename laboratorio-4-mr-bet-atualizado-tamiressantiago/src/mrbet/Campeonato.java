package mrbet;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Representação de um campeonato. Contém nome, quantidade de participantes e times que participam do campeonato.
 * 
 * @author tamires.santiago.oliveira - 123210205
 */
public class Campeonato {
	private String nome;
	private int nParticipantes;
	private Set<Time> times;
	
	/**
	 * Cria um Campeonato. Não aceita um nome nulo ou vazio.
	 * @param nomeC nome do campeonato
	 * @param participantes quantidade de participantes máxima para o campeonato
	 */
	public Campeonato(String nomeC, int participantes) {
		if(nomeC == null)
			throw new NullPointerException("Entrada nula inválida!");
		else if(nomeC.isBlank())
			throw new IllegalArgumentException("Nome vazio!");
		
		this.nome = nomeC;
		this.nParticipantes = participantes;
		this.times = new HashSet<>();
	}

	/**
	 * Adiciona time no Campeonato
	 * @param time Time a ser adicionado
	 * @return String ue informa se o time foi incluido ou não
	 */
	public String adicionarTime(Time time) {
		if(times.size() < nParticipantes) {
			times.add(time);
			return "TIME INCLUÍDO NO CAMPEONATO!";
		}
		return "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";
	}

	/**
	 * Verifica se o time está participando do campeonato.
	 * @param time Time para verificar
	 * @return informa se o time está no campeonato ou não
	 */
	public boolean temTime(Time time) { 
		if(times.contains(time))
			return true;
		else
			return false;
	}

	/**
	 * Método que cria e retorna uma String que apresenta todas as informações que o Campeonato armazena.
	 * 
	 * @return String com as informações do campeonato
	 */
	@Override
	public String toString() {
		return "* " + nome + " - " + times.size() + "/" + nParticipantes;
	}
	
	/**
	 * Gera o HashCode do objeto levando em consideração apenas o atributo nome.
	 * 
	 * @return int que contém o HashCode.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
	
	/**
	 * Método que compara se dois campeonatos são iguais. Leva em consideração apenas o nome do campeonato, desconsiderando letras maiúsculas e minúsculas.
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
		Campeonato other = (Campeonato) obj;
		return Objects.equals(nome.toLowerCase(), other.nome.toLowerCase());
	}
	
	public int getnParticipantes() {
		return nParticipantes;
	}

	public String getNome() {
		return nome;
	}

	public Set<Time> getTimes() {
		return times;
	}
}
