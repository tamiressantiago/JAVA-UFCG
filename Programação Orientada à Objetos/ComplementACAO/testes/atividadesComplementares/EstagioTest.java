package atividadesComplementares;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstagioTest {
	private Estagio est;
	
	@BeforeEach
	void criaObjetoBase() {
		this.est = new Estagio("estagio", 300, "empresa");
	}
	
	@Test
	void testeCriarEstagioUnidadeInvalida() {
		try {
			Estagio est = new Estagio("estagio", -1, "empresa");	
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Unidade inválida!", e.getMessage());
		}
	}
	
	@Test
	void testeCriarEstagioHorasInvalidas() {
		try {
			Estagio est = new Estagio("estagio", 100, "empresa");	
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("ATIVIDADE NÃO CADASTRADA", e.getMessage());
		}
	}
	
	@Test
	void testeCriarEstagioTipoNulo() {
		try {
			Estagio est = new Estagio(null, 300, "empresa");	
			fail();
		} catch(NullPointerException e) {
			assertEquals("Entrada nula inválida!", e.getMessage());
		}
	}

	@Test
	void testeCriarEstagioTipoVazio() {
		try {
			Estagio est = new Estagio("", 300, "empresa");	
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Entrada vazia inválida!", e.getMessage());
		}
	}

	@Test
	void testeCriarEstagioEmpresaNula() {
		try {
			Estagio est = new Estagio("estagio", 300, null);	
			fail();
		} catch(NullPointerException e) {
			assertEquals("Entrada nula inválida!", e.getMessage());
		}
	}

	@Test
	void testeCriarEstagioEmpresaVazio() {
		try {
			Estagio est = new Estagio("estagio", 300, "");	
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Entrada vazia inválida!", e.getMessage());
		}
	}
	
	@Test
	void testeToString() {
		assertEquals("AtividadeComplementar - Tipo: estagio,\n"
				+ "Descricao: null,\n"
				+ "Link: null,\n"
				+ "Unidade Acumulada: 300,\n"
				+ "Empresa: empresa", est.toString());
	}
	
	@Test
	void testeQntCreditos() {
		assertEquals(5, est.qntCreditos(0));
	}
	
	@Test
	void testeQntCreditosLimite() {
		Estagio est2 = new Estagio("estagio", 1140, "empresa tal");	
		assertEquals(18, est2.qntCreditos(0));
	}

}
