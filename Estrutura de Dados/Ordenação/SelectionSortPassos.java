//INCOMPLETO

import java.util.Arrays;
import java.util.Scanner;
public class SelectionSortPassos{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");

        int[] array = new int[entrada.length];
        for(int i = 0; i < entrada.length; i++){
            array[i] = Integer.parseInt(entrada[i]);
        }

        selectionSortPassos(array);
        System.out.println(Arrays.toString(array));
    }

    public static void selectionSortPassos(int[] v){
        for(int i = 0; i < v.length; i++){ //acompanha os indíces dos valores já ordenados
            int menor = i;

            //pega o menor valor do array
            for(int j = 1 + i; j < v.length; j++){
                if (v[j] < v[menor])
                    menor = j;
            }
                
            int aux = v[i];
            v[i] = v[menor];
            v[menor] = aux;
            
            System.out.println(Arrays.toString(v)); 
        }    
    }
}
