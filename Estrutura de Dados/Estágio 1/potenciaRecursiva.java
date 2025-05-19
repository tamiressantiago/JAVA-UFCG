import java.util.Scanner;
public class potenciaRecursiva {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int i = sc.nextInt();
    int j = sc.nextInt();

    System.out.println(potenciaRecursiva(i, j));
  }
  
  public static int potenciaRecursiva(int i, int j){
      if(j == 0)
        return 1;
      
      return potenciaRecursiva(i, --j) * i;
      
  }
  
}
