package org.example.kodi.module2.submodule5;

import java.util.*;

public class App {

    public static void main(String[] args) {
        Random random = new Random();
        Grade grade = new Grade();
        for (int i = 0; i < 20; i++) {
            int randomGrade = random.nextInt(6) + 1;
            grade.addGrade(randomGrade);
        }
        double average = grade.calculateAverage();
        System.out.println("Student grade: " + grade.getGrades());
        System.out.println("Average student grades equals: " + average);

        List<Book> bookList = new LinkedList<>();

        bookList.add(new Book("Kosiarze", 2023));
        bookList.add(new Book("Kosiarze 2", 2023));
        bookList.add(new Book("Kosiarze 3", 2024));
        bookList.add(new Book("Dune", 1978));
        bookList.add(new Book("Dune 2", 1979));
        bookList.add(new Book("Star Wars", 1989));

        for (Book book : bookList) {
            if (book.getYear() >= 2000) {
                System.out.println(book);
            }
        }
    }
}

class Book {
    private String name;
    private int year;

    public Book(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}

class Grade {

    private List<Integer> grades;

    public Grade() {
        this.grades = new ArrayList<>();
    }

    void addGrade(int grade) {
        grades.add(grade);
    }

    double calculateAverage() {
        int min = Collections.min(grades);
        int max = Collections.max(grades);
        boolean hasMinGrade = false;
        boolean hasMaxGrade = false;
        int sum = 0;
        for (Integer grade : grades) {
            if (grade != min && !hasMinGrade) {
                hasMinGrade = true;
                continue;
            }
            if (grade != max && !hasMaxGrade) {
                hasMaxGrade = true;
                continue;
            }
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public List<Integer> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "grades=" + grades +
                '}';
    }
}