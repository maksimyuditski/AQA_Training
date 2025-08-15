import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Задание 1: printThreeWords");
        printThreeWords();
        
        System.out.println("\nЗадание 2: checkSumSign");
        checkSumSign();
        
        System.out.println("\nЗадание 3: printColor");
        printColor();
        
        System.out.println("\nЗадание 4: compareNumbers");
        compareNumbers();
        
        System.out.println("\nЗадание 5: checkSumRange");
        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();
        System.out.println("checkSumRange(" + num1 + ", " + num2 + "): " + checkSumRange(num1, num2));
        
        System.out.println("\nЗадание 6: checkPositiveOrNegative");
        System.out.print("Введите число для проверки знака: ");
        int numberToCheck = scanner.nextInt();
        checkPositiveOrNegative(numberToCheck);
        
        System.out.println("\nЗадание 7: isNegative");
        System.out.print("Введите число для проверки на отрицательность: ");
        int negativeCheck = scanner.nextInt();
        System.out.println("isNegative(" + negativeCheck + "): " + isNegative(negativeCheck));
        
        System.out.println("\nЗадание 8: printStringMultiple");
        scanner.nextLine();
        System.out.print("Введите строку для повторения: ");
        String textToPrint = scanner.nextLine();
        System.out.print("Введите количество повторений: ");
        int repeatCount = scanner.nextInt();
        printStringMultiple(textToPrint, repeatCount);
        
        System.out.println("\nЗадание 9: isLeapYear");
        System.out.print("Введите год для проверки на високосность: ");
        int year = scanner.nextInt();
        System.out.println("isLeapYear(" + year + "): " + isLeapYear(year));
        
        System.out.println("\nЗадание 10: flipArray");
        flipArray();
        
        System.out.println("\nЗадание 11: fillArray");
        fillArray();
        
        System.out.println("\nЗадание 12: multiplyArray");
        multiplyArray();
        
        System.out.println("\nЗадание 13: fillDiagonal");
        fillDiagonal();
        
        System.out.println("\nЗадание 14: createArray");
        System.out.print("Введите длину массива: ");
        int len = scanner.nextInt();
        System.out.print("Введите начальное значение для заполнения: ");
        int initialValue = scanner.nextInt();
        int[] customArray = createArray(len, initialValue);
        System.out.print("Созданный массив: ");
        for (int value : customArray) {
            System.out.print(value + " ");
        }
        System.out.println();
        
        scanner.close();
    }
    
    // Задание 1: Метод printThreeWords()
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    
    // Задание 2: Метод checkSumSign()
    public static void checkSumSign() {
        int a = 10;
        int b = -15;
        int sum = a + b;
        
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
    
    // Задание 3: Метод printColor()
    public static void printColor() {
        int value = 50;
        
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }
    
    // Задание 4: Метод compareNumbers()
    public static void compareNumbers() {
        int a = 15;
        int b = 10;
        
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
    
    // Задание 5: Метод проверки суммы в диапазоне 10-20
    public static boolean checkSumRange(int num1, int num2) {
        int sum = num1 + num2;
        return sum >= 10 && sum <= 20;
    }
    
    // Задание 6: Метод проверки положительного/отрицательного числа
    public static void checkPositiveOrNegative(int number) {
        if (number >= 0) {
            System.out.println("Число " + number + " положительное");
        } else {
            System.out.println("Число " + number + " отрицательное");
        }
    }
    
    // Задание 7: Метод проверки отрицательного числа
    public static boolean isNegative(int number) {
        return number < 0;
    }
    
    // Задание 8: Метод печати строки несколько раз
    public static void printStringMultiple(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }
    
    // Задание 9: Метод проверки високосного года
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    // Задание 10: Замена элементов массива
    public static void flipArray() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        
        System.out.print("Исходный массив: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
        
        // Замена 0 на 1, 1 на 0
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        
        System.out.print("Измененный массив: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    // Задание 11: Заполнение массива числами 1-100
    public static void fillArray() {
        int[] array = new int[100];
        
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        
        System.out.print("Заполненный массив (первые 10 элементов): ");
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("... (остальные элементы от 11 до 100)");
    }
    
    // Задание 12: Умножение элементов массива меньше 6 на 2
    public static void multiplyArray() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        
        System.out.print("Исходный массив: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        
        System.out.print("Измененный массив: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    // Задание 13: Заполнение диагоналей двумерного массива
    public static void fillDiagonal() {
        int size = 5;
        int[][] matrix = new int[size][size];
        
        // Заполнение главной диагонали единицами
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }
        
        // Заполнение побочной диагонали единицами (опционально)
        for (int i = 0; i < size; i++) {
            matrix[i][size - 1 - i] = 1;
        }
        
        System.out.println("Двумерный массив с заполненными диагоналями:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    // Задание 14: Создание массива с заданными параметрами
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        
        return array;
    }
}