package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {
    @Test
    public void should_print_booklist() {
        Library newLibrary = new Library();
        newLibrary.getAllBookList();
    }

    @Test
    public void should_print_movielist() {
        Library newLibrary = new Library();
        newLibrary.getAllMovieList();
    }
}