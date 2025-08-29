import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ С КОЛЛЕКЦИЯМИ JAVA ===\n");
        
        // === ЗАДАНИЕ 1: РАБОТА СО СТУДЕНТАМИ ===
        System.out.println("=== ЗАДАНИЕ 1: УПРАВЛЕНИЕ СТУДЕНТАМИ ===");
        
        // Создание менеджера студентов
        StudentManager manager = new StudentManager();
        
        // Создание студентов с разными оценками
        Student student1 = new Student("Иванов Иван", "ИТ-21", 2);
        student1.addGrade(4.5);
        student1.addGrade(4.0);
        student1.addGrade(5.0);
        student1.addGrade(4.2);
        
        Student student2 = new Student("Петров Петр", "ИТ-21", 2);
        student2.addGrade(2.5);
        student2.addGrade(3.0);
        student2.addGrade(2.0);
        
        Student student3 = new Student("Сидоров Сергей", "ИТ-22", 3);
        student3.addGrade(3.5);
        student3.addGrade(4.0);
        student3.addGrade(3.8);
        
        Student student4 = new Student("Козлова Анна", "ИТ-21", 2);
        student4.addGrade(4.8);
        student4.addGrade(4.9);
        student4.addGrade(4.7);
        
        Student student5 = new Student("Морозов Алексей", "ИТ-23", 3);
        student5.addGrade(2.3);
        student5.addGrade(2.8);
        student5.addGrade(2.1);
        
        Student student6 = new Student("Новикова Елена", "ИТ-22", 1);
        student6.addGrade(3.2);
        student6.addGrade(3.5);
        student6.addGrade(3.0);
        
        // Добавление студентов в менеджер
        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);
        manager.addStudent(student4);
        manager.addStudent(student5);
        manager.addStudent(student6);
        
        // Печать всех студентов
        manager.printAllStudents();
        
        // Статистика по курсам
        manager.printCourseStatistics();
        
        // Печать студентов по курсам
        manager.printStudents(manager.getAllStudents(), 1);
        manager.printStudents(manager.getAllStudents(), 2);
        manager.printStudents(manager.getAllStudents(), 3);
        
        // Удаление студентов со средним баллом < 3
        manager.removeStudentsWithLowGrades();
        
        // Перевод студентов на следующий курс
        manager.promoteStudents();
        
        // Печать обновленной статистики
        manager.printCourseStatistics();
        
        System.out.println("\n\n======= ЗАДАНИЕ 2: ТЕЛЕФОННЫЙ СПРАВОЧНИК =======");
        
        // === ЗАДАНИЕ 2: ТЕЛЕФОННЫЙ СПРАВОЧНИК ===
        PhoneBook phoneBook = new PhoneBook();
        
        System.out.println("\n--- Добавление записей в справочник ---");

        // Добавление записей
        phoneBook.add("Иванов", "+7-900-123-45-67");
        phoneBook.add("Иванов", "+7-900-123-45-68");
        phoneBook.add("Петров", "+7-911-234-56-78");
        phoneBook.add("Сидоров", "+7-922-345-67-89");
        phoneBook.add("Иванов", "+7-933-456-78-90"); // Третий Иванов
        phoneBook.add("Козлов", "+7-944-567-89-01");
        phoneBook.add("Петров", "+7-955-678-90-12"); // Второй Петров
        
        // Попытка добавить дублирующий номер
        phoneBook.add("Иванов", "+7-900-123-45-67");
        
        System.out.println("\n--- Поиск номеров по фамилиям ---");
        
        // Поиск номеров
        phoneBook.printPhones("Иванов");
        phoneBook.printPhones("Петров");
        phoneBook.printPhones("Сидоров");
        phoneBook.printPhones("Смирнов"); // Несуществующая фамилия
        
        System.out.println("\n--- Демонстрация метода get() ---");
        List<String> ivanovPhones = phoneBook.get("Иванов");
        System.out.println("Номера для фамилии Иванов через метод get(): " + ivanovPhones);
        
        List<String> smithPhones = phoneBook.get("Smith");
        System.out.println("Номера для фамилии Smith: " + smithPhones);
        
        // Печать всего справочника
        phoneBook.printAll();
        
        // Статистика справочника
        phoneBook.printStatistics();
        
        System.out.println("\n--- Дополнительные операции ---");
        
        // Проверка существования фамилии
        System.out.println("Содержится ли фамилия 'Иванов': " + phoneBook.containsLastName("Иванов"));
        System.out.println("Содержится ли фамилия 'Неизвестный': " + phoneBook.containsLastName("Неизвестный"));
        
        // Удаление номера
        boolean removed = phoneBook.remove("Иванов", "+7-900-123-45-67");
        System.out.println("\nУдален номер для Иванова: " + removed);
        
        System.out.println("\nОбновленные номера для Иванова:");
        phoneBook.printPhones("Иванов");
        
        System.out.println("\n--- Тестирование поиска без учета регистра ---");
        phoneBook.printPhones("ИВАНОВ");
        phoneBook.printPhones("петров");
        phoneBook.printPhones("Сидоров");
        
        // Итоговая статистика
        phoneBook.printStatistics();

    }
}