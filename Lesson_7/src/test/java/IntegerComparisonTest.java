import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты для класса IntegerComparison")
class IntegerComparisonTest {
    
    // === ТЕСТЫ ДЛЯ МЕТОДА COMPARE ===
    
    @Test
    @DisplayName("Тест метода compare - первое число меньше второго")
    void testCompareLessThan() {
        assertEquals(-1, IntegerComparison.compare(5, 10), "5 < 10, результат должен быть -1");
        assertEquals(-1, IntegerComparison.compare(1, 2), "1 < 2, результат должен быть -1");
        assertEquals(-1, IntegerComparison.compare(-10, -5), "-10 < -5, результат должен быть -1");
        assertEquals(-1, IntegerComparison.compare(-5, 5), "-5 < 5, результат должен быть -1");
        assertEquals(-1, IntegerComparison.compare(0, 1), "0 < 1, результат должен быть -1");
    }
    
    @Test
    @DisplayName("Тест метода compare - числа равны")
    void testCompareEqual() {
        assertEquals(0, IntegerComparison.compare(5, 5), "5 == 5, результат должен быть 0");
        assertEquals(0, IntegerComparison.compare(0, 0), "0 == 0, результат должен быть 0");
        assertEquals(0, IntegerComparison.compare(-5, -5), "-5 == -5, результат должен быть 0");
        assertEquals(0, IntegerComparison.compare(100, 100), "100 == 100, результат должен быть 0");
        assertEquals(0, IntegerComparison.compare(-100, -100), "-100 == -100, результат должен быть 0");
    }
    
    @Test
    @DisplayName("Тест метода compare - первое число больше второго")
    void testCompareGreaterThan() {
        assertEquals(1, IntegerComparison.compare(10, 5), "10 > 5, результат должен быть 1");
        assertEquals(1, IntegerComparison.compare(2, 1), "2 > 1, результат должен быть 1");
        assertEquals(1, IntegerComparison.compare(-5, -10), "-5 > -10, результат должен быть 1");
        assertEquals(1, IntegerComparison.compare(5, -5), "5 > -5, результат должен быть 1");
        assertEquals(1, IntegerComparison.compare(1, 0), "1 > 0, результат должен быть 1");
    }
    
    // === ТЕСТЫ ДЛЯ МЕТОДА ISEQUAL ===
    
    @Test
    @DisplayName("Тест метода isEqual - равные положительные числа")
    void testIsEqualPositiveNumbers() {
        assertTrue(IntegerComparison.isEqual(5, 5), "5 должно быть равно 5");
        assertTrue(IntegerComparison.isEqual(1, 1), "1 должно быть равно 1");
        assertTrue(IntegerComparison.isEqual(100, 100), "100 должно быть равно 100");
        assertTrue(IntegerComparison.isEqual(999, 999), "999 должно быть равно 999");
    }
    
    @Test
    @DisplayName("Тест метода isEqual - равные отрицательные числа")
    void testIsEqualNegativeNumbers() {
        assertTrue(IntegerComparison.isEqual(-5, -5), "-5 должно быть равно -5");
        assertTrue(IntegerComparison.isEqual(-1, -1), "-1 должно быть равно -1");
        assertTrue(IntegerComparison.isEqual(-100, -100), "-100 должно быть равно -100");
    }
    
    @Test
    @DisplayName("Тест метода isEqual - ноль")
    void testIsEqualZero() {
        assertTrue(IntegerComparison.isEqual(0, 0), "0 должно быть равно 0");
    }
    
    @Test
    @DisplayName("Тест метода isEqual - неравные числа")
    void testIsEqualNotEqual() {
        assertFalse(IntegerComparison.isEqual(5, 10), "5 не должно быть равно 10");
        assertFalse(IntegerComparison.isEqual(-5, 5), "-5 не должно быть равно 5");
        assertFalse(IntegerComparison.isEqual(0, 1), "0 не должно быть равно 1");
        assertFalse(IntegerComparison.isEqual(1, -1), "1 не должно быть равно -1");
        assertFalse(IntegerComparison.isEqual(10, 5), "10 не должно быть равно 5");
    }
    
    // === ТЕСТЫ ДЛЯ МЕТОДА ISGREATER ===
    
    @Test
    @DisplayName("Тест метода isGreater - положительные числа")
    void testIsGreaterPositiveNumbers() {
        assertTrue(IntegerComparison.isGreater(10, 5), "10 должно быть больше 5");
        assertTrue(IntegerComparison.isGreater(100, 50), "100 должно быть больше 50");
        assertTrue(IntegerComparison.isGreater(2, 1), "2 должно быть больше 1");
        assertTrue(IntegerComparison.isGreater(999, 1), "999 должно быть больше 1");
    }
    
    @Test
    @DisplayName("Тест метода isGreater - отрицательные числа")
    void testIsGreaterNegativeNumbers() {
        assertTrue(IntegerComparison.isGreater(-5, -10), "-5 должно быть больше -10");
        assertTrue(IntegerComparison.isGreater(-1, -2), "-1 должно быть больше -2");
        assertTrue(IntegerComparison.isGreater(-50, -100), "-50 должно быть больше -100");
    }
    
    @Test
    @DisplayName("Тест метода isGreater - смешанные числа")
    void testIsGreaterMixedNumbers() {
        assertTrue(IntegerComparison.isGreater(0, -5), "0 должно быть больше -5");
        assertTrue(IntegerComparison.isGreater(5, -5), "5 должно быть больше -5");
        assertTrue(IntegerComparison.isGreater(1, 0), "1 должно быть больше 0");
        assertTrue(IntegerComparison.isGreater(-1, -5), "-1 должно быть больше -5");
    }
    
    @Test
    @DisplayName("Тест метода isGreater - ложные случаи")
    void testIsGreaterFalse() {
        assertFalse(IntegerComparison.isGreater(5, 10), "5 не должно быть больше 10");
        assertFalse(IntegerComparison.isGreater(5, 5), "5 не должно быть больше 5");
        assertFalse(IntegerComparison.isGreater(-10, -5), "-10 не должно быть больше -5");
        assertFalse(IntegerComparison.isGreater(-5, 0), "-5 не должно быть больше 0");
        assertFalse(IntegerComparison.isGreater(0, 1), "0 не должно быть больше 1");
    }
    
    // ========== ТЕСТЫ ДЛЯ МЕТОДА ISLESS ==========
    
    @Test
    @DisplayName("Тест метода isLess - положительные числа")
    void testIsLessPositiveNumbers() {
        assertTrue(IntegerComparison.isLess(5, 10), "5 должно быть меньше 10");
        assertTrue(IntegerComparison.isLess(50, 100), "50 должно быть меньше 100");
        assertTrue(IntegerComparison.isLess(1, 2), "1 должно быть меньше 2");
        assertTrue(IntegerComparison.isLess(1, 999), "1 должно быть меньше 999");
    }
    
    @Test
    @DisplayName("Тест метода isLess - отрицательные числа")
    void testIsLessNegativeNumbers() {
        assertTrue(IntegerComparison.isLess(-10, -5), "-10 должно быть меньше -5");
        assertTrue(IntegerComparison.isLess(-2, -1), "-2 должно быть меньше -1");
        assertTrue(IntegerComparison.isLess(-100, -50), "-100 должно быть меньше -50");
    }
    
    @Test
    @DisplayName("Тест метода isLess - смешанные числа")
    void testIsLessMixedNumbers() {
        assertTrue(IntegerComparison.isLess(-5, 0), "-5 должно быть меньше 0");
        assertTrue(IntegerComparison.isLess(-5, 5), "-5 должно быть меньше 5");
        assertTrue(IntegerComparison.isLess(0, 1), "0 должно быть меньше 1");
        assertTrue(IntegerComparison.isLess(-5, -1), "-5 должно быть меньше -1");
    }
    
    @Test
    @DisplayName("Тест метода isLess - ложные случаи")
    void testIsLessFalse() {
        assertFalse(IntegerComparison.isLess(10, 5), "10 не должно быть меньше 5");
        assertFalse(IntegerComparison.isLess(5, 5), "5 не должно быть меньше 5");
        assertFalse(IntegerComparison.isLess(-5, -10), "-5 не должно быть меньше -10");
        assertFalse(IntegerComparison.isLess(0, -5), "0 не должно быть меньше -5");
        assertFalse(IntegerComparison.isLess(1, 0), "1 не должно быть меньше 0");
    }
    
    // === ТЕСТЫ ДЛЯ МЕТОДА MAX ===
    
    @Test
    @DisplayName("Тест метода max - положительные числа")
    void testMaxPositiveNumbers() {
        assertEquals(10, IntegerComparison.max(5, 10), "Максимум из 5 и 10 должен быть 10");
        assertEquals(100, IntegerComparison.max(100, 50), "Максимум из 100 и 50 должен быть 100");
        assertEquals(50, IntegerComparison.max(50, 100), "Максимум из 50 и 100 должен быть 100");
        assertEquals(999, IntegerComparison.max(1, 999), "Максимум из 1 и 999 должен быть 999");
    }
    
    @Test
    @DisplayName("Тест метода max - отрицательные числа")
    void testMaxNegativeNumbers() {
        assertEquals(-5, IntegerComparison.max(-10, -5), "Максимум из -10 и -5 должен быть -5");
        assertEquals(-1, IntegerComparison.max(-2, -1), "Максимум из -2 и -1 должен быть -1");
        assertEquals(-50, IntegerComparison.max(-100, -50), "Максимум из -100 и -50 должен быть -50");
    }
    
    @Test
    @DisplayName("Тест метода max - смешанные числа")
    void testMaxMixedNumbers() {
        assertEquals(0, IntegerComparison.max(-5, 0), "Максимум из -5 и 0 должен быть 0");
        assertEquals(5, IntegerComparison.max(-5, 5), "Максимум из -5 и 5 должен быть 5");
        assertEquals(1, IntegerComparison.max(0, 1), "Максимум из 0 и 1 должен быть 1");
        assertEquals(-1, IntegerComparison.max(-5, -1), "Максимум из -5 и -1 должен быть -1");
    }
    
    @Test
    @DisplayName("Тест метода max - равные числа")
    void testMaxEqualNumbers() {
        assertEquals(5, IntegerComparison.max(5, 5), "Максимум из 5 и 5 должен быть 5");
        assertEquals(0, IntegerComparison.max(0, 0), "Максимум из 0 и 0 должен быть 0");
        assertEquals(-5, IntegerComparison.max(-5, -5), "Максимум из -5 и -5 должен быть -5");
        assertEquals(100, IntegerComparison.max(100, 100), "Максимум из 100 и 100 должен быть 100");
    }
    
    // === ТЕСТЫ ДЛЯ МЕТОДА MIN ===
    
    @Test
    @DisplayName("Тест метода min - положительные числа")
    void testMinPositiveNumbers() {
        assertEquals(5, IntegerComparison.min(5, 10), "Минимум из 5 и 10 должен быть 5");
        assertEquals(50, IntegerComparison.min(100, 50), "Минимум из 100 и 50 должен быть 50");
        assertEquals(50, IntegerComparison.min(50, 100), "Минимум из 50 и 100 должен быть 50");
        assertEquals(1, IntegerComparison.min(1, 999), "Минимум из 1 и 999 должен быть 1");
    }
    
    @Test
    @DisplayName("Тест метода min - отрицательные числа")
    void testMinNegativeNumbers() {
        assertEquals(-10, IntegerComparison.min(-10, -5), "Минимум из -10 и -5 должен быть -10");
        assertEquals(-2, IntegerComparison.min(-2, -1), "Минимум из -2 и -1 должен быть -2");
        assertEquals(-100, IntegerComparison.min(-100, -50), "Минимум из -100 и -50 должен быть -100");
    }
    
    @Test
    @DisplayName("Тест метода min - смешанные числа")
    void testMinMixedNumbers() {
        assertEquals(-5, IntegerComparison.min(-5, 0), "Минимум из -5 и 0 должен быть -5");
        assertEquals(-5, IntegerComparison.min(-5, 5), "Минимум из -5 и 5 должен быть -5");
        assertEquals(0, IntegerComparison.min(0, 1), "Минимум из 0 и 1 должен быть 0");
        assertEquals(-5, IntegerComparison.min(-5, -1), "Минимум из -5 и -1 должен быть -5");
    }
    
    @Test
    @DisplayName("Тест метода min - равные числа")
    void testMinEqualNumbers() {
        assertEquals(5, IntegerComparison.min(5, 5), "Минимум из 5 и 5 должен быть 5");
        assertEquals(0, IntegerComparison.min(0, 0), "Минимум из 0 и 0 должен быть 0");
        assertEquals(-5, IntegerComparison.min(-5, -5), "Минимум из -5 и -5 должен быть -5");
        assertEquals(100, IntegerComparison.min(100, 100), "Минимум из 100 и 100 должен быть 100");
    }
    
    // === ИНТЕГРАЦИОННЫЕ ТЕСТЫ ===
    
    @Test
    @DisplayName("Интеграционный тест - проверка согласованности всех методов")
    void testAllMethodsConsistency() {
        int a = 15, b = 25;
        
        // Проверяем, что compare согласуется с isEqual, isGreater, isLess
        int compareResult = IntegerComparison.compare(a, b);
        assertEquals(-1, compareResult, "compare должен возвращать -1 для 15 и 25");
        assertFalse(IntegerComparison.isEqual(a, b), "isEqual должен возвращать false");
        assertFalse(IntegerComparison.isGreater(a, b), "isGreater должен возвращать false");
        assertTrue(IntegerComparison.isLess(a, b), "isLess должен возвращать true");
        
        // Проверяем max и min
        assertEquals(b, IntegerComparison.max(a, b), "max должен возвращать 25");
        assertEquals(a, IntegerComparison.min(a, b), "min должен возвращать 15");
    }
    
    @Test
    @DisplayName("Тест граничных значений Integer")
    void testIntegerBoundaryValues() {
        // Максимальные и минимальные значения int
        int maxInt = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;
        
        assertEquals(1, IntegerComparison.compare(maxInt, 0));
        assertEquals(-1, IntegerComparison.compare(minInt, 0));
        assertEquals(0, IntegerComparison.compare(maxInt, maxInt));
        assertEquals(0, IntegerComparison.compare(minInt, minInt));
        
        assertTrue(IntegerComparison.isGreater(maxInt, 0));
        assertTrue(IntegerComparison.isLess(minInt, 0));
        
        assertEquals(maxInt, IntegerComparison.max(maxInt, minInt));
        assertEquals(minInt, IntegerComparison.min(maxInt, minInt));
    }
}