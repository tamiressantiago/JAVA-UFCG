package br.edu.ufcg.computacao.p2lp2.coisa;

/**
 *Controle do tempo estudado em uma determinada disciplina remota. 
 *Armazena o nome da disciplina, o tempo online esperado para tal 
 *e o tempo online investido pelo aluno. 
 * 
 * @author Tamires Santiago Oliveira
 */
public class RegistroTempoOnline {
	
	private String nomeDisciplina;
	private int tempoOnlineInvestido;
	private int tempoOnlineEsperado;
	
	/**
	 * Constrói um registro de tempo online a partir do nome da disciplina. 
	 * Tem por padrão um tempo online esperado de 120 horas.
	 * 
	 * @param nomeDisciplina informa o nome da disciplina
	 */
	public RegistroTempoOnline (String nomeDisciplina){
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = 120;
	}
	
	/**
	 * Constrói um registro de tempo online a partir do nome da disciplina e 
	 * do tempo online esperado para a dedicação do aluno.
	 * 
	 * @param nomeDisciplina informa o nome da disciplina
	 * @param tempoOnlineEsperado informa o tempo online esperado
	 */
	public RegistroTempoOnline (String nomeDisciplina, int tempoOnlineEsperado){
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
	}
	
	/**
	 * Registra a quantidade de horas online. As horas são cumulativas.
	 * 
	 * @param tempo quantidade de horas online.
	 */
	public void adicionaTempoOnline(int tempo) {
		this.tempoOnlineInvestido += tempo;
	}
	
	/**
	 * Analisa se o tempo que o estudante passou online é igual ou maior que o tempo esperado.
	 * 
	 * @return booleano que representa se a meta de estudos foi atinginda ou não
	 */
	public boolean atingiuMetaTempoOnline() {
		if (this.tempoOnlineInvestido >= this.tempoOnlineEsperado)
			return true;
		
		return false;
	}
	
	/**
	 * Gera e retorna uma String informando o nome da disciplina, o tempo online investido pelo aluno 
	 * e o tempo online esperado.
	 * 
	 * @return retorna uma String informando todas as informações armazenadas.
	 */
	public String toString() {
		return this.nomeDisciplina+" "+this.tempoOnlineInvestido+"/"+this.tempoOnlineEsperado;	
	}
	
}
