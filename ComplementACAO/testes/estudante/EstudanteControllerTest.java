package estudante;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import atividadesComplementares.AtividadeComplementar;
import atividadesComplementares.Monitoria;

class EstudanteControllerTest {
	private EstudanteController controllerBase;
	private AtividadeComplementar atv;
	
	@BeforeEach
	void criaObjetosBase() {
		this.controllerBase = new EstudanteController();
		controllerBase.criarEstudante("Tamires Santiago", "123456789", "senha123", "matricula");
		this.atv = new Monitoria("Monitoria", 1, "p1");
		controllerBase.adicionarAtividadeComplementarEmEstudante(atv, "123456789", "senha123", "Monitoria");
		}
	
	@Test
	void testeCriaEstudante() {
		boolean retorno = controllerBase.criarEstudante("Fulano", "1234567", "senha123", "matricula");
		assertTrue(retorno);
	}

	@Test
	void testeCriaEstudanteJaExistente() {
		boolean retorno = controllerBase.criarEstudante("Tamires Santiago", "123456789", "senha123", "matricula");
		assertFalse(retorno);
	}
	
	@Test
	void testeAlterarSenhaEstudanteAtualValida() {
		boolean retorno = controllerBase.alterarSenhaEstudante("123456789", "senha123", "senha777");
		assertTrue(retorno);
	}	
	
	@Test
	void testeAlterarSenhaEstudanteAtualInvalida() {
		boolean retorno = controllerBase.alterarSenhaEstudante("123456789", "senha125", "senha1234");
		assertFalse(retorno);
	}	
	
	@Test
	void testeAlterarNovaSenhaInvalida() {
		try {
			controllerBase.alterarSenhaEstudante("123456789", "senha123", "senha");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Senha inválida!", e.getMessage());
		}
	}	
	
	@Test
	void testeAlterarSenhaEstudanteInexistente() {
		boolean retorno = controllerBase.alterarSenhaEstudante("99999999999", "senha125", "senha777");
		assertFalse(retorno);
	}	
	
	@Test
	void testeExibirEstudantes() {
		controllerBase.criarEstudante("André", "1234567777", "senha123", "matricula");
		String[] esperado = {"André\n"
				+ "CPF: 1234567777\n"
				+ "Matricula: matricula\n"
				+ "Bônus: 0", "Tamires Santiago\n"
						+ "CPF: 123456789\n"
						+ "Matricula: matricula\n"
						+ "Bônus: 0"};
		String[] retorno = controllerBase.exibirEstudantes();
		assertArrayEquals(esperado, retorno);
	}	
	
	@Test
	void testeAdicionarAtividadeComplementarEmEstudante() {
		String retorno = controllerBase.adicionarAtividadeComplementarEmEstudante(atv, "123456789", "senha123", "Monitoria");
		assertEquals("123456789_2", retorno);
	}
	
	@Test
	void testeAdicionarAtividadeComplementarEmEstudanteInexistente() {
		try {
			controllerBase.adicionarAtividadeComplementarEmEstudante(atv, "1234567899", "senha123", "Monitoria");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Estudante inexistente!", e.getMessage());
		}
	}
	
	@Test
	void testeAlterarDescricaoAtividade() {
		boolean retorno = controllerBase.alterarDescricaoAtividade("123456789", "senha123", "123456789_1", "bora bill");
		assertTrue(retorno);
	}
	
	@Test
	void testeAlterarDescricaoAtividadeInexistente() {
		boolean retorno = controllerBase.alterarDescricaoAtividade("123456789", "senha123", "123456789_3", "bora bill");
		assertFalse(retorno);
	}
	
	@Test
	void testeAlterarDescricaoAtividadeEstudanteInexistente() {
		try {
			controllerBase.alterarDescricaoAtividade("1234567899", "senha123", "123456789_3", "bora bill");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Estudante inexistente!", e.getMessage());
		}
	}
	
	@Test
	void testeAlterarComprovacaoAtividade() {
		boolean retorno = controllerBase.alterarComprovacaoAtividade("123456789", "senha123", "123456789_1", "link");
		assertTrue(retorno);
	}
	
	@Test
	void testeAlterarComprovacaoAtividadeInexistente() {
		boolean retorno = controllerBase.alterarDescricaoAtividade("123456789", "senha123", "123456789_3", "link");
		assertFalse(retorno);
	}
	
	@Test
	void testeAlterarComprovacaoAtividadeEstudanteInexistente() {
		try {
			controllerBase.alterarDescricaoAtividade("1234567899", "senha123", "123456789_3", "link");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Estudante inexistente!", e.getMessage());
		}
	}
	
	@Test
	void testeCreditosAtividade() {
		int retorno = controllerBase.creditosAtividade("123456789", "senha123", "Monitoria");
		assertEquals(4, retorno);
	}
	
	@Test
	void testeCreditosAtividadeInexistente() {
		int retorno = controllerBase.creditosAtividade("123456789", "senha123", "Estagio");
		assertEquals(0, retorno);
	}
	
	@Test
	void testeCreditosAtividadeEstudanteInexistente() {
		try {
			controllerBase.creditosAtividade("1234567899", "senha123", "Estagio");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Estudante inexistente!", e.getMessage());
		}
	}
	
	@Test
	void testeGerarMapaCreditos() {
		String retorno = controllerBase.gerarMapaCreditosAtividades("123456789", "senha123");
		assertEquals("MAPA DE CRÉDITOS:\n"
				+ "PESQUISA_EXTENSÃO: 0\n"
				+ "MONITORIA: 4\n"
				+ "ESTAGIO: 0\n"
				+ "REPRESENTAÇÃO_ESTUDANTIL: 0", retorno);
	}
	
	@Test
	void testeGerarMapaCreditosEstudanteInexistente() {
		try {
			controllerBase.gerarMapaCreditosAtividades("1234567899", "senha123");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Estudante inexistente!", e.getMessage());
		}
	}
	
	@Test
	void testeVerificarMetaNaoAlcancada() {
		boolean retorno = controllerBase.verificarMetaAlcancada("123456789", "senha123");
		assertFalse(retorno);
	}
	
	@Test
	void testeVerificarMetaAlcancada() {
		AtividadeComplementar atv2 = new Monitoria("Estagio", 10, "p1");
		controllerBase.adicionarAtividadeComplementarEmEstudante(atv2, "123456789", "senha123", "Estagio");
		AtividadeComplementar atv3 = new Monitoria("Monitoria", 10, "p1");
		controllerBase.adicionarAtividadeComplementarEmEstudante(atv3, "123456789", "senha123", "Monitoria");
		boolean retorno = controllerBase.verificarMetaAlcancada("123456789", "senha123");
		assertTrue(retorno);
	}
	
	@Test
	void testeVerificarMetaEstudanteInexistente() {
		try {
			controllerBase.verificarMetaAlcancada("1234567899", "senha123");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Estudante inexistente!", e.getMessage());
		}
	}
	
	@Test
	void testeGerarRelatorioFinal() {
		AtividadeComplementar atv2 = new Monitoria("Estagio", 10, "p1");
		controllerBase.adicionarAtividadeComplementarEmEstudante(atv2, "123456789", "senha123", "Estagio");
		AtividadeComplementar atv3 = new Monitoria("Monitoria", 4, "p1");
		controllerBase.adicionarAtividadeComplementarEmEstudante(atv3, "123456789", "senha123", "Monitoria");
		String retorno = controllerBase.gerarRelatorioFinal("123456789", "senha123");
		assertEquals("Tamires Santiago\n"
				+ "CPF: 123456789\n"
				+ "Matricula: matricula\n"
				+ "Bônus: 0\n"
				+ "MONITORIA- 16/16\n"
				+ "ESTAGIO- 16/18\n"
				+ "PESQUISA E EXTENSÃO- 0/18\n"
				+ "REPRESENTAÇÃO ESTUDANTIL- 0/2\n"
				+ "32/22", retorno);
	}
	
	@Test
	void testeGerarRelatorioFinalEstudanteInexistente() {
		try {
			controllerBase.gerarRelatorioFinal("123456789000", "senha123");
		}catch(IllegalArgumentException e) {
			assertEquals("Estudante inexistente!", e.getMessage());
		}	
	}
	
	@Test
	void testeGerarRelatorioFinalCreditosInsuficientes() {
		try {
			controllerBase.gerarRelatorioFinal("123456789", "senha123");
		}catch(IllegalArgumentException e) {
			assertEquals("Quantidade de créditos inválida!", e.getMessage());
		}	
	}
	
	@Test
	void testeGerarRelatorioFinalPorAtividade() {
		AtividadeComplementar atv2 = new Monitoria("Estagio", 10, "p1");
		controllerBase.adicionarAtividadeComplementarEmEstudante(atv2, "123456789", "senha123", "Estagio");
		AtividadeComplementar atv3 = new Monitoria("Monitoria", 4, "p1");
		controllerBase.adicionarAtividadeComplementarEmEstudante(atv3, "123456789", "senha123", "Monitoria");
		String retorno = controllerBase.gerarRelatorioFinalPorAtividade("123456789", "senha123", "Monitoria");
		assertEquals("Tamires Santiago\n"
				+ "CPF: 123456789\n"
				+ "Matricula: matricula\n"
				+ "Bônus: 0 Monitoria: 16", retorno);
	}
	
	@Test
	void testeGerarRelatorioFinalPorAtividadeEstudanteInexistente() {
		try {
			controllerBase.gerarRelatorioFinalPorAtividade("123456789000", "senha123", "Monitoria");
		}catch(IllegalArgumentException e) {
			assertEquals("Estudante inexistente!", e.getMessage());
		}	
	}
	
	@Test
	void testeGerarRelatorioFinalPorAtividadeCreditosInsuficientes() {
		try {
			controllerBase.gerarRelatorioFinalPorAtividade("123456789", "senha123", "Monitoria");
		}catch(IllegalArgumentException e) {
			assertEquals("Quantidade de créditos inválida!", e.getMessage());
		}	
	}
	
	@Test
	void testeGerarRelatorioParcial() {
		AtividadeComplementar atv3 = new Monitoria("Monitoria", 4, "p1");
		controllerBase.adicionarAtividadeComplementarEmEstudante(atv3, "123456789", "senha123", "Monitoria");
		String retorno = controllerBase.gerarRelatorioParcial("123456789", "senha123", true);
		String data = ""+LocalDate.now();
		String esperado = "Tamires Santiago\n"
				+ "CPF: 123456789\n"
				+ "Matricula: matricula\n"
				+ "Bônus: 0\n"
				+ "Tipo: Monitoria\n"
				+ "\nCréditos acumulados: 4\n"
				+ "Créditos máximos: 16\n"
				+ "Tipo: Monitoria\n"
				+ "\nCréditos acumulados: 16\n"
				+ "Créditos máximos: 16\n"
				+ data;
		assertEquals(esperado, retorno);
	}
	
	@Test
	void testeGerarRelatorioParcialEstudanteInexistente() {
		try {
			controllerBase.gerarRelatorioParcial("123456789000", "senha123", true);
		}catch(IllegalArgumentException e) {
			assertEquals("Estudante inexistente!", e.getMessage());
		}	
	}
	
	@Test
	void testeGerarRelatorioParcialPorAtividade() {
		AtividadeComplementar atv2 = new Monitoria("Estagio", 10, "p1");
		controllerBase.adicionarAtividadeComplementarEmEstudante(atv2, "123456789", "senha123", "Estagio");
		String retorno = controllerBase.gerarRelatorioParcialPorAtividade("123456789", "senha123", true, "Monitoria");
		String data = ""+LocalDate.now();
		String esperado = "Tamires Santiago\n"
				+ "CPF: 123456789\n"
				+ "Matricula: matricula\n"
				+ "Bônus: 0\n"
				+ "Tipo: Monitoria\n"
				+ "\nCréditos acumulados: 4\n"
				+ "Créditos máximos: 16\n"
				+ data;
				
		assertEquals(esperado, retorno);
	}
	
	@Test
	void testeGerarRelatorioParcialPorAtividadeEstudanteInexistente() {
		try {
			controllerBase.gerarRelatorioParcialPorAtividade("123456789000", "senha123", true, "Monitoria");
		}catch(IllegalArgumentException e) {
			assertEquals("Estudante inexistente!", e.getMessage());
		}	
	}
	
	@Test
	void testeListarHistorico() {
		controllerBase.gerarRelatorioParcial("123456789", "senha123", true);
		controllerBase.gerarRelatorioParcialPorAtividade("123456789", "senha123", true, "Monitoria");
		String retorno = controllerBase.listarHistorico("123456789", "senha123");
		String data = ""+LocalDate.now();
		String esperado = "\nTamires Santiago\n"
				+ "CPF: 123456789\n"
				+ "Matricula: matricula\n"
				+ "Bônus: 0\n"
				+ "Tipo: Monitoria\n"
				+ "\nCréditos acumulados: 4"
				+ "\nCréditos máximos: 16\n"
				+ data;
		assertEquals(esperado, retorno);
	}
	
	@Test
	void testeListarHistoricoVazio() {
		controllerBase.criarEstudante("Teste Historico Vazio", "11111111111", "senha123", "matricula");
		String retorno = controllerBase.listarHistorico("11111111111", "senha123");
		String data = ""+LocalDate.now();
		String esperado = "";
		assertEquals(esperado, retorno);
	}
	
	@Test
	void testeListarHistoricoEstudanteInexistente() {
		try {
			controllerBase.listarHistorico("123456789000", "senha123");
		}catch(IllegalArgumentException e) {
			assertEquals("Estudante inexistente!", e.getMessage());
		}	
	}
	
	@Test
	void testeExcluirItemHistorico() {
		controllerBase.gerarRelatorioParcial("123456789", "senha123", true);
		String data = "" + LocalDate.now();
		boolean retorno = controllerBase.excluirItemHistorico("123456789", "senha123", data);
		assertTrue(retorno);
	}
	
	@Test
	void testeExcluirItemHistoricoEstudanteInexistente() {
		try {
			controllerBase.listarHistorico("123456789000", "senha123");
		}catch(IllegalArgumentException e) {
			assertEquals("Estudante inexistente!", e.getMessage());
		}	
	}
	
	@Test
	void testeExcluirItemHistoricoInexistente() {
		controllerBase.gerarRelatorioParcial("123456789", "senha123", true);
		boolean retorno = controllerBase.excluirItemHistorico("123456789", "senha123", "2014/09/23");
		assertFalse(retorno);
	}
	
	@Test
	void testePegarEstudante() {
		Estudante base = new Estudante("nome", "123456789", "senha123", "matricula");
		Estudante teste = controllerBase.pegarEstudante("123456789", "senha123");
		assertEquals(base, teste);
	}
	
	@Test
	void testePegarEstudanteInexistente() {
		try {
			controllerBase.pegarEstudante("123456789000", "senha123");
		}catch(IllegalArgumentException e) {
			assertEquals("Estudante inexistente!", e.getMessage());
		}	
	}
	
	@Test
	void testePegarEstudanteSenhaInválida() {
		try {
			controllerBase.pegarEstudante("123456789", "senha1234");
		}catch(IllegalArgumentException e) {
			assertEquals("Senha inválida!", e.getMessage());
		}	
	}
}
