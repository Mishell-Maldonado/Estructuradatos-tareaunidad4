package estructuradatos_tareaunidad4;
    import java.util.Random;

/**
 * Clase encargada de generar y manejar la matriz de números aleatorios.
 */
public class MatrixManager {
    private int[][] matrix;
    private int[] flattenedArray;
    private final int ROWS = 1000;
    private final int COLS = 1000;

    public MatrixManager() {
        matrix = new int[ROWS][COLS];
        flattenedArray = new int[ROWS * COLS];
    }

    /**
     * Genera la matriz 1000x1000 con números aleatorios entre -100000 y 100000.
     * Rango limitado a 100000 para garantizar que Counting Sort sea viable en memoria
     * y que el desplazamiento en Radix Sort no cause Integer Overflow.
     */
    public void generateMatrix() {
        Random random = new Random();
        int index = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                matrix[i][j] = random.nextInt(200001) - 100000; 
                flattenedArray[index++] = matrix[i][j];
            }
        }
    }

    // NUEVO: Getter para la matriz bidimensional original
    public int[][] getMatrix() {
        return matrix;
    }

    public int[] getFlattenedArray() {
        return flattenedArray;
    }

    public void updateFlattenedArray(int[] sortedArray) {
        this.flattenedArray = sortedArray;
    }
}

