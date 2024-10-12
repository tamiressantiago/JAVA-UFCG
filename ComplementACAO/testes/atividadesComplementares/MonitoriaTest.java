package atividadesComplementares;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MonitoriaTest {

	private Monitoria m;
	
	@BeforeEach
	void criaObjetoBase() {
		this.m = new Monitoria("monitoria", 1, "p1");
	}
	
	@Test
	void testeCriarMonitoriaUnidadeInvalida() {
		try {
			Monitoria m = new Monitoria("monitoria", -1, "p1");		
		} catch(IllegalArgumentException e) {
			assertEquals("Unidade inválida!", e.getMessage());
		}
	}
	
	@Test
	void testeCriarMonitoriaSemestreInvalido() {
		try {
			Monitoria m = new Monitoria("monitoria", 0, "p1");			
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Não é possível cadastrar monitoria com menos de 1 semestre letivo.", e.getMessage());
		}
	}
	
	@Test
	void testeCriarMonitoriaTipoNulo() {
		try {
			Monitoria m = new Monitoria(null, 1, "p1");		
		} catch(NullPointerException e) {
			assertEquals("Entrada nula inválida!", e.getMessage());
		}
	}
	
	@Test
	void testeCriarMonitoriaTipoVazio() {
		try {
			Monitoria m = new Monitoria("", 1, "p1");		
		} catch(IllegalArgumentException e) {
			assertEquals("Entrada vazia inválida!", e.getMessage());
		}
	}
	
	@Test
	void testeCriarMonitoriaDisciplinaNula() {
		try {
			Monitoria m = new Monitoria("monitoria", 1, null);		
		} catch(NullPointerException e) {
			assertEquals("Entrada nula inválida!", e.getMessage());
		}
	}
	
	@Test
	void testeCriarMonitoriaDisciplinaVazia() {
		try {
			Monitoria m = new Monitoria("monitoria", 1, "");		
		} catch(IllegalArgumentException e) {
			assertEquals("Entrada vazia inválida!", e.getMessage());
		}
	}
	
	@Test
	void testeToString() {
		assertEquals("AtividadeComplementar - Tipo: monitoria,\n"
				+ "Descricao: null,\n"
				+ "Link: null,\n"
				+ "Unidade Acumulada: 1,\n"
				+ "Disciplina: p1", m.toString());
	}
	
	@Test
	void testeQntCreditos() {
		assertEquals(4, m.qntCreditos(0));
	}
	
	@Test
	void testeQntCreditosLimite() {
		Monitoria m2 = new Monitoria("monitoria", 5, "p1");	
		assertEquals(16, m2.qntCreditos(0));
	}

}
