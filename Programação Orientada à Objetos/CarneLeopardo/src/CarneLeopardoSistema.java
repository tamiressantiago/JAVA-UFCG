package CarneLeopardo;

public class CarneLeopardoSistema {
	private Contribuinte[] contribuintes;
	private Tributo[] tributos;
	private int indiceC;
	
	public CarneLeopardoSistema() {
		this.contribuintes = new Contribuinte[100];
		this.tributos = new Tributo[60];
	}
	
	public String cadastrarContribuinte(String cpf, String nome, String contato) {
		Contribuinte c = new Contribuinte(cpf, nome, contato);
		if(verificaContribuinte(c)) {
			throw new IllegalArgumentException("Contribuinte já cadastrado!");
		}
		contribuintes[indiceC] = c;
		return cpf;
	}

	public int cadastrarTributo(int codigo, double valor, int ano, String descricao) {
		if(codigo < 1 || codigo > 60)
			throw new IndexOutOfBoundsException("A faixa disponível para códigos tributários é de 1 a 60!");
		
		Tributo novo = new Tributo(codigo, valor, ano, descricao);
		if(verificaTributo(novo)) {
			throw new IllegalArgumentException("O código já está sendo utilizado por outro tributo!");
		}
		tributos[codigo-1] = novo;
		return codigo;
		
	}
	
	public String[] listarContribuintes() {
		String[] saida = new String[contribuintes.length];
		int indice = 0;
		for(Contribuinte c : contribuintes) {
			if(c != null)
				saida[indice] = c.toString();
		}
		return saida;
	}
	
	public Tributo[] listarTributos() {
		return tributos.clone();
	}
	
	private boolean verificaContribuinte(Contribuinte novo) {
		for(Contribuinte c : contribuintes) {
			if(novo.equals(c))
				return true;
		}
		return false;
	}
	
	private boolean verificaTributo(Tributo novo) {
		for(Tributo t : tributos) {
			if(novo.equals(t))
				return true;
		}
		return false;
	}

	public double reajustarTributo(int codigo, int ano, double percentual) {
		Tributo tributo = tributos[codigo-1];
		if(tributo == null || tributo.getAno() <= ano)
			return 0;
		else {
			tributo.atualizarValor(percentual);
			tributo.setAno(ano);
			return tributo.getValor();
			}	
	}
	
	public String atribuirTributoAoContribuinte(int codigo, String cpf) {
		for(Contribuinte c : contribuintes) {
			if(c != null && cpf.equals(c.getCpf())) {
				Tributo novo = new Tributo(tributos[codigo-1]);
				System.out.println(tributos[codigo-1] == novo);
				c.addTributo(novo); //tem q copiar o tributo
				return "| TRIBUTO ADICIONADO COM SUCESSO |"; 
			}
		}
		return "| TRIBUTO OU CONTRIBUINTE NÃO ENCONTRADO |";
	}
	
	public String pagarTributo(String cpf, int codigo) {
		for(Contribuinte c : contribuintes) {
			if(c != null && cpf.equals(c.getCpf())) {
				if(c.pagamentoTributo(codigo));
					return "| TRIBUTO PAGO COM SUCESSO |";
			}
		}
		return "| TRIBUTO OU CONTRIBUINTE NÃO ENCONTRADO |";
	}
	
	public String emitirExtratoDeTributos(String cpf) {
		for(Contribuinte c : contribuintes) {
			if(c != null) {
				if(cpf.equals(c.getCpf()))
					return c.imprimirExtrato();
			}
		}
		return "| TRIBUTO OU CONTRIBUINTE NÃO ENCONTRADO |";
	}
	
	public double totalPagoEmTributos(String cpf, int ano) throws IllegalArgumentException{
		for(Contribuinte c : contribuintes) {
			if(c != null) {
				if(cpf.equals(c.getCpf()))
					return c.valorTotalPagoEmTributos(ano);
			}
		}
		throw new IllegalArgumentException("Contribuinte não cadastrado!");
	}
	
}
