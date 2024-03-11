package org.example.advanced.demo;

public class Service2 {

    private BooksRepo booksRepo;

    public Service2(BooksRepo booksRepo) {
        this.booksRepo = booksRepo;
    }

    void sumPages() {
        int allPages = 0;
        for (Book book : booksRepo.books) {
            allPages += book.getPages();
        }
        System.out.println("Ilość stron: " + allPages);
    }


}
