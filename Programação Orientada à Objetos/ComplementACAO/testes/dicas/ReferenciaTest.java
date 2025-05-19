package dicas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReferenciaTest {
    private Referencia referencia;

    @BeforeEach
    public void criaObjetoBase() {
        referencia = new Referencia("Título de Teste", "Fonte de Teste", 2022, true, 1);
    }

    @Test
    public void testeToString() {
        String esperado = "Título: Título de Teste\nFonte: Fonte de Teste, ano: 2022\nConferida";
        assertEquals(esperado, referencia.toString());
    }

    @Test
    public void testeDetalhes() {
        String esperado = "Título: Título de Teste\nFonte: Fonte de Teste, ano: 2022\nConferida. Importância: 1";
        assertEquals(esperado, referencia.detalhes());
    }

    @Test
    public void testeValor() {
        int esperado = 15; // A referência foi conferida, então o valor é 15
        assertEquals(esperado, referencia.valor());
    }
}