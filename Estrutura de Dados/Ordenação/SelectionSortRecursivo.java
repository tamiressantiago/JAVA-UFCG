//INCOMPLETO

import java.util.Arrays;
import java.util.Scanner;
public class SelectionSortRecursivo{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");

        int[] array = new int[entrada.length];
        for(int i = 0; i < entrada.length; i++){
            array[i] = Integer.parseInt(entrada[i]);
        }

        selectionSortRecursivo(array, 0);
        System.out.println(Arrays.toString(array));
    }

    public static void selectionSortRecursivo(int[] v, int ord){
        if(ord < v.length){
            int menor = ord;
            for(int j = 1 + menor; j < v.length; j++){
                    if (v[j] < v[menor])
                        menor = j;
            }
                    
            int aux = v[menor];
            v[menor] = v[ord];
            v[ord] = aux;
            System.out.println(Arrays.toString(v)); 
            
            selectionSortRecursivo(v, ++ord);
        }

        return;
    }
}
