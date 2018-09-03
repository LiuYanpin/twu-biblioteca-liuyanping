package com.twu.biblioteca;

import java.util.HashMap;

public class Customer {
    private String customerLibraryNumber;
    private String customerLibraryPassword;
    private String customerName;
    private String customerEmailAddress;
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
        StringBuilder builder = new StringBuilder("----User Information----\n")
                .append("Name: ")
                .append(customerName)
                .append("\n")
                .append("EmailAddress: ")
                .append(customerEmailAddress)
                .append("\n")
                .append("PhoneNumber: ")
                .append(customerPhoneNumber)
                .append("\n");
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

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }
    public HashMap<String, Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public HashMap<String, Movie> getBorrowedMovies() {
        return borrowedMovies;
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
}
