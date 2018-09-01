package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void should_new_a_book() {
        Book book = new Book("0001", "Effective Java",
                "Joshua Bloch", 2009, 2);
        assertEquals("0001", book.getBookISBN());
        assertEquals("Effective Java", book.getBookName());
        assertEquals("Joshua Bloch", book.getAuthor());
        assertEquals(2009, book.getYearPublished());
        assertEquals(2, book.getTotalNumberOfTheBook());
    }
}