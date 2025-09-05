import org.testng.Assert;
import org.testng.annotations.*;

public class TriangleAreaTest {
    
    private static final double DELTA = 0.001; // допустимая погрешность для double
    
    @BeforeClass
    public void setUp() {
        System.out.println("Начало тестирования класса TriangleArea");
    }
    
    @AfterClass
    public void tearDown() {
        System.out.println("Завершение тестирования класса TriangleArea");
    }
    
    // === ТЕСТЫ ДЛЯ МЕТОДА calculateAreaByBaseAndHeight ===
    
    @Test(priority = 1, description = "Тест вычисления площади по основанию и высоте - положительные случаи")
    public void testCalculateAreaByBaseAndHeightPositive() {
        Assert.assertEquals(TriangleArea.calculateAreaByBaseAndHeight(10.0, 5.0), 25.0, DELTA,
                           "Площадь треугольника с основанием 10 и высотой 5 должна быть 25");
        
        Assert.assertEquals(TriangleArea.calculateAreaByBaseAndHeight(4.0, 3.0), 6.0, DELTA,
                           "Площадь треугольника с основанием 4 и высотой 3 должна быть 6");
        
        Assert.assertEquals(TriangleArea.calculateAreaByBaseAndHeight(1.0, 1.0), 0.5, DELTA,
                           "Площадь треугольника с основанием 1 и высотой 1 должна быть 0.5");
        
        Assert.assertEquals(TriangleArea.calculateAreaByBaseAndHeight(3.0, 5.0), 7.5, DELTA,
                           "Площадь треугольника с основанием 3 и высотой 5 должна быть 7.5");
        
        Assert.assertEquals(TriangleArea.calculateAreaByBaseAndHeight(20.0, 5.0), 50.0, DELTA,
                           "Площадь треугольника с основанием 20 и высотой 5 должна быть 50");
    }
    
    @Test(priority = 2, expectedExceptions = IllegalArgumentException.class,
          description = "Тест с недопустимым основанием (ноль)")
    public void testCalculateAreaByBaseAndHeightZeroBase() {
        TriangleArea.calculateAreaByBaseAndHeight(0, 5);
    }
    
    @Test(priority = 2, expectedExceptions = IllegalArgumentException.class,
          description = "Тест с недопустимой высотой (ноль)")
    public void testCalculateAreaByBaseAndHeightZeroHeight() {
        TriangleArea.calculateAreaByBaseAndHeight(5, 0);
    }
    
    @Test(priority = 2, expectedExceptions = IllegalArgumentException.class,
          description = "Тест с отрицательным основанием")
    public void testCalculateAreaByBaseAndHeightNegativeBase() {
        TriangleArea.calculateAreaByBaseAndHeight(-5, 5);
    }
    
    @Test(priority = 2, expectedExceptions = IllegalArgumentException.class,
          description = "Тест с отрицательной высотой")
    public void testCalculateAreaByBaseAndHeightNegativeHeight() {
        TriangleArea.calculateAreaByBaseAndHeight(5, -5);
    }
    
    @Test(priority = 2, expectedExceptions = IllegalArgumentException.class,
          description = "Тест с обоими недопустимыми параметрами")
    public void testCalculateAreaByBaseAndHeightBothInvalid() {
        TriangleArea.calculateAreaByBaseAndHeight(0, 0);
    }
    
    @Test(priority = 2, expectedExceptions = IllegalArgumentException.class,
          description = "Тест с отрицательными основанием и высотой")
    public void testCalculateAreaByBaseAndHeightBothNegative() {
        TriangleArea.calculateAreaByBaseAndHeight(-5, -3);
    }
    
    @Test(priority = 2, expectedExceptions = {IllegalArgumentException.class},
          expectedExceptionsMessageRegExp = "Основание и высота должны быть положительными числами",
          description = "Тест сообщения исключения для недопустимых параметров")
    public void testCalculateAreaByBaseAndHeightExceptionMessage() {
        TriangleArea.calculateAreaByBaseAndHeight(-0.1, 5);
    }
    
    // === ТЕСТЫ ДЛЯ МЕТОДА calculateAreaBySides ===
    
    @Test(priority = 3, description = "Тест вычисления площади по трем сторонам - положительные случаи")
    public void testCalculateAreaBySidesPositive() {
        // Прямоугольный треугольник 3-4-5
        Assert.assertEquals(TriangleArea.calculateAreaBySides(3.0, 4.0, 5.0), 6.0, DELTA,
                           "Площадь треугольника со сторонами 3, 4, 5 должна быть 6");
        
        // Равносторонний треугольник со стороной 2
        double expectedEquilateral = Math.sqrt(3.0);
        Assert.assertEquals(TriangleArea.calculateAreaBySides(2.0, 2.0, 2.0), expectedEquilateral, DELTA,
                           "Площадь равностороннего треугольника со стороной 2");
        
        // Прямоугольный треугольник 5-12-13
        Assert.assertEquals(TriangleArea.calculateAreaBySides(5.0, 12.0, 13.0), 30.0, DELTA,
                           "Площадь треугольника со сторонами 5, 12, 13 должна быть 30");
        
        // Равнобедренный треугольник
        Assert.assertEquals(TriangleArea.calculateAreaBySides(5.0, 5.0, 6.0), 12.0, DELTA,
                           "Площадь равнобедренного треугольника со сторонами 5, 5, 6");
    }
    
    @Test(priority = 4, expectedExceptions = IllegalArgumentException.class,
          description = "Тест с отрицательной первой стороной")
    public void testCalculateAreaBySidesNegativeFirst() {
        TriangleArea.calculateAreaBySides(-1, 2, 3);
    }
    
    @Test(priority = 4, expectedExceptions = IllegalArgumentException.class,
          description = "Тест с отрицательной второй стороной")
    public void testCalculateAreaBySidesNegativeSecond() {
        TriangleArea.calculateAreaBySides(1, -2, 3);
    }
    
    @Test(priority = 4, expectedExceptions = IllegalArgumentException.class,
          description = "Тест с отрицательной третьей стороной")
    public void testCalculateAreaBySidesNegativeThird() {
        TriangleArea.calculateAreaBySides(1, 2, -3);
    }
    
    @Test(priority = 4, expectedExceptions = IllegalArgumentException.class,
          description = "Тест с нулевой первой стороной")
    public void testCalculateAreaBySidesZeroFirst() {
        TriangleArea.calculateAreaBySides(0, 2, 3);
    }
    
    @Test(priority = 4, expectedExceptions = IllegalArgumentException.class,
          description = "Тест с нулевой второй стороной")
    public void testCalculateAreaBySidesZeroSecond() {
        TriangleArea.calculateAreaBySides(1, 0, 3);
    }
    
    @Test(priority = 4, expectedExceptions = IllegalArgumentException.class,
          description = "Тест с нулевой третьей стороной")
    public void testCalculateAreaBySidesZeroThird() {
        TriangleArea.calculateAreaBySides(1, 2, 0);
    }
    
    @Test(priority = 5, expectedExceptions = IllegalArgumentException.class,
          description = "Тест с нарушением неравенства треугольника: a + b <= c")
    public void testCalculateAreaBySidesInvalidTriangle1() {
        TriangleArea.calculateAreaBySides(1, 2, 5);
    }
    
    @Test(priority = 5, expectedExceptions = IllegalArgumentException.class,
          description = "Тест с нарушением неравенства треугольника: a + b = c")
    public void testCalculateAreaBySidesInvalidTriangle2() {
        TriangleArea.calculateAreaBySides(1, 1, 2);
    }
    
    @Test(priority = 5, expectedExceptions = IllegalArgumentException.class,
          description = "Тест с нарушением неравенства треугольника: a + c <= b")
    public void testCalculateAreaBySidesInvalidTriangle3() {
        TriangleArea.calculateAreaBySides(1, 5, 2);
    }
    
    @Test(priority = 5, expectedExceptions = IllegalArgumentException.class,
          description = "Тест с нарушением неравенства треугольника: b + c <= a")
    public void testCalculateAreaBySidesInvalidTriangle4() {
        TriangleArea.calculateAreaBySides(5, 1, 2);
    }
    
    @Test(priority = 5, expectedExceptions = IllegalArgumentException.class,
          description = "Тест граничного случая - равенство суммы сторон третьей стороне")
    public void testCalculateAreaBySidesInvalidTriangle5() {
        TriangleArea.calculateAreaBySides(3, 4, 7);
    }
    
    @Test(priority = 5, expectedExceptions = {IllegalArgumentException.class},
          expectedExceptionsMessageRegExp = "Данные стороны не образуют валидный треугольник",
          description = "Тест сообщения исключения для неравенства треугольника")
    public void testCalculateAreaBySidesTriangleInequalityMessage() {
        TriangleArea.calculateAreaBySides(1, 1, 3);
    }
    
    // === ГРАНИЧНЫЕ ТЕСТЫ ===
    
    @Test(priority = 6, description = "Тест маленьких положительных значений")
    public void testCalculateAreaSmallValues() {
        // Очень маленькие, но валидные значения
        double smallArea = TriangleArea.calculateAreaByBaseAndHeight(0.001, 0.002);
        Assert.assertEquals(smallArea, 0.000001, 0.0000001, "Площадь для очень маленьких значений");
        
        // Маленький равносторонний треугольник
        double result = TriangleArea.calculateAreaBySides(0.1, 0.1, 0.1);
        Assert.assertTrue(result > 0, "Площадь маленького треугольника должна быть положительной");
    }
    
    // === ПАРАМЕТРИЗОВАННЫЕ ТЕСТЫ ===
    
    @DataProvider(name = "validBaseHeightData")
    public Object[][] validBaseHeightTestData() {
        return new Object[][] {
            {1.0, 1.0, 0.5},
            {2.0, 3.0, 3.0},
            {4.0, 5.0, 10.0},
            {10.0, 2.0, 10.0},
            {6.0, 4.0, 12.0},
            {8.0, 7.5, 30.0}
        };
    }
    
    @Test(dataProvider = "validBaseHeightData", priority = 7,
          description = "Параметризованный тест площади треугольника по основанию и высоте")
    public void testTriangleAreaBaseHeightWithDataProvider(double base, double height, double expectedArea) {
        double actual = TriangleArea.calculateAreaByBaseAndHeight(base, height);
        Assert.assertEquals(actual, expectedArea, DELTA,
                           "Площадь треугольника с основанием " + base + " и высотой " + height);
    }
    
    @DataProvider(name = "validTrianglesData")
    public Object[][] validTriangleTestData() {
        return new Object[][] {
            {3.0, 4.0, 5.0, 6.0},           // прямоугольный треугольник
            {5.0, 12.0, 13.0, 30.0},        // прямоугольный треугольник
            {6.0, 8.0, 10.0, 24.0},         // прямоугольный треугольник
            {5.0, 5.0, 6.0, 12.0},          // равнобедренный треугольник (приблизительно)
            {2.0, 2.0, 2.0, 1.732}          // равносторонний треугольник (приблизительно sqrt(3))
        };
    }
    
    @Test(dataProvider = "validTrianglesData", priority = 8,
          description = "Параметризованный тест площади треугольника по сторонам")
    public void testTriangleAreaSidesWithDataProvider(double a, double b, double c, double expectedArea) {
        double actual = TriangleArea.calculateAreaBySides(a, b, c);
        Assert.assertEquals(actual, expectedArea, 0.1,
                           "Площадь треугольника со сторонами " + a + ", " + b + ", " + c);
    }
    
    @DataProvider(name = "invalidBaseHeightData")
    public Object[][] invalidBaseHeightTestData() {
        return new Object[][] {
            {0.0, 5.0},      // нулевое основание
            {5.0, 0.0},      // нулевая высота
            {-1.0, 5.0},     // отрицательное основание
            {5.0, -1.0},     // отрицательная высота
            {-2.0, -3.0},    // оба отрицательные
            {0.0, 0.0}       // оба нуля
        };
    }
    
    @Test(dataProvider = "invalidBaseHeightData", priority = 9,
          expectedExceptions = IllegalArgumentException.class,
          description = "Параметризованный тест недопустимых значений основания и высоты")
    public void testTriangleAreaInvalidBaseHeightWithDataProvider(double base, double height) {
        TriangleArea.calculateAreaByBaseAndHeight(base, height);
    }
    
    @DataProvider(name = "invalidTriangleData")
    public Object[][] invalidTriangleTestData() {
        return new Object[][] {
            {-1.0, 2.0, 3.0},    // отрицательная сторона
            {1.0, -2.0, 3.0},    // отрицательная сторона
            {1.0, 2.0, -3.0},    // отрицательная сторона
            {0.0, 2.0, 3.0},     // нулевая сторона
            {1.0, 0.0, 3.0},     // нулевая сторона
            {1.0, 2.0, 0.0},     // нулевая сторона
            {1.0, 2.0, 5.0},     // нарушение неравенства треугольника
            {1.0, 1.0, 2.0},     // нарушение неравенства треугольника
            {3.0, 4.0, 7.0}      // нарушение неравенства треугольника
        };
    }
    
    @Test(dataProvider = "invalidTriangleData", priority = 10,
          expectedExceptions = IllegalArgumentException.class,
          description = "Параметризованный тест недопустимых треугольников")
    public void testTriangleAreaInvalidTriangleWithDataProvider(double a, double b, double c) {
        TriangleArea.calculateAreaBySides(a, b, c);
    }

}