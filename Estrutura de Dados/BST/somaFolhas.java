import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class somaFolhas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");

        BST bst = new BST();
        for(String s : entrada){
            bst.add(Integer.parseInt(s));
        }

        System.out.println(bst.contaFolhas());
        
    }


}

class BST{

    Node root;
    int size;

    public BST(){
        root = null;
        size = 0;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void add(int v) {
        Node newNode = new Node(v);
        if (root == null) {
            root = newNode;
        } else {
            add(newNode, root);
        }
        size++;
    }

    private void add(Node newNode, Node destino) {
        if (newNode.v < destino.v) {
            if (destino.left == null) {
                destino.left = newNode;
                newNode.parent = destino;
                return; // Atualiza o ponteiro parent
            } else {
                add(newNode, destino.left);
            }
        } else {
            if (destino.right == null) {
                destino.right = newNode;
                newNode.parent = destino;
                return; // Atualiza o ponteiro parent
            } else {
                add(newNode, destino.right);
            }
        }
    }


    public Node search(int v){
        if(!isEmpty()){
            return search(root, v);
        }

        return null;
    }

    private Node search(Node node, int elemento){
        if(node == null) return null;
        if(node.v == elemento) return node;
        else if(elemento > node.v) return search(node.right, elemento);
        else return search(node.left, elemento);
    }


    public Node max(){
        if(!isEmpty()){
            return max(root);
        }
        return null;
    }

    private Node max(Node node){
        if(node.right == null) return node;
        else return max(node.right);
    }

    public ArrayList<Integer> predecessor(int v){
        Node node = search(v);
        ArrayList<Integer> caminho = new ArrayList<>();

        if(node == null) return null;

        caminho.add(node.v);

        if(node.left != null){
            caminho.add(node.left.v);
            caminho.add(max(node.left).v);
        }else{
            Node aux = node.parent;
            while(aux != null && aux.v > node.v){
                caminho.add(aux.v);
                aux = aux.parent;
            }
        }

        return caminho;
    }

    public String bfs(){
        ArrayDeque<Node> fila = new ArrayDeque<>();
        String largura = "";

        fila.addLast(root);

        while(!fila.isEmpty()){
            Node atual = fila.removeFirst();
            largura += atual.v + " ";
            
            if(atual.right != null)
                fila.addLast(atual.right);
            if(atual.left != null)
                fila.addLast(atual.left);
        }

        return largura.trim();
    }

    public int contaFolhas() {
        return contaFolhas(root);
    }

    private int contaFolhas(Node node){
        if(node == null)
            return 0;
        if(node.left == null && node.right == null)
            return node.v;
        return (contaFolhas(node.left) + contaFolhas(node.right));
    }

}

class Node{
    int v;
    Node left;
    Node right;
    Node parent;

    public Node(int v){
        this.v = v;
    }

    public boolean isLeaf(){
        return left == null && right == null;
    }

    public boolean onlyLeftChild(){
        return left != null && right == null;
    }

    public boolean onlyRightChild(){
        return left == null && right != null;
    }
}

