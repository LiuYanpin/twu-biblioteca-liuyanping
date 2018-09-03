package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BibliotecaAppTest {
    @Test
    public void should_print_welcome_message() {
        BibliotecaApp app = new BibliotecaApp();
    }

    @Test
    public void should_customer_exist() {
        BibliotecaApp app = new BibliotecaApp();
        assertTrue(app.ifCustomerLibraryNumberExist("001-0001"));
        assertTrue(app.ifCustomerLibraryNumberExist("001-0002"));
        assertTrue(app.ifCustomerLibraryNumberExist("001-0003"));
        assertTrue(app.ifCustomerLibraryNumberExist("001-0004"));
        assertTrue(app.ifCustomerLibraryNumberExist("001-0005"));
        assertFalse(app.ifCustomerLibraryNumberExist("001-0101"));
        assertFalse(app.ifCustomerLibraryNumberExist("010"));
        assertFalse(app.ifCustomerLibraryNumberExist("0102121"));
        assertFalse(app.ifCustomerLibraryNumberExist("010-1212"));
        assertFalse(app.ifCustomerLibraryNumberExist("010000"));
    }

    @Test
    public void should_customer_password_correct() {
        BibliotecaApp app = new BibliotecaApp();
        assertTrue(app.ifCustomerPasswordCorrect("001-0001", "1qaz2wsx"));
        assertTrue(app.ifCustomerPasswordCorrect("001-0002", "1qaz2wsx"));
        assertTrue(app.ifCustomerPasswordCorrect("001-0003", "1qaz2wsx"));
        assertFalse(app.ifCustomerPasswordCorrect("21212", "1212"));
        assertFalse(app.ifCustomerPasswordCorrect("001-0001", "1212"));
        assertFalse(app.ifCustomerPasswordCorrect("001-0003", "1q1q2wsx"));
    }

    @Test
    public void should_return_customer() {
        BibliotecaApp app = new BibliotecaApp();
        Customer customer1 = app.getOneCustomerByLibraryNumber("001-0001");
        Customer customer2 = app.getOneCustomerByLibraryNumber("0010001");
        assertEquals("Alice", customer1.getCustomerName());
        assertEquals("alice@gmail.com", customer1.getCustomerEmailAddress());
        assertNull(customer2);
    }

    @Test
    public void should_judge_option_exist() {
        BibliotecaApp app = new BibliotecaApp();
        assertTrue(app.ifOptionExist("List Books"));
        assertTrue(app.ifOptionExist("List Movies"));
        assertTrue(app.ifOptionExist("Checkout Book"));
        assertTrue(app.ifOptionExist("Checkout Movie"));
        assertTrue(app.ifOptionExist("Return Movie"));
        assertTrue(app.ifOptionExist("Return Book"));
        assertFalse(app.ifOptionExist("ListBooks"));
        assertFalse(app.ifOptionExist("ListMovies"));
    }

    @Test
    public void should_get_customer_detail() {
        BibliotecaApp app = new BibliotecaApp();
        Customer customer1 = app.getOneCustomerByLibraryNumber("001-0001");
        app.getCustomerDetail(customer1);
    }

    @Test
    public void should_get_menu() {
        BibliotecaApp app = new BibliotecaApp();
        app.getMenuList();
    }

    @Test
    public void should_go_to_diffrent_menu() {
        BibliotecaApp app = new BibliotecaApp();
        app.afterChooseOneOption("List Books");
        app.afterChooseOneOption("Checkout Book");
    }

    @Test
    public void should_checkout_book() {
        BibliotecaApp app = new BibliotecaApp();
        Book book = app.checkOneBookFormLibrary("0001");
        assertEquals("Middlemarch", book.getBookName());
        assertNull(app.checkOneBookFormLibrary("9090909"));
    }

    @Test
    public void should_checkout_movie() {
        BibliotecaApp app = new BibliotecaApp();
        Movie movie = app.checkOneMovieFormLibrary("90001");
        assertEquals("Titanic", movie.getMovieName());
        assertEquals(1997, movie.getMovieReleasedYear());
        assertNull(app.checkOneMovieFormLibrary("uiui"));
    }

    @Test
    public void should_return_book() {
        BibliotecaApp app = new BibliotecaApp();
        Customer customer1 = app.getOneCustomerByLibraryNumber("001-0001");
        assertFalse(app.ifCustomerCanReturnOneBook(customer1, "0001"));
        customer1.borrowOneBook(app.checkOneBookFormLibrary("0001"));
        assertTrue(app.ifCustomerCanReturnOneBook(customer1, "0001"));
        assertTrue(app.returnOneBook(customer1, "0001"));
        assertFalse(app.ifCustomerCanReturnOneBook(customer1, "0001"));
    }

    @Test
    public void should_return_movie() {
        BibliotecaApp app = new BibliotecaApp();
        Customer customer1 = app.getOneCustomerByLibraryNumber("001-0001");
        assertFalse(app.ifCustomerCanReturnOneMovie(customer1, "90001"));
        customer1.borrowOneMovie(app.checkOneMovieFormLibrary("90001"));
        assertTrue(app.ifCustomerCanReturnOneMovie(customer1, "90001"));
        assertFalse(app.ifCustomerCanReturnOneMovie(customer1, "90002"));
        assertTrue(app.returnOneMovie(customer1, "90001"));
        assertFalse(app.ifCustomerCanReturnOneMovie(customer1, "90001"));
    }
}