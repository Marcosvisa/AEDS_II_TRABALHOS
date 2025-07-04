public class QuickSort {

    public static void quicksort(int[] array, int esq, int dir) {
        int i = esq, j = dir;
        int pivo = array[(esq + dir) / 2];

        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;

            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }

        if (esq < j) quicksort(array, esq, j);
        if (i < dir) quicksort(array, i, dir);
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {3, 0, 5, 2, 9};

        quicksort(array, 0, array.length - 1);

        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
