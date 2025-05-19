import java.util.Scanner;

public class Primo{

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(primo(n));
	}

	public static boolean primo(int n){
		int c = 2;
		while ( c < n ) {
			if ( n % c == 0 ) {
				return false;
			}
			c++;
		}
		return true;

}

}


