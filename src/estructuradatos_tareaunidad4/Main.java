package estructuradatos_tareaunidad4;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        MatrixManager matrixManager = new MatrixManager();
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean isSorted = false;

        System.out.println("=== TAREA UNIDAD 4: TEORÍA DE LA COMPLEJIDAD ===");
        System.out.println("Generando matriz de 1000x1000...");
        matrixManager.generateMatrix();
        System.out.println("Matriz generada exitosamente.\n");

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Búsqueda de número x y -x");
            System.out.println("2. Ordenar elementos de la matriz");
            System.out.println("3. Ejecutar Problema de Programación (Fibonacci)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    searchMenu(matrixManager, scanner, isSorted);
                    break;
                case 2:
                    sortMenu(matrixManager);
                    isSorted = true;
                    break;
                case 3:
                    fibonacciMenu(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (option != 4);
        scanner.close();
    }

    private static void searchMenu(MatrixManager matrixManager, Scanner scanner, boolean isSorted) {
        System.out.print("Ingrese el número x a buscar: ");
        int x = scanner.nextInt();
        
        int[][] matrix2D = matrixManager.getMatrix();
        int[] arr1D = matrixManager.getFlattenedArray();

        // Secuencial sobre Matriz 2D
        long startTime = System.nanoTime();
        String resultSeq = SearchAlgorithms.sequentialSearch2D(matrix2D, x);
        long endTime = System.nanoTime();
        System.out.printf("Búsqueda Secuencial O(n) [Matriz 2D]: %s. Tiempo: %.4f ms%n",
                resultSeq, (endTime - startTime) / 1_000_000.0);

        if (isSorted) {
            // Binaria
            startTime = System.nanoTime();
            int posBinX = SearchAlgorithms.binarySearch(arr1D, x);
            int posBinNegX = SearchAlgorithms.binarySearch(arr1D, -x);
            endTime = System.nanoTime();
            System.out.printf("Búsqueda Binaria O(log n) [Arreglo 1D]: x %s, -x %s. Tiempo: %.4f ms%n",
                    posBinX != -1 ? "Encontrado" : "No encontrado",
                    posBinNegX != -1 ? "Encontrado" : "No encontrado",
                    (endTime - startTime) / 1_000_000.0);

            // Interpolación
            startTime = System.nanoTime();
            int posIntX = SearchAlgorithms.interpolationSearch(arr1D, x);
            int posIntNegX = SearchAlgorithms.interpolationSearch(arr1D, -x);
            endTime = System.nanoTime();
            System.out.printf("Búsqueda Interpolación O(log log n) [Arreglo 1D]: x %s, -x %s. Tiempo: %.4f ms%n",
                    posIntX != -1 ? "Encontrado" : "No encontrado",
                    posIntNegX != -1 ? "Encontrado" : "No encontrado",
                    (endTime - startTime) / 1_000_000.0);
        } else {
            System.out.println("NOTA: Para usar Búsqueda Binaria e Interpolación, primero debe ordenar la matriz (Opción 2).");
        }
    }

    private static void sortMenu(MatrixManager matrixManager) {
        int[] originalArr = matrixManager.getFlattenedArray();
        String[] algorithms = {"Bubble Sort", "Insertion Sort", "Merge Sort", "Shell Sort", "Counting Sort", "Radix Sort"};

        for (String algo : algorithms) {
            // CORRECCIÓN: Usamos .clone() para que cada algoritmo ordene desde cero
            int[] copyArr = originalArr.clone(); 
            
            long startTime = System.nanoTime();
            long usedMemoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            switch (algo) {
                case "Bubble Sort":
                    System.out.println("Ejecutando Bubble Sort (O(n^2) - Esto tardará minutos)...");
                    SortAlgorithms.bubbleSort(copyArr);
                    break;
                case "Insertion Sort":
                    System.out.println("Ejecutando Insertion Sort (O(n^2) - Esto tardará minutos)...");
                    SortAlgorithms.insertionSort(copyArr);
                    break;
                case "Merge Sort":
                    SortAlgorithms.mergeSort(copyArr, 0, copyArr.length - 1);
                    break;
                case "Shell Sort":
                    SortAlgorithms.shellSort(copyArr);
                    break;
                case "Counting Sort":
                    SortAlgorithms.countingSort(copyArr); // Ya no devuelve un arreglo nuevo
                    break;
                case "Radix Sort":
                    SortAlgorithms.radixSort(copyArr);
                    break;
            }

            long endTime = System.nanoTime();
            long usedMemoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            double timeMs = (endTime - startTime) / 1_000_000.0;
            long memoryUsed = Math.max(0, usedMemoryAfter - usedMemoryBefore);

            System.out.printf("- %s: Tiempo = %.4f ms | Memoria aprox. usada = %d bytes%n", algo, timeMs, memoryUsed);
            
            // Actualizamos la matriz con el último arreglo ordenado (Radix o Merge, los más eficientes)
            if (algo.equals("Radix Sort") || algo.equals("Merge Sort")) {
                matrixManager.updateFlattenedArray(copyArr);
            }
        }
        System.out.println("Ordenamiento completado. La matriz interna ahora está ordenada.");
    }

    private static void fibonacciMenu(Scanner scanner) {
        System.out.print("Ingrese el valor de n para Fibonacci (ej. 40 para notar la diferencia): ");
        int n = scanner.nextInt();

        System.out.println("Ejecutando Solución Genérica O(2^n)...");
        long startTime = System.nanoTime();
        long resultGen = FibonacciComparison.fibonacciGeneric(n);
        long endTime = System.nanoTime();
        System.out.printf("Resultado Genérico: %d | Tiempo: %.4f ms%n", resultGen, (endTime - startTime) / 1_000_000.0);

        System.out.println("Ejecutando Solución Optimizada O(n)...");
        startTime = System.nanoTime();
        long resultOpt = FibonacciComparison.fibonacciOptimized(n);
        endTime = System.nanoTime();
        System.out.printf("Resultado Optimizado: %d | Tiempo: %.4f ms%n", resultOpt, (endTime - startTime) / 1_000_000.0);
    }
}


