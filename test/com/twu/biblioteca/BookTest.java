package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void should_new_a_book_with_number() {
        Book book = new Book("0001", "Effective Java",
                "Joshua Bloch", 2009, 2);
        assertEquals("0001", book.getBookISBN());
        assertEquals("Effective Java", book.getBookName());
        assertEquals("Joshua Bloch", book.getAuthor());
        assertEquals(2009, book.getYearPublished());
        assertEquals(2, book.getTotalNumberOfTheBook());
        assertEquals(2, book.getLeftNumberOfTheBook());
    }

    @Test
    public void should_new_a_book_without_number() {
        Book book = new Book("qaws1121", "Harry Potter", "J.K.Rowling", 2000);
        assertEquals("qaws1121", book.getBookISBN());
        assertEquals("Harry Potter", book.getBookName());
        assertEquals("J.K.Rowling", book.getAuthor());
        assertEquals(2000, book.getYearPublished());
    }


}