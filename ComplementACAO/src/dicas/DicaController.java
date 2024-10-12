package dicas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import estudante.*;

/**
 * A classe DicaController é responsável por gerenciar as dicas.
 * Ela mantém uma lista de dicas e uma referência para o controlador de estudantes.
 * 
 * @author Tamires Santiago Oliveira - 123210205
 */
public class DicaController {
    private List<Dica> dicas;
    private EstudanteController estudantes;

    /**
     * Construtor para a classe DicaController.
     *
     * @param estudantes O controlador de estudantes.
     */
    public DicaController(EstudanteController estudantes) {
        this.estudantes = estudantes;
        this.dicas = new ArrayList<>();
    }

    /**
     * Adiciona uma nova dica à lista de dicas.
     *
     * @param cpf O CPF do autor da dica.
     * @param senha A senha do autor da dica.
     * @param tema O tema da dica.
     * @return A posição da dica na lista.
     */
    public int adicionarDica(String cpf, String senha, String tema) {
        Estudante autor = estudantes.pegarEstudante(cpf, senha);
        dicas.add(new Dica(autor, tema));
        return dicas.size()-1;
    }

    /**
     * Adiciona um elemento de texto à dica na posição especificada.
     *
     * @param cpf O CPF do autor do elemento.
     * @param senha A senha do autor do elemento.
     * @param posicao A posição da dica na lista.
     * @param texto O texto do elemento.
     * @return Um booleano indicando se o elemento foi adicionado com sucesso.
     */
    public boolean adicionarElementoTextoDica(String cpf, String senha, int posicao, String texto) {
        Estudante autor = estudantes.pegarEstudante(cpf, senha);
        if(posicao < 0 || posicao > dicas.size())
            throw new IllegalArgumentException("Posição inválida!");
        return dicas.get(posicao).adicionarElementoTextoDica(texto, autor);
    }

    /**
     * Adiciona um elemento multimídia à dica na posição especificada.
     *
     * @param cpf O CPF do autor do elemento.
     * @param senha A senha do autor do elemento.
     * @param posicao A posição da dica na lista.
     * @param link O link para o conteúdo multimídia.
     * @param cabecalho O cabeçalho ou título do conteúdo multimídia.
     * @param tempo O tempo de duração do conteúdo multimídia em segundos.
     * @return Um booleano indicando se o elemento foi adicionado com sucesso.
     */
    public boolean adicionarElementoMultimidiaDica(String cpf, String senha, int posicao, String link, String cabecalho, int tempo) {
        Estudante autor = estudantes.pegarEstudante(cpf, senha);
        if(posicao < 0 || posicao > dicas.size())
            throw new IllegalArgumentException("Posição inválida!");
        return dicas.get(posicao).adicionarElementoMultimidiaDica(link, cabecalho, tempo, autor);
    }

    /**
     * Adiciona um elemento de referência à dica na posição especificada.
     *
     * @param cpf O CPF do autor do elemento.
     * @param senha A senha do autor do elemento.
     * @param posicao A posição da dica na lista.
     * @param titulo O título da referência.
     * @param fonte A fonte da referência.
     * @param ano O ano da referência.
     * @param conferida Um booleano indicando se a referência foi conferida.
     * @param importancia A importância da referência.
     * @return Um booleano indicando se o elemento foi adicionado com sucesso.
     */
    public boolean adicionarElementoReferenciaDica(String cpf, String senha, int posicao, String titulo, String fonte,
                                                   int ano, boolean conferida, int importancia) {
        Estudante autor = estudantes.pegarEstudante(cpf, senha);
        if(posicao < 0 || posicao > dicas.size())
            throw new IllegalArgumentException("Posição inválida!");
        return dicas.get(posicao).adicionarElementoReferenciaDica(titulo, fonte, ano, conferida, importancia, autor);
    }

    /**
     * Retorna uma lista de dicas em formato de String.
     *
     * @return Uma lista de dicas em formato de String.
     */
    public String[] listarDicas() {
        String[] saida = new String[dicas.size()];
        int cont = 0;
        for(Dica d : dicas) {
            saida[cont] = d.toString();
            cont++;
        }
        return saida;
    }

    /**
     * Retorna uma lista de dicas com detalhes em formato de String.
     *
     * @return Uma lista de dicas com detalhes em formato de String.
     */
    public String[] listarDicasDetalhes() {
        String[] saida = new String[dicas.size()];
        int cont = 0;
        for(Dica d : dicas) {
            saida[cont] = d.detalhes();
            cont++;
        }
        return saida;
    }

    /**
     * Retorna a dica na posição especificada em formato de String.
     *
     * @param posicao A posição da dica na lista.
     * @return A dica na posição especificada em formato de String.
     */
    public String listarDica(int posicao) {
        return dicas.get(posicao).toString();
    }

    /**
     * Retorna a dica com detalhes na posição especificada em formato de String.
     *
     * @param posicao A posição da dica na lista.
     * @return A dica com detalhes na posição especificada em formato de String.
     */
    public String listarDicaDetalhes(int posicao) {
        return dicas.get(posicao).detalhes();
    }

    /**
     * Retorna uma lista de usuários ordenada pelo ranking de dicas.
     *
     * @return Uma lista de usuários ordenada pelo ranking de dicas.
     */
    public String[] listarUsuariosRankingDicas() {
        List<Estudante> autores = new ArrayList<>();
        for(Dica d : dicas) {
            autores.add(d.getAutor());
        }

        Collections.sort(autores, new EstudanteComparator());
        String[] saida = new String[autores.size()];
        int cont = 0;
        for(Estudante autor : autores) {
            saida[cont] = autor.toString();
            cont++;
        }
        return saida;
    }
}