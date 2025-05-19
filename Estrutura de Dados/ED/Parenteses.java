import java.util.Scanner;

class Parenteses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split("");
        sc.close();
        System.out.println(parenteses(entrada));
    }

    public static String parenteses(String[] entrada){
        Pilha pilha = new Pilha(entrada.length);
        for(String s: entrada){
            if(s.equals("("))
                pilha.push(s);
            else if(s.equals(")")){
                String remocao = pilha.pop();
                if(remocao.equals("N"))
                    return "N";
            }
        }

        if(pilha.isEmpty())
            return "S";
        return "N";
    }
}

class Pilha{
    String[] pilha;
    int topo;
    int size;

    Pilha(int tamanho){
        pilha = new String[tamanho];
        topo = -1;
        size = 0;
    }

    public void push(String elemento){
        pilha[++topo] = elemento;
        size++;
    }

    public String pop(){
        if(!isEmpty()){
            String elemento = pilha[topo--];
            size--;
            return elemento;
        }
        return "N";
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }
}
