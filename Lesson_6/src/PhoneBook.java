import java.util.*;

public class PhoneBook {

    private Map<String, List<String>> phoneDirectory;

    public PhoneBook() {
        this.phoneDirectory = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Фамилия не может быть пустой");
        }

        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Номер телефона не может быть пустым");
        }

        // Приводим фамилию к нижнему регистру для единообразия поиска
        String normalizedLastName = lastName.trim().toLowerCase();
        String normalizedPhoneNumber = phoneNumber.trim();

        // Если фамилии еще нет в справочнике, создаем новый список
        phoneDirectory.computeIfAbsent(normalizedLastName, k -> new ArrayList<>());

        // Проверяем, нет ли уже такого номера для данной фамилии
        List<String> phones = phoneDirectory.get(normalizedLastName);
        if (!phones.contains(normalizedPhoneNumber)) {
            phones.add(normalizedPhoneNumber);
            System.out.println("Добавлен номер " + normalizedPhoneNumber + " для фамилии " + lastName);
        } else {
            System.out.println("Номер " + normalizedPhoneNumber + " уже существует для фамилии " + lastName);
        }
    }

    public List<String> get(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            return new ArrayList<>();
        }

        String normalizedLastName = lastName.trim().toLowerCase();
        List<String> phones = phoneDirectory.get(normalizedLastName);

        if (phones == null) {
            return new ArrayList<>(); // Возвращаем пустой список, если фамилия не найдена
        }

        return new ArrayList<>(phones); // Возвращаем копию списка для безопасности
    }

    public void printPhones(String lastName) {
        List<String> phones = get(lastName);

        if (phones.isEmpty()) {
            System.out.println("Фамилия '" + lastName + "' не найдена в справочнике");
        } else {
            System.out.println("Номера телефонов для фамилии '" + lastName + "':");
            for (int i = 0; i < phones.size(); i++) {
                System.out.println((i + 1) + ". " + phones.get(i));
            }
        }
    }

    public boolean remove(String lastName, String phoneNumber) {
        if (lastName == null || phoneNumber == null) {
            return false;
        }

        String normalizedLastName = lastName.trim().toLowerCase();
        String normalizedPhoneNumber = phoneNumber.trim();

        List<String> phones = phoneDirectory.get(normalizedLastName);
        if (phones != null) {
            boolean removed = phones.remove(normalizedPhoneNumber);

            if (phones.isEmpty()) {
                phoneDirectory.remove(normalizedLastName);
            }

            return removed;
        }

        return false;
    }

    public void printAll() {
        System.out.println("\n=== Телефонный справочник ===");

        if (phoneDirectory.isEmpty()) {
            System.out.println("Справочник пуст");
            return;
        }

        // Сортируем фамилии
        List<String> sortedLastNames = new ArrayList<>(phoneDirectory.keySet());
        Collections.sort(sortedLastNames);

        for (String lastName : sortedLastNames) {
            List<String> phones = phoneDirectory.get(lastName);
            System.out.println(lastName.toUpperCase() + ":");
            for (String phone : phones) {
                System.out.println("  " + phone);
            }
        }
    }

    public int getLastNamesCount() {
        return phoneDirectory.size();
    }

    public int getTotalPhonesCount() {
        int total = 0;
        for (List<String> phones : phoneDirectory.values()) {
            total += phones.size();
        }
        return total;
    }

    public boolean containsLastName(String lastName) {
        if (lastName == null) return false;
        return phoneDirectory.containsKey(lastName.trim().toLowerCase());
    }

    public void printStatistics() {
        System.out.println("\n=== Статистика справочника ===");
        System.out.println("Количество уникальных фамилий: " + getLastNamesCount());
        System.out.println("Общее количество номеров: " + getTotalPhonesCount());

        if (!phoneDirectory.isEmpty()) {
            // Находим фамилию с наибольшим количеством номеров
            String maxLastName = "";
            int maxPhones = 0;

            for (Map.Entry<String, List<String>> entry : phoneDirectory.entrySet()) {
                if (entry.getValue().size() > maxPhones) {
                    maxPhones = entry.getValue().size();
                    maxLastName = entry.getKey();
                }
            }

            System.out.println("Наибольше номеров у фамилии: " + maxLastName.toUpperCase() + " (" + maxPhones + " номеров)");
        }
    }
}
