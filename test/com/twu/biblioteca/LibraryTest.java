package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {
    @Test
    public void should_print_booklist() {
        Library newLibrary = new Library();
        newLibrary.getAllBookList();
    }
}