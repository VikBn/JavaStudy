package hw2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

record StudentGrade(String studentName, String school, String subject, double score) {}

public class StudentProcessor {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 16, Arrays.asList(new Grade("Math", 85), new Grade("Science", 92)), "High School A", new Address("New York", "1st Ave")),
                new Student("Bob", 17, Arrays.asList(new Grade("Math", 80), new Grade("Science", 75)), "High School B", new Address("Los Angeles", "2nd St")),
                new Student("Charlie", 16, Arrays.asList(new Grade("Math", 95), new Grade("Science", 90)), "High School A", new Address("New York", "3rd Blvd")),
                new Student("David", 18, Arrays.asList(new Grade("Math", 88), new Grade("Science", 91)), "High School C", new Address("New York", "4th Lane")),
                new Student("Eve", 14, Arrays.asList(new Grade("Math", 70), new Grade("Science", 80)), "High School D", new Address("New York", "5th Road"))
        );

        List<StudentGrade> topGrades = students.stream()
                .filter(student -> student.getAge() > 15 && student.getAddress().getCity().equals("New York")) // Filter condition
                .flatMap(student -> student.getGrades().stream()
                        .map(grade -> new StudentGrade(student.getName(), student.getSchool(), grade.getSubject(), grade.getScore())))
                .sorted(Comparator.comparingDouble(StudentGrade::score).reversed())
                .limit(3)
                .toList();

        System.out.println("Top 3 Grades:");
        topGrades.forEach(sg ->
                System.out.println(sg.studentName() + ", " + sg.school() + ", " + sg.subject() + ", " + sg.score()));

    }
}