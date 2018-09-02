package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private String customerName;
    private HashMap<String, Book> borrowedBooks = new HashMap<>();

    public void borrowOneBook(Book book) {
        borrowedBooks.put(book.getBookISBN(), book);
    }

    public void returnOneBook(Book book) {
        borrowedBooks.remove(book.getBookISBN());
    }

    public boolean ifBorrowedOneBook(String bookIsbn) {
        return borrowedBooks.containsKey(bookIsbn);
    }

}
