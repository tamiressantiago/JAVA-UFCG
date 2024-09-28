package mrbet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ApostaTest {
	
	@Test
	void testeApostaTimeNulo() {
		Campeonato campeonato = new Campeonato("Brasileirão série A 2023", 5);
		
		try {
			Aposta aposta = new Aposta(null, campeonato, 3, 500);	
		} catch(NullPointerException e) {
			assertEquals("Time nulo!", e.getMessage());
		}
	}
	
	@Test
	void testeApostaCampeonatoNulo() {
		Time time = new Time("250_PB", "Nacional de Patos", "Canário");
		
		try {
			Aposta aposta = new Aposta(time, null, 3, 500);	
		} catch(NullPointerException e) {
			assertEquals("Campeonato nulo!", e.getMessage());
		}
	}
	
	@Test
	void testeApostaToString() {
		Time time = new Time("250_PB", "Nacional de Patos", "Canário");
		Campeonato campeonato = new Campeonato("Brasileirão série A 2023", 5);
		
		Aposta aposta = new Aposta(time, campeonato, 3, 500);
		assertEquals("[250_PB] Nacional de Patos / Canário\n"
				+ "Brasileirão série A 2023\n"
				+ "3/5\n"
				+ "R$ 500.0", aposta.toString());
	}

}
