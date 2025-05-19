package CronicasDoEstudante;

public class CronicasDoEstudanteSistema {
	private Cronica[] cronicas;
	private Livreto[] livretos;
	private int indiceC;
	private int indiceL;
	
	/*public CronicasDoEstudanteSistema() {
		this.cronicas = new Cronica[1000];
		this.livretos = new Cronica[100][5]; //duvida na ordem
	}*/
	
	public CronicasDoEstudanteSistema() {
		this.cronicas = new Cronica[1000];
		this.livretos = new Livreto[100];
	}
	
	public void cadastrarCronica(String titulo, String texto, String data) {
		if(!verificaCronica(titulo)) {
			Cronica nova = new Cronica(titulo, texto, data);
			cronicas[indiceC++] = nova;
			nova.setIndice(indiceC);
			//duvida no indice
		}
	}
	
	public void cadastrarCronica(String titulo, String texto, String data, String autor) {
		if(!verificaCronica(titulo)) {
			Cronica nova = new Cronica(titulo, texto, data, autor);
			cronicas[indiceC++] = nova;
			nova.setIndice(indiceC);
			//duvida no indice
		}
	}
	
	private boolean verificaCronica(String titulo) {
		for(Cronica c : cronicas) {
			if(c != null) {
				if(c != null & titulo.equals(c.getTitulo())) //duvida se precisa do null
					return true;
			}
		}
		return false;
	}
	
	
	public String listarCronicas() {
		String retorno = "";
		for(Cronica c : cronicas) {
			if(c != null) {
				retorno += c.toString() + "\n";		
				
			}
		}
		return retorno;
	}
	
	public String lerCronica(int indice) {
		return cronicas[indice].getTexto();
	}
	
	public String exibirCronicaMaisLida() {
		Cronica maisLida = null; //duvida
		int leituras = 0;
		for(Cronica c : cronicas) {
			if(c != null && c.getLeituras() > leituras) {
				maisLida = c;
				leituras = c.getLeituras();
			}
		}
		return maisLida.getTitulo() + " - lida " + leituras + " vezes";
	}
	
	/*
	public String criarLivreto(int seq[]) {
		if(seq.length <= 5 && seq.length >= 3) {
			Cronica[] livreto = new Cronica[5];
			for(int i : seq) {
				livreto[i] = cronicas[i]; //duvida se precisa copiar
			}
			if(indiceL > 99)
				indiceL = 0;
			livretos[indiceL++] = livreto;
			return ""; //duvida
		}
		else
			return "Erro ao criar Livreto!";
	}
	
	public String lerLivreto(int i) {
		String saida = "";
		for(Cronica c : livretos[i]) {
			saida += c.getTexto();			
		}
		return saida;
	}
	
	public boolean contemCronicaNoLivreto(String titulo, int i) {
		for(Cronica c : livretos[i]) {
			if(titulo.equals(c.getTitulo()))
				return true;
		}
		return false;
	}*/
	
	public String criarLivreto(int[] posicoes) {
		if(posicoes.length <= 5 && posicoes.length >= 3) {
			if(indiceL >= 100)
				indiceL = 0;
			livretos[indiceL++] = new Livreto(cronicas, posicoes);
			return "";
		}
		else
			throw new IllegalArgumentException("Erro ao criar Livreto!");
	}
	
	public String lerLivreto(int i) {
		return livretos[i].lerLivreto();
	}
	
	public boolean contemCronicaNoLivreto(String titulo, int i) {
		return livretos[i].contemCronica(titulo);
	}
	
}
