package CronicasDoEstudante;

public class Livreto {
	private Cronica[] cronicas;
	private int qntCronicas;
	 
	public Livreto(Cronica[] lista, int[] indices) {
		this.cronicas = new Cronica[indices.length];
		qntCronicas = indices.length;
		int indiceL = 0;
		for(int c : indices) {
			cronicas[indiceL++] = lista[c];
		}
	}

	public String lerLivreto() {
		String saida = "";
		for(Cronica c : cronicas) {
			saida += c.getTexto() + "\n";
		}
		return saida;
	}
	
	public int getQntCronicas() {
		return qntCronicas;
	}
	
	public boolean contemCronica(String nome) {
		for(Cronica c : cronicas) {
			if(nome.equals(c.getTitulo()))
				return true;
		}
		return false;
	}
	
	
	
}
