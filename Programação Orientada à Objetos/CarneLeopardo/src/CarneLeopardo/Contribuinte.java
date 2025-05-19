package CarneLeopardo;

import java.util.Objects;

public class Contribuinte {
	private String cpf;
	private String nome;
	private String contato;
	private Tributo[] tributos;
	private int indice;
	
	public String getCpf() {
		return cpf;
	}

	public Contribuinte(String cpf, String nome, String contato) {
		this.cpf = cpf;
		this.nome = nome;
		this.contato = contato;
		this.tributos = new Tributo[60];
	}

	@Override
	public String toString() {
		return "| Contribuinte: " + nome + "- CPF: " + cpf + "- Contato: " + contato + " |"; 
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
		Contribuinte other = (Contribuinte) obj;
		return Objects.equals(cpf, other.cpf);
	}

	public void addTributo(Tributo tributo) {
		tributos[indice] = tributo;
		indice ++;
	}

	public boolean pagamentoTributo(int codigo) {
		for(Tributo t : tributos) {
			if(t != null) {
				if(codigo == t.getCodigo()) {
					t.setPago(true);
					return true;
				}
			}
		}
		return false;
	}
	
	public String imprimirExtrato() {
		if(tributos[0] == null)
			return "| EXTRATO VAZIO |";
		String extrato = "| Pago? | Contribuinte: " + nome + " - CPF: " + cpf + " - Contato: " + contato;
		for(Tributo t : tributos) {
			if(t != null) {
				extrato += "\n| " + (t.isPago() ? "SIM" : "NÃO" ) + " | Tributo: " + t.getCodigo() + " - " + t.getDescricao() + " - Valor: " + t.getValor() + " - Ano Base: " + t.getAno() + " |";
 			}
		}
		return extrato;
	}
	
	public double valorTotalPagoEmTributos(int ano) {
		double soma = 0;
		for(Tributo t : tributos) {
			if(t != null && t.getAno() == ano) {
				if(t.isPago())
					soma += t.getValor();
			}
		}
		return soma;
	}
	
}

	





