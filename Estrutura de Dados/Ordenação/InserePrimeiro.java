import java.util.Arrays;
import java.util.Scanner;
public class InserePrimeiro{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");

        int[] array = new int[entrada.length];
        for(int i = 0; i < entrada.length; i++){
            array[i] = Integer.parseInt(entrada[i]);
        }

        inserePrimeiro(array);
        System.out.println(Arrays.toString(array));
    }

    public static void inserePrimeiro(int[] v){
        int i = 0;
        while(i < v.length-1 && v[i] > v[i+1]){
            int aux = v[i];
            v[i] = v[i+1];
            v[i+1] = aux;
            i++;
        }
    }
}