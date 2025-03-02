package hw2;
import hw2.Grade;

import java.util.List;

class Student {
    private final String name;
    private final int age;
    private final List<Grade> grades;
    private final String school;
    private final Address address;

    public Student(String name, int age, List<Grade> grades, String school, Address address) {
        this.name = name;
        this.age = age;
        this.grades = grades;
        this.school = school;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public String getSchool() {
        return school;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return name + " (" + school + ") - " + address;
    }
}