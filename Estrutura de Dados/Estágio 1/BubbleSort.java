import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] seq = sc.nextLine().split(" ");

        int[] array = new int[seq.length];
        for (int i = 0; i < seq.length; i++) {
            array[i] = Integer.parseInt(seq[i]);
        }

        System.out.println(Arrays.toString(bubbleSort(array)));
    }

    public static int[] bubbleSort(int[] seq) {
    	for(int i = 0; i < seq.length; i++) {
    		for(int j = 1; j < seq.length; j++) {
    			if(seq[j] < seq[j-1]) {
    				int aux = seq[j-1];
    				seq[j-1] = seq[j];
    				seq[j] = aux;
    			}
    		}
    		System.out.println(Arrays.toString(seq));
    	}
    	
    	
    	return seq;
    }
}
