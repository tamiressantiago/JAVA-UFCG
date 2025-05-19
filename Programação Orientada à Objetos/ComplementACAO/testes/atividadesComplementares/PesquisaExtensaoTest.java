package atividadesComplementares;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PesquisaExtensaoTest {

	private PesquisaExtensao p;
	
	@BeforeEach
	void criaObjetoBase() {
		this.p = new PesquisaExtensao("PesquisaExtensao", 12, "PET");
	}
	
	@Test
	void testeCriarPesquisaExtensaoUnidadeInvalida() {
		try {
			PesquisaExtensao p = new PesquisaExtensao("PesquisaExtensao", -1, "PET");	
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Unidade inválida!", e.getMessage());
		}
	}
	
	@Test
	void testeCriarPesquisaExtensaoSubtipoInvalido() {
		try {
			PesquisaExtensao p = new PesquisaExtensao("PesquisaExtensao", 100, "PETA");	
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("ATIVIDADE NÃO CADASTRADA", e.getMessage());
		}
	}
	
	@Test
	void testeCriarPesquisaExtensaoSubtipoVazio() {
		try {
			PesquisaExtensao p = new PesquisaExtensao("PesquisaExtensao", 100, "");	
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("ATIVIDADE NÃO CADASTRADA", e.getMessage());
		}
	}
	
	@Test
	void testeCriarPesquisaExtensaoSubtipoNulo() {
		try {
			PesquisaExtensao p = new PesquisaExtensao("PesquisaExtensao", 100, null);	
			fail();
		} catch(NullPointerException e) {
			assertEquals("Entrada nula inválida", e.getMessage());
		}
	}
	
	@Test
	void testeCriarPesquisaExtensaoTipoVazio() {
		try {
			PesquisaExtensao p = new PesquisaExtensao("", 100, "PET");	
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Entrada vazia inválida", e.getMessage());
		}
	}
	
	@Test
	void testeCriarPesquisaExtensaoTipoNulo() {
		try {
			PesquisaExtensao p = new PesquisaExtensao(null, 100, "PET");	
			fail();
		} catch(NullPointerException e) {
			assertEquals("Entrada nula inválida", e.getMessage());
		}
	}
	
	@Test
	void testeToString() {
		assertEquals("AtividadeComplementar - Tipo: PesquisaExtensao,\n"
				+ "Descricao: null,\n"
				+ "Link: null,\n"
				+ "Unidade Acumulada: 12,\n"
				+ "Subtipo: PET", p.toString());
	}
	
	@Test
	void testeQntCreditos() {
		assertEquals(10, p.qntCreditos(0));
	}
	
	@Test
	void testeQntCreditosLimite() {
		PesquisaExtensao p2 = new PesquisaExtensao("PesquisaExtensao", 24, "PET");		
		assertEquals(18, p2.qntCreditos(0));
	}

}
