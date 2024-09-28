package mrbet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Sistema de apostas envolvendo times e campeonatos.
 * 
 * @author tamires.santiago.oliveira - 123210205
 * 
 */
public class MrBetSistema {
	private Map<String, Time> times;
	private Map<String, Campeonato> campeonatos;
	private List<Aposta> apostas;
	
	/**
	 * Cria o sistema MrBetSistema
	 */
	public MrBetSistema() {
		this.times = new HashMap<>();
		this.campeonatos = new HashMap<>();
		this.apostas = new ArrayList<>();
	}
	
	/**
	 * Adiciona um novo time no HashMap de times. Não inclui times com o mesmo código.
	 * @param codigo código único de um time
	 * @param nome nome do time
	 * @param mascote mascote do time
	 * @return String que avisa se a inclusão pôde ser realizada
	 */
	public String addTime(String codigo, String nome, String mascote) {
		if(!times.containsKey(codigo)) {
			Time novo = new Time(codigo, nome, mascote);
			times.put(codigo, novo);
			return "INCLUSÃO REALIZADA!";
		}
		return "TIME JÁ EXISTE!";	
	}

	/**
	 * Mostra as informações de um time.
	 * @param codigo do time
	 * @return informações do time (ou um aviso se time não existe)
	 */
	public String mostrarTime(String codigo) {
		Time time = times.get(codigo);
		if(time != null) {
			return time.toString();
		}
		return "TIME NÃO EXISTE!";
	}

	/**
	 * Adiciona um nome campeonato no HashMap de campeonatos. Não inclui campeonatos com o mesmo nome.
	 * @param nomeC nome do campeonato
	 * @param participantes número máximo de participantes
	 * @return string que sinaliza que o campeonato foi adicionado ou não
	 */
	public String addCampeonato(String nomeC, int participantes) {
		Campeonato novo = new Campeonato(nomeC, participantes);
		if(!campeonatos.containsKey(nomeC.toUpperCase())) {
			campeonatos.put(nomeC.toUpperCase(), novo);
			return "CAMPEONATO ADICIONADO!";
		}
		return "CAMPEONATO JÁ EXISTE!";
	}

	/**
	 * Inclui um time em um campeonato existente
	 * @param cod código identificador do time
	 * @param camp nome do campeonato
	 * @return String que informa de a inclusão foi feita com sucesso.
	 */
	public String incluirTimeCampeonato(String cod, String camp) {
		if(!campeonatos.containsKey(camp.toUpperCase()))
			throw new IllegalArgumentException("O CAMPEONATO NÃO EXISTE!");
		else if(!times.containsKey(cod))
			throw new IllegalArgumentException("O TIME NÃO EXISTE!");
		else
			return campeonatos.get(camp.toUpperCase()).adicionarTime(times.get(cod));
	}

	/**
	 * Verifica se um time participa de um campeonato.
	 * @param cod código identificador do time
	 * @param camp nome do campeonato
	 * @return String que informa se o time está no campeonato ou não
	 */
	public String verificarTimeEmCampeonato(String cod, String camp) {
		if(!campeonatos.containsKey(camp.toUpperCase()))
			throw new IllegalArgumentException("O CAMPEONATO NÃO EXISTE!");
		else if(!times.containsKey(cod))
			throw new IllegalArgumentException("O TIME NÃO EXISTE!");
		else {
			if(campeonatos.get(camp.toUpperCase()).temTime(times.get(cod)))
				return "O TIME ESTÁ NO CAMPEONATO!";
			else
				return "O TIME NÃO ESTÁ NO CAMPEONATO!";
		}
			
	}

	/**
	 * Exibe todos os campeonatos em que um determinado time participa.
	 * @param time código identificador do time
	 * @return String com todos os campeonatos que o time participa
	 */
	public String exibirCampeonatosTime(String time) {
		if(!times.containsKey(time))
			throw new IllegalArgumentException("O TIME NÃO EXISTE!");
	
		String saida = "";
		for(Campeonato atual : campeonatos.values()) {
			if(saida.isEmpty())
				saida += "Campeonatos do " + times.get(time).getNome() + "\n";
			if(atual.temTime(times.get(time))) {
				saida += atual.toString() + "\n";
			}
		}
		return saida;
	}

	/**
	 * Registra uma aposta no sistema.
	 * @param cod código identificador do time
	 * @param camp nome do campeonato
	 * @param colocacao colocação apostada do time do campeonato
	 * @param valor valor da aposta
	 * @return String informando se a aposta foi registrada ou não
	 */
	public String realizarAposta(String cod, String camp, int colocacao, double valor) {
		if(!campeonatos.containsKey(camp.toUpperCase()))
			throw new IllegalArgumentException("O CAMPEONATO NÃO EXISTE!");
		else if(!times.containsKey(cod))
			throw new IllegalArgumentException("O TIME NÃO EXISTE!");
		else if(colocacao > campeonatos.get(camp.toUpperCase()).getnParticipantes())
			return "APOSTA NÃO REGISTRADA!";
		else {
			Time time = times.get(cod);
			Campeonato campeonato = campeonatos.get(camp.toUpperCase());
			apostas.add(new Aposta(time, campeonato, colocacao, valor));
			return "APOSTA REGISTRADA!";
		}
	}

	/**
	 * Informa todas as apostas que foram realizadas no sistema.
	 * @return String com todas as apostas enumeradas
	 */
	public String pegarApostas() {
		int numb = 1;
		String saida = "Apostas:\n";
			
		for(Aposta a : apostas) {
			saida += (numb++ + ". " + a.toString() + "\n");
		}
		return saida;
	}
	
}
