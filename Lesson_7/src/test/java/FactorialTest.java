import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты для класса Factorial")
class FactorialTest {
    
    @Test
    @DisplayName("Тест факториала для положительных чисел")
    void testCalculateFactorialPositive() {
        assertEquals(1, Factorial.calculateFactorial(0), "Факториал 0 должен быть 1");
        assertEquals(1, Factorial.calculateFactorial(1), "Факториал 1 должен быть 1");
        assertEquals(2, Factorial.calculateFactorial(2), "Факториал 2 должен быть 2");
        assertEquals(6, Factorial.calculateFactorial(3), "Факториал 3 должен быть 6");
        assertEquals(24, Factorial.calculateFactorial(4), "Факториал 4 должен быть 24");
        assertEquals(120, Factorial.calculateFactorial(5), "Факториал 5 должен быть 120");
        assertEquals(720, Factorial.calculateFactorial(6), "Факториал 6 должен быть 720");
        assertEquals(5040, Factorial.calculateFactorial(7), "Факториал 7 должен быть 5040");
    }
    
    @Test
    @DisplayName("Тест факториала для отрицательных чисел")
    void testCalculateFactorialNegative() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Factorial.calculateFactorial(-1);
        }, "Должно выбрасываться исключение для отрицательных чисел");
        
        assertEquals("Факториал не определен для отрицательных чисел", exception.getMessage());
        
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.calculateFactorial(-5);
        }, "Должно выбрасываться исключение для отрицательных чисел");
        
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.calculateFactorial(-100);
        }, "Должно выбрасываться исключение для больших отрицательных чисел");
    }
    
    @Test
    @DisplayName("Тест рекурсивного факториала для положительных чисел")
    void testCalculateFactorialRecursivePositive() {
        assertEquals(1, Factorial.calculateFactorialRecursive(0), "Рекурсивный факториал 0 должен быть 1");
        assertEquals(1, Factorial.calculateFactorialRecursive(1), "Рекурсивный факториал 1 должен быть 1");
        assertEquals(2, Factorial.calculateFactorialRecursive(2), "Рекурсивный факториал 2 должен быть 2");
        assertEquals(6, Factorial.calculateFactorialRecursive(3), "Рекурсивный факториал 3 должен быть 6");
        assertEquals(24, Factorial.calculateFactorialRecursive(4), "Рекурсивный факториал 4 должен быть 24");
        assertEquals(120, Factorial.calculateFactorialRecursive(5), "Рекурсивный факториал 5 должен быть 120");
        assertEquals(720, Factorial.calculateFactorialRecursive(6), "Рекурсивный факториал 6 должен быть 720");
        assertEquals(5040, Factorial.calculateFactorialRecursive(7), "Рекурсивный факториал 7 должен быть 5040");
    }
    
    @Test
    @DisplayName("Тест рекурсивного факториала для отрицательных чисел")
    void testCalculateFactorialRecursiveNegative() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Factorial.calculateFactorialRecursive(-1);
        }, "Должно выбрасываться исключение для отрицательных чисел");
        
        assertEquals("Факториал не определен для отрицательных чисел", exception.getMessage());
        
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.calculateFactorialRecursive(-3);
        }, "Должно выбрасываться исключение для отрицательных чисел");
    }
    
    @Test
    @DisplayName("Сравнение итеративного и рекурсивного методов")
    void testIterativeVsRecursive() {
        for (int i = 0; i <= 10; i++) {
            assertEquals(Factorial.calculateFactorial(i), Factorial.calculateFactorialRecursive(i), 
                        "Итеративный и рекурсивный методы должны давать одинаковый результат для " + i);
        }
    }
    
    @Test
    @DisplayName("Тест граничных случаев")
    void testBoundaryValues() {
        // Тест минимальных значений
        assertEquals(1, Factorial.calculateFactorial(0));
        assertEquals(1, Factorial.calculateFactorial(1));
        assertEquals(1, Factorial.calculateFactorialRecursive(0));
        assertEquals(1, Factorial.calculateFactorialRecursive(1));
        
        // Тест больших значений (в пределах разумного)
        long factorial10 = 3628800L;
        assertEquals(factorial10, Factorial.calculateFactorial(10));
        assertEquals(factorial10, Factorial.calculateFactorialRecursive(10));
    }
}