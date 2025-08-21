public interface Shape {

    double calculateArea();

    // Дефолтный метод для периметра
    default double calculatePerimeter() {
        return 0.0;
    }

    // Методы для работы с цветами
    String getFillColor();

    String getBorderColor();

    void setColors(String fillColor, String borderColor);

    // Дефолтный метод для вывода информации о фигуре
    default void displayInfo() {
        System.out.println("Тип: " + this.getClass().getSimpleName());
        System.out.println("Периметр: " + String.format("%.2f", calculatePerimeter()));
        System.out.println("Площадь: " + String.format("%.2f", calculateArea()));
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println("============================");
    }
}
