package org.example.kodi.module3.submodule1;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Book book1 = new Book("Kosiarze", "Neal Shusterman", 2023, 1, 25);
        Book book2 = new Book("Kosiarze 2", "Neal Shusterman", 2023, 10, 2);
        Book book3 = new Book("Kosiarze 3", "Neal Shusterman", 2024, 5, 15);
        Book book4 = new Book("Jumanji", "Neal Shusterman", 2009, 5, 15);
        Book book5 = new Book("Dune", "Frank Herbert", 1979, 7, 24);
        Book book6 = new Book("Dune 2", "Frank Herbert", 1981, 12, 8);

        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);
        bookSet.add(book6);

        for (Book book : bookSet) {
            if (book.getPublishDate().getYear() <= 2010) {
                System.out.println(book);
            }
        }


    }
}

class Book {
    private String title;
    private String author;
    private LocalDate publishDate;

    public Book(String title, String author, int yearOfPublish, int monthOfPublish, int dayOfPublish) {
        this.title = title;
        this.author = author;
        this.publishDate = LocalDate.of(yearOfPublish, monthOfPublish, dayOfPublish);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(publishDate, book.publishDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publishDate);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}