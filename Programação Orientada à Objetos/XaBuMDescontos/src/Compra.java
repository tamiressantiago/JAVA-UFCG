
public class Compra {
	private int codigo;
	private Usuario usuario;
	private double valorTotal;
	private double valorFrete;
	
	public Compra(int codigo, Usuario usuario, double valorTotal, double valorFrete) {
		this.codigo = codigo;
		this.usuario = usuario;
		this.valorTotal = valorTotal;
		this.valorFrete = valorFrete;
	}
		
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setValorFrete(double valorFrete) {
		this.valorFrete = valorFrete;
	}

	public double getValorTotal() {
		return valorTotal;
	}
	
	public double getValorFrete() {
		return valorFrete;
	}
	
	public void aplicaDescontoCompra(double d) {
		this.valorFrete -= d;
	}

	public Cupom pegaCupomUsuario(int indexCupomUsuario) {
		return usuario.usaCupom(indexCupomUsuario);	
	}

	/*
	 * Tá liberado violar o GRASP
	public void aplicaDesconto(double d) {
		this.valorTotal -= d;
	}
	
	public void aplicaDescontoFrete(double d) {
		this.valorFrete -= d;
	}*/
}
