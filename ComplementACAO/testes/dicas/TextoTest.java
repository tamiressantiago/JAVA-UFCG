package dicas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

public class TextoTest {
    private Texto texto;

    @BeforeEach
    public void criaObjetoBase() {
        texto = new Texto("Leia a página de estágio antes de consultar a coordenação de estágio da UASC. https://www.computacao.ufcg.edu.br/graduacao/estagios");
    }

    @Test
    public void testeTextoComMaisDe500Caracteres() {
        try {
            String textoComMaisDe500Caracteres = String.join("", Collections.nCopies(501, "a"));
            new Texto(textoComMaisDe500Caracteres);
            fail();
        } catch(IllegalArgumentException e) {
            assertEquals("Limite de caracteres excedido.", e.getMessage());
        }
    }
    
    @Test
    public void testeToString() {
        String esperado = "Leia a página de estágio antes de consultar a coordenação de estágio da UASC. https://www.computacao.ufcg.edu.br/graduacao/estagios";
        assertEquals(esperado, texto.toString());
    }

    @Test
    public void testeDetalhes() {
        String esperado = "Leia a página de estágio antes de consultar a coordenação de estágio da UASC. https://www.computacao.ufcg.edu.br/graduacao/estagios\n" + 
                          "Leia a página de estágio antes de consultar a coordenação de estágio da UASC. https://www.computacao.ufcg.edu.br/graduacao/estagios".length() + " caracteres.";
        assertEquals(esperado, texto.detalhes());
    }

    @Test
    public void testeValor() {
        int esperado = 13;
        assertEquals(esperado, texto.valor());
    }
}