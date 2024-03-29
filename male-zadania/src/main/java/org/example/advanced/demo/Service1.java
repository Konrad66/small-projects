package org.example.advanced.demo;

public class Service1 {
    private BooksRepo booksRepo;

    public Service1(BooksRepo booksRepo) {
        this.booksRepo = booksRepo;
    }

    void printBooks() {

        booksRepo.books.add(new Book("Ksiazka 3", 400));
        for (Book book : booksRepo.books) {
            System.out.println(book);
        }
    }
}