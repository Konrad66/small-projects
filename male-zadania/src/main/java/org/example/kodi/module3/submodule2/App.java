package org.example.kodi.module3.submodule2;

import java.util.ArrayDeque;
import java.util.Deque;

public class App {
    public static void main(String[] args) {
        Book theBook1 = new Book("Assassins' Creed the Book", "William Shakespeare", 2016);
        Book theBook2 = new Book("Book of jungle", "Rudyard Kipling", 1894);
        Book theBook3 = new Book("50 shades of gray – lexicon for graphicians", "Dante Alighieri", 1572);
        Book theBook4 = new Book("Kosiarze", "Neal Shusterman", 2023);

        Deque<Book> books = new ArrayDeque<>();

        System.out.println("Size of que " + books.size());
        books.add(theBook1);
        books.add(theBook2);
        books.add(theBook3);
        books.add(theBook4);
        books.add(theBook1);
        books.add(theBook3);

        System.out.println("Size of que " + books.size());
        Book temporaryBook = null;
        while (!books.isEmpty()){
            temporaryBook = books.poll();
        }

        System.out.println("Last book taken from queue was: " + temporaryBook);
        System.out.println("Size of que " + books.size());
    }
}

class Book {

    String title;
    String author;
    int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Title: \"" + title + "\", author: " + author + ", (" + year + ")";
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}