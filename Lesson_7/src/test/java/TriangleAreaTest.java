import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты для класса TriangleArea")
class TriangleAreaTest {
    
    private static final double DELTA = 0.001; // допустимая погрешность для double
    
    @Test
    @DisplayName("Тест вычисления площади по основанию и высоте - положительные случаи")
    void testCalculateAreaByBaseAndHeightPositive() {
        assertEquals(25.0, TriangleArea.calculateAreaByBaseAndHeight(10.0, 5.0), DELTA,
                    "Площадь треугольника с основанием 10 и высотой 5 должна быть 25");
        
        assertEquals(6.0, TriangleArea.calculateAreaByBaseAndHeight(4.0, 3.0), DELTA,
                    "Площадь треугольника с основанием 4 и высотой 3 должна быть 6");
        
        assertEquals(0.5, TriangleArea.calculateAreaByBaseAndHeight(1.0, 1.0), DELTA,
                    "Площадь треугольника с основанием 1 и высотой 1 должна быть 0.5");
        
        assertEquals(7.5, TriangleArea.calculateAreaByBaseAndHeight(3.0, 5.0), DELTA,
                    "Площадь треугольника с основанием 3 и высотой 5 должна быть 7.5");
        
        assertEquals(50.0, TriangleArea.calculateAreaByBaseAndHeight(20.0, 5.0), DELTA,
                    "Площадь треугольника с основанием 20 и высотой 5 должна быть 50");
    }
    
    @Test
    @DisplayName("Тест с недопустимыми значениями основания")
    void testCalculateAreaByBaseAndHeightInvalidBase() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaByBaseAndHeight(0, 5);
        }, "Должно выбрасываться исключение для основания = 0");
        
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaByBaseAndHeight(-5, 5);
        }, "Должно выбрасываться исключение для отрицательного основания");
        
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaByBaseAndHeight(-0.1, 5);
        }, "Должно выбрасываться исключение для отрицательного основания");
    }
    
    @Test
    @DisplayName("Тест с недопустимыми значениями высоты")
    void testCalculateAreaByBaseAndHeightInvalidHeight() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaByBaseAndHeight(5, 0);
        }, "Должно выбрасываться исключение для высоты = 0");
        
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaByBaseAndHeight(5, -5);
        }, "Должно выбрасываться исключение для отрицательной высоты");
        
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaByBaseAndHeight(5, -0.1);
        }, "Должно выбрасываться исключение для отрицательной высоты");
    }
    
    @Test
    @DisplayName("Тест с обоими недопустимыми параметрами")
    void testCalculateAreaByBaseAndHeightBothInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaByBaseAndHeight(0, 0);
        }, "Должно выбрасываться исключение для основания и высоты = 0");
        
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaByBaseAndHeight(-5, -3);
        }, "Должно выбрасываться исключение для отрицательных основания и высоты");
    }
    
    @Test
    @DisplayName("Тест вычисления площади по трем сторонам - положительные случаи")
    void testCalculateAreaBySidesPositive() {
        // Прямоугольный треугольник 3-4-5
        assertEquals(6.0, TriangleArea.calculateAreaBySides(3.0, 4.0, 5.0), DELTA,
                    "Площадь треугольника со сторонами 3, 4, 5 должна быть 6");
        
        // Равносторонний треугольник со стороной 2
        double expectedEquilateral = Math.sqrt(3.0); // площадь равностороннего треугольника со стороной 2
        assertEquals(expectedEquilateral, TriangleArea.calculateAreaBySides(2.0, 2.0, 2.0), DELTA,
                    "Площадь равностороннего треугольника со стороной 2");
        
        // Прямоугольный треугольник 5-12-13
        assertEquals(30.0, TriangleArea.calculateAreaBySides(5.0, 12.0, 13.0), DELTA,
                    "Площадь треугольника со сторонами 5, 12, 13 должна быть 30");
        
        // Равнобедренный треугольник
        assertEquals(12.0, TriangleArea.calculateAreaBySides(5.0, 5.0, 6.0), DELTA,
                    "Площадь равнобедренного треугольника со сторонами 5, 5, 6");
    }
    
    @Test
    @DisplayName("Тест с отрицательными сторонами")
    void testCalculateAreaBySidesNegativeSides() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaBySides(-1, 2, 3);
        }, "Должно выбрасываться исключение для отрицательной первой стороны");
        
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaBySides(1, -2, 3);
        }, "Должно выбрасываться исключение для отрицательной второй стороны");
        
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaBySides(1, 2, -3);
        }, "Должно выбрасываться исключение для отрицательной третьей стороны");
        
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaBySides(-1, -2, -3);
        }, "Должно выбрасываться исключение для всех отрицательных сторон");
    }
    
    @Test
    @DisplayName("Тест с нулевыми сторонами")
    void testCalculateAreaBySidesZeroSides() {
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaBySides(0, 2, 3);
        }, "Должно выбрасываться исключение для нулевой первой стороны");
        
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaBySides(1, 0, 3);
        }, "Должно выбрасываться исключение для нулевой второй стороны");
        
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaBySides(1, 2, 0);
        }, "Должно выбрасываться исключение для нулевой третьей стороны");
    }
    
    @Test
    @DisplayName("Тест с нарушением неравенства треугольника")
    void testCalculateAreaBySidesTriangleInequality() {
        // a + b <= c
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaBySides(1, 2, 5);
        }, "Должно выбрасываться исключение при нарушении неравенства треугольника (1+2 <= 5)");
        
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaBySides(1, 1, 2);
        }, "Должно выбрасываться исключение при нарушении неравенства треугольника (1+1 = 2)");
        
        // a + c <= b
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaBySides(1, 5, 2);
        }, "Должно выбрасываться исключение при нарушении неравенства треугольника (1+2 <= 5)");
        
        // b + c <= a
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaBySides(5, 1, 2);
        }, "Должно выбрасываться исключение при нарушении неравенства треугольника (1+2 <= 5)");
        
        // Граничный случай - равенство
        assertThrows(IllegalArgumentException.class, () -> {
            TriangleArea.calculateAreaBySides(3, 4, 7);
        }, "Должно выбрасываться исключение при равенстве суммы сторон третьей стороне");
    }
    
    @Test
    @DisplayName("Тест маленьких положительных значений")
    void testCalculateAreaSmallValues() {
        // Очень маленькие но валидные значения
        double smallArea = TriangleArea.calculateAreaByBaseAndHeight(0.001, 0.002);
        assertEquals(0.000001, smallArea, 0.0000001, "Площадь для очень маленьких значений");
        
        // Маленький равносторонний треугольник
        double result = TriangleArea.calculateAreaBySides(0.1, 0.1, 0.1);
        assertTrue(result > 0, "Площадь маленького треугольника должна быть положительной");
    }
}