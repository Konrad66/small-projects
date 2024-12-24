package org.example.kodi.module3.submodule5;

import java.util.*;

public class App {
    public static void main(String[] args) {
        List<Book> booksList = new LinkedList<>();
        Map<Book, Book> bookHashMap = new HashMap<>();
        int sizeOfCollections = 800_000;

        for (int i = 0; i < sizeOfCollections; i++) {
            booksList.add(new Book("Neal Shusterman", "Kosiarze"));
        }

        for (int i = 0; i < 5_000; i++) {
            bookHashMap.put(new Book(i + 1), new Book("Neal Shusterman", "Kosiarze"));
        }

        long begin = System.nanoTime();
        booksList.remove(0);
        long end = System.nanoTime();
        System.out.println("Removing first element has take: " + (end - begin) + " ns");

        begin = System.nanoTime();
        booksList.remove(booksList.size() - 1);
        end = System.nanoTime();
        System.out.println("Removing last element has take: " + (end - begin) + " ns");

        begin = System.nanoTime();
        Book book1 = booksList.get(0);
        end = System.nanoTime();
        System.out.println("Find first element has take: " + (end - begin) + " ns " + book1);

        begin = System.nanoTime();
        Book book = booksList.get(booksList.size() - 1);
        end = System.nanoTime();
        System.out.println("Find last element has take: " + (end - begin) + " ns " + book);

        begin = System.nanoTime();
        booksList.add(0, new Book("Neal Shusterman", "Kosiarze 2"));
        end = System.nanoTime();
        System.out.println("Adding element on the first index has take: " + (end - begin) + " ns " + book1);

        begin = System.nanoTime();
        booksList.add(booksList.size() - 1, new Book("Neal Shusterman", "Kosiarze 2"));
        end = System.nanoTime();
        System.out.println("Adding element on the last index has take: " + (end - begin) + " ns " + book);

        System.out.println("--------------------");


        System.out.println("Hash map has " + bookHashMap.size() + " elements");
        begin = System.nanoTime();
        bookHashMap.get();
        end = System.nanoTime();
        System.out.println("Find first element has take: " + (end - begin) + " ns ");

        begin = System.nanoTime();
        bookHashMap.get("Book");
        end = System.nanoTime();
        System.out.println("Find last element has take: " + (end - begin) + " ns ");
    }
}

class Book {
    private String author;
    private String title;
    private int yearOfPublish;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public Book(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title);
    }

    @Override
    public String toString() {
        return "Title of book: " + title + " and author of book: " + author;
    }
}