import org.testng.Assert;
import org.testng.annotations.*;

public class ArithmeticCalculatorTest {

    private static final double DELTA = 0.001; // допустимая погрешность для double

    @BeforeClass
    public void setUp() {
        System.out.println("Начало тестирования класса ArithmeticCalculator");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Завершение тестирования класса ArithmeticCalculator");
    }

    // === ТЕСТЫ ДЛЯ МЕТОДА ADD ===

    @Test(priority = 1, description = "Тест сложения - положительные числа")
    public void testAddPositiveNumbers() {
        Assert.assertEquals(ArithmeticCalculator.add(2, 3), 5, "2 + 3 должно быть 5");
        Assert.assertEquals(ArithmeticCalculator.add(7, 3), 10, "7 + 3 должно быть 10");
        Assert.assertEquals(ArithmeticCalculator.add(50, 50), 100, "50 + 50 должно быть 100");
        Assert.assertEquals(ArithmeticCalculator.add(999, 1), 1000, "999 + 1 должно быть 1000");
    }

    @Test(priority = 2, description = "Тест сложения - отрицательные числа")
    public void testAddNegativeNumbers() {
        Assert.assertEquals(ArithmeticCalculator.add(-3, -5), -8, "-3 + (-5) должно быть -8");
        Assert.assertEquals(ArithmeticCalculator.add(-7, -3), -10, "-7 + (-3) должно быть -10");
        Assert.assertEquals(ArithmeticCalculator.add(-50, -50), -100, "-50 + (-50) должно быть -100");
    }

    @Test(priority = 3, description = "Тест сложения - смешанные числа")
    public void testAddMixedNumbers() {
        Assert.assertEquals(ArithmeticCalculator.add(-5, 5), 0, "-5 + 5 должно быть 0");
        Assert.assertEquals(ArithmeticCalculator.add(-3, 5), 2, "-3 + 5 должно быть 2");
        Assert.assertEquals(ArithmeticCalculator.add(3, -5), -2, "3 + (-5) должно быть -2");
        Assert.assertEquals(ArithmeticCalculator.add(-10, 3), -7, "-10 + 3 должно быть -7");
    }

    @Test(priority = 4, description = "Тест сложения - с нулем")
    public void testAddWithZero() {
        Assert.assertEquals(ArithmeticCalculator.add(0, 0), 0, "0 + 0 должно быть 0");
        Assert.assertEquals(ArithmeticCalculator.add(0, 5), 5, "0 + 5 должно быть 5");
        Assert.assertEquals(ArithmeticCalculator.add(5, 0), 5, "5 + 0 должно быть 5");
        Assert.assertEquals(ArithmeticCalculator.add(0, -5), -5, "0 + (-5) должно быть -5");
    }

    // === ТЕСТЫ ДЛЯ МЕТОДА SUBTRACT ===

    @Test(priority = 5, description = "Тест вычитания - положительные числа")
    public void testSubtractPositiveNumbers() {
        Assert.assertEquals(ArithmeticCalculator.subtract(5, 3), 2, "5 - 3 должно быть 2");
        Assert.assertEquals(ArithmeticCalculator.subtract(7, 3), 4, "7 - 3 должно быть 4");
        Assert.assertEquals(ArithmeticCalculator.subtract(50, 50), 0, "50 - 50 должно быть 0");
        Assert.assertEquals(ArithmeticCalculator.subtract(999, 1), 998, "999 - 1 должно быть 998");
        Assert.assertEquals(ArithmeticCalculator.subtract(3, 5), -2, "3 - 5 должно быть -2");
    }

    @Test(priority = 6, description = "Тест вычитания - отрицательные числа")
    public void testSubtractNegativeNumbers() {
        Assert.assertEquals(ArithmeticCalculator.subtract(-3, -5), 2, "-3 - (-5) должно быть 2");
        Assert.assertEquals(ArithmeticCalculator.subtract(-7, -3), -4, "-7 - (-3) должно быть -4");
        Assert.assertEquals(ArithmeticCalculator.subtract(-50, -50), 0, "-50 - (-50) должно быть 0");
    }

    @Test(priority = 7, description = "Тест вычитания - смешанные числа")
    public void testSubtractMixedNumbers() {
        Assert.assertEquals(ArithmeticCalculator.subtract(-5, 5), -10, "-5 - 5 должно быть -10");
        Assert.assertEquals(ArithmeticCalculator.subtract(-3, 5), -8, "-3 - 5 должно быть -8");
        Assert.assertEquals(ArithmeticCalculator.subtract(3, -5), 8, "3 - (-5) должно быть 8");
        Assert.assertEquals(ArithmeticCalculator.subtract(-10, 3), -13, "-10 - 3 должно быть -13");
    }

    @Test(priority = 8, description = "Тест вычитания - с нулем")
    public void testSubtractWithZero() {
        Assert.assertEquals(ArithmeticCalculator.subtract(0, 0), 0, "0 - 0 должно быть 0");
        Assert.assertEquals(ArithmeticCalculator.subtract(0, 5), -5, "0 - 5 должно быть -5");
        Assert.assertEquals(ArithmeticCalculator.subtract(5, 0), 5, "5 - 0 должно быть 5");
        Assert.assertEquals(ArithmeticCalculator.subtract(0, -5), 5, "0 - (-5) должно быть 5");
    }

    // === ТЕСТЫ ДЛЯ МЕТОДА MULTIPLY ===

    @Test(priority = 9, description = "Тест умножения - положительные числа")
    public void testMultiplyPositiveNumbers() {
        Assert.assertEquals(ArithmeticCalculator.multiply(3, 5), 15, "3 * 5 должно быть 15");
        Assert.assertEquals(ArithmeticCalculator.multiply(7, 3), 21, "7 * 3 должно быть 21");
        Assert.assertEquals(ArithmeticCalculator.multiply(50, 50), 2500, "50 * 50 должно быть 2500");
        Assert.assertEquals(ArithmeticCalculator.multiply(999, 1), 999, "999 * 1 должно быть 999");
    }

    @Test(priority = 10, description = "Тест умножения - отрицательные числа")
    public void testMultiplyNegativeNumbers() {
        Assert.assertEquals(ArithmeticCalculator.multiply(-3, -5), 15, "-3 * (-5) должно быть 15");
        Assert.assertEquals(ArithmeticCalculator.multiply(-7, -3), 21, "-7 * (-3) должно быть 21");
        Assert.assertEquals(ArithmeticCalculator.multiply(-50, -50), 2500, "-50 * (-50) должно быть 2500");
    }

    @Test(priority = 11, description = "Тест умножения - смешанные числа")
    public void testMultiplyMixedNumbers() {
        Assert.assertEquals(ArithmeticCalculator.multiply(-5, 5), -25, "-5 * 5 должно быть -25");
        Assert.assertEquals(ArithmeticCalculator.multiply(-3, 5), -15, "-3 * 5 должно быть -15");
        Assert.assertEquals(ArithmeticCalculator.multiply(3, -5), -15, "3 * (-5) должно быть -15");
        Assert.assertEquals(ArithmeticCalculator.multiply(-10, 3), -30, "-10 * 3 должно быть -30");
    }

    @Test(priority = 12, description = "Тест умножения - с нулем")
    public void testMultiplyWithZero() {
        Assert.assertEquals(ArithmeticCalculator.multiply(0, 0), 0, "0 * 0 должно быть 0");
        Assert.assertEquals(ArithmeticCalculator.multiply(50, 0), 0, "50 * 0 должно быть 0");
        Assert.assertEquals(ArithmeticCalculator.multiply(0, 100), 0, "0 * 100 должно быть 0");
        Assert.assertEquals(ArithmeticCalculator.multiply(-5, 0), 0, "-5 * 0 должно быть 0");
        Assert.assertEquals(ArithmeticCalculator.multiply(0, -10), 0, "0 * (-10) должно быть 0");
    }

    @Test(priority = 13, description = "Тест умножения - с единицей")
    public void testMultiplyWithOne() {
        Assert.assertEquals(ArithmeticCalculator.multiply(5, 1), 5, "5 * 1 должно быть 5");
        Assert.assertEquals(ArithmeticCalculator.multiply(1, 5), 5, "1 * 5 должно быть 5");
        Assert.assertEquals(ArithmeticCalculator.multiply(-5, 1), -5, "-5 * 1 должно быть -5");
        Assert.assertEquals(ArithmeticCalculator.multiply(1, -5), -5, "1 * (-5) должно быть -5");
    }

    // === ТЕСТЫ ДЛЯ МЕТОДА DIVIDE ===

    @Test(priority = 14, description = "Тест деления - положительные числа")
    public void testDividePositiveNumbers() {
        Assert.assertEquals(ArithmeticCalculator.divide(5, 2), 2.5, DELTA, "5 / 2 должно быть 2.5");
        Assert.assertEquals(ArithmeticCalculator.divide(6, 3), 2.0, DELTA, "6 / 3 должно быть 2.0");
        Assert.assertEquals(ArithmeticCalculator.divide(7, 7), 1.0, DELTA, "7 / 7 должно быть 1.0");
        Assert.assertEquals(ArithmeticCalculator.divide(999, 1), 999.0, DELTA, "999 / 1 должно быть 999.0");
        Assert.assertEquals(ArithmeticCalculator.divide(1, 5), 0.2, DELTA, "1 / 5 должно быть 0.2");
    }

    @Test(priority = 15, description = "Тест деления - отрицательные числа")
    public void testDivideNegativeNumbers() {
        Assert.assertEquals(ArithmeticCalculator.divide(-5, -2), 2.5, DELTA, "-5 / (-2) должно быть 2.5");
        Assert.assertEquals(ArithmeticCalculator.divide(-6, -3), 2.0, DELTA, "-6 / (-3) должно быть 2.0");
        Assert.assertEquals(ArithmeticCalculator.divide(-7, -7), 1.0, DELTA, "-7 / (-7) должно быть 1.0");
    }

    @Test(priority = 16, description = "Тест деления - смешанные числа")
    public void testDivideMixedNumbers() {
        Assert.assertEquals(ArithmeticCalculator.divide(-5, 2), -2.5, DELTA, "-5 / 2 должно быть -2.5");
        Assert.assertEquals(ArithmeticCalculator.divide(5, -2), -2.5, DELTA, "5 / (-2) должно быть -2.5");
        Assert.assertEquals(ArithmeticCalculator.divide(-6, 3), -2.0, DELTA, "-6 / 3 должно быть -2.0");
        Assert.assertEquals(ArithmeticCalculator.divide(6, -3), -2.0, DELTA, "6 / (-3) должно быть -2.0");
    }

    @Test(priority = 17, description = "Тест деления - деление нуля")
    public void testDivideZero() {
        Assert.assertEquals(ArithmeticCalculator.divide(0, 5), 0.0, DELTA, "0 / 5 должно быть 0.0");
        Assert.assertEquals(ArithmeticCalculator.divide(0, -5), 0.0, DELTA, "0 / (-5) должно быть 0.0");
        Assert.assertEquals(ArithmeticCalculator.divide(0, 1), 0.0, DELTA, "0 / 1 должно быть 0.0");
        Assert.assertEquals(ArithmeticCalculator.divide(0, 999), 0.0, DELTA, "0 / 999 должно быть 0.0");
    }

    @Test(priority = 18, expectedExceptions = IllegalArgumentException.class,
          description = "Тест деления на ноль - положительное число")
    public void testDivideByZeroPositive() {
        ArithmeticCalculator.divide(5, 0);
    }

    @Test(priority = 18, expectedExceptions = IllegalArgumentException.class,
          description = "Тест деления на ноль - другое положительное число")
    public void testDivideByZeroPositive2() {
        ArithmeticCalculator.divide(10, 0);
    }

    @Test(priority = 18, expectedExceptions = IllegalArgumentException.class,
          description = "Тест деления на ноль - единица")
    public void testDivideByZeroOne() {
        ArithmeticCalculator.divide(1, 0);
    }

    @Test(priority = 19, expectedExceptions = IllegalArgumentException.class,
          description = "Тест деления на ноль - отрицательное число")
    public void testDivideByZeroNegative() {
        ArithmeticCalculator.divide(-10, 0);
    }

    @Test(priority = 19, expectedExceptions = IllegalArgumentException.class,
          description = "Тест деления на ноль - другое отрицательное число")
    public void testDivideByZeroNegative2() {
        ArithmeticCalculator.divide(-5, 0);
    }

    @Test(priority = 20, expectedExceptions = IllegalArgumentException.class,
          description = "Тест деления нуля на ноль")
    public void testDivideZeroByZero() {
        ArithmeticCalculator.divide(0, 0);
    }

    @Test(priority = 20, expectedExceptions = {IllegalArgumentException.class},
          expectedExceptionsMessageRegExp = "Деление на ноль невозможно",
          description = "Тест сообщения исключения при делении на ноль")
    public void testDivideByZeroExceptionMessage() {
        ArithmeticCalculator.divide(15, 0);
    }

    @Test(priority = 21, description = "Тест операции деления - граничные случаи")
    public void testDivideBoundaryValues() {
        // Деление на 1
        Assert.assertEquals(ArithmeticCalculator.divide(5, 1), 5.0, DELTA, "5 / 1 должно быть 5.0");
        Assert.assertEquals(ArithmeticCalculator.divide(-5, 1), -5.0, DELTA, "-5 / 1 должно быть -5.0");

        // Деление на -1
        Assert.assertEquals(ArithmeticCalculator.divide(5, -1), -5.0, DELTA, "5 / (-1) должно быть -5.0");
        Assert.assertEquals(ArithmeticCalculator.divide(-5, -1), 5.0, DELTA, "-5 / (-1) должно быть 5.0");

        // Деление больших чисел
        Assert.assertEquals(ArithmeticCalculator.divide(1000, 500), 2.0, DELTA, "1000 / 500 должно быть 2.0");
        Assert.assertEquals(ArithmeticCalculator.divide(1, 1000), 0.001, DELTA, "1 / 1000 должно быть 0.001");
    }

    // === ПАРАМЕТРИЗОВАННЫЕ ТЕСТЫ ===

    @DataProvider(name = "additionData")
    public Object[][] additionTestData() {
        return new Object[][] {
            {1, 2, 3},
            {-1, 1, 0},
            {0, 0, 0},
            {10, -5, 5},
            {-3, -7, -10},
            {100, 200, 300},
            {-50, -50, -100}
        };
    }

    @Test(dataProvider = "additionData", priority = 22,
          description = "Параметризованный тест сложения")
    public void testAddWithDataProvider(int a, int b, int expected) {
        int actual = ArithmeticCalculator.add(a, b);
        Assert.assertEquals(actual, expected, a + " + " + b + " должно быть " + expected);
    }

    @DataProvider(name = "multiplicationData")
    public Object[][] multiplicationTestData() {
        return new Object[][] {
            {2, 3, 6},
            {-2, 3, -6},
            {-2, -3, 6},
            {0, 5, 0},
            {1, 10, 10},
            {-1, 5, -5},
            {7, 7, 49}
        };
    }

    @Test(dataProvider = "multiplicationData", priority = 23,
          description = "Параметризованный тест умножения")
    public void testMultiplyWithDataProvider(int a, int b, int expected) {
        int actual = ArithmeticCalculator.multiply(a, b);
        Assert.assertEquals(actual, expected, a + " * " + b + " должно быть " + expected);
    }

    @DataProvider(name = "subtractionData")
    public Object[][] subtractionTestData() {
        return new Object[][] {
            {5, 3, 2},
            {10, 10, 0},
            {3, 5, -2},
            {-5, -3, -2},
            {-3, -5, 2},
            {0, 5, -5},
            {5, 0, 5}
        };
    }

    @Test(dataProvider = "subtractionData", priority = 24,
          description = "Параметризованный тест вычитания")
    public void testSubtractWithDataProvider(int a, int b, int expected) {
        int actual = ArithmeticCalculator.subtract(a, b);
        Assert.assertEquals(actual, expected, a + " - " + b + " должно быть " + expected);
    }

    @DataProvider(name = "divisionData")
    public Object[][] divisionTestData() {
        return new Object[][] {
            {10, 2, 5.0},
            {15, 3, 5.0},
            {7, 2, 3.5},
            {-10, 2, -5.0},
            {10, -2, -5.0},
            {-10, -2, 5.0},
            {0, 5, 0.0},
            {1, 4, 0.25}
        };
    }

    @Test(dataProvider = "divisionData", priority = 25,
          description = "Параметризованный тест деления")
    public void testDivideWithDataProvider(int a, int b, double expected) {
        double actual = ArithmeticCalculator.divide(a, b);
        Assert.assertEquals(actual, expected, DELTA, a + " / " + b + " должно быть " + expected);
    }

    @DataProvider(name = "divisionByZeroData")
    public Object[][] divisionByZeroTestData() {
        return new Object[][] {
            {5},
            {-5},
            {0},
            {100},
            {-100},
            {1}
        };
    }

    @Test(dataProvider = "divisionByZeroData", priority = 26,
          expectedExceptions = IllegalArgumentException.class,
          description = "Параметризованный тест деления на ноль")
    public void testDivideByZeroWithDataProvider(int dividend) {
        ArithmeticCalculator.divide(dividend, 0);
    }

}