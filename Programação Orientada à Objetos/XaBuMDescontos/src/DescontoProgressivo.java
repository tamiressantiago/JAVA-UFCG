
public class DescontoProgressivo implements Cupom {

	public DescontoProgressivo() {
		
	}
	
	@Override
	public String toString() {
		return "DescontoProgressivo, 1%, 5% ou 10%";
	}

	@Override
	public void calculaDesconto(Compra minhaCompra) {
		double valor = minhaCompra.getValorTotal();
		if(minhaCompra.getValorTotal() <= 100)
			minhaCompra.setValorTotal(valor * 0.99);
		else if(minhaCompra.getValorTotal() <= 500)
			minhaCompra.setValorTotal(valor * 0.95);
		else
			minhaCompra.setValorTotal(valor * 0.9);
	}

}
