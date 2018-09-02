package com.twu.biblioteca;

import java.util.HashMap;

public class Librarian {
    private int librarianID;
    private Library publicLibrary;
    private HashMap<String, Customer> allCustomers = new HashMap<>();
    private int currentCustomerNumber = 0;

    public Librarian() {
    }
    public Librarian(Library publicLibrary) {
        this.publicLibrary = publicLibrary;
        initialCustomer();
    }

    private void initialCustomer() {
        Customer customer1 = new Customer("001-0001", "1qaz2wsx", "Alice", "alice@gmail.com", "13001010202");
        Customer customer2 = new Customer("001-0002", "1qaz2wsx", "Bob", "bob@gmail.com", "010-10002");
        Customer customer3 = new Customer("001-0003", "1qaz2wsx", "Cathy", "cathy@gmail.com", "027-32381");
        Customer customer4 = new Customer("001-0004", "1qaz2wsx", "David", "david@gmail.com", "13889728931");
        Customer customer5 = new Customer("001-0005", "1qaz2wsx", "Evy", "evy@gmail.com", "021-38828873");
        allCustomers.put(customer1.getCustomerLibraryNumber(), customer1);
        allCustomers.put(customer2.getCustomerLibraryNumber(), customer2);
        allCustomers.put(customer3.getCustomerLibraryNumber(), customer3);
        allCustomers.put(customer4.getCustomerLibraryNumber(), customer4);
        allCustomers.put(customer5.getCustomerLibraryNumber(), customer5);
    }
    public int getLibrarianID() {
        return librarianID;
    }
    public void setLibrarianID(int librarianID) {
        this.librarianID = librarianID;
    }

    public boolean checkIfCustomerExist(String customerLibraryNumber) {
        return allCustomers.containsKey(customerLibraryNumber);
    }
    public boolean checkIfCustomerPasswordCorrect(String customerLibraryNumber, String customerPassword) {
        return allCustomers.get(customerLibraryNumber).getCustomerLibraryPassword().equals(customerPassword);
    }

    public Customer getOneCustomerByLibraryNumber(String customerLibraryNumber) {
        return allCustomers.get(customerLibraryNumber);
    }

    public String generatorOneNewLibraryNumber() {
        return customerLibraryNumberGenerator();
    }

    public boolean createOneCustomer(String customerLibraryNumber,
                                      String customerLibraryPassword,
                                   String customerName,
                                   String customerEmailAddress,
                                   String customerPhoneNumber) {
        try {
            Customer newCustomer = new Customer(customerLibraryNumber,
                    customerLibraryPassword, customerName, customerEmailAddress, customerPhoneNumber);
            allCustomers.put(customerLibraryNumber, newCustomer);
            return true;
        }catch (Exception e) {
            return false;
        }

    }
    public boolean ifCustomerCanReturnOneBook(Customer customer, String bookISBN) {
        return customer.ifBorrowedOneBook(bookISBN);
    }
    public Book checkoutOneBook(String bookIsbn) {
        return publicLibrary.checkoutOneBookByBookISBN(bookIsbn);
    }
    public boolean returnOneBook(String bookIsbn) {
        return publicLibrary.returnOneBookByBookISBN(bookIsbn);
    }
    public boolean ifCustomerCanReturnOneMovie(Customer customer, String movieIMDb) {
        return customer.ifBorrowedOneMovie(movieIMDb);
    }
    public Movie checkoutOneMovie(String movieIMDb) {
        return publicLibrary.checkoutOneMovieByMovieIMDb(movieIMDb);
    }
    public boolean returnOneMovie(String movieIMDb) {
        return publicLibrary.returnOneMovieByMovieIMDb(movieIMDb);
    }
    private String customerLibraryNumberGenerator() {
        currentCustomerNumber++;
        return String.format("001-%04d", currentCustomerNumber);
    }
}
