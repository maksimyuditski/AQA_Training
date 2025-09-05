public class Factorial {
    
    //Вычисляет факториал числа итеративным методом
    public static long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал не определен для отрицательных чисел");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    //Вычисляет факториал числа рекурсивным методом
    public static long calculateFactorialRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал не определен для отрицательных чисел");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * calculateFactorialRecursive(n - 1);
    }
    
    public static void main(String[] args) {
        int number = 5;
        System.out.println("Факториал " + number + " (итеративно) = " + calculateFactorial(number));
        System.out.println("Факториал " + number + " (рекурсивно) = " + calculateFactorialRecursive(number));
    }
}