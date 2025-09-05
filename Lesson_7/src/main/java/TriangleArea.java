public class TriangleArea {
    
    //Вычисляет площадь треугольника по основанию и высоте
    public static double calculateAreaByBaseAndHeight(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Основание и высота должны быть положительными числами");
        }
        return (base * height) / 2.0;
    }
    
    //Вычисляет площадь треугольника по трем сторонам (формула Герона)
    public static double calculateAreaBySides(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Все стороны должны быть положительными числами");
        }
        
        // Проверяем неравенство треугольника
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Данные стороны не образуют валидный треугольник");
        }
        
        // Формула Герона
        double s = (a + b + c) / 2.0; // полупериметр
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    
    public static void main(String[] args) {
        // Тест по основанию и высоте
        double base = 10.0;
        double height = 5.0;
        System.out.println("Площадь треугольника (основание=" + base + ", высота=" + height + ") = " 
                          + calculateAreaByBaseAndHeight(base, height));
        
        // Тест по трем сторонам
        double a = 3.0, b = 4.0, c = 5.0;
        System.out.println("Площадь треугольника (стороны: " + a + ", " + b + ", " + c + ") = " 
                          + calculateAreaBySides(a, b, c));
    }
}