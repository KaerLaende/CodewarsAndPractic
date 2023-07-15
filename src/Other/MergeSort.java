package Other;


/*

 */
public class MergeSort {
    public static void merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        // создаем временные массивы
        int[] L = new int[n1];
        int[] R = new int[n2];
        // копируем данные во временные массивы L[] и R[]
        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = A[q + 1 + j];
        }
        // сливаем временные массивы обратно в A[p..r]
        int i = 0; // начальный индекс первого подмассива
        int j = 0; // начальный индекс второго подмассива
        int k = p; // начальный индекс смерженного подмассива
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }
        // копируем оставшиеся элементы L[], если таковые есть
        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }
        // копируем оставшиеся элементы R[], если таковые есть
        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9};
        merge(array, 0, 1, 4);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}