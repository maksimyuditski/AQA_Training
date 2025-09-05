public class ArithmeticCalculator {
    
    //Складывает два целых числа
    public static int add(int a, int b) {
        return a + b;
    }
    
    //Вычитает второе число из первого
    public static int subtract(int a, int b) {
        return a - b;
    }
    
    //Умножает два числа
    public static int multiply(int a, int b) {
        return a * b;
    }
    
    //Делит первое число на второе
    public static double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно");
        }
        return (double) a / b;
    }
    
    public static void main(String[] args) {
        int num1 = 20, num2 = 4;
        
        System.out.println(num1 + " + " + num2 + " = " + add(num1, num2));
        System.out.println(num1 + " - " + num2 + " = " + subtract(num1, num2));
        System.out.println(num1 + " * " + num2 + " = " + multiply(num1, num2));
        System.out.println(num1 + " / " + num2 + " = " + divide(num1, num2));
    }
}