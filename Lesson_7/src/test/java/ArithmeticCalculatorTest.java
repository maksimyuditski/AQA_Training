import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты для класса ArithmeticCalculator")
class ArithmeticCalculatorTest {
    
    private static final double DELTA = 0.001; // допустимая погрешность для double
    
    // === ТЕСТЫ ДЛЯ МЕТОДА ADD ===
    
    @Test
    @DisplayName("Тест сложения - положительные числа")
    void testAddPositiveNumbers() {
        assertEquals(5, ArithmeticCalculator.add(2, 3), "2 + 3 должно быть 5");
        assertEquals(10, ArithmeticCalculator.add(7, 3), "7 + 3 должно быть 10");
        assertEquals(100, ArithmeticCalculator.add(50, 50), "50 + 50 должно быть 100");
        assertEquals(1000, ArithmeticCalculator.add(999, 1), "999 + 1 должно быть 1000");
    }
    
    @Test
    @DisplayName("Тест сложения - отрицательные числа")
    void testAddNegativeNumbers() {
        assertEquals(-8, ArithmeticCalculator.add(-3, -5), "-3 + (-5) должно быть -8");
        assertEquals(-10, ArithmeticCalculator.add(-7, -3), "-7 + (-3) должно быть -10");
        assertEquals(-100, ArithmeticCalculator.add(-50, -50), "-50 + (-50) должно быть -100");
    }
    
    @Test
    @DisplayName("Тест сложения - смешанные числа")
    void testAddMixedNumbers() {
        assertEquals(0, ArithmeticCalculator.add(-5, 5), "-5 + 5 должно быть 0");
        assertEquals(2, ArithmeticCalculator.add(-3, 5), "-3 + 5 должно быть 2");
        assertEquals(-2, ArithmeticCalculator.add(3, -5), "3 + (-5) должно быть -2");
        assertEquals(-7, ArithmeticCalculator.add(-10, 3), "-10 + 3 должно быть -7");
    }
    
    @Test
    @DisplayName("Тест сложения - с нулем")
    void testAddWithZero() {
        assertEquals(0, ArithmeticCalculator.add(0, 0), "0 + 0 должно быть 0");
        assertEquals(5, ArithmeticCalculator.add(0, 5), "0 + 5 должно быть 5");
        assertEquals(5, ArithmeticCalculator.add(5, 0), "5 + 0 должно быть 5");
        assertEquals(-5, ArithmeticCalculator.add(0, -5), "0 + (-5) должно быть -5");
    }
    
    // === ТЕСТЫ ДЛЯ МЕТОДА SUBTRACT ===
    
    @Test
    @DisplayName("Тест вычитания - положительные числа")
    void testSubtractPositiveNumbers() {
        assertEquals(2, ArithmeticCalculator.subtract(5, 3), "5 - 3 должно быть 2");
        assertEquals(4, ArithmeticCalculator.subtract(7, 3), "7 - 3 должно быть 4");
        assertEquals(0, ArithmeticCalculator.subtract(50, 50), "50 - 50 должно быть 0");
        assertEquals(998, ArithmeticCalculator.subtract(999, 1), "999 - 1 должно быть 998");
        assertEquals(-2, ArithmeticCalculator.subtract(3, 5), "3 - 5 должно быть -2");
    }
    
    @Test
    @DisplayName("Тест вычитания - отрицательные числа")
    void testSubtractNegativeNumbers() {
        assertEquals(2, ArithmeticCalculator.subtract(-3, -5), "-3 - (-5) должно быть 2");
        assertEquals(-4, ArithmeticCalculator.subtract(-7, -3), "-7 - (-3) должно быть -4");
        assertEquals(0, ArithmeticCalculator.subtract(-50, -50), "-50 - (-50) должно быть 0");
    }
    
    @Test
    @DisplayName("Тест вычитания - смешанные числа")
    void testSubtractMixedNumbers() {
        assertEquals(-10, ArithmeticCalculator.subtract(-5, 5), "-5 - 5 должно быть -10");
        assertEquals(-8, ArithmeticCalculator.subtract(-3, 5), "-3 - 5 должно быть -8");
        assertEquals(8, ArithmeticCalculator.subtract(3, -5), "3 - (-5) должно быть 8");
        assertEquals(-13, ArithmeticCalculator.subtract(-10, 3), "-10 - 3 должно быть -13");
    }
    
    @Test
    @DisplayName("Тест вычитания - с нулем")
    void testSubtractWithZero() {
        assertEquals(0, ArithmeticCalculator.subtract(0, 0), "0 - 0 должно быть 0");
        assertEquals(-5, ArithmeticCalculator.subtract(0, 5), "0 - 5 должно быть -5");
        assertEquals(5, ArithmeticCalculator.subtract(5, 0), "5 - 0 должно быть 5");
        assertEquals(5, ArithmeticCalculator.subtract(0, -5), "0 - (-5) должно быть 5");
    }
    
    // === ТЕСТЫ ДЛЯ МЕТОДА MULTIPLY ===
    
    @Test
    @DisplayName("Тест умножения - положительные числа")
    void testMultiplyPositiveNumbers() {
        assertEquals(15, ArithmeticCalculator.multiply(3, 5), "3 * 5 должно быть 15");
        assertEquals(21, ArithmeticCalculator.multiply(7, 3), "7 * 3 должно быть 21");
        assertEquals(2500, ArithmeticCalculator.multiply(50, 50), "50 * 50 должно быть 2500");
        assertEquals(999, ArithmeticCalculator.multiply(999, 1), "999 * 1 должно быть 999");
    }
    
    @Test
    @DisplayName("Тест умножения - отрицательные числа")
    void testMultiplyNegativeNumbers() {
        assertEquals(15, ArithmeticCalculator.multiply(-3, -5), "-3 * (-5) должно быть 15");
        assertEquals(21, ArithmeticCalculator.multiply(-7, -3), "-7 * (-3) должно быть 21");
        assertEquals(2500, ArithmeticCalculator.multiply(-50, -50), "-50 * (-50) должно быть 2500");
    }
    
    @Test
    @DisplayName("Тест умножения - смешанные числа")
    void testMultiplyMixedNumbers() {
        assertEquals(-25, ArithmeticCalculator.multiply(-5, 5), "-5 * 5 должно быть -25");
        assertEquals(-15, ArithmeticCalculator.multiply(-3, 5), "-3 * 5 должно быть -15");
        assertEquals(-15, ArithmeticCalculator.multiply(3, -5), "3 * (-5) должно быть -15");
        assertEquals(-30, ArithmeticCalculator.multiply(-10, 3), "-10 * 3 должно быть -30");
    }
    
    @Test
    @DisplayName("Тест умножения - с нулем")
    void testMultiplyWithZero() {
        assertEquals(0, ArithmeticCalculator.multiply(0, 0), "0 * 0 должно быть 0");
        assertEquals(0, ArithmeticCalculator.multiply(50, 0), "50 * 0 должно быть 0");
        assertEquals(0, ArithmeticCalculator.multiply(0, 100), "0 * 100 должно быть 0");
        assertEquals(0, ArithmeticCalculator.multiply(-5, 0), "-5 * 0 должно быть 0");
        assertEquals(0, ArithmeticCalculator.multiply(0, -10), "0 * (-10) должно быть 0");
    }
    
    @Test
    @DisplayName("Тест умножения - с единицей")
    void testMultiplyWithOne() {
        assertEquals(5, ArithmeticCalculator.multiply(5, 1), "5 * 1 должно быть 5");
        assertEquals(5, ArithmeticCalculator.multiply(1, 5), "1 * 5 должно быть 5");
        assertEquals(-5, ArithmeticCalculator.multiply(-5, 1), "-5 * 1 должно быть -5");
        assertEquals(-5, ArithmeticCalculator.multiply(1, -5), "1 * (-5) должно быть -5");
    }
    
    // === ТЕСТЫ ДЛЯ МЕТОДА DIVIDE ===
    
    @Test
    @DisplayName("Тест деления - положительные числа")
    void testDividePositiveNumbers() {
        assertEquals(2.5, ArithmeticCalculator.divide(5, 2), DELTA, "5 / 2 должно быть 2.5");
        assertEquals(2.0, ArithmeticCalculator.divide(6, 3), DELTA, "6 / 3 должно быть 2.0");
        assertEquals(1.0, ArithmeticCalculator.divide(7, 7), DELTA, "7 / 7 должно быть 1.0");
        assertEquals(999.0, ArithmeticCalculator.divide(999, 1), DELTA, "999 / 1 должно быть 999.0");
        assertEquals(0.2, ArithmeticCalculator.divide(1, 5), DELTA, "1 / 5 должно быть 0.2");
    }
    
    @Test
    @DisplayName("Тест деления - отрицательные числа")
    void testDivideNegativeNumbers() {
        assertEquals(2.5, ArithmeticCalculator.divide(-5, -2), DELTA, "-5 / (-2) должно быть 2.5");
        assertEquals(2.0, ArithmeticCalculator.divide(-6, -3), DELTA, "-6 / (-3) должно быть 2.0");
        assertEquals(1.0, ArithmeticCalculator.divide(-7, -7), DELTA, "-7 / (-7) должно быть 1.0");
    }
    
    @Test
    @DisplayName("Тест деления - смешанные числа")
    void testDivideMixedNumbers() {
        assertEquals(-2.5, ArithmeticCalculator.divide(-5, 2), DELTA, "-5 / 2 должно быть -2.5");
        assertEquals(-2.5, ArithmeticCalculator.divide(5, -2), DELTA, "5 / (-2) должно быть -2.5");
        assertEquals(-2.0, ArithmeticCalculator.divide(-6, 3), DELTA, "-6 / 3 должно быть -2.0");
        assertEquals(-2.0, ArithmeticCalculator.divide(6, -3), DELTA, "6 / (-3) должно быть -2.0");
    }
    
    @Test
    @DisplayName("Тест деления - деление нуля")
    void testDivideZero() {
        assertEquals(0.0, ArithmeticCalculator.divide(0, 5), DELTA, "0 / 5 должно быть 0.0");
        assertEquals(0.0, ArithmeticCalculator.divide(0, -5), DELTA, "0 / (-5) должно быть 0.0");
        assertEquals(0.0, ArithmeticCalculator.divide(0, 1), DELTA, "0 / 1 должно быть 0.0");
        assertEquals(0.0, ArithmeticCalculator.divide(0, 999), DELTA, "0 / 999 должно быть 0.0");
    }
    
    @Test
    @DisplayName("Тест деления на ноль - положительные числа")
    void testDivideByZeroPositive() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ArithmeticCalculator.divide(5, 0);
        }, "Должно выбрасываться исключение при делении на ноль");
        
        assertEquals("Деление на ноль невозможно", exception.getMessage());
        
        assertThrows(IllegalArgumentException.class, () -> {
            ArithmeticCalculator.divide(10, 0);
        }, "Должно выбрасываться исключение при делении 10 на ноль");
        
        assertThrows(IllegalArgumentException.class, () -> {
            ArithmeticCalculator.divide(1, 0);
        }, "Должно выбрасываться исключение при делении 1 на ноль");
    }
    
    @Test
    @DisplayName("Тест деления на ноль - отрицательные числа")
    void testDivideByZeroNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            ArithmeticCalculator.divide(-10, 0);
        }, "Должно выбрасываться исключение при делении отрицательного числа на ноль");
        
        assertThrows(IllegalArgumentException.class, () -> {
            ArithmeticCalculator.divide(-5, 0);
        }, "Должно выбрасываться исключение при делении -5 на ноль");
    }
    
    @Test
    @DisplayName("Тест деления нуля на ноль")
    void testDivideZeroByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            ArithmeticCalculator.divide(0, 0);
        }, "Должно выбрасываться исключение при делении ноля на ноль");
    }
    
    @Test
    @DisplayName("Тест операции деления - граничные случаи")
    void testDivideBoundaryValues() {
        // Деление на 1
        assertEquals(5.0, ArithmeticCalculator.divide(5, 1), DELTA, "5 / 1 должно быть 5.0");
        assertEquals(-5.0, ArithmeticCalculator.divide(-5, 1), DELTA, "-5 / 1 должно быть -5.0");
        
        // Деление на -1
        assertEquals(-5.0, ArithmeticCalculator.divide(5, -1), DELTA, "5 / (-1) должно быть -5.0");
        assertEquals(5.0, ArithmeticCalculator.divide(-5, -1), DELTA, "-5 / (-1) должно быть 5.0");
        
        // Деление больших чисел
        assertEquals(2.0, ArithmeticCalculator.divide(1000, 500), DELTA, "1000 / 500 должно быть 2.0");
        assertEquals(0.001, ArithmeticCalculator.divide(1, 1000), DELTA, "1 / 1000 должно быть 0.001");
    }
}