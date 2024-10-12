import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XaBuMSistema {
	
	private Map<String, Usuario> usuarios;
	private List<Cupom> cupons;
	
	public XaBuMSistema() {
		this.usuarios = new HashMap<>();
		this.cupons = new ArrayList<>();
	}
	
	public String adicionaUsuario(String cpf, String nome) {
		if(usuarios.containsKey(cpf))
			return "Usuário já cadastrado";
		
		usuarios.put(cpf, new Usuario(cpf, nome));
		return "Usuário cadastrado";
	}
	
	public String criaCupomFreteGratis(double maxDesconto) {
		cupons.add(new FreteGratis(maxDesconto));
		return "Cupom adicionado";
	}
	
	public String criaCupomFreteGratis() {
		cupons.add(new FreteGratis());
		return "Cupom adicionado";
	}
	
	public String criaCupomDescontoFixo(double percentualDesconto, double maxDesconto) {
		cupons.add(new DescontoFixo(percentualDesconto, maxDesconto));
		return "Cupom adicionado";
	}
	
	public String criaCupomDescontoProgressivo() {
		cupons.add(new DescontoProgressivo());
		return "Cupom adicionado";
	}
	
	public String addCupomUsuario(String cpf, int indexCupom) {
		if(usuarios.containsKey(cpf)) {
			usuarios.get(cpf).addCupomUsuario(cupons.get(indexCupom));
			cupons.remove(indexCupom);
			return "Cupom adicionado ao usuário";
		}
		return "Usuário não existe";
	}
	
	public String aplicarDescontoCompra(Compra minhaCompra, int indexCupomUsuario) {
		Cupom c = minhaCompra.pegaCupomUsuario(indexCupomUsuario);
		c.calculaDesconto(minhaCompra);
		return "Cupom adicionado";
	}
	
	 /*Mal definido
	public String[] listarCuponsUsuario(String cpf) {
		String[] saida = new String[usuarios.size()];
		
		}*/
			
}

