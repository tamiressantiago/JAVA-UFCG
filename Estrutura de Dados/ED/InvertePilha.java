import java.util.ArrayDeque;
import java.util.Scanner;

class InvertePilha{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        String[] entrada = sc.nextLine().split(" ");
        int index = sc.nextInt();
        
        ArrayDeque<Integer> pilha = new ArrayDeque<>(size);
        for(String s: entrada){
            pilha.push(Integer.parseInt(s));
        }

        invertePilha(pilha, index);
        System.out.println("-");
        exibir(pilha);
        
        }
        
    private static void invertePilha(ArrayDeque<Integer> pilha, int index) {
        ArrayDeque<Integer> aux = new ArrayDeque<>(pilha.size());
        
        while(index >= 0){
            aux.add(pilha.pop());
            index--;
        }

        while(!aux.isEmpty()){
            pilha.push(aux.removeFirst());
        }
    }

    private static void exibir(ArrayDeque<Integer> pilha){
        ArrayDeque<Integer> aux = new ArrayDeque<>(pilha.size());
        
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