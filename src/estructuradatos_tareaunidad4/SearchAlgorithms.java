package estructuradatos_tareaunidad4;

/**
 * Clase que implementa algoritmos de búsqueda y evalúa su rendimiento.
 */
public class SearchAlgorithms {
    /**
     * Búsqueda Secuencial en Matriz 2D - Complejidad O(n^2) respecto a la dimensión.
     * Busca x y -x simultáneamente en la estructura bidimensional original.
     */
    public static String sequentialSearch2D(int[][] matrix, int x) {
        boolean foundX = false;
        boolean foundNegX = false;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == x) foundX = true;
                if (matrix[i][j] == -x) foundNegX = true;
                
                if (foundX && foundNegX) {
                    return "x Sí, -x Sí";
                }
            }
        }
        return "x " + (foundX ? "Encontrado" : "No encontrado") + 
            ", -x " + (foundNegX ? "Encontrado" : "No encontrado");
    }

    /**
     * Búsqueda Binaria - Complejidad O(log n). Requiere arreglo 1D ordenado.
     */
    public static int binarySearch(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) return mid;
            if (arr[mid] < x) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    /**
     * Búsqueda por Interpolación - Complejidad O(log log n) promedio.
     * Requiere arreglo 1D ordenado y valores uniformemente distribuidos.
     */
    public static int interpolationSearch(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right && x >= arr[left] && x <= arr[right]) {
            if (left == right) {
                if (arr[left] == x) return left;
                return -1;
            }
            int pos = left + ((x - arr[left]) * (right - left)) / (arr[right] - arr[left]);
            if (pos < 0 || pos >= arr.length) break;
            
            if (arr[pos] == x) return pos;
            if (arr[pos] < x) left = pos + 1;
            else right = pos - 1;
        }
        return -1;
    }
}

