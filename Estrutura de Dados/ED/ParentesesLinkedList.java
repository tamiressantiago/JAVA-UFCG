import java.util.Scanner;

public class ParentesesLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split("");

        MyLinkedList pilha = new MyLinkedList();

        String saida = "S";
        for(String s : entrada){
            if(s.equals("("))
                pilha.addFirst(s);
            else if(s.equals(")")){
                if(pilha.isEmpty())
                    saida = "N";
                else
                    pilha.removeFirst();
            }
        }

        if(!pilha.isEmpty())
            saida = "N";

        System.out.println(saida);

    }
}

    class MyLinkedList{
        Node head;
        Node tail;
        int size;

        public MyLinkedList(){
            size = 0;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public void addFirst(String valor){
            Node nn = new Node(valor);
            
            if(size == 0){
                head = nn;
                tail = nn;
            }
            else{
                head.prev = nn;
                nn.next = head;
                head = nn;
            }
            size++;
        }

        public String removeFirst(){
            if(!isEmpty()){
                Node aux = head;
                if(size == 1){
                    head = null;
                    tail = null;
                }
                else{     
                    head = head.next;
                    head.prev = null;
                }
                size--;
                return aux.valor;

            }
            return "vazia";
        }

    }

    class Node{
        String valor;
        Node prev;
        Node next;

        public Node(String valor){
            this.valor = valor;
        }
    }

