package mrbet;

public class Aposta {
	private Time time;
	private Campeonato campeonato;
	private int colocacao;
	private double valor;

	/**
	 * Cria uma aposta.
	 * @param time Time
	 * @param campeonato Campeonato
	 * @param colocacao Colocação do time no campeonato
	 * @param valor Valor da aposta
	 */
	public Aposta(Time time, Campeonato campeonato, int colocacao, double valor) {
		if(time == null)
			throw new NullPointerException("Time nulo!");
		else if(campeonato == null)
			throw new NullPointerException("Campeonato nulo!");
		
		this.time = time;
		this.campeonato = campeonato;
		this.colocacao = colocacao;
		this.valor = valor;
	}

	/**
	 * Método que cria e retorna uma String que apresenta todas as informações que a Aposta armazena.
	 * 
	 * @return String com as informações da aposta
	 */
	@Override
	public String toString() {
		return time.toString() + "\n" + campeonato.getNome() + "\n" + colocacao + "/" + campeonato.getnParticipantes() + "\nR$ " + valor;
	}
	
}

	

