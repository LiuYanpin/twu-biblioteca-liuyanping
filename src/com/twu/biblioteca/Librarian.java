package com.twu.biblioteca;

import java.util.HashMap;

public class Librarian {
    private Library publicLibrary;
    private HashMap<String, Customer> allCustomers = new HashMap<>();

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

    public boolean checkIfCustomerExist(String customerLibraryNumber) {
        return allCustomers.containsKey(customerLibraryNumber);
    }
    public boolean checkIfCustomerPasswordCorrect(String customerLibraryNumber, String customerPassword) {
        return allCustomers.containsKey(customerLibraryNumber)
                && allCustomers.get(customerLibraryNumber).getCustomerLibraryPassword().equals(customerPassword);
    }

    public Customer getOneCustomerByLibraryNumber(String customerLibraryNumber) {
        if (allCustomers.containsKey(customerLibraryNumber)) {
            return allCustomers.get(customerLibraryNumber);
        }
        return null;
    }

    public boolean ifCustomerCanReturnOneBook(Customer customer, String bookISBN) {
        return customer.getBorrowedBooks().containsKey(bookISBN);
    }
    public Book checkoutOneBook(String bookISBN) {
        return publicLibrary.checkoutOneBookByBookISBN(bookISBN);
    }
    public boolean returnOneBook(Customer currentCustomer, String bookISBN) {
        return publicLibrary.returnOneBookByBookISBN(bookISBN) && currentCustomer.returnOneBook(bookISBN);
    }
    public boolean ifCustomerCanReturnOneMovie(Customer customer, String movieIMDb) {
        return customer.getBorrowedMovies().containsKey(movieIMDb);
    }
    public Movie checkoutOneMovie(String movieIMDb) {
        return publicLibrary.checkoutOneMovieByMovieIMDb(movieIMDb);
    }
    public boolean returnOneMovie(Customer currentCustomer, String movieIMDb) {
        return publicLibrary.returnOneMovieByMovieIMDb(movieIMDb) && currentCustomer.returnOneMovie(movieIMDb);
    }

    public String getCustomerDetail(Customer customer) {
        return customer.getCustomerDetail();
    }
}
