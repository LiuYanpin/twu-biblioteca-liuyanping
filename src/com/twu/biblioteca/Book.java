package com.twu.biblioteca;

public class Book {
    private String bookISBN;
    private String bookName;
    private String author;
    private int yearPublished;
    private int totalNumberOfTheBook;
    private int leftNumberOfTheBook;

    public Book(String bookISBN, String bookName, String author, int yearPublished, int totalNumberOfTheBook) {
        this.bookISBN = bookISBN;
        this.bookName = bookName;
        this.author = author;
        this.yearPublished = yearPublished;
        this.totalNumberOfTheBook = totalNumberOfTheBook;
        this.leftNumberOfTheBook = totalNumberOfTheBook;
    }
    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getTotalNumberOfTheBook() {
        return totalNumberOfTheBook;
    }

    public void setTotalNumberOfTheBook(int totalNumberOfTheBook) {
        this.totalNumberOfTheBook = totalNumberOfTheBook;
    }

    public int getLeftNumberOfTheBook() {
        return leftNumberOfTheBook;
    }

    public void setLeftNumberOfTheBook(int leftNumberOfTheBook) {
        this.leftNumberOfTheBook = leftNumberOfTheBook;
    }
}
