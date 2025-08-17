public class Park {

    private final String parkName;
    private final String location;

    // Конструктор
    public Park(String parkName, String location) {
        this.parkName = parkName;
        this.location = location;
    }

    // Внутренний класс для аттракционов
    public class Attraction {
        private final String attractionName;     // название аттракциона
        private final String workingHours;       // время работы
        private final double ticketPrice;        // стоимость билета
        private final String attractionType;     // тип аттракциона
        private final int minAge;                // минимальный возраст

        // Конструктор
        public Attraction(String attractionName, String workingHours,
                          double ticketPrice, String attractionType, int minAge) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.ticketPrice = ticketPrice;
            this.attractionType = attractionType;
            this.minAge = minAge;
        }

        // Метод вывода информации об аттракционе
        public void displayAttractionInfo() {
            System.out.println("=== Информация об аттракционе ===");
            System.out.println("Парк: " + parkName + " (" + location + ")");
            System.out.println("Название аттракциона: " + attractionName);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость билета: " + ticketPrice + " руб.");
            System.out.println("Тип аттракциона: " + attractionType);
            System.out.println("Минимальный возраст: " + minAge + " лет");
            System.out.println("=====================================\n");
        }
    }

    // Метод создания нового аттракциона
    public Attraction createAttraction(String name, String hours, double price, String type, int age) {
        return new Attraction(name, hours, price, type, age);
    }

}
