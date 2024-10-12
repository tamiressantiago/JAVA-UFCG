package mrbet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeTest {
	
	@Test
	void testeTimeCodigoNulo() {
		try {
			Time time = new Time(null, "Nacional de Patos", "Canário");
		} catch(NullPointerException e) {
			assertEquals("Entrada nula inválida!", e.getMessage());
		}
	}

	@Test
	void testeTimeNomeNulo() {
		try {
			Time time = new Time("250_PB", null, "Canário");
		} catch(NullPointerException e) {
			assertEquals("Entrada nula inválida!", e.getMessage());
		}
	}
	
	@Test
	void testeTimeMascoteNulo() {
		try {
			Time time = new Time("250_PB", "Nacional de Patos", null);
		} catch(NullPointerException e) {
			assertEquals("Entrada nula inválida!", e.getMessage());
		}
	}

	@Test
	void testeTimeCodigoVazio() {
		try {
			Time time = new Time("", "Nacional de Patos", "Canário");
		} catch(IllegalArgumentException e) {
			assertEquals("Entrada vazia!", e.getMessage());
		}
	}
	
	@Test
	void testeTimeNomeVazio() {
		try {
			Time time = new Time("250_PB", " ", "Canário");
		} catch(IllegalArgumentException e) {
			assertEquals("Entrada vazia!", e.getMessage());
		}
	}
	
	@Test
	void testeTimeMascoteVazio() {
		try {
			Time time = new Time("250_PB", "Nacional de Patos", " ");
		} catch(IllegalArgumentException e) {
			assertEquals("Entrada vazia!", e.getMessage());
		}
	}
	
	@Test
	void testeHashCodeObjetosIguais() {
		Time time1 = new Time("250_PB", "Nacional de Patos", "Canário");
		Time time2 = new Time("250_PB", "Sport Lagoa Seca", "Carneiro");
		assertEquals(time1.hashCode(), time2.hashCode());
	}
	
	@Test
	void testeEqualsObjetosIguais() {
		Time time1 = new Time("250_PB", "Nacional de Patos", "Canário");
		Time time2 = new Time("250_PB", "Sport Lagoa Seca", "Carneiro");
		boolean verifica = time1.equals(time2);
		assertTrue(verifica);
	}
	
	@Test
	void testeEqualsObjetosDiferentes() {
		Time time1 = new Time("250_PB", "Nacional de Patos", "Canário");
		Time time2 = new Time("252_PB", "Sport Lagoa Seca", "Carneiro");
		boolean verifica = time1.equals(time2);
		assertFalse(verifica);
	}
	
	@Test
	void testeToString() {
		Time time1 = new Time("250_PB", "Nacional de Patos", "Canário");
		String verifica = time1.toString();
		assertEquals("[250_PB] Nacional de Patos / Canário", verifica);
	}
}
