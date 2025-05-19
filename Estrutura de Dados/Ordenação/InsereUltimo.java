import java.util.Arrays;
import java.util.Scanner;
public class InsereUltimo{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");

        int[] array = new int[entrada.length];
        for(int i = 0; i < entrada.length; i++){
            array[i] = Integer.parseInt(entrada[i]);
        }

        insereUltimo(array);
        System.out.println(Arrays.toString(array));
    }

    public static void insereUltimo(int[] v){
        int i = v.length -1;
        while(i > 0 && v[i] < v[i-1]){
            int aux = v[i];
            v[i] = v[i-1];
            v[i-1] = aux;
            i--;
        }
    }
}