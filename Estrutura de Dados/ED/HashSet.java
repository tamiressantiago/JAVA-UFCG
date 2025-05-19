import java.util.Arrays;
import java.util.Scanner;

class HashSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        Set hs = new Set(size);
        
        String[] comando = new String[2];
        do{
            comando = sc.nextLine().split(" ");
            if(comando[0].equals("put"))
                System.out.println(Arrays.toString(hs.put(comando[1])));
            else if(comando[0].equals("remove"))
                System.out.println(Arrays.toString(hs.remove(comando[1])));
            else if(comando[0].equals("contains"))
                System.out.println(hs.contains(comando[1]));

        } while(!comando[0].equals("end"));
    }
}

class Set {
    private String[] array;

    public Set(int tamanho){
        array = new String[tamanho];
    }

    private int hash(int valor){
        return valor % array.length;
    }

    public String[] put(String valor){
        if(!contains(valor)){
            int sondagem = 0;
            
            while(sondagem < array.length){
                int indice = (hash(Integer.parseInt(valor)) + sondagem) % array.length;
                
                if(array[indice] == null){
                    array[indice] = valor;
                    return array;
                }
                sondagem++;
            }

        }
 
        return array;
    }

    public String[] remove(String valor) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(valor)) {
                array[i] = null;
            }
        }
        return array;
    }

    public boolean contains(String valor){
        for(String s : array){
            if(s != null && s.equals(valor))
                return true;
        }
        return false;
    }
}
