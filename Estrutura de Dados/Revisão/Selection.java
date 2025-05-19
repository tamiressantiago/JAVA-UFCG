public class Selection { //pega o menor valor do array e coloca na primeira posição, depois desconsidera esse elemento que já está ordenado e repete o processo até o fim do array

    public void selection(int[] v){

        for(int i = 0; i < v.length; i++){
            int indice_menor = i; //definimos o menor valor de cada rodada como i, dessa forma não estaremos considerando os elementos já ordenados no próximo loop
            for(int j = i + 1; j < v.length; j++){ //começamos o j = i+1 para não compararmos um elemento com ele mesmo
                if(v[j] < v[indice_menor])
                    indice_menor = j;
            }
            swap(v, i, indice_menor);
        }
    }

    private static void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
    
}
