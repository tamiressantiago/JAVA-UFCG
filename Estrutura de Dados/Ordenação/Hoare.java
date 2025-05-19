import java.util.Arrays;
import java.util.Scanner;

public class Hoare{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");

        int[] array = new int[entrada.length];
        for(int i = 0; i < entrada.length; i++){
            array[i] = Integer.parseInt(entrada[i]);
        }

        hoare(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void hoare(int[] v, int ini, int fim){
        int i = ini+1;
        int j = fim;
        int pivot = v[ini];

        while(i <= j){

            while(i <= j && v[i] <= pivot){
                i++;
            }
            while(i <= j && v[j] > pivot){
                j--;
            }

            if(i < j)
                swap(v, i, j);
        }

        swap(v, ini, j);
    }

    public static void swap(int[] v, int i, int j){
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}