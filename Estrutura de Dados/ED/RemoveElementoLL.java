import java.util.Scanner;
class RemoveElementoLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        LinkedList ll = new LinkedList();
        for(String elemento: entrada){
            ll.addLast(Integer.parseInt(elemento));
        }

        int elemento = sc.nextInt();
        ll.removeElemento(elemento);
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

    public void removeElemento(int e){
        Node aux = head;
        int tamanho = size;
        for(int i = 0; i < tamanho; i++){
            if(aux.valor == e)
                removeNo(aux);
            aux = aux.next;
        }
    }

    public void removeNo(Node n){
        if(size == 1){
            head = null;
            tail = null;
        }
        else if(n == head){
            n.next.prev = null;
            head = n.next;
        }
        else if(n == tail){
            n.prev.next = null;
            tail = n.prev;
        }
        else{
            n.prev.next = n.next;
            n.next.prev = n.prev;
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