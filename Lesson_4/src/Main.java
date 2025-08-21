public class Main {
    
    public static void main(String[] args) {
        
        // ЗАДАНИЕ 1
        System.out.println("=== ЗАДАНИЕ 1 ===\n");
        
        // Создание животных
        Dog dogBobik = new Dog("Бобик");
        Dog dogRex = new Dog("Рекс");
        Cat catMurka = new Cat("Мурка");
        Cat catBarsik = new Cat("Барсик");
        Cat catRomka = new Cat("Ромка");
        
        System.out.println("=== Тестирование бега и плавания ===");
        // Тестирование бега
        dogBobik.run(150);
        dogBobik.run(600); // превышение лимита
        catMurka.run(100);
        catMurka.run(250); // превышение лимита
        
        // Тестирование плавания
        dogRex.swim(5);
        dogRex.swim(15); // превышение лимита
        catBarsik.swim(10); // коты не умеют плавать
        
        System.out.println("\n=== Подсчет созданных животных ===");
        System.out.println("Всего животных: " + Animal.getTotalAnimalsCount());
        System.out.println("Собак: " + Dog.getDogsCount());
        System.out.println("Котов: " + Cat.getCatsCount());
        
        // === РАБОТА С МИСКОЙ ===
        System.out.println("\n=== Кормление котов ===");
        
        // Создание массива котов и миски
        Cat[] cats = {catMurka, catBarsik, catRomka};
        FoodBowl bowl = new FoodBowl(25);
        
        System.out.println("Изначальное количество еды: " + bowl.getFoodAmount());

        for (Cat cat : cats) {
            cat.eatFromBowl(bowl, 10);
            System.out.println("Осталось еды: " + bowl.getFoodAmount());
        }
        
        // Проверка сытости котов
        System.out.println("\n=== Проверка сытости котов ===");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " - " + (cat.isFull() ? "сытый" : "голодный"));
        }
        
        // Добавление еды в миску
        System.out.println("\n=== Добавление еды в миску ===");
        bowl.addFood(20);
        
        // Кормление голодного кота
        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eatFromBowl(bowl, 10);
                break;
            }
        }
        
        // ЗАДАНИЕ 2
        System.out.println("\n\n=== ЗАДАНИЕ 2 ===\n");
        
        // Создание геометрических фигур
        Circle circle = new Circle(5.0, "Красный", "Черный");
        Rectangle rectangle = new Rectangle(4.0, 6.0, "Синий", "Белый");
        Triangle triangle = new Triangle(3.0, 4.0, 5.0, "Зеленый", "Желтый");
        
        // Массив фигур для демонстрации полиморфизма
        Shape[] shapes = {circle, rectangle, triangle};
        
        System.out.println("=== Характеристики всех фигур ===");
        for (Shape shape : shapes) {
            shape.displayInfo();
        }
        
        // Демонстрация изменения цветов
        System.out.println("\n=== Изменение цветов фигур ===");
        circle.setColors("Оранжевый", "Фиолетовый");
        System.out.println("Новые цвета круга:");
        circle.displayInfo();
        
        // Дополнительные расчеты
        System.out.println("\n=== Дополнительные расчеты ===");
        double totalArea = 0;
        double totalPerimeter = 0;
        
        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();
            totalPerimeter += shape.calculatePerimeter();
        }
        
        System.out.println("Общая площадь всех фигур: " + String.format("%.2f", totalArea));
        System.out.println("Общий периметр всех фигур: " + String.format("%.2f", totalPerimeter));
        System.out.println("============================");

    }
}