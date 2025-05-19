import java.util.Scanner;
public class FibonacciRecursivo{
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    System.out.println(FibonacciRecursivo(n));
  }
  
  public static int FibonacciRecursivo(int n){
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        return FibonacciRecursivo(n-1) + FibonacciRecursivo(n-2);
    }
    
}
