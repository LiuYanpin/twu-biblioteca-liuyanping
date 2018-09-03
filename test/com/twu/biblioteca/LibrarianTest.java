package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class LibrarianTest {
    @Test
    public void should_find_an_exist_customer() {
        Library library = new Library();
        Librarian librarian = new Librarian(library);
        Customer customer = librarian.getOneCustomerByLibraryNumber("001-0001");
        assertTrue(librarian.checkIfCustomerExist(customer.getCustomerLibraryNumber()));
        assertEquals("Alice", customer.getCustomerName());
        assertEquals("alice@gmail.com", customer.getCustomerEmailAddress());
    }

    @Test
    public void should_initial_customer_info() {
        Library library = new Library();
        Librarian librarian = new Librarian(library);
        assertTrue(librarian.checkIfCustomerExist("001-0001"));
        assertTrue(librarian.checkIfCustomerExist("001-0002"));
        assertTrue(librarian.checkIfCustomerExist("001-0003"));
        assertTrue(librarian.checkIfCustomerExist("001-0004"));
        assertFalse(librarian.checkIfCustomerExist("001-0009"));
        assertFalse(librarian.checkIfCustomerExist("010-0044"));
        assertFalse(librarian.checkIfCustomerExist("121-0023"));
        assertFalse(librarian.checkIfCustomerExist("001-0006"));
    }

    @Test
    public void should_check_customer_password() {
        Library library = new Library();
        Librarian librarian = new Librarian(library);
        assertFalse(librarian.checkIfCustomerPasswordCorrect("001-0001", "21212"));
        assertFalse(librarian.checkIfCustomerPasswordCorrect("001-0010", "1qaz2wsx"));
        assertFalse(librarian.checkIfCustomerPasswordCorrect("001-0001", "qwesa"));
        assertTrue(librarian.checkIfCustomerPasswordCorrect("001-0001", "1qaz2wsx"));
    }

    @Test
    public void should_get_one_customer_by_number() {
        Library library = new Library();
        Librarian librarian = new Librarian(library);
        Customer customer = librarian.getOneCustomerByLibraryNumber("001-0001");
        assertEquals("001-0001", customer.getCustomerLibraryNumber());
        assertEquals("Alice", customer.getCustomerName());
        assertNull(librarian.getOneCustomerByLibraryNumber("0001-11"));
    }

    @Test
    public void should_checkout_one_book() {
        Library library = new Library();
        Librarian librarian = new Librarian(library);
        Book book = librarian.checkoutOneBook("0001");//Middlemarch (George Eliot, 1874)
        assertEquals("0001", book.getBookISBN());
        assertEquals("Middlemarch", book.getBookName());
        assertEquals(1874, book.getYearPublished());
        assertEquals("George Eliot", book.getAuthor());
        assertEquals(0, book.getTotalNumberOfTheBook());//default
        assertEquals(0, book.getLeftNumberOfTheBook());//default
    }

    @Test
    public void should_return_one_book() {
        Library library = new Library();
        Librarian librarian = new Librarian(library);
        Customer customer = librarian.getOneCustomerByLibraryNumber("001-0001");
        assertFalse(librarian.returnOneBook(customer, "0001"));
        customer.borrowOneBook(librarian.checkoutOneBook("0001"));
        assertTrue(librarian.returnOneBook(customer, "0001"));
    }

    @Test
    public void should_checkout_one_movie() {
        Library library = new Library();
        Librarian librarian = new Librarian(library);
        Customer customer = librarian.getOneCustomerByLibraryNumber("001-0001");
        customer.borrowOneMovie(librarian.checkoutOneMovie("90001"));
        assertTrue(librarian.ifCustomerCanReturnOneMovie(customer, "90001"));
        assertTrue(librarian.returnOneMovie(customer, "90001"));
        assertFalse(librarian.returnOneMovie(customer, "90001"));
    }

    @Test
    public void should_get_customer_detail() {
        Library library = new Library();
        Librarian librarian = new Librarian(library);
        Customer customer = librarian.getOneCustomerByLibraryNumber("001-0001");
        String actual = librarian.getCustomerDetail(customer);
        String expect = "----User Information----\n" +
                "Name: Alice\n" +
                "EmailAddress: alice@gmail.com\n" +
                "PhoneNumber: 13001010202\n";
        System.out.println(actual);
        assertEquals(expect, actual);
    }

}