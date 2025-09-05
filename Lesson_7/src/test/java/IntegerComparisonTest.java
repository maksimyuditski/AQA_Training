import org.testng.Assert;
import org.testng.annotations.*;

public class IntegerComparisonTest {
    
    @BeforeClass
    public void setUp() {
        System.out.println("Начало тестирования класса IntegerComparison");
    }
    
    @AfterClass
    public void tearDown() {
        System.out.println("Завершение тестирования класса IntegerComparison");
    }
    
    // === ТЕСТЫ ДЛЯ МЕТОДА COMPARE ===
    
    @Test(priority = 1, description = "Тест метода compare - первое число меньше второго")
    public void testCompareLessThan() {
        Assert.assertEquals(IntegerComparison.compare(5, 10), -1, "5 < 10, результат должен быть -1");
        Assert.assertEquals(IntegerComparison.compare(1, 2), -1, "1 < 2, результат должен быть -1");
        Assert.assertEquals(IntegerComparison.compare(-10, -5), -1, "-10 < -5, результат должен быть -1");
        Assert.assertEquals(IntegerComparison.compare(-5, 5), -1, "-5 < 5, результат должен быть -1");
        Assert.assertEquals(IntegerComparison.compare(0, 1), -1, "0 < 1, результат должен быть -1");
    }
    
    @Test(priority = 2, description = "Тест метода compare - числа равны")
    public void testCompareEqual() {
        Assert.assertEquals(IntegerComparison.compare(5, 5), 0, "5 == 5, результат должен быть 0");
        Assert.assertEquals(IntegerComparison.compare(0, 0), 0, "0 == 0, результат должен быть 0");
        Assert.assertEquals(IntegerComparison.compare(-5, -5), 0, "-5 == -5, результат должен быть 0");
        Assert.assertEquals(IntegerComparison.compare(100, 100), 0, "100 == 100, результат должен быть 0");
        Assert.assertEquals(IntegerComparison.compare(-100, -100), 0, "-100 == -100, результат должен быть 0");
    }
    
    @Test(priority = 3, description = "Тест метода compare - первое число больше второго")
    public void testCompareGreaterThan() {
        Assert.assertEquals(IntegerComparison.compare(10, 5), 1, "10 > 5, результат должен быть 1");
        Assert.assertEquals(IntegerComparison.compare(2, 1), 1, "2 > 1, результат должен быть 1");
        Assert.assertEquals(IntegerComparison.compare(-5, -10), 1, "-5 > -10, результат должен быть 1");
        Assert.assertEquals(IntegerComparison.compare(5, -5), 1, "5 > -5, результат должен быть 1");
        Assert.assertEquals(IntegerComparison.compare(1, 0), 1, "1 > 0, результат должен быть 1");
    }
    
    // === ТЕСТЫ ДЛЯ МЕТОДА ISEQUAL ===
    
    @Test(priority = 4, description = "Тест метода isEqual - равные положительные числа")
    public void testIsEqualPositiveNumbers() {
        Assert.assertTrue(IntegerComparison.isEqual(5, 5), "5 должно быть равно 5");
        Assert.assertTrue(IntegerComparison.isEqual(1, 1), "1 должно быть равно 1");
        Assert.assertTrue(IntegerComparison.isEqual(100, 100), "100 должно быть равно 100");
        Assert.assertTrue(IntegerComparison.isEqual(999, 999), "999 должно быть равно 999");
    }
    
    @Test(priority = 5, description = "Тест метода isEqual - равные отрицательные числа")
    public void testIsEqualNegativeNumbers() {
        Assert.assertTrue(IntegerComparison.isEqual(-5, -5), "-5 должно быть равно -5");
        Assert.assertTrue(IntegerComparison.isEqual(-1, -1), "-1 должно быть равно -1");
        Assert.assertTrue(IntegerComparison.isEqual(-100, -100), "-100 должно быть равно -100");
    }
    
    @Test(priority = 6, description = "Тест метода isEqual - ноль")
    public void testIsEqualZero() {
        Assert.assertTrue(IntegerComparison.isEqual(0, 0), "0 должно быть равно 0");
    }
    
    @Test(priority = 7, description = "Тест метода isEqual - неравные числа")
    public void testIsEqualNotEqual() {
        Assert.assertFalse(IntegerComparison.isEqual(5, 10), "5 не должно быть равно 10");
        Assert.assertFalse(IntegerComparison.isEqual(-5, 5), "-5 не должно быть равно 5");
        Assert.assertFalse(IntegerComparison.isEqual(0, 1), "0 не должно быть равно 1");
        Assert.assertFalse(IntegerComparison.isEqual(1, -1), "1 не должно быть равно -1");
        Assert.assertFalse(IntegerComparison.isEqual(10, 5), "10 не должно быть равно 5");
    }
    
    // === ТЕСТЫ ДЛЯ МЕТОДА ISGREATER ===
    
    @Test(priority = 8, description = "Тест метода isGreater - положительные числа")
    public void testIsGreaterPositiveNumbers() {
        Assert.assertTrue(IntegerComparison.isGreater(10, 5), "10 должно быть больше 5");
        Assert.assertTrue(IntegerComparison.isGreater(100, 50), "100 должно быть больше 50");
        Assert.assertTrue(IntegerComparison.isGreater(2, 1), "2 должно быть больше 1");
        Assert.assertTrue(IntegerComparison.isGreater(999, 1), "999 должно быть больше 1");
    }
    
    @Test(priority = 9, description = "Тест метода isGreater - отрицательные числа")
    public void testIsGreaterNegativeNumbers() {
        Assert.assertTrue(IntegerComparison.isGreater(-5, -10), "-5 должно быть больше -10");
        Assert.assertTrue(IntegerComparison.isGreater(-1, -2), "-1 должно быть больше -2");
        Assert.assertTrue(IntegerComparison.isGreater(-50, -100), "-50 должно быть больше -100");
    }
    
    @Test(priority = 10, description = "Тест метода isGreater - смешанные числа")
    public void testIsGreaterMixedNumbers() {
        Assert.assertTrue(IntegerComparison.isGreater(0, -5), "0 должно быть больше -5");
        Assert.assertTrue(IntegerComparison.isGreater(5, -5), "5 должно быть больше -5");
        Assert.assertTrue(IntegerComparison.isGreater(1, 0), "1 должно быть больше 0");
        Assert.assertTrue(IntegerComparison.isGreater(-1, -5), "-1 должно быть больше -5");
    }
    
    @Test(priority = 11, description = "Тест метода isGreater - ложные случаи")
    public void testIsGreaterFalse() {
        Assert.assertFalse(IntegerComparison.isGreater(5, 10), "5 не должно быть больше 10");
        Assert.assertFalse(IntegerComparison.isGreater(5, 5), "5 не должно быть больше 5");
        Assert.assertFalse(IntegerComparison.isGreater(-10, -5), "-10 не должно быть больше -5");
        Assert.assertFalse(IntegerComparison.isGreater(-5, 0), "-5 не должно быть больше 0");
        Assert.assertFalse(IntegerComparison.isGreater(0, 1), "0 не должно быть больше 1");
    }
    
    // === ТЕСТЫ ДЛЯ МЕТОДА ISLESS ===
    
    @Test(priority = 12, description = "Тест метода isLess - положительные числа")
    public void testIsLessPositiveNumbers() {
        Assert.assertTrue(IntegerComparison.isLess(5, 10), "5 должно быть меньше 10");
        Assert.assertTrue(IntegerComparison.isLess(50, 100), "50 должно быть меньше 100");
        Assert.assertTrue(IntegerComparison.isLess(1, 2), "1 должно быть меньше 2");
        Assert.assertTrue(IntegerComparison.isLess(1, 999), "1 должно быть меньше 999");
    }
    
    @Test(priority = 13, description = "Тест метода isLess - отрицательные числа")
    public void testIsLessNegativeNumbers() {
        Assert.assertTrue(IntegerComparison.isLess(-10, -5), "-10 должно быть меньше -5");
        Assert.assertTrue(IntegerComparison.isLess(-2, -1), "-2 должно быть меньше -1");
        Assert.assertTrue(IntegerComparison.isLess(-100, -50), "-100 должно быть меньше -50");
    }
    
    @Test(priority = 14, description = "Тест метода isLess - смешанные числа")
    public void testIsLessMixedNumbers() {
        Assert.assertTrue(IntegerComparison.isLess(-5, 0), "-5 должно быть меньше 0");
        Assert.assertTrue(IntegerComparison.isLess(-5, 5), "-5 должно быть меньше 5");
        Assert.assertTrue(IntegerComparison.isLess(0, 1), "0 должно быть меньше 1");
        Assert.assertTrue(IntegerComparison.isLess(-5, -1), "-5 должно быть меньше -1");
    }
    
    @Test(priority = 15, description = "Тест метода isLess - ложные случаи")
    public void testIsLessFalse() {
        Assert.assertFalse(IntegerComparison.isLess(10, 5), "10 не должно быть меньше 5");
        Assert.assertFalse(IntegerComparison.isLess(5, 5), "5 не должно быть меньше 5");
        Assert.assertFalse(IntegerComparison.isLess(-5, -10), "-5 не должно быть меньше -10");
        Assert.assertFalse(IntegerComparison.isLess(0, -5), "0 не должно быть меньше -5");
        Assert.assertFalse(IntegerComparison.isLess(1, 0), "1 не должно быть меньше 0");
    }
    
    // === ТЕСТЫ ДЛЯ МЕТОДА MAX ===
    
    @Test(priority = 16, description = "Тест метода max - положительные числа")
    public void testMaxPositiveNumbers() {
        Assert.assertEquals(IntegerComparison.max(5, 10), 10, "Максимум из 5 и 10 должен быть 10");
        Assert.assertEquals(IntegerComparison.max(100, 50), 100, "Максимум из 100 и 50 должен быть 100");
        Assert.assertEquals(IntegerComparison.max(50, 100), 100, "Максимум из 50 и 100 должен быть 100");
        Assert.assertEquals(IntegerComparison.max(1, 999), 999, "Максимум из 1 и 999 должен быть 999");
    }
    
    @Test(priority = 17, description = "Тест метода max - отрицательные числа")
    public void testMaxNegativeNumbers() {
        Assert.assertEquals(IntegerComparison.max(-10, -5), -5, "Максимум из -10 и -5 должен быть -5");
        Assert.assertEquals(IntegerComparison.max(-2, -1), -1, "Максимум из -2 и -1 должен быть -1");
        Assert.assertEquals(IntegerComparison.max(-100, -50), -50, "Максимум из -100 и -50 должен быть -50");
    }
    
    @Test(priority = 18, description = "Тест метода max - смешанные числа")
    public void testMaxMixedNumbers() {
        Assert.assertEquals(IntegerComparison.max(-5, 0), 0, "Максимум из -5 и 0 должен быть 0");
        Assert.assertEquals(IntegerComparison.max(-5, 5), 5, "Максимум из -5 и 5 должен быть 5");
        Assert.assertEquals(IntegerComparison.max(0, 1), 1, "Максимум из 0 и 1 должен быть 1");
        Assert.assertEquals(IntegerComparison.max(-5, -1), -1, "Максимум из -5 и -1 должен быть -1");
    }
    
    @Test(priority = 19, description = "Тест метода max - равные числа")
    public void testMaxEqualNumbers() {
        Assert.assertEquals(IntegerComparison.max(5, 5), 5, "Максимум из 5 и 5 должен быть 5");
        Assert.assertEquals(IntegerComparison.max(0, 0), 0, "Максимум из 0 и 0 должен быть 0");
        Assert.assertEquals(IntegerComparison.max(-5, -5), -5, "Максимум из -5 и -5 должен быть -5");
        Assert.assertEquals(IntegerComparison.max(100, 100), 100, "Максимум из 100 и 100 должен быть 100");
    }
    
    // === ТЕСТЫ ДЛЯ МЕТОДА MIN ===
    
    @Test(priority = 20, description = "Тест метода min - положительные числа")
    public void testMinPositiveNumbers() {
        Assert.assertEquals(IntegerComparison.min(5, 10), 5, "Минимум из 5 и 10 должен быть 5");
        Assert.assertEquals(IntegerComparison.min(100, 50), 50, "Минимум из 100 и 50 должен быть 50");
        Assert.assertEquals(IntegerComparison.min(50, 100), 50, "Минимум из 50 и 100 должен быть 50");
        Assert.assertEquals(IntegerComparison.min(1, 999), 1, "Минимум из 1 и 999 должен быть 1");
    }
    
    @Test(priority = 21, description = "Тест метода min - отрицательные числа")
    public void testMinNegativeNumbers() {
        Assert.assertEquals(IntegerComparison.min(-10, -5), -10, "Минимум из -10 и -5 должен быть -10");
        Assert.assertEquals(IntegerComparison.min(-2, -1), -2, "Минимум из -2 и -1 должен быть -2");
        Assert.assertEquals(IntegerComparison.min(-100, -50), -100, "Минимум из -100 и -50 должен быть -100");
    }
    
    @Test(priority = 22, description = "Тест метода min - смешанные числа")
    public void testMinMixedNumbers() {
        Assert.assertEquals(IntegerComparison.min(-5, 0), -5, "Минимум из -5 и 0 должен быть -5");
        Assert.assertEquals(IntegerComparison.min(-5, 5), -5, "Минимум из -5 и 5 должен быть -5");
        Assert.assertEquals(IntegerComparison.min(0, 1), 0, "Минимум из 0 и 1 должен быть 0");
        Assert.assertEquals(IntegerComparison.min(-5, -1), -5, "Минимум из -5 и -1 должен быть -5");
    }
    
    @Test(priority = 23, description = "Тест метода min - равные числа")
    public void testMinEqualNumbers() {
        Assert.assertEquals(IntegerComparison.min(5, 5), 5, "Минимум из 5 и 5 должен быть 5");
        Assert.assertEquals(IntegerComparison.min(0, 0), 0, "Минимум из 0 и 0 должен быть 0");
        Assert.assertEquals(IntegerComparison.min(-5, -5), -5, "Минимум из -5 и -5 должен быть -5");
        Assert.assertEquals(IntegerComparison.min(100, 100), 100, "Минимум из 100 и 100 должен быть 100");
    }
    
    // === ИНТЕГРАЦИОННЫЕ ТЕСТЫ ===
    
    @Test(priority = 24, description = "Интеграционный тест - проверка согласованности всех методов")
    public void testAllMethodsConsistency() {
        int a = 15, b = 25;
        
        // Проверяем, что compare согласуется с isEqual, isGreater, isLess
        int compareResult = IntegerComparison.compare(a, b);
        Assert.assertEquals(compareResult, -1, "compare должен возвращать -1 для 15 и 25");
        Assert.assertFalse(IntegerComparison.isEqual(a, b), "isEqual должен возвращать false");
        Assert.assertFalse(IntegerComparison.isGreater(a, b), "isGreater должен возвращать false");
        Assert.assertTrue(IntegerComparison.isLess(a, b), "isLess должен возвращать true");
        
        // Проверяем max и min
        Assert.assertEquals(IntegerComparison.max(a, b), b, "max должен возвращать 25");
        Assert.assertEquals(IntegerComparison.min(a, b), a, "min должен возвращать 15");
    }
    
    @Test(priority = 25, description = "Тест граничных значений Integer")
    public void testIntegerBoundaryValues() {
        // Максимальные и минимальные значения int
        int maxInt = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;
        
        Assert.assertEquals(IntegerComparison.compare(maxInt, 0), 1);
        Assert.assertEquals(IntegerComparison.compare(minInt, 0), -1);
        Assert.assertEquals(IntegerComparison.compare(maxInt, maxInt), 0);
        Assert.assertEquals(IntegerComparison.compare(minInt, minInt), 0);
        
        Assert.assertTrue(IntegerComparison.isGreater(maxInt, 0));
        Assert.assertTrue(IntegerComparison.isLess(minInt, 0));
        
        Assert.assertEquals(IntegerComparison.max(maxInt, minInt), maxInt);
        Assert.assertEquals(IntegerComparison.min(maxInt, minInt), minInt);
    }
    
    // === ПАРАМЕТРИЗОВАННЫЕ ТЕСТЫ ===
    
    @DataProvider(name = "comparisonData")
    public Object[][] comparisonTestData() {
        return new Object[][] {
            {5, 10, -1, false, false, true, 10, 5},
            {10, 5, 1, false, true, false, 10, 5},
            {5, 5, 0, true, false, false, 5, 5},
            {-5, -10, 1, false, true, false, -5, -10},
            {0, 0, 0, true, false, false, 0, 0},
            {-5, 5, -1, false, false, true, 5, -5},
            {100, -100, 1, false, true, false, 100, -100}
        };
    }
    
    @Test(dataProvider = "comparisonData", priority = 26,
          description = "Параметризованный тест всех методов сравнения")
    public void testAllComparisonMethods(int a, int b, int compareResult, boolean equal,
                                        boolean greater, boolean less, int maxVal, int minVal) {
        Assert.assertEquals(IntegerComparison.compare(a, b), compareResult,
                           "Результат сравнения " + a + " и " + b);
        Assert.assertEquals(IntegerComparison.isEqual(a, b), equal,
                           "Проверка равенства " + a + " и " + b);
        Assert.assertEquals(IntegerComparison.isGreater(a, b), greater,
                           "Проверка " + a + " > " + b);
        Assert.assertEquals(IntegerComparison.isLess(a, b), less,
                           "Проверка " + a + " < " + b);
        Assert.assertEquals(IntegerComparison.max(a, b), maxVal,
                           "Максимум из " + a + " и " + b);
        Assert.assertEquals(IntegerComparison.min(a, b), minVal,
                           "Минимум из " + a + " и " + b);
    }
    
    @DataProvider(name = "equalPairsData")
    public Object[][] equalPairsTestData() {
        return new Object[][] {
            {0, 0},
            {5, 5},
            {-5, -5},
            {100, 100},
            {-100, -100},
            {Integer.MAX_VALUE, Integer.MAX_VALUE},
            {Integer.MIN_VALUE, Integer.MIN_VALUE}
        };
    }
    
    @Test(dataProvider = "equalPairsData", priority = 27,
          description = "Параметризованный тест равных пар")
    public void testEqualPairs(int a, int b) {
        Assert.assertEquals(IntegerComparison.compare(a, b), 0, "Равные числа должны давать 0 при сравнении");
        Assert.assertTrue(IntegerComparison.isEqual(a, b), "Равные числа должны проходить тест isEqual");
        Assert.assertFalse(IntegerComparison.isGreater(a, b), "Равные числа не должны проходить тест isGreater");
        Assert.assertFalse(IntegerComparison.isLess(a, b), "Равные числа не должны проходить тест isLess");
        Assert.assertEquals(IntegerComparison.max(a, b), a, "Максимум равных чисел должен равняться любому из них");
        Assert.assertEquals(IntegerComparison.min(a, b), a, "Минимум равных чисел должен равняться любому из них");
    }
    
    @DataProvider(name = "extremeValuesData")
    public Object[][] extremeValuesTestData() {
        return new Object[][] {
            {Integer.MAX_VALUE, Integer.MIN_VALUE},
            {Integer.MAX_VALUE, 0},
            {Integer.MIN_VALUE, 0},
            {Integer.MAX_VALUE, -1},
            {Integer.MIN_VALUE, 1}
        };
    }
    
    @Test(dataProvider = "extremeValuesData", priority = 28,
          description = "Параметризованный тест экстремальных значений")
    public void testExtremeValues(int a, int b) {
        // Проверяем, что методы работают корректно с экстремальными значениями
        int compareResult = IntegerComparison.compare(a, b);
        Assert.assertTrue(compareResult >= -1 && compareResult <= 1, "compare должен возвращать -1, 0 или 1");
        
        boolean equal = IntegerComparison.isEqual(a, b);
        boolean greater = IntegerComparison.isGreater(a, b);
        boolean less = IntegerComparison.isLess(a, b);
        
        // Проверяем логическую согласованность
        if (equal) {
            Assert.assertFalse(greater, "Если числа равны, одно не может быть больше другого");
            Assert.assertFalse(less, "Если числа равны, одно не может быть меньше другого");
            Assert.assertEquals(compareResult, 0, "Если числа равны, compare должен возвращать 0");
        }
        
        if (greater) {
            Assert.assertFalse(equal, "Если одно число больше, они не могут быть равны");
            Assert.assertFalse(less, "Если одно число больше, оно не может быть меньше");
            Assert.assertEquals(compareResult, 1, "Если первое число больше, compare должен возвращать 1");
        }
        
        if (less) {
            Assert.assertFalse(equal, "Если одно число меньше, они не могут быть равны");
            Assert.assertFalse(greater, "Если одно число меньше, оно не может быть больше");
            Assert.assertEquals(compareResult, -1, "Если первое число меньше, compare должен возвращать -1");
        }
        
        // Проверяем max и min
        int maxResult = IntegerComparison.max(a, b);
        int minResult = IntegerComparison.min(a, b);
        
        Assert.assertTrue(maxResult == a || maxResult == b, "max должен возвращать одно из входных чисел");
        Assert.assertTrue(minResult == a || minResult == b, "min должен возвращать одно из входных чисел");
        Assert.assertTrue(maxResult >= minResult, "max должен быть больше или равен min");
    }

}