import java.util.Scanner;

public class primeiroNegativo{

public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    String[] entrada = sc.nextLine().split(" ");
    System.out.println(encontraPrimeiroNegativo(entrada, 0));

}

public static String encontraPrimeiroNegativo(String[] seq, int indice){
    if(indice < seq.length){
        if(Integer.parseInt(seq[indice]) < 0)
            return seq[indice];
        return encontraPrimeiroNegativo(seq, ++indice);
    }

    return "-"; 
}
}
