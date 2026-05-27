package estructuradatos_tareaunidad4;

public class FibonacciComparison {

    // Solución Genérica (Recursiva) - O(2^n)
    public static long fibonacciGeneric(int n) {
        if (n <= 1) return n;
        return fibonacciGeneric(n - 1) + fibonacciGeneric(n - 2);
    }

    // Solución Optimizada (Bottom-Up) - O(n)
    public static long fibonacciOptimized(int n) {
        if (n <= 1) return n;
        long a = 0, b = 1, c;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    } 
} 
