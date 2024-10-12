package estudante;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import atividadesComplementares.AtividadeComplementar;

/**
 * Classe EstudanteController que controla as operações relacionadas aos estudantes.
 * 
 * @author Tamires Santiago Oliveira - 123210205
 */
public class EstudanteController {

    private Map<String, Estudante> estudantes;

    /**
     * Construtor para a classe EstudanteController.
     * Inicializa o mapa de estudantes.
     */
    public EstudanteController() {
    	this.estudantes = new HashMap<>();
    }

    /**
     * Cria um novo estudante e o adiciona ao mapa de estudantes.
     * @param nome O nome do estudante.
     * @param cpf O CPF do estudante.
     * @param senha A senha do estudante.
     * @param matricula A matrícula do estudante.
     * @return Verdadeiro se o estudante foi criado com sucesso, falso caso contrário.
     */
    public boolean criarEstudante(String nome, String cpf, String senha, String matricula) {
    	if(existeEstudante(cpf))
    		return false; 
    	
    	Estudante novo = new Estudante(nome, cpf, senha, matricula);
    	estudantes.put(cpf, novo);
    	return true;
    }
    
    private boolean existeEstudante(String cpf) {
    	if(estudantes.containsKey(cpf))
    		return true;
    	return false;
    }
    
    /**
     * Altera a senha de um estudante.
     * @param cpf O CPF do estudante.
     * @param senhaAntiga A senha antiga do estudante.
     * @param novaSenha A nova senha do estudante.
     * @return Verdadeiro se a senha foi alterada com sucesso, falso caso contrário.
     */
    public boolean alterarSenhaEstudante(String cpf, String senhaAntiga, String novaSenha) {
    	if(existeEstudante(cpf))
    		return estudantes.get(cpf).alterarSenha(senhaAntiga, novaSenha);
    	return false;
    }
    
    /**
     * Exibe os estudantes em ordem alfabética.
     * @return Um array de strings representando os estudantes.
     */
    public String[] exibirEstudantes() {
    	List<Estudante> lista = new ArrayList<>(this.estudantes.values());
    	Collections.sort(lista);
    	String[] retorno = new String[estudantes.size()];
    	int cont = 0;
    	for(Estudante atual : lista) {
    		retorno[cont] = atual.toString();
    		cont++;
    	}
    	return retorno;
    }
    
    private boolean verificaEstudante(String cpf, String senha) {
    	return estudantes.get(cpf).verificaSenha(senha);
    }
    
    /**
     * Adiciona uma atividade complementar a um estudante.
     * @param atv A atividade complementar a ser adicionada.
     * @param cpf O CPF do estudante.
     * @param senha A senha do estudante.
     * @param tipo O tipo da atividade complementar.
     * @return O código da atividade complementar adicionada.
     */
    public String adicionarAtividadeComplementarEmEstudante(AtividadeComplementar atv, String cpf, String senha, String tipo) { 
    	if(estudantes.containsKey(cpf)) {
    		if(verificaEstudante(cpf, senha))
    			return estudantes.get(cpf).adicionarAtividadeComplementar(atv, tipo);
    		return "Senha incorreta";
    	}
    	throw new IllegalArgumentException("Estudante inexistente!");
    }

    /**
     * Altera a descrição de uma atividade complementar de um estudante.
     * @param cpf O CPF do estudante.
     * @param senha A senha do estudante.
     * @param codigoAtividade O código da atividade complementar.
     * @param descricao A nova descrição da atividade complementar.
     * @return Verdadeiro se a descrição foi alterada com sucesso, falso caso contrário.
     */
	public boolean alterarDescricaoAtividade(String cpf, String senha, String codigoAtividade, String descricao) {
		if(estudantes.containsKey(cpf)) {
			if(verificaEstudante(cpf, senha))
				return estudantes.get(cpf).alterarDescricaoAtividade(codigoAtividade, descricao);
			return false;
    	}
    	throw new IllegalArgumentException("Estudante inexistente!");
	}

	/**
	 * Altera o link de comprovação de uma atividade complementar de um estudante.
	 * @param cpf O CPF do estudante.
	 * @param senha A senha do estudante.
	 * @param codigoAtividade O código da atividade complementar.
	 * @param linkComprovacao O novo link de comprovação da atividade complementar.
	 * @return Verdadeiro se o link de comprovação foi alterado com sucesso, falso caso contrário.
	 */
	public boolean alterarComprovacaoAtividade(String cpf, String senha, String codigoAtividade, String linkComprovacao) { 
		if(estudantes.containsKey(cpf)) {
			if(verificaEstudante(cpf, senha))
				return estudantes.get(cpf).alterarComprovacaoAtividade(codigoAtividade, linkComprovacao);
			return false;
    	}
		throw new IllegalArgumentException("Estudante inexistente!");
	}
	
	/**
	 * Retorna a quantidade de créditos obtidos por um estudante em uma atividade complementar específica.
	 * @param cpf O CPF do estudante.
	 * @param senha A senha do estudante.
	 * @param tipo O tipo da atividade complementar.
	 * @return A quantidade de créditos obtidos na atividade complementar.
	 */
	public int creditosAtividade(String cpf, String senha, String tipo) {
		if(estudantes.containsKey(cpf)) {
			 if(verificaEstudante(cpf, senha))
				 return estudantes.get(cpf).creditosAtividade(tipo);
			 throw new IllegalArgumentException("Senha inválida!");
	    	}
	    throw new IllegalArgumentException("Estudante inexistente!");
	    }

	/**
	 * Gera um mapa de créditos obtidos por um estudante em todas as atividades complementares.
	 * @param cpf O CPF do estudante.
	 * @param senha A senha do estudante.
	 * @return Uma string que representa o mapa de créditos.
	 */
	 public String gerarMapaCreditosAtividades(String cpf, String senha) {
		if(estudantes.containsKey(cpf)) {
			 if(verificaEstudante(cpf, senha))
				 return estudantes.get(cpf).gerarMapaCreditosAtividades();
			 throw new IllegalArgumentException("Senha inválida!");
	    	}
	    throw new IllegalArgumentException("Estudante inexistente!");
	 }

	 /**
	  * Verifica se um estudante alcançou a meta de créditos.
	  * @param cpf O CPF do estudante.
	  * @param senha A senha do estudante.
	  * @return Verdadeiro se a meta de créditos foi alcançada, falso caso contrário.
	  */
	 public boolean verificarMetaAlcancada(String cpf, String senha) {
		if(estudantes.containsKey(cpf)) {
			 if(verificaEstudante(cpf, senha))
				 return estudantes.get(cpf).verificarMetaAlcancada();
			 throw new IllegalArgumentException("Senha inválida!");
	    }
	    throw new IllegalArgumentException("Estudante inexistente!"); 
	 }

	 /**
	  * Gera um relatório final de um estudante.
	  * @param cpf O CPF do estudante.
	  * @param senha A senha do estudante.
	  * @return Uma string que representa o relatório final.
	  */
	 public String gerarRelatorioFinal(String cpf, String senha) {
		 if(estudantes.containsKey(cpf)) {
			 if(verificaEstudante(cpf, senha))
				 return estudantes.get(cpf).gerarRelatorioFinal();
			 throw new IllegalArgumentException("Senha inválida!");
	    }
	    throw new IllegalArgumentException("Estudante inexistente!"); 
	 }

	 /**
	  * Gera um relatório final de um estudante para uma atividade complementar específica.
	  * @param cpf O CPF do estudante.
	  * @param senha A senha do estudante.
	  * @param tipoAtividade O tipo da atividade complementar.
	  * @return Uma string que representa o relatório final para a atividade complementar.
	  */
	 public String gerarRelatorioFinalPorAtividade(String cpf, String senha, String tipoAtividade) {
		 if(estudantes.containsKey(cpf)) {
			 if(verificaEstudante(cpf, senha))
				 return estudantes.get(cpf).gerarRelatorioFinalPorAtividade(tipoAtividade);
			 throw new IllegalArgumentException("Senha inválida!");
	    }
	    throw new IllegalArgumentException("Estudante inexistente!"); 
	    }
	 
	 /**
	  * Gera um relatório parcial de um estudante.
	  * @param cpf O CPF do estudante.
	  * @param senha A senha do estudante.
	  * @param salvar Se verdadeiro, o relatório parcial é salvo no histórico do estudante.
	  * @return Uma string que representa o relatório parcial.
	  */
	 public String gerarRelatorioParcial(String cpf, String senha, boolean salvar) {
		 if(estudantes.containsKey(cpf)) {
			 if(verificaEstudante(cpf, senha))
				 return estudantes.get(cpf).gerarRelatorioParcial(salvar);
			 throw new IllegalArgumentException("Senha inválida!");
	    }
	    throw new IllegalArgumentException("Estudante inexistente!"); 
	 }

	 /**
	  * Gera um relatório parcial de um estudante para uma atividade complementar específica.
	  * @param cpf O CPF do estudante.
	  * @param senha A senha do estudante.
	  * @param salvar Se verdadeiro, o relatório parcial é salvo no histórico do estudante.
	  * @param tipo O tipo da atividade complementar.
	  * @return Uma string que representa o relatório parcial para a atividade complementar.
	  */
	 public String gerarRelatorioParcialPorAtividade(String cpf, String senha, boolean salvar, String tipo) {
		 if(estudantes.containsKey(cpf)) {
			 if(verificaEstudante(cpf, senha))
				 return estudantes.get(cpf).gerarRelatorioParcialPorAtividade(salvar, tipo);
			 throw new IllegalArgumentException("Senha inválida!");
	    }
	    throw new IllegalArgumentException("Estudante inexistente!"); 
	 }
	 
	 /**
	  * Lista o histórico de um estudante.
	  * @param cpf O CPF do estudante.
	  * @param senha A senha do estudante.
	  * @return Uma string que representa o histórico do estudante.
	  */
	 public String listarHistorico(String cpf, String senha) {
		 if(estudantes.containsKey(cpf)) {
			 if(verificaEstudante(cpf, senha))
				 return estudantes.get(cpf).listarHistorico();
			 throw new IllegalArgumentException("Senha inválida!");
	    }
	    throw new IllegalArgumentException("Estudante inexistente!"); 
	   }

	 /**
	  * Exclui um item do histórico de um estudante.
	  * @param cpf O CPF do estudante.
	  * @param senha A senha do estudante.
	  * @param data A data do item do histórico a ser excluído.
	  * @return Verdadeiro se o item do histórico foi excluído com sucesso, falso caso contrário.
	  */
	 public boolean excluirItemHistorico(String cpf, String senha, String data) {
		 if(estudantes.containsKey(cpf)) {
			 if(verificaEstudante(cpf, senha))
				 return estudantes.get(cpf).excluirItemHistorico(data);
			 throw new IllegalArgumentException("Senha inválida!");
	    }
	    throw new IllegalArgumentException("Estudante inexistente!"); 
	   }
	 
	 /**
	  * Retorna um estudante.
	  * @param cpf O CPF do estudante.
	  * @param senha A senha do estudante.
	  * @return O estudante.
	  */
	 public Estudante pegarEstudante(String cpf, String senha) {
		 if(estudantes.containsKey(cpf)) {
			 if(verificaEstudante(cpf, senha))
				 return estudantes.get(cpf);
			 throw new IllegalArgumentException("Senha inválida!");
	    }
	    throw new IllegalArgumentException("Estudante inexistente!"); 
	   }
		 		 
}
