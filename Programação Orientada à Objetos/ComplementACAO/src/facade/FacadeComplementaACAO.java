package facade;

import estudante.EstudanteController;
import atividadesComplementares.AtividadeController;
import dicas.DicaController;


public class FacadeComplementaACAO {
	
	 private EstudanteController estudanteController;
	 private DicaController dicaController; //mudei o nome
	 private AtividadeController atividadeController; //mudei o nome

	public FacadeComplementaACAO(EstudanteController estudante, DicaController dica, AtividadeController atividade) {
		this.estudanteController = estudante;
		this.dicaController = dica;
		this.atividadeController = atividade;
	}
	
	public boolean criarEstudante(String nome, String cpf, String senha, String matricula) {
		return estudanteController.criarEstudante(nome, cpf, senha, matricula);
	}
	public String[] exibirEstudantes() {
		return estudanteController.exibirEstudantes();
	}
	public boolean alterarSenhaEstudante(String cpf, String senhaAntiga, String novaSenha) {
		return estudanteController.alterarSenhaEstudante(cpf, senhaAntiga, novaSenha);
	}
	
	public int adicionarDica(String cpf, String senha, String tema) {
		return dicaController.adicionarDica(cpf, senha, tema);
	}
	public boolean adicionarElementoTextoDica(String cpf, String senha, int posicao, String texto) { 
		return dicaController.adicionarElementoTextoDica(cpf, senha, posicao, texto);
	}
	public boolean adicionarElementoMultimidiaDica(String cpf, String senha, int posicao, String link, String cabecalho, int tempo) {
		return dicaController.adicionarElementoMultimidiaDica(cpf, senha, posicao, link, cabecalho, tempo);
	}
	public boolean adicionarElementoReferenciaDica(String cpf, String senha, int posicao, String titulo, String fonte, int ano, boolean conferida, int importancia) {
		return dicaController.adicionarElementoReferenciaDica(cpf, senha, posicao, titulo, fonte, ano, conferida, importancia);
	}
	
	public String[] listarDicas() {
		return dicaController.listarDicas();
	}
	public String[] listarDicasDetalhes() {
		return dicaController.listarDicasDetalhes();
	}
	public String listarDica(int posicao) {
		return dicaController.listarDica(posicao);
	}
	public String listarDicaDetalhes(int posicao) {
		return dicaController.listarDicaDetalhes(posicao);
	}
	public String[] listarUsuariosRankingDicas() {
		return dicaController.listarUsuariosRankingDicas();
	}

	public String criarAtividadeMonitoriaEmEstudante(String cpf, String senha, String tipo, int unidadeAcumulada, String disciplina) {
		return atividadeController.criarAtividadeMonitoriaEmEstudante(cpf, senha, tipo, unidadeAcumulada, disciplina);
	}
	public String criarAtividadePesquisaExtensaoEmEstudante(String cpf, String senha, String tipo, int unidadeAcumulada, String subtipo) {
		return atividadeController.criarAtividadePesquisaExtensaoEmEstudante(cpf, senha, tipo, unidadeAcumulada, subtipo);
	}
	public String criarAtividadeEstagioEmEstudante(String cpf, String senha, String tipo, int unidadeAcumulada, String nomeEmpresa) {
		return atividadeController.criarAtividadeEstagioEmEstudante(cpf, senha, tipo, unidadeAcumulada, nomeEmpresa);
	}
	public String criarAtividadeRepresentacaoEstudantil(String cpf, String senha, int unidadeAcumulada, String subtipo) {
		return atividadeController.criarAtividadeRepresentacaoEstudantil(cpf, senha, subtipo, unidadeAcumulada, subtipo);
	}
	
	public boolean alterarDescricaoAtividade(String cpf, String senha, String codigoAtividade, String descricao) {
		return estudanteController.alterarDescricaoAtividade(cpf, senha, codigoAtividade, descricao);
	}
	public boolean alterarComprovacaoAtividade(String cpf, String senha, String codigoAtividade, String linkComprovacao) {
		return estudanteController.alterarComprovacaoAtividade(cpf, senha, codigoAtividade, linkComprovacao);
	}
	public int creditosAtividade(String cpf, String senha, String tipo) {
		return estudanteController.creditosAtividade(cpf, senha, tipo);
	}
	public String gerarMapaCreditosAtividades(String cpf, String senha) {
		return estudanteController.gerarMapaCreditosAtividades(cpf, senha);
	}
	public boolean verificarMetaAlcancada(String cpf, String senha) {
		return estudanteController.verificarMetaAlcancada(cpf, senha);
	}

	public String gerarRelatorioFinal(String cpf, String senha) {
		return estudanteController.gerarRelatorioFinal(cpf, senha);
	}
	public String gerarRelatorioFinalPorAtividade(String cpf, String senha, String tipoAtividade) {
		return estudanteController.gerarRelatorioFinalPorAtividade(cpf, senha, tipoAtividade);
	}
	public String gerarRelatorioParcial(String cpf, String senha, boolean salvar) {
		return estudanteController.gerarRelatorioParcial(cpf, senha, salvar);
	}
	public String gerarRelatorioParcialPorAtividade(String cpf, String senha, boolean salvar, String tipoAtividade) {
		return estudanteController.gerarRelatorioParcialPorAtividade(cpf, senha, salvar, tipoAtividade);
	}
	public String listarHistorico(String cpf, String senha) {
		return estudanteController.listarHistorico(cpf, senha);
	}
	public boolean excluirItemHistorico(String cpf, String senha, String data) {
		return estudanteController.excluirItemHistorico(cpf, senha, data);
	}


}
