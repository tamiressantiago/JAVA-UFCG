
public class FreteGratis implements Cupom {
	private double maxDesconto;
	
	public FreteGratis() {
		this.maxDesconto = 0;
	}
	
	public FreteGratis(double maxDesconto) {
		this.maxDesconto = maxDesconto;
	}

	@Override
	public String toString() {
		if(maxDesconto == 0)
			return "FreteGratis";
		return "Desconto de até R$ " + maxDesconto + " no Frete";
	}

	@Override
	public void calculaDesconto(Compra minhaCompra) {
		if(maxDesconto == 0)
			minhaCompra.setValorFrete(0);
		else
			minhaCompra.setValorFrete(minhaCompra.getValorFrete() - maxDesconto);
	}
	
	
}
