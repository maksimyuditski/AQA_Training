import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {

    private String name;
    private String group;
    private int course;
    private List<Double> grades;

    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new ArrayList<>();
    }

    public Student(String name, String group, int course, List<Double> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new ArrayList<>(grades);
    }

    // Добавление оценки
    public void addGrade(double grade) {
        if (grade >= 2.0 && grade <= 5.0) {
            grades.add(grade);
        } else {
            throw new IllegalArgumentException("Оценка должна быть от 2 до 5");
        }
    }

    // Вычисление среднего балла
    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    // Переопределение equals и hashCode для корректной работы в Set
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Student student = (Student) obj;
        return course == student.course &&
                Objects.equals(name, student.name) &&
                Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group, course);
    }

    @Override
    public String toString() {
        return String.format("Student{name='%s', group='%s', course=%d, averageGrade=%.2f, grades=%s}",
                name, group, course, getAverageGrade(), grades);
    }

}
