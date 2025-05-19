import java.util.NoSuchElementException;

public class LinkedList {
    Node head;
    Node tail;
    int size;
    
    public LinkedList() {
        int size = 0;
    }
   
    public boolean isEmpty() {
        return size == 0; //não funciona com head == null ????
    }

    public void addFirst(int valor) {
        Node nn = new Node(valor);

        if(head == null){
            head = nn;
            tail = nn;
        } else {
            nn.next = head;
            head.prev = nn;
            head = nn;
        }
        
        size++;
        
    }

    public void addLast(int valor) {
        Node nn = new Node(valor);
        
        if(head == null){
            head = nn;
            tail = nn;
        } else {
            tail.next = nn;
            nn.prev = tail;
            tail = nn;
        }
        
        size++;
    }

    // adiciona um valor na posição passada como parâmetro
    public void add(int index, int valor) {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("Índice Inválido");

        Node nn = new Node(valor);

        if(index == 0)
            addFirst(valor);
        else if(index == size)
            addLast(valor);
        else{
            Node aux = head;

            for(int i = 0; i < index - 1; i++) //fazemos -1 para parar no elemento que será anterior ao nn
                aux = aux.next;
            
            nn.next = aux.next; //fazemos a conexão next do nn ao next do elemento anterior a ele (aux) que será seu próximo
            aux.next = nn; //REfazemos a conexão next do elemento anterior ao nn
            nn.prev = aux; //fazemos a conexão prev do nn ao seu elemento anterior
            nn.next.prev = nn; //o novo next do nn ainda tem seu prev no antecessor do nn, REfazemos essa conexão para conectar no nn
    
            size++;
        }

    }

    public int getFirst() {
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        return head.value;
    }

    public int getLast() {
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        return tail.value;
    }

    // retorna o elemento na posição  passada como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
        if(index < 0 || index > size) //VER PQ É SIZE E NÃO SIZE - 1
            throw new IndexOutOfBoundsException("Índice Inválido");

        if(isEmpty())
            throw new IndexOutOfBoundsException();

        Node aux = this.head;
        for (int i = 0; i < index; i++) //mesmo que seja index, trabalhamos com < pois sempre estamos pegando o elemento logo após
            aux = aux.next;
        
        return aux.value;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if(isEmpty())
            throw new NoSuchElementException();

        int value = head.value;

        if (head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = head.next;
            this.head.prev = null;
        }
        
        size--;
        return value;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeLast() {
        if(isEmpty())
            throw new NullPointerException();

        int value = tail.value;

         if (tail.prev == null) {
            this.head = null;
            this.tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
         }
        
        size--;
        return value;
    }

    // remove o valor no índice passado como parâmetro. retorna o valor removido.
    // lançar exceção se o índice não for válido.
    public int remove(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Índice Inválido");

        if (index == 0) // se o index for 0 não entrará no for
            return removeFirst();
        if (index == size - 1)  // se o index for o do último elemento, não poderemos fazer as modificações do next pois este será nulo
            return removeLast();

        Node aux = head;
        for(int i = 0; i < index; i++){ // pegarei o elemento anterior ao que quero remover
            aux = aux.next;
        }

        int value = aux.value;
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
        size--;

        return value;

    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada. true se remover, false se não remover.
    public boolean removeByValue(int value) {
        int indice = indexOf(value);
        if(indice != -1){
            remove(indice);
            return true;
        }
        
        return false;
    }

    // retorna a posição da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        Node aux = head;
        int index = 0;
        while(aux != null){
            if(aux.value == value)
                return index;
            aux = aux.next;
            index++;
        }

        return -1;
    }

    public boolean contain(int v) {
        int contain = indexOf(v);
        return contain != -1;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
        Node aux = head;
        int index = -1;
        int contador = -1;
        while(aux != null){
            contador++;
            if(aux.value == valor)
                index = contador;
            aux = aux.next;
        }

        return index;
    }
    
    // deve retornar uma string representando a lista. 
    public String toString() {
        if (isEmpty()) return "";

        Node aux = this.head;
        String out = "";
        while (aux != null) {
            out += aux.value + ", ";
            aux = aux.next;
        }
        return out.substring(0, out.length() - 2);
    }
    
    public int size() {
        return size;
    }

    public void insereOrdenado(int v){
        Node nn = new Node(v);
        Node aux = head;
        int indice = 0;
        for(int i = 1; i < size; i++){
            if(v > aux.value)
                indice = i;
            aux = aux.next;
        }
        add(indice, v);
    }

    public void inverte(){
        if(size <= 1) return;

        Node aux = head;
        Node temp = null;

        while(aux != null){
            temp = aux.prev;
            aux.prev = aux.next;
            aux.next = temp;
            aux = aux.prev;
        }

        temp = head;
        head = tail;
        tail = temp;
    }
}

class Node {

    int value;
    Node prev;
    Node next;
    int freq;

    Node(int v) {
        this.value = v;
        int freq = 0;
    }

}