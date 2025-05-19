import java.util.ArrayDeque;
import java.util.Scanner;

class OrdenaPilhaInvertendo {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        String[] entrada = sc.nextLine().split(" ");
        Pilha pilha = new Pilha(size);
     
        for(String s: entrada){
            pilha.push(Integer.parseInt(s));
        }

        System.out.println("-");
        ordenaPilhaInvertendo(pilha);
        exibir(pilha);
    }

    public static void ordenaPilhaInvertendo(Pilha pilha){
        int control = pilha.size-1;
        while(control >= 0){
            int maior = maxPilha(pilha, control);
            invertePilha(pilha, maior);
            invertePilha(pilha, control); 
            control--;
           
        }
    }
/*
    public static int maxPilha(Pilha pilha, int index){
        Pilha aux = new Pilha(pilha.size());
        int iMaior = 0;
        int maior = pilha.pop();

        aux.push(maior);
        index--;

        while(index >= 0){
            int atual = pilha.pop();
            
            if(atual > maior){
                maior = atual;
                iMaior = pilha.capacidade - index - 1;
                
            }
            aux.push(atual);
            index--;
        }

        while(!aux.isEmpty()){
            pilha.push(aux.pop());
        }
        //System.out.println(iMaior);
        //System.out.println(".");
        return iMaior;
    }*/

    public static int maxPilha(Pilha pilha, int index){

        Pilha pilha2 = new Pilha(pilha.size());
        for(int i = 0; i <= index; i++){
            int v = pilha.pop();
            pilha2.push(v);
        }

        int maior = pilha2.pop();
        int imaior = index;
        pilha.push(maior);

        while(!pilha2.isEmpty()){
            int valor = pilha2.pop();
            index--;
            if(valor > maior){
                maior = valor;
                imaior = index;
            }
            pilha.push(valor);
        }

        return imaior;
    }

    private static void invertePilha(Pilha pilha, int index) {
        ArrayDeque<Integer> aux = new ArrayDeque<>(pilha.size());
        //exibir(pilha);
        //aqui estou usando uma fila...
        while(index >= 0){
            aux.add(pilha.pop());
            index--;
        }

        while(!aux.isEmpty()){
            pilha.push(aux.removeFirst());
        }
    }

    private static void exibir(Pilha pilha){
        Pilha aux = new Pilha(pilha.size());
        
        // ao varrer uma pilha não podemos usar um FOR com o SIZE de controle, pois o size muda dinâmicamente a cada pop() realizado
        while(!pilha.isEmpty()){
            int valor = pilha.pop();
            System.out.println(valor);
            aux.push(valor);
        }

        while(!aux.isEmpty()){
            pilha.push(aux.pop());
        }
    }

}

class Pilha{
    int[] array;
    int topo;
    int size;
    int capacidade;

    public Pilha(int tamanho){
        array = new int[tamanho];
        topo = -1;
        size = 0;
        capacidade = tamanho;
    }

    public void push(int value){
        array[++topo] = value;
        size++;
    }

    public int pop(){
        int valor = array[topo];
        topo--;
        size--;
        return valor;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }


}
