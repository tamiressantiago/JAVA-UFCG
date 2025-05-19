import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {
    
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         String[] entrada = sc.nextLine().split(" ");
         int d = sc.nextInt();

         int[] v = new int[entrada.length];
         for(int i = 0; i < v.length; i++){
            v[i] = Integer.parseInt(entrada[i]);
         }

         v = radixSort(v, d);
    }

    public static int[] radixSort(int[] v, int d){
        for(int exp = 1; d > 0; exp*= 10){
            v = countingRadix(v, exp);
            d--;
        }
        return v;
    }


    private static int[] countingRadix(int[] A, int exp){
        //frequência
        int[] C = new int[10];
        for(int i = 0; i < A.length; i++){
            C[(A[i] / exp) % 10] += 1;
        }

        //cumulativo
        for(int i = 1; i < 10; i++){
            C[i] += C[i-1];
        }

        //ordenando
        int[] S = new int[A.length];
        for(int i = A.length - 1; i >= 0; i--){
            S[C[(A[i] / exp) % 10] -1] = A[i];
            C[(A[i] / exp) % 10] -= 1;
        }
        System.out.println(Arrays.toString(S));
        return S;
    }
}
