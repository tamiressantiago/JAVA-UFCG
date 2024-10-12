package dicas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MultimidiaTest {
    private Multimidia multimidia;

    @BeforeEach
    public void iniciaObjetoBase() {
        multimidia = new Multimidia("Link de Teste", "Cabeçalho de Teste", 10);
    }

    @Test
    public void testeToString() {
        String esperado = "Cabeçalho de Teste\nLink de Teste";
        assertEquals(esperado, multimidia.toString());
    }

    @Test
    public void testeDetalhes() {
        String esperado = "Cabeçalho de Teste\nLink de Teste 10";
        assertEquals(esperado, multimidia.detalhes());
    }

    @Test
    public void testeValor() {
        int esperado = 0; // 10 segundos correspondem a 0 pontos
        assertEquals(esperado, multimidia.valor());
    }
}