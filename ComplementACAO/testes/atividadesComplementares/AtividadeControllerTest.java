package atividadesComplementares;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import estudante.Estudante;
import estudante.EstudanteController;

class AtividadeControllerTest {

	private EstudanteController e;
	private AtividadeController a;
	
	@BeforeEach
	void criaObjetoBase() {
		EstudanteController e = new EstudanteController();
		this.a = new AtividadeController(e);
		e.criarEstudante("Tamires Santiago", "123456789", "senha123", "matricula");
	}
	
	@Test
	void testeCriaAtividadeMonitoriaEmEstudante() {
		String retorno = a.criarAtividadeMonitoriaEmEstudante("123456789", "senha123", "Monitoria", 1, "p1");
		assertEquals("123456789_1", retorno);
	}
	@Test
	void testeCriaAtividadeMonitoriaEmEstudanteInexistente() {
		try {
			String retorno = a.criarAtividadeMonitoriaEmEstudante("9999999999", "senha123", "Monitoria", 1, "p1");
		}
		catch(IllegalArgumentException e) {
			assertEquals("Estudante inexistente!", e.getMessage());
		}
	}
	
	@Test
	void testeCriaAtividadePesquisaExtensaoEmEstudante() {
		String retorno = a.criarAtividadePesquisaExtensaoEmEstudante("123456789", "senha123", "teste", 1, "PET");
		assertEquals("123456789_1", retorno);
	}
	@Test
	void testeCriaAtividadePesquisaExtensaoEmEstudanteInexistente() {
		try {
			String retorno = a.criarAtividadePesquisaExtensaoEmEstudante("123456789", "senha123", "teste", 1, "PET");
		}
		catch(IllegalArgumentException e) {
			assertEquals("Estudante inexistente!", e.getMessage());
		}
	}

	@Test
	void testeCriaAtividadeEstagioEmEstudante() {
		String retorno = a.criarAtividadeEstagioEmEstudante("123456789", "senha123", "teste", 300, "teste");
		assertEquals("123456789_1", retorno);
	}
	@Test
	void testeCriaAtividadeEstagioEmEstudanteInexistente() {
		try {
			String retorno = a.criarAtividadeEstagioEmEstudante("123456789", "senha123", "teste", 300, "teste");
		}
		catch(IllegalArgumentException e) {
			assertEquals("Estudante inexistente!", e.getMessage());
		}
	}
	
	@Test
	void testeCriaAtividadeRepresentacaoEstudantilEmEstudante() {
		String retorno = a.criarAtividadeRepresentacaoEstudantil("123456789", "senha123", "teste", 300, "Diretoria");
		assertEquals("123456789_1", retorno);
	}
	@Test
	void testeCriaAtividadeRepresentacaoEstudantilEmEstudanteInexistente() {
		try {
			String retorno = a.criarAtividadeRepresentacaoEstudantil("123456789", "senha123", "teste", 300, "Diretoria");
		}
		catch(IllegalArgumentException e) {
			assertEquals("Estudante inexistente!", e.getMessage());
		}
	}
}
