import java.util.Arrays;
import java.util.Scanner;

public class RadixDoisDigitos {

     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         String[] entrada = sc.nextLine().split(" ");
         int d = sc.nextInt();

         int[] v = new int[entrada.length];
         for(int i = 0; i < v.length; i++){
            v[i] = Integer.parseInt(entrada[i]);
         }

         v = radixDoisDigitos(v, d);
    }

    public static int[] radixDoisDigitos(int[] v, int d){
        for(int exp = 1; v[0]/exp > 0; exp *= 100){
            v = countingRadix(v, exp);
            System.out.println(Arrays.toString(v));
        }
        return v; 
    }
            
    private static int[] countingRadix(int[] A, int exp) {
    //freq
    int[] C = new int[100];
    for(int i = 0; i < A.length; i++){
        C[(A[i]/exp) % 100] += 1; 
    }

    //cumulativo
    for(int i = 1; i < 100; i++){
        C[i] += C[i-1];
    }

    //ordenação
    int[] S = new int[A.length];
    for(int i = A.length - 1; i >= 0; i--){
        S[C[(A[i]/exp) % 100] -1] = A[i];
        C[(A[i]/exp) % 100] -= 1;
    }

    return S;
    
    }
    
    
}
