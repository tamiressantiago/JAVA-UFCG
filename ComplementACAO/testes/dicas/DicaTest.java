package dicas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import estudante.Estudante;

public class DicaTest {
    private Dica dica;
    private Estudante autor;
    private Estudante outroAutor;

    @BeforeEach
    public void criaObjetoBase() {
        this.autor = new Estudante("nome", "12345678901", "senha123", "matricula");
        this.outroAutor = new Estudante("outroNome", "outroCpf", "senha444", "outraMatricula");
        this.dica = new Dica(autor, "tema");
    }

    @Test
    public void testAdicionarElementoTextoDica() {
        assertTrue(dica.adicionarElementoTextoDica("texto", autor));
    }
    
    @Test
    public void testAdicionarElementoTextoDicaAutorDiferente() {
        assertFalse(dica.adicionarElementoTextoDica("texto", outroAutor));
    }
    
    @Test
    public void testeAdicionarElementoTextoDicaComTextoVazio() {
        try {
            dica.adicionarElementoTextoDica("", autor);
            fail();
        } catch(IllegalArgumentException e) {
            assertEquals("Entrada inválida", e.getMessage());
        }
    }
    
    @Test
    public void testeAdicionarElementoTextoDicaComTextoNulo() {
        try {
            dica.adicionarElementoTextoDica(null, autor);
            fail();
        } catch(NullPointerException e) {
            assertEquals("Entrada inválida", e.getMessage());
        }
    }

    @Test
    public void testAdicionarElementoMultimidiaDica() {
        assertTrue(dica.adicionarElementoMultimidiaDica("link", "cabecalho", 10, autor));
    }
    
    @Test
    public void testAdicionarElementoMultimidiaDicaAutorDiferente() {
        assertFalse(dica.adicionarElementoMultimidiaDica("link", "cabecalho", 10, outroAutor));
    }
    
    @Test
    public void testeAdicionarElementoMultimidiaDicaComLinkVazio() {
        try {
            dica.adicionarElementoMultimidiaDica("", "cabecalho", 10, autor);
            fail();
        } catch(IllegalArgumentException e) {
            assertEquals("Entrada inválida", e.getMessage());
        }
    }
    
    @Test
    public void testeAdicionarElementoMultimidiaDicaComLinkNulo() {
        try {
            dica.adicionarElementoMultimidiaDica(null, "cabecalho", 10, autor);
            fail();
        } catch(NullPointerException e) {
            assertEquals("Entrada inválida", e.getMessage());
        }
    }
    
    @Test
    public void testeAdicionarElementoMultimidiaDicaComCabecalhoVazio() {
        try {
            dica.adicionarElementoMultimidiaDica( "Link", "", 10, autor);
            fail();
        } catch(IllegalArgumentException e) {
            assertEquals("Entrada inválida", e.getMessage());
        }
    }
    
    @Test
    public void testeAdicionarElementoMultimidiaDicaComCabecalhoNulo() {
        try {
            dica.adicionarElementoMultimidiaDica("Link", null, 10, autor);
            fail();
        } catch(NullPointerException e) {
            assertEquals("Entrada inválida", e.getMessage());
        }
    }

    @Test
    public void testAdicionarElementoReferenciaDica() {
        assertTrue(dica.adicionarElementoReferenciaDica("titulo", "fonte", 2022, true, 1, autor));
    }
    
    @Test
    public void testAdicionarElementoReferenciaDicaAutorDiferente() {
        assertFalse(dica.adicionarElementoReferenciaDica("titulo", "fonte", 2022, true, 1, outroAutor));
    }
    
    @Test
    public void testeAdicionarElementoReferenciaDicaComTituloVazio() {
    	try {
    		dica.adicionarElementoReferenciaDica("", "fonte", 2022, true, 5, autor);
    		fail();
    	} catch(IllegalArgumentException e) {
    		assertEquals("Entrada inválida", e.getMessage());
    	}
    }
    
    @Test
    public void testeAdicionarElementoReferenciaDicaComTituloNulo() {
    	try {
    		dica.adicionarElementoReferenciaDica(null, "fonte", 2022, true, 5, autor);
    		fail();
    	} catch(NullPointerException e) {
    		assertEquals("Entrada inválida", e.getMessage());
    	}
    }
   
    @Test
    public void testeAdicionarElementoReferenciaDicaComFonteVazia() {
    	try {
    		dica.adicionarElementoReferenciaDica("titulo", "", 2022, true, 5, autor);
    		fail();
    	} catch(IllegalArgumentException e) {
    		assertEquals("Entrada inválida", e.getMessage());
    	}
    }
    
    @Test
    public void testeAdicionarElementoReferenciaDicaComFonteNula() {
    	try {
    		dica.adicionarElementoReferenciaDica("titulo", null, 2022, true, 5, autor);
    		fail();
    	} catch(NullPointerException e) {
    		assertEquals("Entrada inválida", e.getMessage());
    	}
    }
    
    @Test
    public void testeToString() {
    	dica.adicionarElementoTextoDica("Texto de Teste", autor);
    	dica.adicionarElementoMultimidiaDica("Link de Teste", "Título de Teste", 10, autor);
    	dica.adicionarElementoReferenciaDica("Título de Teste", "Fonte de Teste", 2022, true, 1, autor);
        assertEquals("nome\n"
        		+ "\n"
        		+ "Texto de Teste\n"
        		+ "Título de Teste\n"
        		+ "Link de Teste\n"
        		+ "Título: Título de Teste\n"
        		+ "Fonte: Fonte de Teste, ano: 2022\n"
        		+ "Conferida", dica.toString());
    }

    @Test
    public void testeDetalhes() {
    	dica.adicionarElementoTextoDica("Texto de Teste", autor);
    	dica.adicionarElementoMultimidiaDica("Link de Teste", "Título de Teste", 10, autor);
    	dica.adicionarElementoReferenciaDica("Título de Teste", "Fonte de Teste", 2022, true, 1, autor);
        assertEquals("nome\n"
        		+ "Tema: tema\n"
        		+ "Texto de Teste\n"
        		+ "14 caracteres.\n"
        		+ "Título de Teste\n"
        		+ "Link de Teste 10\n"
        		+ "Título: Título de Teste\n"
        		+ "Fonte: Fonte de Teste, ano: 2022\n"
        		+ "Conferida. Importância: 1", dica.detalhes());
    }
}
