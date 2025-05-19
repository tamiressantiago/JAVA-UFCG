import java.util.Scanner;
import java.util.Arrays;
public class SomaDois{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] seq = sc.nextLine().split(" ");
        int n = sc.nextInt();

        System.out.println(Arrays.toString(somaDois(seq, n)));
    }

    public static String[] somaDois(String[] seq, int n){
        String[] par = new String[2]; 
        for(int i = 0; i < seq.length; i++){
            for(int j = 1; j < seq.length; j++){
                if(Integer.parseInt(seq[i]) + Integer.parseInt(seq[j]) == n){
                    par[0] = seq[i];
                    par[1] = seq[j];
                    return par;
                } 
            }
        }
        return par;
    }

}
