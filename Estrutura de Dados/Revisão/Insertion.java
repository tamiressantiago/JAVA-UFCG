public class Insertion{ //diz que o primeiro elemento está ordenado, a partir disto vai organizando os demais em posições antes ou depois deste elemento

    public void insertion(int[] v){
        //consideramos que o primeiro elemento já está ordenado
        for(int i = 1; i < v.length; i++){
            //veremos se o elemento atual é menor que o anterior, se sim o movemos para lá posição por posição
            //como a quantidade de trocas é indefinida, usaremos while

            int j = i; //variável auxiliar para o while, controlará a posição do elemento que estamos movendo
            while(j > 0 && v[j] < v[j-1]){
                swap(v, j, j-1);
                j--;
            }
        }
    }

    private void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}