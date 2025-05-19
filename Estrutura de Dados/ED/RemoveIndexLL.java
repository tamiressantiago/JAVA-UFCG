import java.util.Scanner;

class RemoveIndexLL {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        LinkedList ll = new LinkedList();
        for(String elemento: entrada){
            ll.addLast(Integer.parseInt(elemento));
        }

        int indice = sc.nextInt();
        ll.removeIndex(indice);
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

   public void removeIndex(int indice){
        if(size == 1){
            head = null;
            tail = null;
        }
        else if(indice == 0){
            head.next.prev = null;
            head = head.next;
        }
        else if(indice == size -1){
            tail.prev.next = null;
            tail = tail.prev;
        }
        else {
            Node aux = head;
            for(int i = 1; i <= indice; i++)
                aux = aux.next;

            aux.next.prev = aux.prev;
            aux.prev.next = aux.next;
        }
        size--;

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

