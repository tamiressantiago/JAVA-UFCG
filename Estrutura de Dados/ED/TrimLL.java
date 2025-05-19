import java.util.Scanner;
class TrimLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        LinkedList ll = new LinkedList();
        for(String elemento: entrada){
            ll.addLast(Integer.parseInt(elemento));
        }

        int quantidade = sc.nextInt();
        for(int i = 0; i < quantidade; i++){
            ll.removeFirst();
            ll.removeLast();
        }
        System.out.println(ll.toString());
        sc.close();
    }
}


class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList(){
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addLast(int valor){
        Node nn = new Node(valor);

        if(size == 0){
            head = nn;
            tail = nn;
        } else {
            tail.next = nn;
            nn.prev = tail;
            tail = nn;
        }

        size++;
    }

    public void removeFirst(){
        if(!isEmpty()){
            head.next.prev = null;
            head = head.next;
        }
        size--;
    }

    public void removeLast(){
        if(!isEmpty()){
            if(size == 1)
                tail = null;
            else{
                tail.prev.next = null;
                tail = tail.prev;
            }
        }
        size--;
    }

    public String toString(){
        if(isEmpty())
            return "vazia";

        String saida = "";
        Node aux = head;
        saida += head.valor + " ";
        for(int i = 1; i < size; i++){
            aux = aux.next;
            saida += aux.valor + " ";
        }

        return saida.substring(0, saida.length()-1);
    }

}

class Node{
    int valor;
    Node prev;
    Node next;

    public Node(int valor){
        this.valor = valor;
    }
}
