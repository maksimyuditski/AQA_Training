import org.testng.Assert;
import org.testng.annotations.*;

public class FactorialTest {
    
    @BeforeClass
    public void setUp() {
        System.out.println("Начало тестирования класса Factorial");
    }
    
    @AfterClass
    public void tearDown() {
        System.out.println("Завершение тестирования класса Factorial");
    }
    
    // === ТЕСТЫ ДЛЯ МЕТОДА calculateFactorial ===
    
    @Test(priority = 1, description = "Тест факториала для положительных чисел")
    public void testCalculateFactorialPositive() {
        Assert.assertEquals(Factorial.calculateFactorial(0), 1, "Факториал 0 должен быть 1");
        Assert.assertEquals(Factorial.calculateFactorial(1), 1, "Факториал 1 должен быть 1");
        Assert.assertEquals(Factorial.calculateFactorial(2), 2, "Факториал 2 должен быть 2");
        Assert.assertEquals(Factorial.calculateFactorial(3), 6, "Факториал 3 должен быть 6");
        Assert.assertEquals(Factorial.calculateFactorial(4), 24, "Факториал 4 должен быть 24");
        Assert.assertEquals(Factorial.calculateFactorial(5), 120, "Факториал 5 должен быть 120");
        Assert.assertEquals(Factorial.calculateFactorial(6), 720, "Факториал 6 должен быть 720");
        Assert.assertEquals(Factorial.calculateFactorial(7), 5040, "Факториал 7 должен быть 5040");
    }
    
    @Test(priority = 2, expectedExceptions = IllegalArgumentException.class,
          description = "Тест факториала для отрицательного числа -1")
    public void testCalculateFactorialNegativeOne() {
        Factorial.calculateFactorial(-1);
    }
    
    @Test(priority = 2, expectedExceptions = IllegalArgumentException.class,
          description = "Тест факториала для отрицательного числа -5")
    public void testCalculateFactorialNegativeFive() {
        Factorial.calculateFactorial(-5);
    }
    
    @Test(priority = 2, expectedExceptions = IllegalArgumentException.class,
          description = "Тест факториала для большого отрицательного числа -100")
    public void testCalculateFactorialNegativeLarge() {
        Factorial.calculateFactorial(-100);
    }
    
    @Test(priority = 2, expectedExceptions = {IllegalArgumentException.class},
          expectedExceptionsMessageRegExp = "Факториал не определен для отрицательных чисел",
          description = "Тест сообщения исключения для отрицательных чисел")
    public void testCalculateFactorialExceptionMessage() {
        Factorial.calculateFactorial(-3);
    }
    
    // === ТЕСТЫ ДЛЯ МЕТОДА calculateFactorialRecursive ====
    
    @Test(priority = 3, description = "Тест рекурсивного факториала для положительных чисел")
    public void testCalculateFactorialRecursivePositive() {
        Assert.assertEquals(Factorial.calculateFactorialRecursive(0), 1,
                           "Рекурсивный факториал 0 должен быть 1");
        Assert.assertEquals(Factorial.calculateFactorialRecursive(1), 1,
                           "Рекурсивный факториал 1 должен быть 1");
        Assert.assertEquals(Factorial.calculateFactorialRecursive(2), 2,
                           "Рекурсивный факториал 2 должен быть 2");
        Assert.assertEquals(Factorial.calculateFactorialRecursive(3), 6,
                           "Рекурсивный факториал 3 должен быть 6");
        Assert.assertEquals(Factorial.calculateFactorialRecursive(4), 24,
                           "Рекурсивный факториал 4 должен быть 24");
        Assert.assertEquals(Factorial.calculateFactorialRecursive(5), 120,
                           "Рекурсивный факториал 5 должен быть 120");
        Assert.assertEquals(Factorial.calculateFactorialRecursive(6), 720,
                           "Рекурсивный факториал 6 должен быть 720");
        Assert.assertEquals(Factorial.calculateFactorialRecursive(7), 5040,
                           "Рекурсивный факториал 7 должен быть 5040");
    }
    
    @Test(priority = 4, expectedExceptions = IllegalArgumentException.class,
          description = "Тест рекурсивного факториала для отрицательного числа -1")
    public void testCalculateFactorialRecursiveNegativeOne() {
        Factorial.calculateFactorialRecursive(-1);
    }
    
    @Test(priority = 4, expectedExceptions = IllegalArgumentException.class,
          description = "Тест рекурсивного факториала для отрицательного числа -3")
    public void testCalculateFactorialRecursiveNegativeThree() {
        Factorial.calculateFactorialRecursive(-3);
    }
    
    @Test(priority = 4, expectedExceptions = {IllegalArgumentException.class},
          expectedExceptionsMessageRegExp = "Факториал не определен для отрицательных чисел",
          description = "Тест сообщения исключения рекурсивного метода")
    public void testCalculateFactorialRecursiveExceptionMessage() {
        Factorial.calculateFactorialRecursive(-10);
    }
    
    // === СРАВНИТЕЛЬНЫЕ ТЕСТЫ ===
    
    @Test(priority = 5, description = "Сравнение итеративного и рекурсивного методов")
    public void testIterativeVsRecursive() {
        for (int i = 0; i <= 10; i++) {
            long iterative = Factorial.calculateFactorial(i);
            long recursive = Factorial.calculateFactorialRecursive(i);
            Assert.assertEquals(iterative, recursive,
                               "Итеративный и рекурсивный методы должны давать одинаковый результат для " + i);
        }
    }
    
    // === ГРАНИЧНЫЕ ТЕСТЫ ===
    
    @Test(priority = 6, description = "Тест граничных случаев")
    public void testBoundaryValues() {
        // Тест минимальных значений
        Assert.assertEquals(Factorial.calculateFactorial(0), 1, "Факториал 0");
        Assert.assertEquals(Factorial.calculateFactorial(1), 1, "Факториал 1");
        Assert.assertEquals(Factorial.calculateFactorialRecursive(0), 1, "Рекурсивный факториал 0");
        Assert.assertEquals(Factorial.calculateFactorialRecursive(1), 1, "Рекурсивный факториал 1");
        
        // Тест больших значений (в пределах разумного)
        long factorial10 = 3628800L;
        Assert.assertEquals(Factorial.calculateFactorial(10), factorial10, "Факториал 10");
        Assert.assertEquals(Factorial.calculateFactorialRecursive(10), factorial10, "Рекурсивный факториал 10");
    }
    
    // === ПАРАМЕТРИЗОВАННЫЕ ТЕСТЫ ===
    
    @DataProvider(name = "factorialPositiveData")
    public Object[][] factorialPositiveTestData() {
        return new Object[][] {
            {0, 1L},
            {1, 1L},
            {2, 2L},
            {3, 6L},
            {4, 24L},
            {5, 120L},
            {6, 720L},
            {7, 5040L}
        };
    }
    
    @Test(dataProvider = "factorialPositiveData", priority = 7,
          description = "Параметризованный тест итеративного факториала")
    public void testFactorialWithDataProvider(int input, long expected) {
        long actual = Factorial.calculateFactorial(input);
        Assert.assertEquals(actual, expected,
                           "Факториал " + input + " должен быть " + expected);
    }
    
    @Test(dataProvider = "factorialPositiveData", priority = 8,
          description = "Параметризованный тест рекурсивного факториала")
    public void testFactorialRecursiveWithDataProvider(int input, long expected) {
        long actual = Factorial.calculateFactorialRecursive(input);
        Assert.assertEquals(actual, expected,
                           "Рекурсивный факториал " + input + " должен быть " + expected);
    }
    
    @DataProvider(name = "factorialNegativeData")
    public Object[][] factorialNegativeTestData() {
        return new Object[][] {
            {-1},
            {-2},
            {-5},
            {-10},
            {-100}
        };
    }
    
    @Test(dataProvider = "factorialNegativeData", priority = 9,
          expectedExceptions = IllegalArgumentException.class,
          description = "Параметризованный тест отрицательных значений для итеративного метода")
    public void testFactorialNegativeWithDataProvider(int input) {
        Factorial.calculateFactorial(input);
    }
    
    @Test(dataProvider = "factorialNegativeData", priority = 10,
          expectedExceptions = IllegalArgumentException.class,
          description = "Параметризованный тест отрицательных значений для рекурсивного метода")
    public void testFactorialRecursiveNegativeWithDataProvider(int input) {
        Factorial.calculateFactorialRecursive(input);
    }

}