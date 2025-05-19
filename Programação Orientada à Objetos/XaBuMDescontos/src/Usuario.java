import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
	private String cpf;
	private String nome;
	private List<Cupom> cupons;
	private int cuponsTotais;
	
	public Usuario(String cpf, String nome) {
		if(cpf.isBlank() || nome.isBlank() || cpf == null || nome == null)
			throw new IllegalArgumentException();
		
		this.cpf = cpf;
		this.nome = nome;
		this.cupons = new ArrayList<>();
		this.cuponsTotais = 0;
	}
	
	
	public void addCupomUsuario(Cupom c) {
		cupons.add(c);
		cuponsTotais += 1;
	}
	
	public void removerCupomUsuario(Cupom c) {
		cupons.remove(c);
	}
	
	/*
	 * Listagem tá mal descrita
	public String[] listarCuponsUsuario() {
		String[] saida = new String[cupons.size()];
		int cont  = 0;
		for(Cupom c : cupons) {
			saida[cont] = c.toString();
		}
	}*/
	
	public Cupom usaCupom(int indexCupomUsuario) {
		Cupom c = cupons.get(indexCupomUsuario);
		cupons.remove(indexCupomUsuario);
		return c;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return nome + " - " + cpf;
	}


	
	
	
}
