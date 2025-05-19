package atividadesComplementares;

/**
 * Classe abstrata AtividadeComplementar que representa uma atividade complementar genérica.
 * Esta classe contém informações comuns a todas as atividades complementares, como tipo, descrição, link e unidades acumuladas.
 * 
 * @author Tamires Santiago Oliveira - 123210205
 */
public abstract class AtividadeComplementar{

    private String tipo;
    private String descricao;
    private String link;
    protected int unidadeAcumulada;

    /**
     * Construtor para a classe AtividadeComplementar.
     * @param tipo O tipo de atividade complementar.
     * @param unidadeAcumulada A quantidade de unidades acumuladas pela atividade.
     * @throws IllegalArgumentException Se a quantidade de unidades acumuladas for menor que 0.
     */
    public AtividadeComplementar(String tipo, int unidadeAcumulada) {
        this.tipo = tipo;
        this.unidadeAcumulada = unidadeAcumulada;
        if(unidadeAcumulada < 0)
            throw new IllegalArgumentException("Unidade inválida!");
    }

    /**
     * Define a descrição da atividade complementar.
     * @param descricao A descrição da atividade complementar.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Define o link da atividade complementar.
     * @param link O link da atividade complementar.
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * Calcula a quantidade de créditos obtidos com a atividade complementar.
     * @param creditosTotais A quantidade total de créditos obtidos até agora.
     * @return A quantidade de créditos obtidos com a atividade complementar.
     */
    public abstract int qntCreditos(int creditosTotais);

    /**
     * Retorna uma representação em String da AtividadeComplementar.
     * @return Uma representação em String da AtividadeComplementar.
     */
    @Override
    public String toString() {
        return "AtividadeComplementar - Tipo: " + tipo + ",\nDescricao: " + descricao + ",\nLink: "
            + link + ",\nUnidade Acumulada: " + unidadeAcumulada;
    }
    
    public String representacaoRelatorio() {
    	return "Tipo: " + this.tipo + "\n"; 
    }

    /**
     * Retorna o tipo da AtividadeComplementar.
     * @return O tipo da AtividadeComplementar.
     */
    public String getTipo() {
        return this.tipo;
    }
}