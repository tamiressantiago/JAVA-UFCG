package estudante;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import atividadesComplementares.AtividadeComplementar;
import atividadesComplementares.Monitoria;

class EstudanteTest {
	private Estudante estudanteBase;
	private AtividadeComplementar atv;
	
	@BeforeEach
	void criaObjetosBase() {
		this.estudanteBase = new Estudante("Tamires Santiago", "123456789", "senha123", "matricula");
		this.atv = new Monitoria("Monitoria", 1, "p1");
		estudanteBase.adicionarAtividadeComplementar(atv, "Monitoria");
	}
	
	@Test
	void testeCriaEstudanteSenhaValida() {
		try {
			Estudante e = new Estudante("Tamires Santiago", "123456789", "senha", "matricula");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Senha inválida!", e.getMessage());
		}
	}
	
	@Test
	void testeCriaEstudanteNomeNulo(){
		try {
			Estudante e = new Estudante(null, "123456789", "senha123", "matricula");
			fail();
		} catch(NullPointerException e) {
			assertEquals("Entrada nula inválida!", e.getMessage());
		}
	}
	
	@Test
	void testeCriaEstudanteCpfNulo(){
		try {
			Estudante e = new Estudante("Tamires Santiago", null, "senha123", "matricula");
			fail();
		} catch(NullPointerException e) {
			assertEquals("Entrada nula inválida!", e.getMessage());
		}
	}
	
	@Test
	void testeCriaEstudanteSenhaNula() {
		try {
			Estudante e = new Estudante("Tamires Santiago", "123456789", null, "matricula");
			fail();
		} catch(NullPointerException e) {
			assertEquals("Entrada nula inválida!", e.getMessage());
		}
	}
	
	@Test
	void testeCriaEstudanteMatriculaNula() {
		try {
			Estudante e = new Estudante("Tamires Santiago", "123456789", "senha123", null);
			fail();
		} catch(NullPointerException e) {
			assertEquals("Entrada nula inválida!", e.getMessage());
		}
	}
	
	@Test
	void testeCriaEstudanteNomeVazio() {
		try {
			Estudante e = new Estudante("", "123456789", "senha123", "matricula");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Entrada vazia!", e.getMessage());
		}
	}
	
	@Test
	void testeCriaEstudanteCpfVazio() {
		try {
			Estudante e = new Estudante("Tamires Santiago", "", "senha123", "matricula");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Entrada vazia!", e.getMessage());
		}
	}
	
	@Test
	void testeCriaEstudanteSenhaVazia() {
		try {
			Estudante e = new Estudante("Tamires Santiago", "123456789", "", "matricula");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Entrada vazia!", e.getMessage());
		}
	}
	
	@Test
	void testeCriaEstudanteMatriculaVazia() {
		try {
			Estudante e = new Estudante("Tamires Santiago", "123456789", "senha123", "");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Entrada vazia!", e.getMessage());
		}
	}

	@Test
	void testeAlterarSenhaAtualValida() {
		assertTrue(estudanteBase.alterarSenha("senha123", "senha456"));
	}	
	
	@Test
	void testeAlterarSenhaAtualInvalida() {
		assertFalse(estudanteBase.alterarSenha("senha122", "senha456"));
	}	
	
	@Test
	void testeAlterarNovaSenhaInvalida() {
		try {
			estudanteBase.alterarSenha("senha123", "senha");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("Senha inválida!", e.getMessage());
		}
	}	
	
	@Test
	void testeVerificaSenhaValida() {
		assertTrue(estudanteBase.verificaSenha("senha123"));
	}
	
	@Test
	void testeVerificaSenhaInValida() {
		assertFalse(estudanteBase.verificaSenha("senha1234"));
	}
	
	@Test
	void testeHashCodeObjetosIguais() {
		Estudante estudanteTeste = new Estudante("Tamires Santiago", "123456789", "senha123", "matricula");
		assertEquals(estudanteBase.hashCode(), estudanteTeste.hashCode());
	}
	
	@Test
	void testeEqualsObjetosIguais() {
		Estudante estudanteTeste = new Estudante("Tamires Santiago", "123456789", "senha123", "matricula");
		assertTrue(estudanteBase.equals(estudanteTeste));
	}
	
	@Test
	void testeEqualsObjetosDiferentes() {
		Estudante estudanteTeste = new Estudante("Tamires Santiago", "111111111", "senha123", "matricula");
		assertFalse(estudanteBase.equals(estudanteTeste));
	}
	
	@Test
	void testeToString() {
		assertEquals(estudanteBase.toString(), "Tamires Santiago\nCPF: 123456789\nMatricula: matricula\nBônus: 0");
	}
	
	@Test
	void testeAdicionarAtividadeComplementar() {
		String retorno = estudanteBase.adicionarAtividadeComplementar(atv, "Monitoria");
		assertEquals("123456789_2", retorno);
	}
	
	@Test
	void testeAlterarDescricaoAtividade() {
		boolean retorno = estudanteBase.alterarDescricaoAtividade("123456789_1", "bora bill");
		assertTrue(retorno);
	}
	
	@Test
	void testeAlterarDescricaoAtividadeInexistente() {
		boolean retorno = estudanteBase.alterarDescricaoAtividade("123456789_2", "bora bill");
		assertFalse(retorno);
	}
	
	@Test
	void testeAlterarComprovacaoAtividade() {
		boolean retorno = estudanteBase.alterarComprovacaoAtividade("123456789_1", "link");
		assertTrue(retorno);
	}
	
	@Test
	void testeAlterarComprovacaoAtividadeInexistente() {
		boolean retorno = estudanteBase.alterarComprovacaoAtividade("123456789_3", "link");
		assertFalse(retorno);
	}
	
	@Test
	void testeCreditosAtividade() {
		int retorno = estudanteBase.creditosAtividade("Monitoria");
		assertEquals(4, retorno);
	}
	
	@Test
	void testeCreditosoAtividadeInexistente() {
		int retorno = estudanteBase.creditosAtividade("Estagio");
		assertEquals(0, retorno);
	}
	
	@Test
	void testeGerarMapaCreditos() {
		String retorno = estudanteBase.gerarMapaCreditosAtividades();
		assertEquals("MAPA DE CRÉDITOS:\n"
				+ "PESQUISA_EXTENSÃO: 0\n"
				+ "MONITORIA: 4\n"
				+ "ESTAGIO: 0\n"
				+ "REPRESENTAÇÃO_ESTUDANTIL: 0", retorno);
	}
	
	@Test
	void testeVerificarMetaNaoAlcancada() {
		boolean retorno = estudanteBase.verificarMetaAlcancada();
		assertFalse(retorno);
	}
	
	@Test
	void testeVerificarMetaAlcancada() {
		AtividadeComplementar atv2 = new Monitoria("Estagio", 10, "p1");
		estudanteBase.adicionarAtividadeComplementar(atv2, "Estagio");
		AtividadeComplementar atv3 = new Monitoria("Monitoria", 4, "p1");
		estudanteBase.adicionarAtividadeComplementar(atv3, "Monitoria");
		boolean retorno =  estudanteBase.verificarMetaAlcancada();
		assertTrue(retorno);
	}
	
	@Test
	void testeGerarRelatorioFinal() {
		AtividadeComplementar atv2 = new Monitoria("Estagio", 10, "p1");
		estudanteBase.adicionarAtividadeComplementar(atv2, "Estagio");
		AtividadeComplementar atv3 = new Monitoria("Monitoria", 4, "p1");
		estudanteBase.adicionarAtividadeComplementar(atv3, "Monitoria");
		String retorno = estudanteBase.gerarRelatorioFinal();
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
	void testeGerarRelatorioFinalCreditosInsuficientes() {
		try {
			estudanteBase.gerarRelatorioFinal();
		}catch(IllegalArgumentException e) {
			assertEquals("Quantidade de créditos inválida!", e.getMessage());
		}	
	}
	
	@Test
	void testeGerarRelatorioFinalPorAtividade() {
		AtividadeComplementar atv2 = new Monitoria("Estagio", 10, "p1");
		estudanteBase.adicionarAtividadeComplementar(atv2, "Estagio");
		AtividadeComplementar atv3 = new Monitoria("Monitoria", 4, "p1");
		estudanteBase.adicionarAtividadeComplementar(atv3, "Monitoria");
		String retorno = estudanteBase.gerarRelatorioFinalPorAtividade("Monitoria");
		assertEquals("Tamires Santiago\n"
				+ "CPF: 123456789\n"
				+ "Matricula: matricula\n"
				+ "Bônus: 0 Monitoria: 16", retorno);
	}
	
	@Test
	void testeGerarRelatorioFinalPorAtividadeCreditosInsuficientes() {
		try {
			estudanteBase.gerarRelatorioFinalPorAtividade("Monitoria");
		}catch(IllegalArgumentException e) {
			assertEquals("Quantidade de créditos inválida!", e.getMessage());
		}	
	}
	
	@Test
	void testeGerarRelatorioParcial() {
		AtividadeComplementar atv2 = new Monitoria("Estagio", 10, "p1");
		estudanteBase.adicionarAtividadeComplementar(atv2, "Estagio");
		String retorno = estudanteBase.gerarRelatorioParcial(true);
		String data = ""+LocalDate.now();
		String esperado = "Tamires Santiago\n"
				+ "CPF: 123456789\n"
				+ "Matricula: matricula\n"
				+ "Bônus: 0\n"
				+ "Tipo: Monitoria\n"
				+ "\nCréditos acumulados: 4\n"
				+ "Créditos máximos: 16\n"
				+ "Tipo: Estagio\n"
				+ "\nCréditos acumulados: 16\n"
				+ "Créditos máximos: 16\n"
				+ data;
		assertEquals(esperado, retorno);
	}
	
	@Test
	void testeGerarRelatorioParcialPorAtividade() {
		AtividadeComplementar atv2 = new Monitoria("Estagio", 10, "p1");
		estudanteBase.adicionarAtividadeComplementar(atv2, "Estagio");
		String retorno = estudanteBase.gerarRelatorioParcialPorAtividade(true, "Monitoria");
		String data = ""+LocalDate.now();
		String esperado = "Tamires Santiago\n"
				+ "CPF: 123456789\n"
				+ "Matricula: matricula\n"
				+ "Bônus: 0\n" 
				+ "Tipo: Monitoria\n"
				+ "\nCréditos acumulados: 4\n"
				+ "Créditos máximos: 16\n" + data;
				
		assertEquals(esperado, retorno);
	}
	
	@Test
	void testeListarHistorico() {
		estudanteBase.gerarRelatorioParcial(true);
		estudanteBase.gerarRelatorioParcialPorAtividade(true, "Monitoria");
		String retorno = estudanteBase.listarHistorico();
		String data = ""+LocalDate.now();
		String esperado = "\nTamires Santiago\n"
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
	void testeExcluirItemHistorico() {
		estudanteBase.gerarRelatorioParcial(true);
		String data = "" + LocalDate.now();
		boolean retorno = estudanteBase.excluirItemHistorico(data);
		assertTrue(retorno);
	}
	
	@Test
	void testeExcluirItemHistoricoInexistente() {
		estudanteBase.gerarRelatorioParcial(true);
		boolean retorno = estudanteBase.excluirItemHistorico("2014/09/23");
		assertFalse(retorno);
	}
}
