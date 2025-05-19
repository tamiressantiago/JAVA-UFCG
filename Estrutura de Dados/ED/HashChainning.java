import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Iterator;

class HashChainning{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tamanho = sc.nextInt();
        tabelaHash tabela = new tabelaHash(tamanho);
        String[] comando = new String[3];
        sc.nextLine();
        do{
            comando = sc.nextLine().split(" ");
            if(comando[0].equals("put"))
                tabela.put(Integer.parseInt(comando[1]), comando[2]);
            else if(comando[0].equals("remove"))
                tabela.remover(Integer.parseInt(comando[1]));
            else if(comando[0].equals("keys"))
                tabela.keys();
            else if(comando[0].equals("values"))
                tabela.values();

        } while(!comando[0].equals("end"));
    }

}

class tabelaHash{
    private ArrayList<Pair>[] tabela;
    private int size;
    private int qnt;

    public tabelaHash(int tamanho){
        tabela = new ArrayList[tamanho];
        size = tamanho;
    }

    private int hash(int chave){
        return chave % size;
    }

    public void put(int chave, String valor){
        int indice = hash(chave);
        Pair novo = new Pair(chave, valor);

        //iniciando o primeiro arrayList
        if(tabela[indice] == null)
            tabela[indice] = new ArrayList<Pair>();

        //verificar se já existe o elemento
        if(!containsKey(chave)){
            tabela[indice].add(novo);
            qnt++;
        }
        //se o elemento já existir, atualizamos o valor
        else{ 
            for(Pair p: tabela[indice]){
                if(p.chave == chave)
                    p.valor = valor;
            }
        }

        estado();
    }

    public void remover(int chave) {
        int indice = hash(chave);
    
        if (tabela[indice] != null) { // Evita erro de acessar lista nula
            Iterator<Pair> iterador = tabela[indice].iterator();
            
            while (iterador.hasNext()) {
                Pair p = iterador.next();
                if (p.chave == chave) {
                    iterador.remove(); // Remove com segurança
                    qnt--; // Atualiza a quantidade de elementos
                    break; // Para a busca após remover
                }
            }
        }
    
        estado(); // Mostra o estado atualizado da tabela
    }

    public void keys(){
        int[] saida = new int[qnt];
        int i = 0;

        for(ArrayList<Pair> array: tabela){
            if(array != null){
                for(Pair p: array){
                    saida[i] = p.chave;
                    i++;
                }
            }
        }
        Arrays.sort(saida);
        System.out.println(Arrays.toString(saida));
    }

    public void values(){
        String[] saida = new String[qnt];
        int i = 0;
        for(ArrayList<Pair> array: tabela){
            if(array != null){
                for(Pair p: array){
                    saida[i] = p.valor;
                    i++;
                }

            }
        }
        Arrays.sort(saida);
        System.out.println(Arrays.toString(saida));
    }

    public void estado() {
        System.out.println(
            Arrays.toString(
                Arrays.stream(tabela)
                    .map(lista -> lista == null || lista.isEmpty() ? "[]" :
                        "[" + lista.stream()
                            .map(p -> "<" + p.chave + ", " + p.valor + ">")
                            .collect(Collectors.joining(", ")) + "]"
                    )
                    .toArray()
            )
        );
    }
    



    public boolean containsKey(int chave){
        int indice = hash(chave);
        for(Pair p : tabela[indice]){
            if(p.chave == chave)
                return true;
        }

        return false;

    }
}

class Pair{
    int chave;
    String valor;

    public Pair(int chave, String valor){
        this.chave = chave;
        this.valor = valor;
    }
}