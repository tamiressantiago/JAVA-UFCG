import java.util.Scanner;
public class buscaLinearRecursiva {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    String[] entrada = sc.nextLine().split(" ");
    int n = sc.nextInt();

    System.out.println(buscaLinearRecursiva(entrada, n, 0));
  }
  
  public static int buscaLinearRecursiva(String[] seq, int n, int indice){
      if(indice < seq.length){
        if(Integer.parseInt(seq[indice]) == n)
            return indice;
        return buscaLinearRecursiva(seq, n, ++indice);
      }
      return -1;
  }
  
}
