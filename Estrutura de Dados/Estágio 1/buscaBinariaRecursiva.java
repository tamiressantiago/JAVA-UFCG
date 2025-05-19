import java.util.Scanner;
public class buscaBinariaRecursiva {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    String[] seq = sc.nextLine().split(" ");
    String n = sc.nextLine();

    System.out.println(buscaBinariaRecursiva(seq, n, 0, seq.length -1));
  }
  
  public static int buscaBinariaRecursiva(String[] seq, String n, int ini, int fim){
      int meio = (ini + fim) / 2;
      if(ini <= fim){
        if(seq[meio].equals(n))
            return meio;
        
        System.out.println(meio);
        
        if(Integer.parseInt(n) < Integer.parseInt(seq[meio]))
            return buscaBinariaRecursiva(seq, n, ini, meio - 1);
        return buscaBinariaRecursiva(seq, n, meio + 1, fim);
      }
      else
        return -1;
  }
  
}
