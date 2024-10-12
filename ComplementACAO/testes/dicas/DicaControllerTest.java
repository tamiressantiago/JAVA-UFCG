package dicas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import estudante.EstudanteController;

import static org.junit.jupiter.api.Assertions.*;

public class DicaControllerTest {
    private DicaController dicaController;
    private EstudanteController estudanteController;

    @BeforeEach
    public void criaObjetoBase() {
        this.estudanteController = new EstudanteController();
        this.dicaController = new DicaController(estudanteController);
        estudanteController.criarEstudante("Tamires", "12345678901", "senha123", "matricula");
        dicaController.adicionarDica("12345678901", "senha123", "Tema de Teste");
    }

    @Test
    public void testeAdicionarDica() {
        int posicao = dicaController.adicionarDica("12345678901", "senha123", "Segundo Tema de Teste");
        assertEquals(1, posicao);
    }
    
    @Test
    public void testeAdicionarDicaComCpfInvalido() {
        try {
            dicaController.adicionarDica("cpf_invalido", "senha123", "Tema de Teste");
            fail();
        } catch(IllegalArgumentException e) {
            assertEquals("Estudante inexistente!", e.getMessage());
        }
    }
    
    @Test
    public void testeAdicionarElementoTextoDica() {
        dicaController.adicionarDica("12345678901", "senha123", "Segundo Tema de Teste");
        boolean resultado = dicaController.adicionarElementoTextoDica("12345678901", "senha123", 1, "Texto de Teste");
        assertTrue(resultado);
    }
    
    @Test
    public void testeAdicionarElementoTextoPosicaoInvalida() {
        try {
            dicaController.adicionarElementoTextoDica("12345678901", "senha123", 5, "texto");
            fail();
        } catch(IllegalArgumentException e) {
            assertEquals("Posição inválida!", e.getMessage());
        }
    }

    @Test
    public void testeAdicionarElementoMultimidiaDica() {
        dicaController.adicionarDica("12345678901", "senha123", "Segundo Tema de Teste");
        boolean resultado = dicaController.adicionarElementoMultimidiaDica("12345678901", "senha123", 1, "link", "cabecalho", 10);
        assertTrue(resultado);
    }
    
    @Test
    public void testeAdicionarElementoMultimidiaDicaPosicaoInvalida() {
        try {
            dicaController.adicionarElementoMultimidiaDica("12345678901", "senha123", 5, "link", "cabecalho", 10);
            fail();
        } catch(IllegalArgumentException e) {
            assertEquals("Posição inválida!", e.getMessage());
        }
    }

    @Test
    public void testeAdicionarElementoReferenciaDica() {
        dicaController.adicionarDica("12345678901", "senha123", "Segundo Tema de Teste");
        boolean resultado = dicaController.adicionarElementoReferenciaDica("12345678901", "senha123", 1, "titulo", "fonte", 2022, true, 5);
        assertTrue(resultado);
    }
   
    @Test
    public void testeAdicionarElementoReferenciaDicaPosicaoInvalida() {
    	try {
    		dicaController.adicionarElementoReferenciaDica("12345678901", "senha123", 5, "titulo", "fonte", 2022, true, 5);
    		fail();
    	} catch(IllegalArgumentException e) {
    		assertEquals("Posição inválida!", e.getMessage());
    	}
    }
    
    @Test
    public void testeListarDicas() {
    	dicaController.adicionarElementoTextoDica("12345678901", "senha123", 0, "Texto de Teste");
        String[] esperado = new String[1];
        esperado[0] = "Tamires\n"
        		+ "\n"
        		+ "Texto de Teste";
    	String[] saida = dicaController.listarDicas();
        assertArrayEquals(esperado, saida);
    }

    @Test
    public void testeListarDicasDetalhes() {
    	dicaController.adicionarElementoTextoDica("12345678901", "senha123", 0, "Texto de Teste");
        String[] esperado = new String[1];
        esperado[0] = "Tamires\n"
        		+ "Tema: Tema de Teste\n"
        		+ "Texto de Teste\n"
        		+ "14 caracteres.";
    	String[] saida = dicaController.listarDicasDetalhes();
        assertArrayEquals(esperado, saida);
    }

    @Test
    public void testeListarDica() {
    	dicaController.adicionarElementoTextoDica("12345678901", "senha123", 0, "Texto de Teste");
        String esperado = "Tamires\n"
        		+ "\n"
        		+ "Texto de Teste";
    	String saida = dicaController.listarDica(0);
        assertEquals(esperado, saida);
    }

    @Test
    public void testeListarDicaDetalhes() {
    	dicaController.adicionarElementoTextoDica("12345678901", "senha123", 0, "Texto de Teste");
        String esperado = "Tamires\n"
        		+ "Tema: Tema de Teste\n"
        		+ "Texto de Teste\n"
        		+ "14 caracteres.";
    	String saida = dicaController.listarDicaDetalhes(0);
        assertEquals(esperado, saida);
    }

    @Test
    public void testeListarUsuariosRankingDicas() {
    	dicaController.adicionarElementoTextoDica("12345678901", "senha123", 0, "Leia a página de estágio antes de consultar a coordenação de estágio da UASC. https://www.computacao.ufcg.edu.br/graduacao/estagios\"");
    	estudanteController.criarEstudante("Fulano", "12345678901000", "senha123", "matricula");
    	dicaController.adicionarDica("12345678901000", "senha123", "Segundo Tema de Teste");
    	dicaController.adicionarElementoMultimidiaDica("12345678901000", "senha123", 1, "link", "cabecalho", 500);
    	
        String[] esperado = new String[2];
        esperado[0] = "Fulano\n"
        		+ "CPF: 12345678901000\n"
        		+ "Matricula: matricula\n"
        		+ "Bônus: 40";
        
        esperado[1] = "Tamires\n"
        		+ "CPF: 12345678901\n"
        		+ "Matricula: matricula\n"
        		+ "Bônus: 13";
    	String[] saida = dicaController.listarUsuariosRankingDicas();
        assertArrayEquals(esperado, saida);
    }
    
}