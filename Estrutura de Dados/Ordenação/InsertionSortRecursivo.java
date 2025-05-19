//INCOMPLETO
import java.util.Arrays;
import java.util.Scanner;
public class InsertionSortRecursivo{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");

        int[] array = new int[entrada.length];
        for(int i = 0; i < entrada.length; i++){
            array[i] = Integer.parseInt(entrada[i]);
        }

        insertionSortRecursivo(array, 1); //ordenados começa em 1 pois consideramos que o primeiro elemento já está ordenado
        System.out.println(Arrays.toString(array));
    }

    public static void insertionSortRecursivo(int[] v, int ordenados){ //ordenados acompanha a quantidade de elementos na sua posição correta
        
        if(ordenados < v.length){ //enquanto toda a lista não estiver ordenada
            int i = ordenados;
            while(i > 0 && v[i] < v[i-1]){
                int aux = v[i];
                v[i] = v[i-1];
                v[i-1] = aux;
                i--;
            }
            System.out.println(Arrays.toString(v));
            insertionSortRecursivo(v, ++ordenados);
        }
        return;
    }
}