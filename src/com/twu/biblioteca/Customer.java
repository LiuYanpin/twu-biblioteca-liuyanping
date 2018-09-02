package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private String customerLibraryNumber; //xxx-xxxx
    private String customerLibraryPassword;
    private String customerName;
    private String customerEmailAddress;
    private String customerPhoneNumber;
    private HashMap<String, Book> borrowedBooks = new HashMap<>();
    private HashMap<String, Movie> borrowedMovies = new HashMap<>();

    public Customer(String customerLibraryNumber) {
        this.customerLibraryNumber = customerLibraryNumber;
        this.customerLibraryPassword = "";
        this.customerName = "";
        this.customerEmailAddress = "";
        this.customerPhoneNumber = "";
    }

    public Customer(String customerLibraryNumber, String customerLibraryPassword, String customerName, String customerEmailAddress, String customerPhoneNumber) {
        this.customerLibraryNumber = customerLibraryNumber;
        this.customerLibraryPassword = customerLibraryPassword;
        this.customerName = customerName;
        this.customerEmailAddress = customerEmailAddress;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public void getCustomerDetail() {
        StringBuilder builder = new StringBuilder("Name: ")
                .append(customerName)
                .append("\n")
                .append("EmailAddress: ")
                .append(customerEmailAddress)
                .append("\n")
                .append("PhoneNumber: ")
                .append(customerPhoneNumber);
        System.out.println(builder.toString());
    }

    public String getCustomerLibraryNumber() {
        return customerLibraryNumber;
    }

    public void setCustomerLibraryNumber(String customerLibraryNumber) {
        this.customerLibraryNumber = customerLibraryNumber;
    }

    public String getCustomerLibraryPassword() {
        return customerLibraryPassword;
    }

    public void setCustomerLibraryPassword(String customerLibraryPassword) {
        this.customerLibraryPassword = customerLibraryPassword;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }

    public void setCustomerEmailAddress(String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public void borrowOneBook(Book book) {
        borrowedBooks.put(book.getBookISBN(), book);
    }

    public void returnOneBook(Book book) {
        borrowedBooks.remove(book.getBookISBN());
    }

    public boolean ifBorrowedOneBook(String bookIsbn) {
        return borrowedBooks.containsKey(bookIsbn);
    }

    public void borrowOneMovie(Movie movie) {
        borrowedMovies.put(movie.getMovieIMDbNumber(), movie);
    }

    public void returnOneBook(Movie movie) {
        borrowedMovies.remove(movie.getMovieIMDbNumber());
    }
    public boolean ifBorrowedOneMovie(String movieIMDb) {
        return borrowedMovies.containsKey(movieIMDb);
    }

}
