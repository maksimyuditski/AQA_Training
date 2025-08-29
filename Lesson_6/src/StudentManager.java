import java.util.*;

public class StudentManager {

    private Set<Student> students;

    public StudentManager() {
        this.students = new HashSet<>();
    }

    // Добавление студента
    public void addStudent(Student student) {
        students.add(student);
    }

    // Удаление студентов со средним баллом < 3
    public void removeStudentsWithLowGrades() {
        System.out.println("\n=== Удаление студентов со средним баллом < 3 ===");

        List<Student> studentsToRemove = new ArrayList<>();
        for (Student student : students) {
            if (student.getAverageGrade() < 3.0) {
                studentsToRemove.add(student);
                System.out.println("Удален студент: " + student.getName() +
                        " (средний балл: " + String.format("%.2f", student.getAverageGrade()) + ")");
            }
        }

        students.removeAll(studentsToRemove);

        if (studentsToRemove.isEmpty()) {
            System.out.println("Нет студентов для удаления (все имеют средний балл >= 3.0)");
        }
    }

    // Перевод студентов на следующий курс
    public void promoteStudents() {
        System.out.println("\n=== Перевод студентов на следующий курс ===");

        int promotedCount = 0;
        for (Student student : students) {
            if (student.getAverageGrade() >= 3.0) {
                int oldCourse = student.getCourse();
                student.setCourse(oldCourse + 1);
                System.out.println("Студент " + student.getName() +
                        " переведен с " + oldCourse + " на " + (oldCourse + 1) + " курс" +
                        " (средний балл: " + String.format("%.2f", student.getAverageGrade()) + ")");
                promotedCount++;
            }
        }

        if (promotedCount == 0) {
            System.out.println("Нет студентов для перевода на следующий курс");
        }
    }

    // Печать студентов определенного курса
    public void printStudents(Set<Student> students, int course) {
        System.out.println("\n=== Студенты " + course + " курса ===");

        List<String> studentNames = new ArrayList<>();
        for (Student student : students) {
            if (student.getCourse() == course) {
                studentNames.add(student.getName());
            }
        }

        if (studentNames.isEmpty()) {
            System.out.println("На " + course + " курсе нет студентов");
        } else {
            System.out.println("Количество студентов: " + studentNames.size());
            for (String name : studentNames) {
                System.out.println("- " + name);
            }
        }
    }

    // Получение всех студентов
    public Set<Student> getAllStudents() {
        return new HashSet<>(students);
    }

    // Печать всех студентов
    public void printAllStudents() {
        System.out.println("\n=== Все студенты ===");
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Статистика по курсам
    public void printCourseStatistics() {
        System.out.println("\n=== Статистика по курсам ===");

        Map<Integer, List<Student>> studentsByCourse = new HashMap<>();

        for (Student student : students) {
            studentsByCourse.computeIfAbsent(student.getCourse(), k -> new ArrayList<>()).add(student);
        }

        for (Map.Entry<Integer, List<Student>> entry : studentsByCourse.entrySet()) {
            int course = entry.getKey();
            List<Student> courseStudents = entry.getValue();
            double averageGradeForCourse = courseStudents.stream()
                    .mapToDouble(Student::getAverageGrade)
                    .average()
                    .orElse(0.0);

            System.out.printf("Курс %d: %d студентов, средний балл: %.2f%n",
                    course, courseStudents.size(), averageGradeForCourse);
        }
    }
}
