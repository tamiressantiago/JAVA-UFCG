import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayDeque;

class remocaoBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");

        BST bst = new BST();
        for(String s : entrada){
            bst.add(Integer.parseInt(s));
        }

       System.out.println(bst.bfs());
        
    }
}

class BST{
    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public String bfs(){
        ArrayDeque<Node> fila = new ArrayDeque<>();
        String bfs = "";
    
        fila.addLast(root);
        while(!fila.isEmpty()){
            Node atual = fila.removeFirst();
            bfs += atual.value + " ";

            if(atual.left != null)
                fila.addLast(atual.left);
            if(atual.right != null)
                fila.addLast(atual.right);
        }
        return bfs.trim();
    }

    public String dfs(){
        ArrayDeque<Node> pilha = new ArrayDeque<>();
        String dfs = "";

        pilha.push(root);
        while(!pilha.isEmpty()){
            Node atual = pilha.pop();
            dfs += atual.value + " ";

            if(atual.left != null)
                pilha.push(atual.left);
            if(atual.right != null)
                pilha.push(atual.right);
        }

        return dfs;
    }


    public boolean isEmpty(){
        return root == null;
    }

    public int altura(){
        return altura(root);
    }

    private int altura(Node node){
        if(node == null) return -1;
        return 1 + Math.max(altura(node.left), altura(node.right));
    }

    public void add(int n){
        Node newNode = new Node(n);
        if(root == null)
            root = newNode;
        else
           add(newNode, root);

        size++;
    }

    private void add(Node newNode, Node atual){
        if(newNode.value < atual.value){
            if(atual.left == null){
                atual.left = newNode;
                newNode.parent = atual;
                return;
            }
                add(newNode, atual.left);
        }
        else{
            if(atual.right == null){
                atual.right = newNode;
                newNode.parent = atual;
                return;
            }
                add(newNode, atual.right);
        }

    }

    public void remove(int v){
        Node toRemove = search(v);
        if(toRemove != null){
            remove(toRemove);
            size--;
        }

    }

    public Node remove(Node toRemove){
        //primeiro caso: o nó é uma folha
        if (toRemove.isLeaf()) {
            if (toRemove == this.root)
                this.root = null;
            else {
                if (toRemove.value < toRemove.parent.value)
                    toRemove.parent.left = null;
                else
                    toRemove.parent.right = null;
            }

        //segundo caso: o nó tem apenas um filho
        } else if (toRemove.hasOnlyLeftChild()) {
            if (toRemove == this.root)  {
                this.root = toRemove.left;
                this.root.parent = null;
            } else {
                toRemove.left.parent = toRemove.parent;
                if (toRemove.value < toRemove.parent.value)
                    toRemove.parent.left = toRemove.left;
                else
                    toRemove.parent.right = toRemove.left;
            }
        } else if (toRemove.hasOnlyRightChild()) {
            if (toRemove == this.root) {
                this.root = toRemove.right;
                this.root.parent = null;
            } else {
                toRemove.right.parent = toRemove.parent;
                if (toRemove.value < toRemove.parent.value)
                    toRemove.parent.left = toRemove.right;
                else
                    toRemove.parent.right = toRemove.right;
            }   

        //terceiro caso: o nó tem dois filhos
        } else {
            Node sucessor = sucessor(toRemove);
            toRemove.value = sucessor.value;
            remove(sucessor);
        }

        return toRemove;

    }

    public Node sucessor(Node node){
        if(node == null) return null;

        if(node.right != null)
            return min(node.right);
        else{
            Node aux = node.parent;
            while(aux != null && aux.value < node.value){
                aux = aux.parent;
            }
            return aux;
        }
    }

    public Node min(){
        if(isEmpty()) return null;
        return min(root);
    }

    private Node min(Node root){    
        Node min = root;
        while(min.left != null)
            min = min.left;
        
        return min;
    }

    public Node search(int v){
        return search(v, root);
    }

    private Node search(int v, Node atual){
        if(atual == null) return null;
        if(atual.value == v) return atual;
        if(v > atual.value) return search(v, atual.right);
        else return search(v, atual.left);
    }

    public List preOrdem() {
        ArrayList<Integer> preOrdem = new ArrayList<>();
        return preOrdem(root, preOrdem);
    }

    private List preOrdem(Node atual, List<Integer> saida){
        if(atual != null){
            saida.add(atual.value);
            preOrdem(atual.left, saida);
            preOrdem(atual.right, saida);
        }

        return saida;
    }

    public List emOrdem(){
        ArrayList<Integer> emOrdem = new ArrayList<>();
        return emOrdem(root, emOrdem);
    }

    private List emOrdem(Node atual, List<Integer> saida){
        if(atual != null){
            emOrdem(atual.left, saida);
            saida.add(atual.value);
            emOrdem(atual.right, saida);
        }

        return saida;
    }

    public List posOrdem(){
        ArrayList<Integer> posOrdem = new ArrayList<>();
        return posOrdem(root, posOrdem);
    }

    private List posOrdem(Node atual, List<Integer> saida){
        if(atual != null){
            posOrdem(atual.left, saida);
            posOrdem(atual.right, saida);
            saida.add(atual.value);
        }

        return saida;
    }
}

class Node{
    int value;
    Node left;
    Node right;
    Node parent;

    public Node(int value){
        this.value = value;
    }

    public boolean isLeaf(){
        return left == null && right == null;
    }

    public boolean hasOnlyLeftChild(){
        return left != null && right == null;
    }

    public boolean hasOnlyRightChild(){
        return left == null && right != null;
    }
}