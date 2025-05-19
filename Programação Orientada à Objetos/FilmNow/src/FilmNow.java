package filmnow;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes. 
 * 
 * @author Tamires Santiago Oliveira - 123210205
 *
 */
public class FilmNow {
	
	private static final int TAMANHO = 100;
	private static final int TAMANHOHOT = 10;
	
	private Filme[] filmes; //uma representacao simploria da lista de filmes
	private Filme[] filmesHot;

	/**
	 * Cria o FilmNow.
	 */
	public FilmNow() {
		this.filmes = new Filme[TAMANHO];
		this.filmesHot = new Filme[TAMANHOHOT];
	}
	
	/**
	 * Acessa a lista de filmes mantida.
	 * @return O array de filmes.
	 */
	public Filme[] getFilmes() {
		return this.filmes.clone();
	}

	/**
	 * Acessa os dados de um filme específico.
	 * @param posicao Posição do filme no sistema.
	 * @return 
	 * 		- Dados do filme, se a posição informada for válida;
	 *  	- Se a posição for inválida, retorna uma String com a mensagem;
	 *  	- Retorna vazio caso o filme seja null.
	 */
	
	public String detalharFilme(int posicao) {
		if(posicao < 1 || posicao > 100)
			return "POSIÇÃO INVÁLIDA";
		else if(filmes[posicao-1] == null)
			return "";
		return filmes[posicao-1].toString();
	}
	
	/**
	 * Adiciona um filme em uma posição. Se já existir filme na posição, sobrescreve o anterior. 
	 * @param posicao Posição do filme.
	 * @param nome Nome do filme.
	 * @param ano Ano de lançamento do filme.
	 * @param local Local onde o filme foi assitido.
	 * 
	 * @return retorna uma String que informa se o filme pôde ser adicionado ou não.
	 */
	public String cadastraFilme(int posicao, String nome, String ano, String local) {
		Filme novo = new Filme(nome, ano, local);
		String retorno = "";
		if(posicao > 100 || posicao < 1) 
			retorno = "POSIÇÃO INVÁLIDA";
		else if(nome.isBlank())
			retorno = "FILME INVÁLIDO";
		else if(local.isBlank())
			retorno = "FILME INVÁLIDO";
		else if(verificaFilmes(novo))
			retorno = "FILME JÁ ADICIONADO";
		else {
			retorno = "FILME ADICIONADO";
			this.filmes[posicao-1] = novo;
		}
		return retorno;
	}
	
	private boolean verificaFilmes(Filme novo) {
		for(Filme f: this.filmes) {
			if(f != null) {
				if(f.equals(novo))
					return true;	
			}
		}
		return false;
	}
	
	/**
	 * Cadastra um filme na HotList.
	 * 
	 * @param posicaoFilme Posição do filme que será cadastrado
	 * @param posicaoHot Posição em que o filme ocupará na HotList
	 * @return retorna uma String que informa se o filme pôde ser adicionado ou não.
	 */
	public String cadastraHot(int posicaoFilme, int posicaoHot) {
		if(posicaoFilme < 1 || posicaoFilme > 100)
			return "FILME INVÁLIDO";
		else if(posicaoHot < 1 || posicaoHot > 10)
			return "POSIÇÃO INVÁLIDA";
		else if(verificarHot(filmes[posicaoFilme-1])) 
			return "FILME JÁ ADICIONADO";
		else {
			this.filmesHot[posicaoHot-1] = filmes[posicaoFilme-1];
			filmes[posicaoFilme-1].setHot("🔥");
			return "ADICIONADO À HOTLIST NA POSIÇÃO " + posicaoHot;	
		}
	}

	private boolean verificarHot(Filme filme) {
		for (Filme f : this.filmesHot) {
            if (f != null && f.equals(filme)) 
                return true;
        }
     return false;
	}

	/**
	 * Acessa a lista de filmes Hot.
	 * @return O array de filmes Hot.
	 */
	public Filme[] getFilmesHot() {
		return this.filmesHot.clone();
	}

	/**
	 * Remove um filme do array de filmesHot. Caso o filme seja removido, ele perde o emoji de Hot.
	 * 
	 * @param posicao do filme a ser removido
	 * @return String que informa se o filme foi removido ou não
	 */
	public String removerHot(int posicao) {
		if(posicao > 0 && posicao < 11) {
			Filme filme = filmesHot[posicao-1];
			filmesHot[posicao-1] = null;
			for(Filme f: this.filmes) {
				if(f != null && f.equals(filme))
					f.setHot("");
			}
			return "FILME REMOVIDO";
		}
		return "POSIÇÃO INVÁLIDA";
	}

}
