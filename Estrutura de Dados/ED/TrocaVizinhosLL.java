import java.util.Scanner;

class TrocaVizinhosLL {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        LinkedList ll = new LinkedList();
        for(String elemento: entrada){
            ll.addLast(Integer.parseInt(elemento));
        }

        int indice = sc.nextInt();
        ll.trocaVizinhos(indice);
        System.out.println(ll.toString());
    }
}


class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList(){
        size = 0;
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

    public void trocaVizinhos(int indice){
        Node v1 = head;
        Node v2;

        for(int i = 0; i < indice; i++){
            v1 = v1.next;
        }

        v2 = v1.next;

        Node v1Prev = v1.prev;
        Node v1Next = v1.next;
        Node v2Prev = v2.prev;
        Node v2Next = v2.next;

        v2.prev = v1Prev;
        v1.prev = v2;
        v2.next = v1;
        v1.next = v2Next;

        if(v2 != tail)
            v2Next.prev = v1;
        else
            tail = v1;

        if(v1 != head)
            v1Prev.next = v2;
        else
            head = v2;
    }

    public String toString(){
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
