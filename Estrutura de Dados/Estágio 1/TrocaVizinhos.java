import java.util.Scanner;
import java.util.Arrays;
public class TrocaVizinhos{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] seq = sc.nextLine().split(" ");

        System.out.println(Arrays.toString(trocaVizinhos(seq)));
    }

    public static String[] trocaVizinhos(String[] seq){
        for(int i = 1; i < seq.length; i+=2){
            String aux = seq[i];
            seq[i] = seq[i-1];
            seq[i-1] = aux;
        }

        return seq;

    }

}
