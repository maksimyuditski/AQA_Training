public class Main {
    
    public static void main(String[] args) {

        System.out.println("=== ЗАДАНИЕ 1: Демонстрация класса Product ===\n");
        
        // Создание объектов
        Product product1 = new Product("iPhone 15", "17.08.2025",
                                      "Apple", "США", 1000, false);
        product1.displayInfo();
        
        System.out.println("=== ЗАДАНИЕ 2: Создание массива из 5 товаров ===\n");
        
        // Массив объектов
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S20", "01.02.2025",
                                     "Samsung", "Korea", 2000, true);
        
        productsArray[1] = new Product("MacBook", "12.12.2024",
                                     "Apple", "США", 5000, false);
        
        productsArray[2] = new Product("PlayStation 5", "01.01.2020",
                                     "Sony", "Япония", 2000, true);
        
        productsArray[3] = new Product("Nintendo Switch", "01.01.2021",
                                     "Nintendo", "Япония", 1000, false);
        
        productsArray[4] = new Product("ASUS какой-то", "01.01.2025",
                                     "ASUS", "США", 5000, true);
        
        // Вывод информации о всех товарах из массива
        System.out.println("Информация о всех товарах в массиве:\n");
        for (int i = 0; i < productsArray.length; i++) {
            System.out.println("Товар " + (i + 1) + ":");
            productsArray[i].displayInfo();
        }
        
        System.out.println("=== ЗАДАНИЕ 3: Демонстрация класса Park с внутренним классом ===\n");
        
        // Создание объекта парка
        Park disneyLand = new Park("Диснейленд", "Париж");
        
        // Создание аттракционов через внутренний класс
        Park.Attraction rollerCoaster = disneyLand.createAttraction(
            "Вагонетки", "09:00 - 22:00", 1200.0, "Американские горки", 12);
        
        Park.Attraction carousel = disneyLand.createAttraction(
            "Кружки", "10:00 - 21:00", 500.0, "Карусель", 3);

        
        // Вывод информации об аттракционах
        rollerCoaster.displayAttractionInfo();
        carousel.displayAttractionInfo();

    }
}