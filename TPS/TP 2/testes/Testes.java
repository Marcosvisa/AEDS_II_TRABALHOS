package testes;
import java.util.Random;

public class Testes {

    static int contarComp=0, contarMov=0;
   public static void main(String args[]) {
    Random random = new Random();
        int n=100000;
        int []array=new int[n];

        for(int x=0; x<n; x++){
            array[x]=random.nextInt(100);
        }

        long inicio = System.nanoTime();
        

        //ordenacao
        quickSort(array, 0, n - 1);
        
        long fim = System.nanoTime();
        
       System.out.println("Tamanho do vetor: " +n);
       System.out.println("Tempo em ms: " + (fim - inicio) / 1_000_000.0);
       System.out.println("Numero de comparacoes: " +contarComp);
       System.out.println("Numero de movimentacoes: " +contarMov);
   }

   public static void quickSort(int[] array, int esq, int dir) {
    if (esq < dir) {
        int pivoIndex = particiona(array, esq, dir);
        quickSort(array, esq, pivoIndex - 1);
        quickSort(array, pivoIndex + 1, dir);
    }
}

public static int particiona(int[] array, int esq, int dir) {
    int pivo = array[dir];
    int i = esq - 1;

    for (int j = esq; j < dir; j++) {
        contarComp++;
        if (array[j] <= pivo) {
            i++;
            troca(array, i, j);
        }
    }

    troca(array, i + 1, dir);
    return i + 1;
}

public static void troca(int[] array, int i, int j) {
    if (i != j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        contarMov++;
    }
}

}
