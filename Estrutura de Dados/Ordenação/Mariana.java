import java.util.Arrays;
import java.util.Scanner;

public class Mariana{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(",");
        ordenacao(entrada);
    }

    public static void ordenacao(String[] v){

        for(int i = 1; i < v.length; i++){
            int j = i;
            System.out.println(Arrays.toString(v));
            while(j > 0){
                int comparacao = v[j].compareTo(v[j-1]);
                if(comparacao < 0)
                    swap(v, j, j-1);
                j--;
            }
        }

    }

    public static void swap(String[] v, int i, int j){
        String aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}