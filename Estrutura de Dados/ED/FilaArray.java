import java.util.Scanner;

class FilaArray{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tamanho = sc.nextInt();
        sc.nextLine();
        Fila fila = new Fila(tamanho);
        String[] entrada = new String[2];
        do{
            entrada = sc.nextLine().split(" ");
            if(entrada[0].equals("add"))
                fila.add(Integer.parseInt(entrada[1]));
            else if(entrada[0].equals("remove"))
                fila.remove();
            else if(entrada[0].equals("print"))
                fila.print();
            else if(entrada[0].equals("element"))
                fila.element();

        } while(!entrada[0].equals("end"));
    }
}

class Fila{
    private int[] fila;
    private int size;
    private int head;
    private int tail;
    
    public Fila (int tamanho){
        fila = new int[tamanho];
        head = -1;
        tail = -1;
        size = 0;
    }

    public boolean isFull(){
        return size == fila.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public void add(int value){
        if(isEmpty())
            head++;
        else if(isFull())
            System.out.println("full");

        if(!isFull()){
            tail = (tail + 1) % fila.length;
            fila[tail] = value;
            size++;
        }
        return;
    }

    public void remove(){
        if(!isEmpty()){
            head++;
            size--;
        } else {
            System.out.println("empty");
        }

        return;
    }

    public void print(){
        String saida = "";
        if(isEmpty())
            saida = "empty ";
        else{
            for(int i = head; i < size + head; i++)
                saida += fila[i%fila.length] + " ";
        }

        saida = saida.substring(0, saida.length()-1);

        System.out.println(saida);
        return;
    }

    public void element(){
        if(isEmpty())
            System.out.println("empty");
        else
            System.out.println(fila[head]);
    }
}