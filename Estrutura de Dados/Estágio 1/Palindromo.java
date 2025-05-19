import java.util.Scanner;

public class Palindromo{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();
        char[] seq = entrada.toCharArray();

        System.out.println(palindromo(seq));
    }


    public static boolean palindromo(char[] seq){
        int indice = seq.length - 1;

        for(int i = 0; i < seq.length/2; i++){
            if(seq[i] != (seq[indice]))
                return false;
            indice--;
    }
        return true;
    }
}
