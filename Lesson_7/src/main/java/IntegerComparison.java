public class IntegerComparison {
    
    //Сравнивает два целых числа
    public static int compare(int a, int b) {
        return Integer.compare(a, b);
    }
    
    //Проверяет, равны ли два числа
    public static boolean isEqual(int a, int b) {
        return a == b;
    }
    
    //Проверяет, больше ли первое число второго
    public static boolean isGreater(int a, int b) {
        return a > b;
    }
    
    //Проверяет, меньше ли первое число второго
    public static boolean isLess(int a, int b) {
        return a < b;
    }
    
    //Возвращает максимальное из двух чисел
    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    //Возвращает минимальное из двух чисел
    public static int min(int a, int b) {
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        int num1 = 15, num2 = 25;
        
        System.out.println("Сравнение " + num1 + " и " + num2 + ": " + compare(num1, num2));
        System.out.println(num1 + " == " + num2 + ": " + isEqual(num1, num2));
        System.out.println(num1 + " > " + num2 + ": " + isGreater(num1, num2));
        System.out.println(num1 + " < " + num2 + ": " + isLess(num1, num2));
        System.out.println("Максимум: " + max(num1, num2));
        System.out.println("Минимум: " + min(num1, num2));
    }
}