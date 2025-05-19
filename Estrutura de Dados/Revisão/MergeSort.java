public class MergeSort{

    public void mergeSort(int[] v, int ini, int fim){
        if(ini < fim){ //condição de parada, pois o mergeSort é recursivo
            int meio = (fim + ini) / 2;

            mergeSort(v, ini, meio);
            mergeSort(v, meio+1, fim);
            merge(v, ini, meio, fim);
        }
}
            
    private void merge(int[] v, int ini, int meio, int fim) {
        //merge utiliza memória auxiliar
        int[] helper = new int[v.length]; //array auxiliar para acessar os valores sem se preocupar com sobrescrita
        for(int i = 0; i < v.length; i++){
            helper[i] = v[i];
        }

        int i = ini; //indice para a primeira metade do array
        int j = meio+1; //indice para a segunda metade do array
        int k = ini; //indice para o array auxiliar

        while(i <= meio && j <= fim){ //devemos tratar cada metade do array como um próprio, não podem ultrapassar seus "fins"
            if(helper[i] < helper[j]) //verificamos com o helper para ver o array íntegro
                v[k++] = helper[i++]; //adicionamos no nosso array v com auxílio do helper
            else
                v[k++] = helper[j++];
        }

        while(i <= meio){ //adicionar o restante, caso a ordenação do lado j não seja crescente é necessário adicionar ela também
            v[k++] = helper[i++];
        }
    
    }
}