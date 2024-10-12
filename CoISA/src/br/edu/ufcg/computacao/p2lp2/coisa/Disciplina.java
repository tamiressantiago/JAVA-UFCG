package br.edu.ufcg.computacao.p2lp2.coisa;

import java.util.Arrays;

/**
 * Acompanhamento de uma disciplina. Guarda informações do aluno acerca de determinada disciplina, 
 * incluindo suas notas, sua média, horas de estudo e estado de aprovação.
 * 
 * @author Tamires Santiago Oliveira
 */

public class Disciplina {
	
	private String nomeDisciplina;
	private int horasEstudo; 
	private double[] notas = new double[4];
	private int qntNotas;
	private int[] pesos;
	
	/**
	 * Constrói uma disciplina a partir de seu nome.
	 * 
	 * @param nomeDisciplina informa o nome da disciplina
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.qntNotas = 4;
		this.pesos = new int[qntNotas];
	}
	
	/**
	 * Constrói uma disciplina a partir de seu nome e a quantidade de notas.
	 * 
	 * @param nomeDisciplina informa o nome da disciplina
	 * @param qntNotas informa a quantidade de notas
	 */
	public Disciplina(String nomeDisciplina, int qntNotas) {
		this.nomeDisciplina = nomeDisciplina;
		this.qntNotas = qntNotas;
		this.notas = new double[qntNotas];
		this.pesos = new int[qntNotas];
	}
	
	/**
	 * Constrói uma disciplina a partir de seu nome, a quantidade de notas e os pesos dessas notas.
	 * 
	 * @param nomeDisciplina informa o nome da disciplina
	 * @param qntNotas informa a quantidade de notas
	 * @param pesos informa os pesos das notas
	 */
	public Disciplina(String nomeDisciplina, int qntNotas, int[] pesos) {
		this.nomeDisciplina = nomeDisciplina;
		this.qntNotas = qntNotas;
		this.pesos = pesos;
		this.notas = new double[qntNotas];
	}

	/**
	 * Cadastra a quantidade de horas estudadas. As horas são cumulativas.
	 * 
	 * @param horas quantidade de horas estudadas
	 */
	public void cadastraHoras(int horas) {
		this.horasEstudo += horas;
	}
	
	/**
	 * Recebe a nota do aluno e a armazena em sua determinada posição (1ª, 2ª, 3ª, etc), 
	 * sendo possível repor notas.
	 * 
	 * @param nota informa a posição da nota
	 * @param valorNota nota do aluno
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota-1] = valorNota;
	}
	
	private double calculoMedia() {
		double media = 0;
		double somaPesos = 0;
		if(this.pesos[0] == 0)
			for(int i = 0; i < this.qntNotas; i++) {
				media += this.notas[i];
				somaPesos += 1;
			}
		else {
			for(int i = 0; i < this.qntNotas; i++) {
				media += this.notas[i] * this.pesos[i];
				somaPesos += this.pesos[i];
			}
		}
		
		media = media/somaPesos;
		return media;
	}
	
	/**
	 * Analisa o estado de aprovação do aluno, se a media for maior que 7 o aluno está aprovado,
	 * senão, ele está reprovado.
	 * 
	 * @return boolean que determina se o aluno está aprovado ou não
	 */
	public boolean aprovado() {
		double media = calculoMedia(); 
		if(media >= 7)
			return true;
		
		return false;
	}
	
	/**
	 * Gera e retorna uma String contendo o nome da disciplina, o número de horas estudadas, 
	 * a média do aluno e todas as notas da disciplina.
	 * 
	 * @return retorna todas as informações armazenadas do aluno.
	 */
	public String toString() {
		return this.nomeDisciplina+" "+this.horasEstudo+" "+calculoMedia()+" "+Arrays.toString(notas);
	}

}
