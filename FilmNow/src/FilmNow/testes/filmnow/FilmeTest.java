package filmnow;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/**
 * @author Tamires Santiago Oliveira - 123210205
 */
class FilmeTest {
	private Filme filmeBase;

	@BeforeEach
	void preparaFilmes() {
		this.filmeBase = new Filme("Avatar", "2009", "Disney+");
	   }

	@Test
	void testEqualsObjetosIguais() {
		Filme filmeComparacao = new Filme("Avatar", "2009", "Disney+");
		boolean verifica = filmeBase.equals(filmeComparacao);
		assertTrue(verifica);
	}
	
	@Test
	void testEqualsObjetosDiferente() {
		Filme filmeComparacao = new Filme("Ratatouille", "2007", "Disney+");
		boolean verifica = filmeBase.equals(filmeComparacao);
		assertFalse(verifica);
	}

	@Test
	void testHashCodeObjetosIguais() {
		Filme filmeComparacao = new Filme("Avatar", "2009", "Disney+");
		int filmeB = filmeBase.hashCode();
		int filmeC = filmeComparacao.hashCode();
		assertEquals(filmeB, filmeC);
	}
	
	@Test
	void testToString() {
		String verifica = filmeBase.toString();
		assertEquals("Avatar, 2009\nDisney+", verifica);
	}
	
}
