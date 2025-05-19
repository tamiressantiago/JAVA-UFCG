import java.util.Scanner;

public class TemRepetido {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    String[] seq = sc.nextLine().split(" ");
    System.out.println(temRepetido(seq));
  }
  
  public static boolean temRepetido(String[] seq){
      for(int i = 0; i < seq.length; i++){
          for(int j = i + 1; j < seq.length; j++){
              if(seq[i].equals(seq[j]))
                return true;
          }
      }
      return false;
  }
}
