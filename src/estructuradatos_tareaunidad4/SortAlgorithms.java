package estructuradatos_tareaunidad4;

import java.util.Arrays;
public class SortAlgorithms {

    // O(n^2) - Optimizado con bandera
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // O(n^2)
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i]; int j = i - 1;
            while (j >= 0 && arr[j] > key) { arr[j + 1] = arr[j]; j--; }
            arr[j + 1] = key;
        }
    }

    // O(n log n)
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid); mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] L = Arrays.copyOfRange(arr, left, mid + 1);
        int[] R = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int i = 0, j = 0, k = left;
        while (i < L.length && j < R.length) { if (L[i] <= R[j]) arr[k++] = L[i++]; else arr[k++] = R[j++]; }
        while (i < L.length) arr[k++] = L[i++];
        while (j < R.length) arr[k++] = R[j++];
    }

    // O(n log n) promedio
    public static void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i]; int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) arr[j] = arr[j - gap];
                arr[j] = temp;
            }
        }
    }

    // O(n + k) - Soporta negativos usando índice desfasado
    public static void countingSort(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int num : arr) { if (num < min) min = num; if (num > max) max = num; }
        int range = max - min + 1;
        int[] count = new int[range]; int[] output = new int[arr.length];
        for (int num : arr) count[num - min]++;
        for (int i = 1; i < range; i++) count[i] += count[i - 1];
        for (int i = arr.length - 1; i >= 0; i--) { output[count[arr[i] - min] - 1] = arr[i]; count[arr[i] - min]--; }
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    // O(d*(n+k)) - Soporta negativos desplazando a positivos
    public static void radixSort(int[] arr) {
        int min = arr[0];
        for (int num : arr) if (num < min) min = num;
        if (min < 0) { for (int i = 0; i < arr.length; i++) arr[i] -= min; }
        int max = arr[0];
        for (int num : arr) if (num > max) max = num;
        for (int exp = 1; max / exp > 0; exp *= 10) countingSortForRadix(arr, exp);
        if (min < 0) { for (int i = 0; i < arr.length; i++) arr[i] += min; }
    }
    private static void countingSortForRadix(int[] arr, int exp) {
        int[] output = new int[arr.length]; int[] count = new int[10];
        for (int num : arr) count[(num / exp) % 10]++;
        for (int i = 1; i < 10; i++) count[i] += count[i - 1];
        for (int i = arr.length - 1; i >= 0; i--) { output[count[(arr[i] / exp) % 10] - 1] = arr[i]; count[(arr[i] / exp) % 10]--; }
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}