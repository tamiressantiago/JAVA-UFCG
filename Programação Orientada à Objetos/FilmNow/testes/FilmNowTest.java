package filmnow;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author Tamires Santiago Oliveira - 123210205
 */
class FilmNowTest {

	FilmNow fn = new FilmNow();

	@Test
	void testCadastraFilme() {
		String verifica = fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		assertEquals("FILME ADICIONADO", verifica);
	}
	
	@Test
	void testCadastraFilmeLimite() {
		String verifica = fn.cadastraFilme(100, "Avatar", "2009", "Disney+");
		assertEquals("FILME ADICIONADO", verifica);
	}
	
	@Test
	void testCadastraFilmeAcimaLimite() {
		String verifica = fn.cadastraFilme(101, "Avatar", "2009", "Disney+");
		assertEquals("POSIÇÃO INVÁLIDA", verifica);
	}
	
	@Test
	void testCadastraFilmeAbaixoLimite() {
		String verifica = fn.cadastraFilme(0, "Avatar", "2009", "Disney+");
		assertEquals("POSIÇÃO INVÁLIDA", verifica);
	}
	
	@Test
	void testCadastraFilmePosicaoExistente() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		String verifica = fn.cadastraFilme(1, "20 dias em Mariupol", "2023", "Cinema");
		assertEquals("FILME ADICIONADO", verifica);
	}
	
	@Test
	void testCadastraFilmesIguais() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		String verifica = fn.cadastraFilme(2, "Avatar", "2009", "Disney+");
		assertEquals("FILME JÁ ADICIONADO", verifica);
	}

	@Test
	void testCadastraFilmesIguaisExetoLocal() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		String verifica = fn.cadastraFilme(2, "Avatar", "2009", "Netflix");
		assertEquals("FILME JÁ ADICIONADO", verifica);
	}
	
	@Test
	void testCadastraFilmeSemLocal() {
		String verifica = fn.cadastraFilme(1, "Avatar", "2009", "");
		assertEquals("FILME INVÁLIDO", verifica);
	}
	
	@Test
	void testCadastraFilmeSemAno() {
		String verifica = fn.cadastraFilme(1, "Avatar", "", "Disney+");
		assertEquals("FILME ADICIONADO", verifica);
	}
	
	@Test
	void testCadastraFilmeSemNome() {
		String verifica = fn.cadastraFilme(1, "", "2009", "Disney+");
		assertEquals("FILME INVÁLIDO", verifica);
	}
	
	@Test
	void testDetalharFilme() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		String verifica = fn.detalharFilme(1);
		assertEquals("Avatar, 2009\nDisney+", verifica);
	}
	
	@Test
	void testDetalharFilmeSemAno() {
		fn.cadastraFilme(1, "Avatar", "", "Disney+");
		String verifica = fn.detalharFilme(1);
		assertEquals("Avatar, \nDisney+", verifica);
	}
	
	@Test
	void testDetalharFilmePosicaoVazia() {
		String verifica = fn.detalharFilme(10);
		assertEquals("", verifica);
	}
	
	@Test
	void testDetalharFilmePosicaoInferior() {
		String verifica = fn.detalharFilme(-1);
		assertEquals("POSIÇÃO INVÁLIDA", verifica);
	}
	
	@Test
	void testDetalharFilmePosicaoSuperior() {
		String verifica = fn.detalharFilme(101);
		assertEquals("POSIÇÃO INVÁLIDA", verifica);
	}
	
	@Test
	void testDetalharFilmeHotList() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		fn.cadastraHot(1, 1);
		String verifica = fn.detalharFilme(1);
		assertEquals("🔥Avatar, 2009\nDisney+", verifica);
	}

	@Test
	void testGetFilmes() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		Filme lista[] = fn.getFilmes();
		assertEquals("Avatar, 2009\nDisney+", lista[0].toString());
	}
	
	@Test
	void testCadastraHot() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		String verifica = fn.cadastraHot(1, 1);
		assertEquals("ADICIONADO À HOTLIST NA POSIÇÃO 1", verifica);
	}
	
	@Test
	void testCadastraHotFilmePosicaoLimite() {
		fn.cadastraFilme(100, "Avatar", "2009", "Disney+");
		String verifica = fn.cadastraHot(100, 1);
		assertEquals("ADICIONADO À HOTLIST NA POSIÇÃO 1", verifica);
	}
	
	@Test
	void testCadastraHotFilmePosicaoInferior() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		String verifica = fn.cadastraHot(0, 1);
		assertEquals("FILME INVÁLIDO", verifica);
	}
	
	@Test
	void testCadastraHotFilmePosicaoSuperior() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		String verifica = fn.cadastraHot(101, 1);
		assertEquals("FILME INVÁLIDO", verifica);
	}
	
	@Test
	void testCadastraHotPosicaoLimite() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		String verifica = fn.cadastraHot(1, 10);
		assertEquals("ADICIONADO À HOTLIST NA POSIÇÃO 10", verifica);
	}
	
	@Test
	void testCadastraHotEFilmePosicaoLimite() {
		fn.cadastraFilme(100, "Avatar", "2009", "Disney+");
		String verifica = fn.cadastraHot(100, 10);
		assertEquals("ADICIONADO À HOTLIST NA POSIÇÃO 10", verifica);
	}
	
	@Test
	void testCadastraHotPosicaoInferior() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		String verifica = fn.cadastraHot(1, 0);
		assertEquals("POSIÇÃO INVÁLIDA", verifica);
	}
	
	@Test
	void testCadastraHotPosicaoSuperior() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		String verifica = fn.cadastraHot(1, 101);
		assertEquals("POSIÇÃO INVÁLIDA", verifica);
	}
	
	@Test
	void testCadastraHotRepetido() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		fn.cadastraHot(1, 1);
		String verifica = fn.cadastraHot(1, 2);
		assertEquals("FILME JÁ ADICIONADO", verifica);
	}
	
	
	@Test
	void testGetFilmesHot() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		fn.cadastraHot(1, 1);
		Filme lista[] = fn.getFilmes();
		assertEquals("🔥Avatar, 2009\nDisney+", lista[0].toString());	}
	

	@Test
	void testRemoverHot() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		fn.cadastraHot(1, 1);
		String verifica = fn.removerHot(1);
		assertEquals("FILME REMOVIDO", verifica);
	}
	
	@Test
	void testRemoverHotPosicaoLimite() {
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		fn.cadastraHot(1, 10);
		String verifica = fn.removerHot(10);
		assertEquals("FILME REMOVIDO", verifica);
	}
	
	@Test
	void testRemoverHotPosicaoSuperior() {
		String verifica = fn.removerHot(11);
		assertEquals("POSIÇÃO INVÁLIDA", verifica);
	}

	@Test
	void testRemoverHotPosicaoInferior() {
		String verifica = fn.removerHot(0);
		assertEquals("POSIÇÃO INVÁLIDA", verifica);
	}
}
