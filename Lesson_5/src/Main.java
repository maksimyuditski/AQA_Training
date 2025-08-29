public class Main {
    
    // Константы для размера массива
    private static final int REQUIRED_SIZE = 4;

    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверка размера массива
        if (array == null) {
            throw new MyArraySizeException("Массив не может быть null");
        }
        
        if (array.length != REQUIRED_SIZE) {
            throw new MyArraySizeException("Неправильное количество строк: " + array.length + ". Ожидается: " + REQUIRED_SIZE);
        }
        
        // Проверка количества столбцов в каждой строке
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null || array[i].length != REQUIRED_SIZE) {
                int actualLength = (array[i] == null) ? 0 : array[i].length;
                throw new MyArraySizeException("Неправильное количество столбцов в строке " + i + ": " + actualLength + ". Ожидается: " + REQUIRED_SIZE);
            }
        }
        
        // Обработка элементов массива и подсчет суммы
        int sum = 0;
        for (int i = 0; i < REQUIRED_SIZE; i++) {
            for (int j = 0; j < REQUIRED_SIZE; j++) {
                try {
                    // Попытка преобразования строки в число
                    int value = Integer.parseInt(array[i][j]);
                    sum += value;
                    System.out.println("Ячейка [" + i + "][" + j + "]: " + array[i][j] + " -> " + value);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Невозможно преобразовать '" + array[i][j] + "' в число", i, j);
                } catch (NullPointerException e) {
                    throw new MyArrayDataException("Значение null", i, j);
                }
            }
        }
        
        return sum;
    }
    
    // Метод ArrayIndexOutOfBoundsException
    public static void demonstrateArrayIndexOutOfBoundsException() {
        System.out.println("\n=== Демонстрация ArrayIndexOutOfBoundsException ===");
        
        int[] testArray = {1, 2, 3, 4, 5};
        System.out.println("Создан массив размером " + testArray.length + ": " + java.util.Arrays.toString(testArray));
        
        try {
            System.out.println("Попытка доступа к элементу с индексом 10...");
            int value = testArray[10]; // Это вызовет исключение
            System.out.println("Значение: " + value); // Эта строка не выполнится
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение ArrayIndexOutOfBoundsException:");
            System.out.println("Сообщение: " + e.getMessage());
            System.out.println("Причина: попытка доступа к несуществующему индексу массива");
        }
        
        // Демонстрация с отрицательным индексом
        try {
            System.out.println("\nПопытка доступа к элементу с индексом -1...");
            int value = testArray[-1]; // Это также вызовет исключение
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение ArrayIndexOutOfBoundsException:");
            System.out.println("Сообщение: " + e.getMessage());
            System.out.println("Причина: отрицательный индекс массива");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== ОБРАБОТКА ИСКЛЮЧЕНИЙ В JAVA ===\n");
        
        // === ТЕСТ 1: Корректный массив ===
        System.out.println("--- ТЕСТ 1: Корректный массив 4х4 ---");
        String[][] correctArray = {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
        };
        
        try {
            int result = processArray(correctArray);
            System.out.println("Результат вычисления: " + result);
        } catch (MyArraySizeException e) {
            System.err.println("Ошибка размера массива: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println("Ошибка данных: " + e.getMessage());
        }
        
        // === ТЕСТ 2: Неправильный размер массива ===
        System.out.println("\n--- ТЕСТ 2: Неправильный размер массива (3х3) ---");
        String[][] wrongSizeArray = {
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"}
        };
        
        try {
            int result = processArray(wrongSizeArray);
            System.out.println("Результат вычисления: " + result);
        } catch (MyArraySizeException e) {
            System.err.println("Ошибка размера массива: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println("Ошибка данных: " + e.getMessage());
        }
        
        // === ТЕСТ 3: Неверные данные в массиве ===
        System.out.println("\n--- ТЕСТ 3: Неверные данные в массиве ---");
        String[][] invalidDataArray = {
            {"1", "2", "3", "4"},
            {"5", "abc", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "text"}
        };
        
        try {
            int result = processArray(invalidDataArray);
            System.out.println("Результат вычисления: " + result);
        } catch (MyArraySizeException e) {
            System.err.println("Ошибка размера массива: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println("Ошибка данных: " + e.getMessage());
            System.err.println("Позиция ошибки - строка: " + e.getRow() + ", столбец: " + e.getColumn());
        }
        
        // === ТЕСТ 4: Null элементы ===
        System.out.println("\n--- ТЕСТ 4: Null элементы в массиве ---");
        String[][] nullDataArray = {
            {"1", "2", "3", "4"},
            {"5", null, "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
        };
        
        try {
            int result = processArray(nullDataArray);
            System.out.println("Результат вычисления: " + result);
        } catch (MyArraySizeException e) {
            System.err.println("Ошибка размера массива: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println("Ошибка данных: " + e.getMessage());
        }
        
        // === ТЕСТ 5: Массив с отрицательными числами ===
        System.out.println("\n--- ТЕСТ 5: Массив с отрицательными числами ---");
        String[][] negativeArray = {
            {"-1", "2", "-3", "4"},
            {"5", "-6", "7", "-8"},
            {"-9", "10", "-11", "12"},
            {"13", "-14", "15", "-16"}
        };
        
        try {
            int result = processArray(negativeArray);
            System.out.println("Результат вычисления: " + result);
        } catch (MyArraySizeException e) {
            System.err.println("Ошибка размера массива: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println("Ошибка данных: " + e.getMessage());
        }
        
        // === ArrayIndexOutOfBoundsException ===
        demonstrateArrayIndexOutOfBoundsException();

    }
}