package org.example.kodi.module2.submodule6;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Random random = new Random();
        Student konrad = new Student("Konrad", "Nowak");
        Student wiktoria = new Student("Wiktoria", "Nowak");
        Student beata = new Student("Beata", "Nowak");

        Grade konradGrade = new Grade();
        Grade wiktoriaGrade = new Grade();
        Grade beataGrade = new Grade();

        for (int i = 0; i < 5; i++) {
            int randomGrade = random.nextInt(6) + 1;
            int randomGrade2 = random.nextInt(6) + 1;
            int randomGrade3 = random.nextInt(6) + 1;
            konradGrade.addGrade(randomGrade);
            wiktoriaGrade.addGrade(randomGrade2);
            beataGrade.addGrade(randomGrade3);
        }

        HashMap<Student, Grade> gradeBook = new HashMap<>();
        gradeBook.put(konrad, konradGrade);
        gradeBook.put(wiktoria, wiktoriaGrade);
        gradeBook.put(beata, beataGrade);


        for (Map.Entry<Student, Grade> studentGrades : gradeBook.entrySet()) {
            System.out.println("My name is " + studentGrades.getKey() + " those are my grades: " + studentGrades.getValue() + " and this is my average rating " + studentGrades.getValue().calculateAverage());
        }
    }
}

class Grade {
    private List<Integer> grades;

    public Grade() {
        this.grades = new ArrayList<>();
    }

    List<Integer> addGrade(int grade) {
        grades.add(grade);
        return grades;
    }

    double calculateAverage() {
        int sum = 0;
        for (Integer grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public List<Integer> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return "" + grades;
    }
}

class Student {

    private String name;
    private String surname;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}