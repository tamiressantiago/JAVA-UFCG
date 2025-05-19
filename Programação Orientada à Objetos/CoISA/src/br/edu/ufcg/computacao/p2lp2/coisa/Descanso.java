package br.edu.ufcg.computacao.p2lp2.coisa;

/**
 * Programa para análise da rotina do aluno. O programa indica se o aluno está cansado ou descansado 
 * com base em suas horas de descanso semanais.
 * 
 * @author Tamires Santiago Oliveira
 */

public class Descanso {
	
	
	private int horasDescanso;
	private int numeroSemana;
	private boolean descansado;
	private String emoji;
	
	/**
	 * Define a quantidade de horas descansadas.
	 * 
	 * @param valor horas descansadas
	 */
	public void defineHorasDescanso(int valor) {
		this.horasDescanso = valor;
	}
	
	/**
	 * Define o número de semanas.
	 * 
	 * @param valor número de semanas
	 */
	public void defineNumeroSemanas(int valor) {
		this.numeroSemana = valor;
	}
	
	/**
	 * Calcula a média de horas semanais descansadas e a partir disso define se o aluno 
	 * está cansado ou descansado.
	 * 
	 * Parte Bônus: Verifica se o estado de descanso mudou, se tiver mudado o útimo emoji adicionado
	 * é removido.
	 * 
	 * @return String informa o estado de descanso do aluno.
	 */
	  public String getStatusGeral() {
		  	String retorno;
	        if (this.numeroSemana != 0 && this.horasDescanso / this.numeroSemana >= 26) {
	        	if(this.descansado == false)
	        		this.emoji = null;
	            this.descansado = true;
	        } else {
	        	if(this.descansado == true)
	        		this.emoji = null;
	            this.descansado = false;
	        }

	        if(this.descansado == true)
	        	retorno = "descansado";
	        else
	        	retorno = "cansado";
	        
	        if (this.emoji != null) 
	        	retorno += " - " + this.emoji; 
	        
	        return retorno;
	    }

	
	/**
	 * Parte Bônus: define um emoji referente ao humor do aluno.
	 * 
	 * @param emoji ultima sensação geral do aluno
	 */
	public void definirEmoji(String emoji) {
		this.emoji = emoji;
	}
	


}
