package mrbet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MrBetSistemaTest {
	MrBetSistema bet = new MrBetSistema();
	
	@BeforeEach
	void preparaTimes() {
		bet.addTime("250_PB", "Nacional de Patos", "Canário");
		bet.addTime("252_PB", "Sport Lagoa Seca", "Carneiro");
		bet.addTime("002_RJ", "Clube de Regatas do Flamengo", "Urubu");
		bet.addTime("105_PB", "Sociedade Recreativa de Monteiro (SOCREMO)", "Gavião");
	}
	
	@Test
	void testecadastrarTimeExistente() {
		String verifica = bet.addTime("250_PB", "Nacional de Patos", "Canário");
		assertEquals("TIME JÁ EXISTE!", verifica);
	}
	
	@Test
	void testecadastrarCampeonato() {
		String verifica = bet.addCampeonato("Brasileirão série A 2023", 5);
		assertEquals("CAMPEONATO ADICIONADO!", verifica);
	}
	
	@Test
	void testecadastrarCampeonatoExistente() {
		bet.addCampeonato("Brasileirão série A 2023", 3);
		String verifica = bet.addCampeonato("Brasileirão série A 2023", 5);
		assertEquals("CAMPEONATO JÁ EXISTE!", verifica);
	}
	
	@Test
	void testeIncluirTimeCampeonato() {
		bet.addCampeonato("Brasileirão série A 2023", 5);
		String verifica = bet.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023");
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", verifica);
		
		String verifica2 = bet.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023");
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", verifica2);
	}
	
	@Test
	void testeIncluirTimeExistenteCampeonato() {
		bet.addCampeonato("Brasileirão série A 2023", 5);
		String verifica = bet.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023");
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", verifica);
		
		String verifica2 = bet.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023");
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", verifica2);
		
		String verifica3 = bet.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023");
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", verifica3);
	}
	
	@Test
	void testeIncluirTimeInexistente() {
		bet.addCampeonato("Brasileirão série A 2023", 5);
		try {
			bet.incluirTimeCampeonato("005_PB", "Brasileirão série A 2023");
			fail();
		} 
		catch(IllegalArgumentException e) {			
			assertEquals("O TIME NÃO EXISTE!", e.getMessage());
		}	
	}
	
	@Test
	void testeIncluirTimeCampeonatoInexistente() {
		try {
			bet.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023");
			fail();
		} 
		catch(IllegalArgumentException e) {			
			assertEquals("O CAMPEONATO NÃO EXISTE!", e.getMessage());
		}	
	}
	
	@Test
	void testeIncluirTimeCampeonatoAcimaLimite() {
		bet.addCampeonato("Brasileirão série A 2023", 1);
		
		String verifica = bet.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023");
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", verifica);
		
		String verifica2 = bet.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023");
		assertEquals("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!", verifica2);
	}
	
	@Test
	void testeVerificaTimeEmCampeonato() {
		bet.addCampeonato("Copa do Nordeste 2023", 1);
		bet.incluirTimeCampeonato("250_PB", "Copa do Nordeste 2023");
		
		String verifica = bet.verificarTimeEmCampeonato("250_PB", "Copa do Nordeste 2023");
		assertEquals("O TIME ESTÁ NO CAMPEONATO!", verifica);
		
		String verifica2 = bet.verificarTimeEmCampeonato("252_PB", "Copa do Nordeste 2023");
		assertEquals("O TIME NÃO ESTÁ NO CAMPEONATO!", verifica2);
	}

	@Test
	void testeVerificaTimeEmCampeonatoInexistente() {
		try {
			bet.verificarTimeEmCampeonato("252_PB", "Brasileirão série D 2023");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("O CAMPEONATO NÃO EXISTE!", e.getMessage() );		
		}
	}
	
	@Test
	void testeVerificaTimeInexistenteEmCampeonato() {
		bet.addCampeonato("Copa do Nordeste 2023", 1);
		try {
			bet.verificarTimeEmCampeonato("005_PB", "Copa do Nordeste 2023");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("O TIME NÃO EXISTE!", e.getMessage() );		
		}
	}
	
	@Test
	void testeMostrarTimeExistente() {
		String saida = bet.mostrarTime("250_PB");
		assertEquals("[250_PB] Nacional de Patos / Canário", saida);
	}
	
	@Test
	void testeMostrarTimeInexistente() {
		String saida = bet.mostrarTime("005_PB");
		assertEquals("TIME NÃO EXISTE!", saida);
	}
	
	@Test
	void testeExibirCampeonatosTime() {
		bet.addCampeonato("Copa do Nordeste 2023", 1);
		bet.addCampeonato("Brasileirão série A 2023", 1);
		bet.incluirTimeCampeonato("250_PB", "Copa do Nordeste 2023");
		
		String saida = bet.exibirCampeonatosTime("250_PB");
		assertEquals("Campeonatos do Nacional de Patos\n"
				+ "* Copa do Nordeste 2023 - 1/1\n", saida);	
		}
	
	@Test
	void testeExibirCampeonatosTimeInexistente() {
		bet.addCampeonato("Copa do Nordeste 2023", 1);
		try {
			bet.exibirCampeonatosTime("005_PB");
			fail();
		} catch(IllegalArgumentException e) {
			assertEquals("O TIME NÃO EXISTE!", e.getMessage() );		
		}
	}
	
	@Test
	void testeRealizarAposta() {
		bet.addCampeonato("Copa do Nordeste 2023", 5);
		String saida = bet.realizarAposta("250_PB", "Copa do Nordeste 2023", 3, 500);
		assertEquals("APOSTA REGISTRADA!", saida);
	}
	
	@Test
	void testeRealizarApostaCampeonatoInexistente() {
		try {
			bet.realizarAposta("250_PB", "Copa do Nordeste 2023", 3, 500);
			fail();
		} catch(IllegalArgumentException e){
			assertEquals("O CAMPEONATO NÃO EXISTE!", e.getMessage());
		}
	}
	
	@Test
	void testeRealizarApostaTimeInexistente() {
		bet.addCampeonato("Copa do Nordeste 2023", 5);
		try {
			bet.realizarAposta("005_PB", "Copa do Nordeste 2023", 3, 500);
			fail();
		} catch(IllegalArgumentException e){
			assertEquals("O TIME NÃO EXISTE!", e.getMessage());
		}
	}
	
	@Test
	void testeRealizarApostaPosicaoInvalida() {
		bet.addCampeonato("Copa do Nordeste 2023", 5);
		String retorno = bet.realizarAposta("250_PB", "Copa do Nordeste 2023", 6, 500);
		assertEquals("APOSTA NÃO REGISTRADA!", retorno);
	}
	
	@Test
	void testeRealizarApostaPosicaoNoLimite() {
		bet.addCampeonato("Copa do Nordeste 2023", 2);
		String retorno = bet.realizarAposta("250_PB", "Copa do Nordeste 2023", 2, 500);
		assertEquals("APOSTA REGISTRADA!", retorno);
	}
	
	@Test
	void testePegarApostas() {
		bet.addCampeonato("Copa do Nordeste 2023", 5);
		bet.realizarAposta("250_PB", "Copa do Nordeste 2023", 3, 500);
		
		String retorno = bet.pegarApostas();
		assertEquals("Apostas:\n"
				+ "1. [250_PB] Nacional de Patos / Canário\n"
				+ "Copa do Nordeste 2023\n"
				+ "3/5\n"
				+ "R$ 500.0\n", retorno);
	}
	
}
