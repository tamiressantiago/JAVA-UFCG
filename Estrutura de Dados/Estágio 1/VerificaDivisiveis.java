import java.util.Scanner;

public class VerificaDivisiveis {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] seq = sc.nextLine().split(" ");

        int[] array = new int[seq.length];
        for (int i = 0; i < seq.length; i++) {
            array[i] = Integer.parseInt(seq[i]);
        }

        System.out.println((verificaDivisiveis(array)));
    }

    public static boolean verificaDivisiveis(int[] seq) {
    	for(int i = 0; i < seq.length; i++) {
    		for(int j = i + 1; j < seq.length; j++) {
    			if(seq[j] % seq[i] == 0)
    				return true;
    		}
    	}
    	return false;
    	
    }
   }
