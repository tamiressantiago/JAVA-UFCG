package atividadesComplementares;

/**
 * A classe PesquisaExtensao é uma subclasse de AtividadeComplementar.
 * Ela representa uma atividade de pesquisa ou extensão realizada pelo estudante.
 * 
 * @author Tamires Santiago Oliveira - 123210205
 */
public class PesquisaExtensao extends AtividadeComplementar {
	  private String subtipo;
	
	  /**
	   * Construtor para a classe PesquisaExtensao.
	   *
	   * @param tipo O tipo da atividade complementar.
	   * @param unidadeAcumulada A quantidade de unidades acumuladas pela atividade.
	   * @param subtipo O subtipo da atividade de pesquisa ou extensão.
	   */
	  public PesquisaExtensao(String tipo, int unidadeAcumulada, String subtipo) {
		  super(tipo, unidadeAcumulada);
		  if(tipo == null || subtipo == null)
	    	  throw new NullPointerException("Entrada nula inválida");
		  else if(!((subtipo.equals("PET")) || (subtipo.equals("PIBIC")) || (subtipo.equals("PIVIC")) || (subtipo.equals("PIBITI")) || (subtipo.equals("PIVITI")) || (subtipo.equals("PROBEDEX")) || (subtipo.equals("PDI"))))
	    	  throw new IllegalArgumentException("ATIVIDADE NÃO CADASTRADA");
	      else if(tipo.isBlank() || subtipo.isBlank())
        	  throw new IllegalArgumentException("Entrada vazia inválida");
	   
	      this.subtipo = subtipo;
	  }
	
	  /**
	   * Retorna uma representação em String da atividade de pesquisa ou extensão.
	   *
	   * @return Uma representação em String da atividade de pesquisa ou extensão.
	   */
	  @Override
	  public String toString() {
		  return super.toString() + ",\nSubtipo: " + subtipo;
	  }
	
	  /**
	   * Calcula a quantidade de créditos obtidos pela atividade de pesquisa ou extensão.
	   *
	   * @param creditosTotais A quantidade total de créditos obtidos até o momento.
	   * @return A quantidade de créditos obtidos pela atividade de pesquisa ou extensão.
	   */
	  @Override
	  public int qntCreditos(int creditosTotais) {
		  int creditos = (unidadeAcumulada / 12) * 10;
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