package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CarneLeopardo.CarneLeopardoSistema;

class TributoTest {

	@Test
	void reajustarTributo() {
		CarneLeopardoSistema cl = new CarneLeopardoSistema();
		cl.cadastrarTributo(25, 25, 2024, "oi");
		double retorno = cl.reajustarTributo(25, 2022, 0.10);
		
		assertEquals(27.5, retorno);
	}

}
