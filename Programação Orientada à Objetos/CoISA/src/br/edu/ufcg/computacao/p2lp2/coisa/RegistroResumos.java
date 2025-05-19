package br.edu.ufcg.computacao.p2lp2.coisa;

/**
 * Registro de resumos dos estudos. Armazena uma quantidade determinada de resumos. 
 * 
 * @author Tamires Santiago Oliveira
 */
public class RegistroResumos {
	private int numeroDeResumos;
	private Resumo[] resumos;
	private int indice;
	private int qntResumos;
		
	/**
	 * Constrói um registro de resumos a partir de uma quantidade máxima de resumos a serem cadastrados.
	 * 
	 * @param numeroDeResumos quantidade de resumos a serem cadastrados.
	 */
	public RegistroResumos(int numeroDeResumos){
		this.numeroDeResumos = numeroDeResumos;
		this.resumos = new Resumo[numeroDeResumos];
	}
	
	/**
	 * Recebe um tema e seu texto, cria um novo objeto Resumo e o guarda em um array de resumos.
	 * Quando o array chegar em seu limite máximo, o índice zera e os próximos resumos substituirão
	 * os primeiros.
	 * 
	 * @param tema tema do resumo recebido
	 * @param texto resumo a ser armazenado
	 */
	public void adiciona(String tema, String texto) {
		if(this.indice == this.numeroDeResumos)
			this.indice = 0;
		this.resumos[this.indice] = new Resumo(tema, texto);
		this.indice++;
		
		if(this.qntResumos < this.numeroDeResumos)
			this.qntResumos++;
	}
	
	/**
	 * Cria um array chamado retorno e nele armazena o tema e o conteúdo dos resumos, recebidos 
	 * através do toString.
	 * 
	 * @return retorna o array criado
	 */
	public String[] pegaResumos() {
		String[] retorno = new String[this.qntResumos];
		for(int i = 0; i < this.qntResumos; i++) {
			retorno[i] = this.resumos[i].toString();
		}
		return retorno;
	}
	
	
	/**
	 * Cria uma String chamada retorno que informará a quantidade de resumos e todos os seus temas.
	 * 
	 * @return retorna a String criada
	 */
	public String imprimeResumos() {
		String retorno = "- "+this.qntResumos +" resumo(s) cadastrado(s)\n- ";
		for(int i = 0; i < this.qntResumos; i++) {
			retorno += this.resumos[i].getTema();
			if(i != this.qntResumos -1)
				retorno += " | ";
		}
		return retorno;
	}
	
	/**
	 * Retorna a quantidade de resumos cadastrados, préviamente contados.
	 * @return retorna a quantidade de resumos cadastrados
	 */
	public int conta() {
		return this.qntResumos;
	}

	/**
	 * Verifica se há um resumo cadastrado de algum determinado tema.
	 * 
	 * @param tema tema do resumo a ser procurado
	 * @return retorna true se houver um resumo cadastrado do tema especificado, se não houver, 
	 * retorna false
	 */
	public boolean temResumo(String tema) {
		for(int i = 0; i < this.qntResumos; i++) {
			if(this.resumos[i].getTema().equals(tema))
				return true;
		}
		return false;
	}
	
	
}
