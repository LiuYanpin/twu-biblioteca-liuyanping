package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    @Test
    public void should_create_a_movie_without_rating() {
        Movie newMovie = new Movie("1000", "Titanic", 1997, "James Cameron");
        assertEquals("Titanic", newMovie.getBookIMDbNumber());
        assertEquals(1997, newMovie.getMovieReleasedYear());
        assertEquals("James Cameron", newMovie.getDirectorName());
        assertEquals("unrated", newMovie.getMovieRating());
    }

    @Test
    public void should_create_a_movie_with_rating() {
        Movie actualMovie = new Movie("1001", "The Dark Knight", 2008,
                "Christopher Nolan", "9.5");
        assertEquals("The Dark Knight", actualMovie.getBookIMDbNumber());
        assertEquals(2008, actualMovie.getMovieReleasedYear());
        assertEquals("Christopher Nolan", actualMovie.getDirectorName());
        assertEquals("9.5", actualMovie.getMovieRating());
    }
}