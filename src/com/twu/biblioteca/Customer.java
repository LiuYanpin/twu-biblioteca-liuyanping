package com.twu.biblioteca;

import java.util.HashMap;

public class Customer {
    private String customerLibraryNumber;
    private String customerLibraryPassword;
    private String customerName;
    private String customerEmailAddress;

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    private String customerPhoneNumber;
    private HashMap<String, Book> borrowedBooks = new HashMap<>();
    private HashMap<String, Movie> borrowedMovies = new HashMap<>();

    public Customer(String customerLibraryNumber, String customerLibraryPassword, String customerName,
                    String customerEmailAddress, String customerPhoneNumber) {
        this.customerLibraryNumber = customerLibraryNumber;
        this.customerLibraryPassword = customerLibraryPassword;
        this.customerName = customerName;
        this.customerEmailAddress = customerEmailAddress;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerDetail() {
        StringBuilder builder = new StringBuilder("Name: ")
                .append(customerName)
                .append("\n")
                .append("EmailAddress: ")
                .append(customerEmailAddress)
                .append("\n")
                .append("PhoneNumber: ")
                .append(customerPhoneNumber);
        return builder.toString();
    }

    public String getCustomerLibraryNumber() {
        return customerLibraryNumber;
    }

    public String getCustomerLibraryPassword() {
        return customerLibraryPassword;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }

    public void borrowOneBook(Book book) {
        borrowedBooks.put(book.getBookISBN(), book);
    }

    public boolean returnOneBook(String bookISBN) {
        if (borrowedBooks.containsKey(bookISBN)) {
            borrowedBooks.remove(bookISBN);
            return true;
        }
        return false;
    }

    public boolean ifBorrowedOneBook(String bookIsbn) {
        return borrowedBooks.containsKey(bookIsbn);
    }

    public void borrowOneMovie(Movie movie) {
        borrowedMovies.put(movie.getMovieIMDbNumber(), movie);
    }

    public boolean returnOneMovie(String movieIMDb) {
        if (borrowedMovies.containsKey(movieIMDb)) {
            borrowedMovies.remove(movieIMDb);
            return true;
        }
        return false;
    }

    public boolean ifBorrowedOneMovie(String movieIMDb) {
        return borrowedMovies.containsKey(movieIMDb);
    }

}
