package org.example.advanced.demo;

public class Dependencies {

    public static void main(String[] args) {

        BooksRepo booksRepo = new BooksRepo();
        booksRepo.books.add(new Book("Ksiazka 1", 300));
        booksRepo.books.add(new Book("Ksiazka 2", 350));

        Service1 service1 = new Service1(booksRepo);
        Service2 service2 = new Service2(booksRepo);

        service1.printBooks();
        service2.sumPages();

    }
}