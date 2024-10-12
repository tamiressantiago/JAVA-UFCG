package mrbet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CampeonatoTest {

	@Test
	void testeCampeonatoNomeVazio() {
		try {
			Campeonato campeonato = new Campeonato(" ", 3);			
		} catch(IllegalArgumentException e) {
			assertEquals("Nome vazio!", e.getMessage());
		}
	}
	
	@Test
	void testeCampeonatoNomeNulo() {
		try {
			Campeonato campeonato = new Campeonato(null, 3);			
		} catch(NullPointerException e) {
			assertEquals("Entrada nula inválida!", e.getMessage());
		}
	}
	
	@Test
	void testeHashCodeObjetosIguais() {
		Campeonato campeonato1 = new Campeonato("Brasileirão série A 2023", 5);
		Campeonato campeonato2 = new Campeonato("Brasileirão série A 2023", 6);
		assertEquals(campeonato1.hashCode(), campeonato2.hashCode());
	}
	
	@Test
	void testeEqualsObjetosIguais() {
		Campeonato campeonato1 = new Campeonato("Brasileirão série A 2023", 5);
		Campeonato campeonato2 = new Campeonato("Brasileirão série A 2023", 5);
		boolean verifica = campeonato1.equals(campeonato2);
		assertTrue(verifica);
	}
	
	@Test
	void testeEqualsObjetosDiferentes() {
		Campeonato campeonato1 = new Campeonato("Brasileirão série A 2023", 5);
		Campeonato campeonato2 = new Campeonato("Copa do Mundo", 500);
		boolean verifica = campeonato1.equals(campeonato2);
		assertFalse(verifica);
	}
	
	@Test
	void testeTemTimeTrue() {
		Time time = new Time("250_PB", "Nacional de Patos", "Canário");
		Campeonato campeonato1 = new Campeonato("Brasileirão série A 2023", 5);
		campeonato1.adicionarTime(time);
		assertTrue(campeonato1.temTime(time));
	}
	
	@Test
	void testeTemTimeFalse() {
		Time time = new Time("250_PB", "Nacional de Patos", "Canário");
		Campeonato campeonato1 = new Campeonato("Brasileirão série A 2023", 5);
		assertFalse(campeonato1.temTime(time));
	}
	
	@Test
	void testeToString() {
		Campeonato campeonato1 = new Campeonato("Brasileirão série A 2023", 5);
		String verifica = campeonato1.toString();
		assertEquals("* Brasileirão série A 2023 - 0/5", verifica);
	}
	
}
