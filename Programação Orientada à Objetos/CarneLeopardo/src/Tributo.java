package CarneLeopardo;

import java.util.Objects;

public class Tributo {
	private int codigo;
	private double valor;
	private int ano;
	private String descricao;
	private boolean pago;


	public Tributo(int codigo, double valor, int ano, String descricao) {
		this.codigo = codigo;
		this.valor = valor;
		this.ano = ano;
		this.descricao = descricao;
	}
	
	//construtor de cópia
	public Tributo(Tributo outro) {
		this.codigo = outro.codigo;
		this.valor = outro.valor;
		this.ano = outro.ano;
		this.descricao = outro.descricao;
	}

	@Override
	public String toString() {
		return "| Tributo: " + codigo + " - " + descricao + " - Valor: " + valor + " - Ano Base: " + ano + " |";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tributo other = (Tributo) obj;
		return codigo == other.codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void atualizarValor(double percentual) {
		this.valor = this.valor + this.valor * percentual;
	}

	public int getAno() {
		return ano;
	}

	public double getValor() {
		return valor;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public boolean isPago() {
		return pago;
	}
	
	public void setPago(boolean pago) {
		this.pago = pago;
	}
	
}
