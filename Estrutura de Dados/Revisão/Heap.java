import java.util.Arrays;
import java.util.Scanner;

class Heap{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] seq = sc.nextLine().split(" ");
        int[] seqInt = new int[seq.length];
        for(int i = 0; i < seq.length; i++){
            seqInt[i] = Integer.parseInt(seq[i]);
        }

        HeapC hp = new HeapC(seqInt);
        System.out.println(hp.toString());
        
    }
}

class HeapC{
    private int[] heap;
    private int tail;

    public HeapC(int capacidade){
        heap = new int[capacidade];
        tail = -1;
    }

    public HeapC(int[] heap) {
        this.heap = heap;
        this.tail = this.heap.length - 1;
        this.buildHeap();
    }

    public boolean isEmpty() {
        return this.tail == -1;
    }

    public int left(int i) {
        if(isValidIndex(i))
    	    return (i*2) + 1;   
        return -1;
    }

    public int right(int i) {
        if(isValidIndex(i))
            return (i*2) + 2;
        return -1;
    }

    public int parent(int i) {
        if(i > 0 && i <= tail)
            return (i-1)/2;
        return -1;
    }

    public void add(int n) {
        tail++;
    	int index = tail;
        if(index >= heap.length)
            resize();    
        heap[index] = n;

        while(parent(index) != -1 && heap[index] > heap[parent(index)]){
            swap(index, parent(index));
            index = parent(index);
        }

    }

    private void buildHeap() {
        for(int i = parent(tail); i >= 0; i--){
            heapify(i);
        }
    }
    
    public int remove() {
        if (isEmpty()) throw new RuntimeException("Empty");
        int element = this.heap[0];
        this.heap[0] = this.heap[tail];
        this.tail -= 1;

        this.heapify(0);
        
        return element;
    }
        
    private void heapify(int index) {
        if (isLeaf(index) || !isValidIndex(index)) 
            return;
        
        // compares index, left and right to find max
        int index_max = max_index(index, left(index), right(index));
        
        // if current index is not greater than its children, 
        // swap and keep heapifying.
        if (index_max != index) {
                swap(index, index_max);
                heapify(index_max);
        }
    } 
    
    private int max_index(int index, int left, int right) {
        if (this.heap[index] > this.heap[left]) {
            if (isValidIndex(right)) {
                if (this.heap[index] < this.heap[right])
                    return right;
            }
            return index;
        
        } else {
            if (isValidIndex(right)) {
                if (this.heap[left] < this.heap[right])
                    return right;
            } 
            
            return left;
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= tail;
    }
    
    private boolean isLeaf(int index) {
        return index > parent(tail) && index <= tail; 
    } 
    
    private void swap(int i, int j) {
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }

    private void resize() {
        int[] novoHeap = new int[this.heap.length * 2];
        for (int i = 0; i <= tail; i++)
            novoHeap[i] = this.heap[i];
        
        this.heap = novoHeap;
    }
    
    public int size() {
        return this.tail + 1;
    }
    
    public String toString() {
        return Arrays.toString(this.heap);
    }

}