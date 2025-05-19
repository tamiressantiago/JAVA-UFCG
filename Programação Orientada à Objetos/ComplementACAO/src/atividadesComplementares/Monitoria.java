package atividadesComplementares;

/**
 * A classe Monitoria é uma subclasse de AtividadeComplementar.
 * Ela representa uma atividade complementar do tipo monitoria.
 * 
 * @author Tamires Santiago Oliveira - 123210205
 */
public class Monitoria extends AtividadeComplementar {
    private String disciplina;

    /**
     * Construtor para a classe Monitoria.
     *
     * @param tipo O tipo da atividade complementar.
     * @param unidadeAcumulada A quantidade de unidades acumuladas pela atividade.
     * @param disciplina A disciplina da monitoria.
     * @throws IllegalArgumentException Se a quantidade de unidades acumuladas for menor que 1.
     */
    public Monitoria(String tipo, int unidadeAcumulada, String disciplina) {
        super(tipo, unidadeAcumulada);
        if(unidadeAcumulada < 1)
            throw new IllegalArgumentException("Não é possível cadastrar monitoria com menos de 1 semestre letivo.");
        else if(tipo == null || disciplina == null)
            throw new NullPointerException("Entrada nula inválida!");
        else if(tipo.isBlank() || disciplina.isBlank())
            throw new IllegalArgumentException("Entrada vazia inválida!");
        this.disciplina = disciplina;
    }

    /**
     * Retorna uma representação em String da monitoria.
     *
     * @return Uma representação em String da monitoria.
     */
    @Override
    public String toString() {
        return super.toString() + ",\nDisciplina: " + disciplina;
    }

    /**
     * Retorna a quantidade de créditos da monitoria.
     *
     * @param creditosTotais A quantidade total de créditos.
     * @return A quantidade de créditos da monitoria.
     */
    @Override
    public int qntCreditos(int creditosTotais) {
        int creditos = unidadeAcumulada * 4;

        if (creditosTotais + creditos > 16)
            creditos = 16;
        else
            creditos += creditosTotais;
        return creditos;
    }
    
    @Override
	public String representacaoRelatorio() {
		return super.representacaoRelatorio() + "\nCréditos acumulados: " + qntCreditos(0) + "\nCréditos máximos: 16";
	}
}