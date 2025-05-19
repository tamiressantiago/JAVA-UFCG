package estudante;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import atividadesComplementares.AtividadeComplementar;

/**
 * Classe Estudante que representa um estudante.
 * Esta classe contém informações sobre o estudante, como nome, CPF, senha, matrícula, bônus, créditos e atividades complementares.
 *
 *@author Tamires Santiago Oliveira - 123210205
 */
public class Estudante implements Comparable<Estudante>{

    private String nome;
    private String cpf;
    private String senha;
    private String matricula;
    private int bonus;
    private Map<String, Integer> creditos;
    private Map<String, AtividadeComplementar> atividades;
    private Map<String, String> historico;

    /**
     * Construtor para a classe Estudante.
     * @param nome O nome do estudante.
     * @param cpf O CPF do estudante.
     * @param senha A senha do estudante.
     * @param matricula A matrícula do estudante.
     * @throws NullPointerException Se alguma das entradas for nula.
     * @throws IllegalArgumentException Se alguma das entradas for vazia ou se a senha tiver menos de 8 caracteres.
     */
    public Estudante(String nome, String cpf, String senha, String matricula) {
    	if(nome == null || cpf == null || senha == null || matricula == null)
			throw new NullPointerException("Entrada nula inválida!");
		else if(nome.isBlank() || cpf.isBlank() || senha.isBlank() || matricula.isBlank())
			throw new IllegalArgumentException("Entrada vazia!");
		else if(senha.length() < 8)
    		throw new IllegalArgumentException("Senha inválida!");
    	
    	this.nome = nome;
    	this.cpf = cpf;
    	this.senha = senha;
    	this.matricula = matricula;
    	this.bonus = 0;
    	this.atividades = new LinkedHashMap<>();
    	this.historico = new LinkedHashMap<>();
    	this.creditos= new HashMap<>(); 
    	creditos.put("Monitoria", 0);
    	creditos.put("Estagio", 0);
    	creditos.put("PesquisaExtensao", 0);
    	creditos.put("RepresentaçãoEstudantil", 0);    	
    }

    /**
     * Altera a senha do estudante.
     * @param senhaAntiga A senha antiga do estudante.
     * @param novaSenha A nova senha do estudante.
     * @return Verdadeiro se a senha foi alterada com sucesso, falso caso contrário.
     * @throws IllegalArgumentException Se a nova senha tiver menos de 8 caracteres.
     */
    public boolean alterarSenha(String senhaAntiga, String novaSenha) {
    	if(senhaAntiga.equals(this.senha)) {
    		if(novaSenha.length() != 8)
        		throw new IllegalArgumentException("Senha inválida!");
    		this.senha = novaSenha;
    		return true;
    	}
    	return false;
    }
    
    /**
     * Verifica se a senha fornecida é igual à senha do estudante.
     * @param verificaSenha A senha a ser verificada.
     * @return Verdadeiro se a senha fornecida é igual à senha do estudante, falso caso contrário.
     */
    public boolean verificaSenha(String verificaSenha) {
    	return verificaSenha.equals(this.senha);
    }
    
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudante other = (Estudante) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return nome + "\nCPF: " + cpf + "\nMatricula: " + matricula + "\nBônus: " + bonus;
	}
	
	/**
	 * Adiciona uma atividade complementar ao estudante.
	 * @param atv A atividade complementar a ser adicionada.
	 * @param tipo O tipo da atividade complementar.
	 * @return O código da atividade complementar adicionada.
	 */
	public String adicionarAtividadeComplementar(AtividadeComplementar atv, String tipo) {
		String codigo = this.cpf + "_" + (atividades.size() + 1);
		atividades.put(codigo, atv);
		creditos.put(tipo, atv.qntCreditos(creditos.get(tipo)));
		return codigo;
    }
	
	/**
	 * Altera a descrição de uma atividade complementar do estudante.
	 * @param codigoAtividade O código da atividade complementar.
	 * @param descricao A nova descrição da atividade complementar.
	 * @return Verdadeiro se a descrição foi alterada com sucesso, falso caso contrário.
	 */
	public boolean alterarDescricaoAtividade(String codigoAtividade, String descricao) {
		if(atividades.get(codigoAtividade) != null) {
			atividades.get(codigoAtividade).setDescricao(descricao);
			return true;
		}
		return false;
    }

	/**
	 * Altera o link de comprovação de uma atividade complementar do estudante.
	 * @param codigoAtividade O código da atividade complementar.
	 * @param linkComprovacao O novo link de comprovação da atividade complementar.
	 * @return Verdadeiro se o link de comprovação foi alterado com sucesso, falso caso contrário.
	 */
    public boolean alterarComprovacaoAtividade(String codigoAtividade, String linkComprovacao) {
    	if(atividades.get(codigoAtividade) != null) {
    		atividades.get(codigoAtividade).setLink(linkComprovacao);
    		return true;
    	}
    	return false;
    }
    
    /**
     * Retorna a quantidade de créditos obtidos pelo estudante em uma atividade complementar específica.
     * @param tipo O tipo da atividade complementar.
     * @return A quantidade de créditos obtidos na atividade complementar.
     */
    public int creditosAtividade(String tipo) {
    	return creditos.get(tipo);
    }

    /**
     * Gera um mapa de créditos obtidos pelo estudante em todas as atividades complementares.
     * @return Uma string que representa o mapa de créditos.
     */
    public String gerarMapaCreditosAtividades() {
    	String mapa = "MAPA DE CRÉDITOS:\nPESQUISA_EXTENSÃO: ";
    	mapa += creditosAtividade("PesquisaExtensao") + "\nMONITORIA: " + creditosAtividade("Monitoria") + "\nESTAGIO: " + creditosAtividade("Estagio") + "\nREPRESENTAÇÃO_ESTUDANTIL: " + creditosAtividade("RepresentaçãoEstudantil");
    	return mapa; 
    }

    /**
     * Verifica se o estudante alcançou a meta de créditos.
     * @return Verdadeiro se a meta de créditos foi alcançada, falso caso contrário.
     */
    public boolean verificarMetaAlcancada() {
    	int creditosTotais = 0;
    	for(Integer atividade : creditos.values()) {
    			creditosTotais += atividade;
    	}
    	if(creditosTotais >= 22)
    		return true;
    	return false;
    }
    
    /**
     * Gera um relatório final do estudante.
     * @return Uma string que representa o relatório final.
     * @throws IllegalArgumentException Se a quantidade de créditos for inválida.
     */
    public String gerarRelatorioFinal() {
    	if (verificarMetaAlcancada()) {
    		return toString() + "\nMONITORIA- " + creditosAtividade("Monitoria") + "/16" + 
    				"\nESTAGIO- " + creditosAtividade("Estagio") + "/18" + 
    				"\nPESQUISA E EXTENSÃO- " + creditosAtividade("PesquisaExtensao") + "/18" +
    				"\nREPRESENTAÇÃO ESTUDANTIL- " + creditosAtividade("RepresentaçãoEstudantil") + "/2" +
    				"\n" + (creditosAtividade("Monitoria") + creditosAtividade("Estagio") + creditosAtividade("PesquisaExtensao") + creditosAtividade("RepresentaçãoEstudantil")) +
    				"/22";
    	}
    	throw new IllegalArgumentException("Quantidade de créditos inválida!");
    }
    
    /**
     * Gera um relatório final do estudante para uma atividade complementar específica.
     * @param tipoAtividade O tipo da atividade complementar.
     * @return Uma string que representa o relatório final para a atividade complementar.
     * @throws IllegalArgumentException Se a quantidade de créditos for inválida.
     */
    public String gerarRelatorioFinalPorAtividade(String tipoAtividade) {
    	if (verificarMetaAlcancada()) {
    		return toString() + " " + tipoAtividade + ": " + creditosAtividade(tipoAtividade);
        }
    	throw new IllegalArgumentException("Quantidade de créditos inválida!");
    }
    
    /**
     * Gera um relatório parcial do estudante.
     * @param salvar Se verdadeiro, o relatório parcial é salvo no histórico do estudante.
     * @return Uma string que representa o relatório parcial.
     */
    public String gerarRelatorioParcial(boolean salvar) {
    	String saida = toString();
    	for(AtividadeComplementar a : atividades.values()) {
    		saida += "\n" + a.representacaoRelatorio();
    	}
    	if(salvar) {
    		String data = "" + LocalDate.now();
    		saida += "\n" + data;
    		historico.put(data, saida);
    	}
    	return saida;
    }

    /**
     * Gera um relatório parcial do estudante para uma atividade complementar específica.
     * @param salvar Se verdadeiro, o relatório parcial é salvo no histórico do estudante.
     * @param tipo O tipo da atividade complementar.
     * @return Uma string que representa o relatório parcial para a atividade complementar.
     */
    public String gerarRelatorioParcialPorAtividade(boolean salvar, String tipo) {
    	String saida = toString();
    	for(AtividadeComplementar a : atividades.values()) {
    		if(a.getTipo().equals(tipo))
    			saida += "\n" + a.representacaoRelatorio();
    	}
    	
    	if(salvar) {
    		String data = "" + LocalDate.now();
    		saida += "\n" + data;
    		historico.put(data, saida);
    	}
    	return saida;
    }
    
    /**
     * Lista o histórico do estudante.
     * @return Uma string que representa o histórico do estudante.
     */
    public String listarHistorico() {
    	String saida = "";
    	for(String s : historico.values()) {
    		saida += "\n" + s;
    	}
    	return saida;
    }

    /**
     * Exclui um item do histórico do estudante.
     * @param data A data do item do histórico a ser excluído.
     * @return Verdadeiro se o item do histórico foi excluído com sucesso, falso caso contrário.
     */
    public boolean excluirItemHistorico(String data) {
    	if(historico.containsKey(data)) {
    		historico.remove(data);
    		return true;
    	}
    	return false;
    }

    /**
     * Compara este estudante com outro estudante.
     * @param e O outro estudante.
     * @return Um valor negativo, zero ou positivo se este estudante for menor, igual ou maior que o outro estudante, respectivamente.
     */
	@Override
	public int compareTo(Estudante e) {
		return this.nome.compareTo(e.nome);
	}

	 /**
     * Retorna o nome do estudante.
     * @return O nome do estudante.
     */
	public String getNome() {
		return nome;
	}

	/**
     * Adiciona bônus ao estudante.
     * @param bonus O bônus a ser adicionado.
     */
	public void adicionaBonus(int bonus) {
		this.bonus += bonus;
	}

	/**
     * Retorna o bônus do estudante.
     * @return O bônus do estudante.
     */
	public int getBonus() {
		return bonus;
	}
	
}
