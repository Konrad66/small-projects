package org.example.kodi.module3.submodule5;

import java.util.*;

public class App {
    public static void main(String[] args) {
        List<Book> booksList = new LinkedList<>();

        Map<Book, Integer> bookHashMap = new HashMap<>();
        int sizeOfCollections = 800_000;

        for (int i = 0; i < sizeOfCollections; i++) {
            booksList.add(new Book("Neal Shusterman", "Kosiarze" + i));
        }

        Book firstBook = booksList.get(0);
        Book lastBook = booksList.get(booksList.size() - 1);

        for (int i = 0; i < 5_000; i++) {
            String author = "Neal Shusterman" + i;
            String title = "Kosiarze" + i;
            Integer value = i;
            Book book = new Book(author, title);
            bookHashMap.put(book, value);
        }

        Book firstBookMap = new Book("Neal Shusterman0", "Kosiarze0");
        Book lastBookMap = new Book("Neal Shusterman4999", "Kosiarze4999");

        long begin = System.nanoTime();
        booksList.remove(firstBook);
        long end = System.nanoTime();
        System.out.println("Removing first element has take: " + (end - begin) + " ns");

        begin = System.nanoTime();
        booksList.remove(lastBook);
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
        bookHashMap.get(firstBookMap);
        end = System.nanoTime();
        System.out.println("Find first element has take: " + (end - begin) + " ns ");

        begin = System.nanoTime();
        bookHashMap.get(lastBookMap);
        end = System.nanoTime();
        System.out.println("Find last element has take: " + (end - begin) + " ns ");

        begin = System.nanoTime();
        bookHashMap.remove(firstBookMap);
        end = System.nanoTime();
        System.out.println("Removing first element has take: " + (end - begin) + " ns");

        begin = System.nanoTime();
        bookHashMap.remove(lastBookMap);
        end = System.nanoTime();
        System.out.println("Removing last element has take: " + (end - begin) + " ns");

        begin = System.nanoTime();
        bookHashMap.put(new Book("Neal Shusterman0", "Kosiarze0"), 0);
        end = System.nanoTime();
        System.out.println("Adding element on the first index has take: " + (end - begin) + " ns ");

        begin = System.nanoTime();
        bookHashMap.put(new Book("Neal Shusterman5000", "Kosiarze5000"), 5000);
        end = System.nanoTime();
        System.out.println("Adding element on the last index has take: " + (end - begin) + " ns ");
    }
}

class Book {
    private String author;
    private String title;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
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

//jezeli dwa metody sa sobie rowne