import static java.lang.Math.max;

public class DescontoFixo implements Cupom {
	private double percentualDesconto;
	private double maxDesconto;
	
	public DescontoFixo(double percentualDesconto, double maxDesconto) {
		this.percentualDesconto = percentualDesconto;
		this.maxDesconto = maxDesconto;
	}

	@Override
	public String toString() {
		return "DescontoFixo de " + percentualDesconto + "%, até no máximo R$ " + maxDesconto;
	}

	@Override
	public void calculaDesconto(Compra minhaCompra) {
		double valor = minhaCompra.getValorTotal();
		minhaCompra.setValorTotal(max(valor * this.percentualDesconto, valor - this.maxDesconto));
	}
	
	
}
