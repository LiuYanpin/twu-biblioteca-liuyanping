package com.twu.biblioteca;

public class Movie {
    private String movieIMDbNumber;
    private String movieName;
    private int movieReleasedYear;
    private String directorName;
    private String movieRating;
    private int totalNumberOfTheMovie;
    private int leftNumberOfTheMovie;

    public String getMovieIMDbNumber() { return movieIMDbNumber; }

    public String getMovieName() {
        return movieName;
    }

    public int getMovieReleasedYear() {
        return movieReleasedYear;
    }

    public String getDirectorName() {
        return directorName;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public int getTotalNumberOfTheMovie() {
        return totalNumberOfTheMovie;
    }

    public int getLeftNumberOfTheMovie() {
        return leftNumberOfTheMovie;
    }

    public void setLeftNumberOfTheMovie(int leftNumberOfTheMovie) {
        this.leftNumberOfTheMovie = leftNumberOfTheMovie;
    }


    public Movie(String movieIMDbNumber, String movieName, int movieReleasedYear, String directorName) {
        this.movieIMDbNumber = movieIMDbNumber;
        this.movieName = movieName;
        this.movieReleasedYear = movieReleasedYear;
        this.directorName = directorName;
        this.movieRating = "unrated";
    }

    public Movie(String movieIMDbNumber, String movieName, int movieReleasedYear, String directorName, String movieRating) {
        this.movieIMDbNumber = movieIMDbNumber;
        this.movieName = movieName;
        this.movieReleasedYear = movieReleasedYear;
        this.directorName = directorName;
        this.movieRating = movieRating;
    }

    public Movie(String movieIMDbNumber, String movieName, int movieReleasedYear, String directorName, int totalNumberOfTheMovie) {
        this.movieIMDbNumber = movieIMDbNumber;
        this.movieName = movieName;
        this.movieReleasedYear = movieReleasedYear;
        this.directorName = directorName;
        this.movieRating = "unrated";
        this.totalNumberOfTheMovie = totalNumberOfTheMovie;
        this.leftNumberOfTheMovie = totalNumberOfTheMovie;
    }

    public Movie(String movieIMDbNumber, String movieName, int movieReleasedYear, String directorName, String movieRating, int totalNumberOfTheMovie) {
        this.movieIMDbNumber = movieIMDbNumber;
        this.movieName = movieName;
        this.movieReleasedYear = movieReleasedYear;
        this.directorName = directorName;
        this.movieRating = movieRating;
        this.totalNumberOfTheMovie = totalNumberOfTheMovie;
        this.leftNumberOfTheMovie = totalNumberOfTheMovie;
    }


}
