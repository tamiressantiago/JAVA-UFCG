package atividadesComplementares;

/**
 * A classe RepresentacaoEstudantil é uma subclasse de AtividadeComplementar.
 * Ela representa uma atividade complementar do tipo representação estudantil.
 * 
 * @author Tamires Santiago Oliveira - 123210205
 */
public class RepresentacaoEstudantil extends AtividadeComplementar {
    private String subtipo;

    /**
     * Construtor para a classe RepresentacaoEstudantil.
     *
     * @param tipo O tipo da atividade complementar.
     * @param unidadeAcumulada A quantidade de unidades acumuladas pela atividade.
     * @param subtipo O subtipo da representação estudantil.
     * @throws IllegalArgumentException Se a quantidade de unidades acumuladas for menor que 1.
     */
    public RepresentacaoEstudantil(String tipo, int unidadeAcumulada, String subtipo) {
        super(tipo, unidadeAcumulada);
        if(unidadeAcumulada < 1)
            throw new IllegalArgumentException("Não é possível cadastrar representação estudantil com menos de 1 ano.");
        else if(tipo == null || subtipo == null)
			throw new NullPointerException("Entrada nula inválida!");
        else if (!((subtipo.equals("Diretoria")) || (subtipo.equals("Comissão"))))
			throw new IllegalArgumentException("ATIVIDADE NÃO CADASTRADA"); 
		else if(tipo.isBlank() || subtipo.isBlank())
			throw new IllegalArgumentException("Entrada vazia inválida!");
        this.subtipo = subtipo;
    }

    /**
     * Retorna uma representação em String da representação estudantil.
     *
     * @return Uma representação em String da representação estudantil.
     */
    @Override
    public String toString() {
        return super.toString() + ",\nSubtipo: " + subtipo;
    }

    /**
     * Retorna a quantidade de créditos da representação estudantil.
     *
     * @param creditosTotais A quantidade total de créditos.
     * @return A quantidade de créditos da representação estudantil.
     */
    @Override
    public int qntCreditos(int creditosTotais) {
        return 2;
    }
    
    @Override
	public String representacaoRelatorio() {
		return super.representacaoRelatorio() + "\nCréditos acumulados: " + qntCreditos(0) + "\nCréditos máximos: 2";
	}
}