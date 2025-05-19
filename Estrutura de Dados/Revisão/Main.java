import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {
        int[] v = {4, 11, -2, 3, 9, 19, 2};
        //Insertion insertion = new Insertion();
        //insertion.insertion(v);

        //Selection selection = new Selection();
        //selection.selection(v);

        //MergeSort mergeS = new MergeSort();
        //mergeS.mergeSort(v, 0, v.length-1);
        
        QuickSort quickS = new QuickSort();
        quickS.quick(v, 0, v.length-1);
        //System.out.println(Arrays.toString(v));
    }
}
