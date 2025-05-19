/*
 * Uma péssima partição no nosso contexto é colocar o pivot em um lugar que não há elementos à sua esquerda e que há n−1
 elementos à sua direita, por exemplo. Como vimos, um exemplo concreto deste caso ocorre quando o array já está ordenado e 
 sempre escolhemos o pivot como sendo o primeiro elemento ou quando está ordenado em ordem reversa e fazemos essa mesma escolha de pivot.
 * 
 * Qual seria o melhor caso de particionamento? Seria um que se aproximasse do Merge Sort, em que sempre dividimos o array pela metade. 
 * Ou seja, se o pivot sempre ficar no meio do array, teremos uma árvore binária na recursão em que a esquerda tem metade do tamanho do 
 * array e a direita também tem a metade do tamanho. Essa árvore, como já vimos, tem a altura mínima, isto é, O(logn). 
 * Então, o custo do melhor caso seria logn execuções do particiona, que é O(n). Como resultado, o melhor caso do Quick Sort é O(n∗logn).
 * 
 * No caso médio o Quick Sort é O(n∗logn). Esse caso tem sempre uma alta probabilidade de se manifestar, 
 * mesmo que haja algumas péssimas escolhas pivot durante a execução do algoritmo.
 * 
 * O QuickSort é in-place porém não-estável.
 */

import java.util.Arrays;

public class QuickSort {
    public void quick(int[] v, int ini, int fim){
        if(ini < fim){ //condição de parada pois o QuickSort é recursivo
            int pivot = partitionLomuto(v, ini, fim);
            quick(v, ini, pivot-1); //não precisamos colocar o pivot incluso pois ele já está na posição correta
            quick(v, pivot+1, fim);
        }
    }

    private int partitionLomuto(int[] v, int ini, int fim){
        //escolhendo o pivot de maneira aleatória
        int range = fim - ini + 1;
        int pivot_aleatorio = (int)(Math.random() * range) + ini; //se formos utilizar pivot aleatório, trocamos este valor pelo da posição ini
        //

        int pivot = v[ini];
        int i = ini;

        for(int j = ini + 1; j <= fim; j++){ //j controla a iteração e i controla as trocas
            if(v[j] <= pivot){ // atenção ao sinal
                i++;
                swap(v, i, j);
                System.out.println(Arrays.toString(v));
            }
            
        }

        swap(v, ini, i); //trocamos i(que aponta para algum valor menor que o pivot) pela posição do pivot
        return i; //posição final do pivot
        
    }

    private int partitionHoare(int[] v, int ini, int fim){
        int pivot = v[ini];
        int i = ini + 1; //+1 pois o elemento ini já é o pivot, que está ordenado
        int j = fim;

        while(i <= j){
            
            while(i <= j && v[i] <= pivot){
                i++;
            }
            while(i <= j && v[j] > pivot){ //apenas maior que o pivot, pois o igual entra na primeira metade
                j--;
            }

            if(i < j) //precisa verificar se um dos dois não ultrapassou
                swap(v, i, j);
        }

        swap(v, ini, j); //troca o pivot com um elemento menor que ele (guardado pelo j)
        return j;
    }

    private static void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
