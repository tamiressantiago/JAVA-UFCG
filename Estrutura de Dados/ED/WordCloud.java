import java.util.HashMap;
import java.util.Scanner;

class WordCloud{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        Cloud wc = new Cloud(entrada);
        String comando = sc.nextLine();
        while(!comando.equals("fim")){
            System.out.println(wc.getQuantidade(comando));
            comando = sc.nextLine();

        } 
    }
}

class Cloud{
    HashMap<String, Integer> mapa;

    public Cloud(String[] seq){
        mapa = new HashMap<>();
        for(String s : seq){
            if(!mapa.containsKey(s))
                mapa.put(s, 1);
            else{
                Integer incrementar = mapa.get(s) + 1;
                mapa.replace(s, incrementar);
            }
        }
    }

    public Integer getQuantidade(String chave){
        return mapa.get(chave);
    }

}

