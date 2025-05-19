import java.util.Scanner;

public class VetorCircular {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] seq = sc.nextLine().split(" ");
        int n = Integer.parseInt(sc.nextLine());

        int[] array = new int[seq.length];
        for (int i = 0; i < seq.length; i++) {
            array[i] = Integer.parseInt(seq[i]);
        }

        System.out.println((vetorCircular(array, n)).trim());
    }

    public static String vetorCircular(int[] seq, int n) {
       
    	String saida = "";
        int cont = 0;

        while (n > 0) {
            if (cont == seq.length) {
                cont = 0;
            }
            saida += seq[cont] + " ";
            cont++;
            n--;
        }

        return saida;
    }
}
