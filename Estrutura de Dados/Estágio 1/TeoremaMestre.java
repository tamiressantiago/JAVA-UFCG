import java.util.Scanner;
public class TeoremaMestre
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] num = sc.nextLine().split(" ");
        System.out.println(teoremaMestre(num));

    }

    public static String teoremaMestre(String[] num){
       int a = Integer.parseInt(num[0]);
       int b = Integer.parseInt(num[1]);
       int c = Integer.parseInt(num[2]);

       if(c < logBaseB(a,b))
            return "T(n) = theta(n**"+(int) logBaseB(a,b)+")";
       else if(c == logBaseB(a,b))
            return "T(n) = theta(n**"+c+" * log n)";
        else
            return "T(n) = theta(n**"+c+")";
    }

    public static double logBaseB(double a, double b) {
        return Math.log(a) / Math.log(b);
    }
}

