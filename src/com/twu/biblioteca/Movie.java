package com.twu.biblioteca;

public class Movie {
    private String movieIMDbNumber;
    private String movieName;
    private int movieReleasedYear;
    private String directorName;
    private String movieRating;
    private int totalNumberOfTheMovie;
    private int leftNumberOfTheMovie;

    public Movie(String movieIMDbNumber, String movieName, int movieReleasedYear, String directorName) {
        this.movieIMDbNumber = movieIMDbNumber;
        this.movieName = movieName;
        this.movieReleasedYear = movieReleasedYear;
        this.directorName = directorName;
        this.movieRating = "unrated";
        this.totalNumberOfTheMovie = 1;
        this.leftNumberOfTheMovie = 1;
    }

    public Movie(String movieIMDbNumber, String movieName, int movieReleasedYear, String directorName, String movieRating) {
        this.movieIMDbNumber = movieIMDbNumber;
        this.movieName = movieName;
        this.movieReleasedYear = movieReleasedYear;
        this.directorName = directorName;
        this.movieRating = movieRating;
        this.totalNumberOfTheMovie = 1;
        this.leftNumberOfTheMovie = 1;
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

    public String getmovieIMDbNumber() {
        return movieIMDbNumber;
    }

    public void setmovieIMDbNumber(String movieIMDbNumber) {
        this.movieIMDbNumber = movieIMDbNumber;
    }

    public String getBookIMDbNumber() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieReleasedYear() {
        return movieReleasedYear;
    }

    public void setMovieReleasedYear(int movieReleasedYear) {
        this.movieReleasedYear = movieReleasedYear;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }
    public int getTotalNumberOfTheMovie() {
        return totalNumberOfTheMovie;
    }

    public void setTotalNumberOfTheMovie(int totalNumberOfTheMovie) {
        this.totalNumberOfTheMovie = totalNumberOfTheMovie;
    }

    public int getLeftNumberOfTheMovie() {
        return leftNumberOfTheMovie;
    }

    public void setLeftNumberOfTheMovie(int leftNumberOfTheMovie) {
        this.leftNumberOfTheMovie = leftNumberOfTheMovie;
    }

}
