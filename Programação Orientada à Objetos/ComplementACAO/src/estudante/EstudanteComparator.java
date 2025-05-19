package estudante;

import java.util.Comparator;

/**
 * Implementa a interface Comparator para comparar dois objetos Estudante.
 * Esta classe é usada para ordenar uma coleção de estudantes com base na quantidade de bônus que eles têm.
 *
 *@author Tamires Santiago Oliveira - 123210205
 */
public class EstudanteComparator implements Comparator<Estudante> {

    /**
     * Compara dois objetos Estudante com base na quantidade de bônus que eles têm.
     * @param o1 O primeiro estudante a ser comparado.
     * @param o2 O segundo estudante a ser comparado.
     * @return Um valor negativo, zero ou positivo se o primeiro estudante tiver menos, igual ou mais bônus que o segundo estudante, respectivamente.
     */
    @Override
    public int compare(Estudante o1, Estudante o2) {
        return Integer.compare(o2.getBonus(), o1.getBonus());
    }

}