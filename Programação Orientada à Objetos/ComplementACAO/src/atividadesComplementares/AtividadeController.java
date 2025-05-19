
package atividadesComplementares;

import estudante.EstudanteController;

/**
 * Classe AtividadeController que controla as atividades complementares dos estudantes.
 * Esta classe é responsável por criar diferentes tipos de atividades complementares e adicioná-las aos estudantes.
 * 
 * @author Tamires Santiago Oliveira - 123210205
 */
public class AtividadeController {

    private EstudanteController estudantes;

    /**
     * Construtor para a classe AtividadeController.
     * @param estudantes O controlador dos estudantes.
     */
    public AtividadeController(EstudanteController estudantes) {
        this.estudantes = estudantes;
    }

    /**
     * Cria uma atividade de monitoria e adiciona ao estudante.
     * @param cpf O CPF do estudante.
     * @param senha A senha do estudante.
     * @param tipo O tipo de atividade complementar.
     * @param unidadeAcumulada A quantidade de unidades acumuladas pela atividade.
     * @param disciplina A disciplina da monitoria.
     * @return Uma string que representa a atividade de monitoria.
     */
    public String criarAtividadeMonitoriaEmEstudante(String cpf, String senha, String tipo, int unidadeAcumulada, String disciplina) {
        Monitoria novo = new Monitoria(tipo, unidadeAcumulada, disciplina);
        return estudantes.adicionarAtividadeComplementarEmEstudante(novo, cpf, senha, "Monitoria");
    }

    /**
     * Cria uma atividade de pesquisa ou extensão e adiciona ao estudante.
     * @param cpf O CPF do estudante.
     * @param senha A senha do estudante.
     * @param tipo O tipo de atividade complementar.
     * @param unidadeAcumulada A quantidade de unidades acumuladas pela atividade.
     * @param subtipo O subtipo da pesquisa ou extensão.
     * @return Uma string que representa a atividade de pesquisa ou extensão.
     */
    public String criarAtividadePesquisaExtensaoEmEstudante(String cpf, String senha, String tipo, int unidadeAcumulada, String subtipo) {
        PesquisaExtensao novo = new PesquisaExtensao(tipo, unidadeAcumulada, subtipo);
        return estudantes.adicionarAtividadeComplementarEmEstudante(novo, cpf, senha, "PesquisaExtensao");
    }

    /**
     * Cria uma atividade de estágio e adiciona ao estudante.
     * @param cpf O CPF do estudante.
     * @param senha A senha do estudante.
     * @param tipo O tipo de atividade complementar.
     * @param unidadeAcumulada A quantidade de unidades acumuladas pela atividade.
     * @param nomeEmpresa O nome da empresa onde o estágio foi realizado.
     * @return Uma string que representa a atividade de estágio.
     */
    public String criarAtividadeEstagioEmEstudante(String cpf, String senha, String tipo, int unidadeAcumulada, String nomeEmpresa) {
        Estagio novo = new Estagio(tipo, unidadeAcumulada, nomeEmpresa);
        return estudantes.adicionarAtividadeComplementarEmEstudante(novo, cpf, senha, "Estagio");
    }

    /**
     * Cria uma atividade de representação estudantil e adiciona ao estudante.
     * @param cpf O CPF do estudante.
     * @param senha A senha do estudante.
     * @param tipo O tipo de atividade complementar.
     * @param unidadeAcumulada A quantidade de unidades acumuladas pela atividade.
     * @param subtipo O subtipo da representação estudantil.
     * @return Uma string que representa a atividade de representação estudantil.
     */
    public String criarAtividadeRepresentacaoEstudantil(String cpf, String senha, String tipo, int unidadeAcumulada, String subtipo) {
        RepresentacaoEstudantil novo = new RepresentacaoEstudantil(tipo, unidadeAcumulada, subtipo);
        return estudantes.adicionarAtividadeComplementarEmEstudante(novo, cpf, senha, "RepresentaçãoEstudantil");
    }

}
