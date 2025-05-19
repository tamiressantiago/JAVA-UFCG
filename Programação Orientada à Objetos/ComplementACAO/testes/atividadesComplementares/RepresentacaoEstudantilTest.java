package atividadesComplementares;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import atividadesComplementares.Monitoria;

class RepresentacaoEstudantilTest {

	private RepresentacaoEstudantil r;
	
	@BeforeEach
	void criaObjetoBase() {
		this.r = new RepresentacaoEstudantil("Representação Estudantil", 1, "Diretoria");
	}
	
	@Test
	void testeCriarRepresentacaoUnidadeInvalida() {
		try {
			RepresentacaoEstudantil r = new RepresentacaoEstudantil("Representação Estudantil", -1, "Diretoria");		
		} catch(IllegalArgumentException e) {
			assertEquals("Unidade inválida!", e.getMessage());
		}
	}
	
	@Test
	void testeCriarRepresentacaoAnoInvalido() {
		try {
			RepresentacaoEstudantil r = new RepresentacaoEstudantil("Representação Estudantil", 0, "Diretoria");			
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Não é possível cadastrar representação estudantil com menos de 1 ano.", e.getMessage());
		}
	}
	
	@Test
	void testeCriarRepresentacaoTipoVazio() {
		try {
			RepresentacaoEstudantil r = new RepresentacaoEstudantil("", 1, "Diretoria");		
		} catch(IllegalArgumentException e) {
			assertEquals("Entrada vazia inválida!", e.getMessage());
		}
	}
	
	@Test
	void testeCriarRepresentacaoTipoNulo() {
		try {
			RepresentacaoEstudantil r = new RepresentacaoEstudantil(null, 1, "Diretoria");		
		} catch(NullPointerException e) {
			assertEquals("Entrada nula inválida!", e.getMessage());
		}
	}
	
	@Test
	void testeCriarRepresentacaoSubtipoVazio() {
		try {
			RepresentacaoEstudantil r = new RepresentacaoEstudantil("Representação Estudantil", 1, "");		
		} catch(IllegalArgumentException e) {
			assertEquals("ATIVIDADE NÃO CADASTRADA", e.getMessage());
		}
	}
	
	@Test
	void testeCriarRepresentacaoSubtipoNulo() {
		try {
			RepresentacaoEstudantil r = new RepresentacaoEstudantil("Representação Estudantil", 1, null);		
		} catch(NullPointerException e) {
			assertEquals("Entrada nula inválida!", e.getMessage());
		}
	}
	
	@Test
	void testeToString() {
		assertEquals("AtividadeComplementar - Tipo: Representação Estudantil,\n"
				+ "Descricao: null,\n"
				+ "Link: null,\n"
				+ "Unidade Acumulada: 1,\n"
				+ "Subtipo: Diretoria", r.toString());
	}
	
	@Test
	void testeQntCreditos() {
		assertEquals(2, r.qntCreditos(01));
	}
	
	@Test
	void testeQntCreditosLimite() {
		RepresentacaoEstudantil r2 = new RepresentacaoEstudantil("Representação Estudantil", 4, "Diretoria");
		assertEquals(2, r2.qntCreditos(0));
	}

}
