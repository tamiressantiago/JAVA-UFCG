package atividadesComplementares;

/**
 * Classe Estagio que estende a classe AtividadeComplementar.
 * Esta classe representa um estágio como uma atividade complementar.
 * 
 * @author Tamires Santiago Oliveira - 123210205
 */
public class Estagio extends AtividadeComplementar {
	private String empresa;

	  /**
	   * Construtor para a classe Estagio.
	   * @param tipo O tipo de atividade complementar.
	   * @param unidadeAcumulada A quantidade de unidades acumuladas pela atividade.
	   * @param empresa A empresa onde o estágio foi realizado.
	   * @throws IllegalArgumentException Se a quantidade de unidades acumuladas for menor que 300.
	   */
	  public Estagio(String tipo, int unidadeAcumulada, String empresa) {
		   super(tipo, unidadeAcumulada);
		   if(unidadeAcumulada < 300)
			   throw new IllegalArgumentException("ATIVIDADE NÃO CADASTRADA");
		   else if(tipo == null || empresa == null)
				throw new NullPointerException("Entrada nula inválida!");
			else if (tipo.isBlank() || empresa.isBlank())
				throw new IllegalArgumentException("Entrada vazia inválida!");
		   this.empresa = empresa;
	  }

	  /**
	   * Retorna uma representação em String do Estagio.
	   * @return Uma representação em String do Estagio.
	   */
	  @Override
	  public String toString() {
		  return super.toString() + ",\nEmpresa: " + empresa;
	  }
	
	  /**
	   * Calcula a quantidade de créditos obtidos com o estágio.
	   * @param creditosTotais A quantidade total de créditos obtidos até agora.
	   * @return A quantidade de créditos obtidos com o estágio.
	   */
	  @Override
	  public int qntCreditos(int creditosTotais) {
		   int creditos = unidadeAcumulada / 60;
		   if(creditos + creditosTotais > 18)
			   creditos = 18;
		   else
			   creditos += creditosTotais;
		   return creditos;
	  }
	
	  @Override
		public String representacaoRelatorio() {
			return super.representacaoRelatorio() + "\nCréditos acumulados: " + qntCreditos(0) + "\nCréditos máximos: 18";
		}
  
}