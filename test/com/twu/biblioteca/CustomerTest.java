package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {
    @Test
    public void should_new_a_customer() {
        Customer customer = new Customer("001-0001",
                "1qaz2wsx", "Alice",
                "alice@163.com", "0100" );
        assertEquals("001-0001", customer.getCustomerLibraryNumber());
        assertEquals("1qaz2wsx", customer.getCustomerLibraryPassword());
        assertEquals("Alice", customer.getCustomerName());
        assertEquals("alice@163.com", customer.getCustomerEmailAddress());
        assertEquals("0100", customer.getCustomerPhoneNumber());
    }

    @Test
    public void should_get_detail() {
        Customer customer = new Customer("001-0001",
                "1qaz2wsx", "Alice",
                "alice@163.com", "0100" );
        String actual = customer.getCustomerDetail();
        assertEquals("Name: Alice\nEmailAddress: alice@163.com\nPhoneNumber: 0100", actual);
    }

    @Test
    public void should_borrow_new_book() {
        Book book = new Book("0101", "Jane Eyre", "Charlotte Brontë", 1847);
        Customer customer = new Customer("001-0001",
                "1qaz2wsx", "Alice",
                "alice@163.com", "0100" );
        customer.borrowOneBook(book);
        assertTrue(customer.ifBorrowedOneBook("0101"));
    }

    @Test
    public void should_return_borrowed_book() {
        Book book = new Book("0101", "Jane Eyre", "Charlotte Brontë", 1847);
        Customer customer = new Customer("001-0001",
                "1qaz2wsx", "Alice",
                "alice@163.com", "0100" );
        customer.borrowOneBook(book);
        assertTrue(customer.returnOneBook("0101"));
        assertFalse(customer.returnOneBook("0101"));
    }

    @Test
    public void should_borrow_new_movie() {
        Movie movie = new Movie("0001", "Titanic", 1994,
                "James Cameron", "9.0");
        Customer customer = new Customer("001-0001",
                "1qaz2wsx", "Alice",
                "alice@163.com", "0100" );
        customer.borrowOneMovie(movie);
        assertTrue(customer.ifBorrowedOneMovie("0001"));
        assertTrue(customer.returnOneMovie("0001"));
        assertFalse(customer.returnOneMovie("0001"));
    }
}