package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {
    @Test
    public void should_print_booklist() {
        Library newLibrary = new Library();
        String actual = newLibrary.getAllBookList();
        String expect = "ISBN      BookName            Author                        PublishedYear\n" +
                "0001      Middlemarch         George Eliot                  1874      \n" +
                "0002      To the Lighthouse   Virginia Woolf                1927      \n" +
                "0003      Mrs Dalloway        Virginia Woolf                1925      \n" +
                "0004      Great Expectations  Charles Dickens               1861      \n" +
                "0005      Jane Eyre           Charlotte Bronte              1847      \n" +
                "0006      leak House          Charles Dickens               1853      \n" +
                "0007      Wuthering Heights   Emily Bronte                  1847      \n" +
                "0008      David Copperfield   Charles Dickens               1850      \n" +
                "0009      Frankenstein        Mary Shelley                  1818      \n" +
                "0010      Vanity Fair         William Makepeace Thackeray   1848      \n";
        assertEquals(expect, actual);
    }

    @Test
    public void should_print_movielist() {
        Library newLibrary = new Library();
        String actual = newLibrary.getAllMovieList();
        String expect = "No.       MovieName                                         ReleasedYear        Director            Rating    \n" +
                "90001     Titanic                                           1997                James Cameron       unrated   \n" +
                "90002     Gone With the Wind                                1939                Victor Fleming      9.9       \n" +
                "90003     Star Wars: Episode IV - A New Hope                1977                George Lucas        9         \n" +
                "90004     The Dark Knight                                   2008                Christopher Nolan   9.1       \n" +
                "90005     Jurassic Park                                     1993                Steven Spielberg    8.9       \n" +
                "90006     E. T. The Extra-Terrestrial                       1982                Steven Spielberg    unrated   \n" +
                "90007     Harry Potter and the Deathly Hallows, Part 2      2011                David Yates         8.8       \n" +
                "90008     Forrest Gump                                      1994                Robert Zemeckis     9.4       \n" +
                "90009     Avatar                                            2009                James Cameron       9.2       \n" +
                "90010     Alice in Wonderland                               2010                Tim Burton          8.7       \n";
        assertEquals(expect, actual);
    }

    @Test
    public void should_checkout_one_book() {
        Library library = new Library();
        Book book = library.checkoutOneBookByBookISBN("0001");
        assertEquals("0001", book.getBookISBN());
        assertEquals("Middlemarch", book.getBookName());
        assertTrue(library.returnOneBookByBookISBN("0001"));
        assertFalse(library.returnOneBookByBookISBN("0001"));
    }

    @Test
    public void should_checkout_one_movie() {
        Library library = new Library();
        Movie movie = library.checkoutOneMovieByMovieIMDb("90001");
        assertEquals("90001", movie.getMovieIMDbNumber());
        assertEquals("Titanic", movie.getMovieName());
        assertTrue(library.returnOneMovieByMovieIMDb("90001"));
        assertFalse(library.returnOneMovieByMovieIMDb("90001"));
    }
}