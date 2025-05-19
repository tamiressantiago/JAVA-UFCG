package CarneLeopardo;

public class Main {

	public static void main(String[] args) {
		CarneLeopardoSistema cl = new CarneLeopardoSistema();
		System.out.println(cl.cadastrarContribuinte("123456465", "2024", "9991"));
		System.out.println(cl.cadastrarTributo(25, 25, 2024, "oi"));
		System.out.println(cl.reajustarTributo(25, 2022, 0.10));
		System.out.println(cl.atribuirTributoAoContribuinte(25, "123456465"));
		
		try {
			System.out.println(cl.totalPagoEmTributos("1", 2021));
		} catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}

}
