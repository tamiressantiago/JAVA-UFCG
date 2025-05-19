import java.util.Scanner;
public class encontraQuebraRecursivo {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    String[] seq = sc.nextLine().split(" ");

    System.out.println(encontraQuebraRecursivo(seq, 1));
  }
  
  public static int encontraQuebraRecursivo(String[] seq, int indice){
      if(indice < seq.length){
          if(Integer.parseInt(seq[indice]) < Integer.parseInt(seq[indice-1]))
            return indice;
          return encontraQuebraRecursivo(seq, ++indice);
      }
      
      return -1;
      
  }
}
