package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class LibrarianTest {
    @Test
    public void should_find_an_exist_customer() {
        Librarian librarian = new Librarian();
        librarian.createOneCustomer("001-0001","xxx", "Alice",
                "alice@163.com", "010-12121");
        Customer newCustomer = librarian.getOneCustomerByLibraryNumber("001-0001");
        assertTrue(librarian.checkIfCustomerExist(newCustomer.getCustomerLibraryNumber()));
        assertEquals("Alice", newCustomer.getCustomerName());
        assertEquals("alice@163.com", newCustomer.getCustomerEmailAddress());
    }


}