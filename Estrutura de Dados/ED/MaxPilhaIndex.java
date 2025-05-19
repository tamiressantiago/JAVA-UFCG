import java.util.Scanner;

class MaxPilhaIndex {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int index = sc.nextInt();
        
        Pilha pilha = new Pilha(entrada.length);
        for(String s: entrada){
            pilha.push(Integer.parseInt(s));
        }

        System.out.println(maxPilha(pilha, index));
        
    }

    public static int maxPilha(Pilha pilha, int index){
        Pilha aux = new Pilha(pilha.size());
        int maior = pilha.pop();
        aux.push(maior);
        index--;

        while(index >= 0){
            int atual = pilha.pop();
            if(atual > maior)
                maior = atual;
            aux.push(atual);
            index--;
        }

        while(!aux.isEmpty()){
            pilha.push(aux.pop());
        }

        return maior;
    }
}

class Pilha{

    int[] pilha;
    int topo;
    int size;

    Pilha(int tamanho){
        pilha = new int[tamanho];
        topo = -1;
        size = 0;
    }

    public void push(int valor){
        pilha[++topo] = valor;
        size++;
    }

    public int size(){
        return size;
    }

    public int pop(){
        int valor = pilha[topo];
        topo--;
        size--;
        return valor;
    }

    public boolean isEmpty(){
        return size == 0;
    }

}
