package com.twu.biblioteca;

public class Librarian {
    private int librarianID;
    private Library publicLibrary;

    public Librarian() {
    }
    public Librarian(Library publicLibrary) {
        this.publicLibrary = publicLibrary;
    }

    public int getLibrarianID() {
        return librarianID;
    }
    public void setLibrarianID(int librarianID) {
        this.librarianID = librarianID;
    }

    public Book checkoutOneBook(String bookIsbn) {
        return publicLibrary.checkoutOneBookByBookISDN(bookIsbn);
    }

    public boolean customerCanReturnOneBook(Customer customer, String bookISBN) {
         return customer.ifBorrowedOneBook(bookISBN);
    }

    public boolean returnOneBook(String bookIsbn) {
        return publicLibrary.returnOneBookByBookISDN(bookIsbn);
    }
}
