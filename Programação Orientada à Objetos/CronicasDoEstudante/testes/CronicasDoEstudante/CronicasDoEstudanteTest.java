package CronicasDoEstudante;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CronicasDoEstudanteTest {
	CronicasDoEstudanteSistema sistema = new CronicasDoEstudanteSistema();
	@BeforeEach
	void criarCronicas() {
		
		sistema.cadastrarCronica("Minha semana do fera 2022.2", "Cheguei bem fera na UFCG, não sabia onde achar nada… A semana do fera foi essencial para eu tomar um rumo…", "13/03/2023");
		sistema.cadastrarCronica("JUnit lá vou eu!", "JUnit é o framework de Java para testes de unidade, disponível na versão 5…", "19/04/2023", "Nathanzinho");
		sistema.cadastrarCronica("Mulheres na computacao!", "Ada Lovelace eh uma importante figura na historia da computacao...", "24/08/2023");
	}
	
	@Test
	void criarLivretoAbaixo() {
		try{
			sistema.criarLivreto(new int[] {0,1});	
		}catch(IllegalArgumentException e) {
			assertEquals("Erro ao criar Livreto!", e.getMessage());
		}
	}

}
