package com.twu.biblioteca;

import java.util.HashMap;
/*
http://language.chinadaily.com.cn/2015-12/22/content_22771415.htm
BBC评出最经久不衰的10部经典英国小说
0001.Middlemarch (George Eliot, 1874)乔治·艾略特《米德尔马契》，1874年出版
0002.To the Lighthouse (Virginia Woolf, 1927)弗吉尼亚·伍尔芙《到灯塔去》，1927年出版
0003.Mrs Dalloway (Virginia Woolf, 1925)弗吉尼亚·伍尔芙《达洛卫夫人》，1925年出版
0004.Great Expectations (Charles Dickens, 1861)查尔斯·狄更斯《远大前程》，1861年出版
0005.Jane Eyre (Charlotte Brontë, 1847)夏洛蒂·勃朗特《简·爱》，1847年出版
0006.leak House (Charles Dickens, 1853)查尔斯·狄更斯《荒凉之屋》，1853年出版
0007.Wuthering Heights (Emily Bronte, 1847)艾米莉·勃朗特《呼啸山庄》，1847年出版
0008:David Copperfield (Charles Dickens, 1850)查尔斯·狄更斯《大卫·科波菲尔》，1850年出版
0009:Frankenstein (Mary Shelley, 1818)玛莉·雪莱《科学怪人》，1818年出版
0010:Vanity Fair (William Makepeace Thackeray, 1848)威廉·梅克皮斯·萨克雷《名利场》，1848年出版
String bookISBN, String bookName, String author, int yearPublished, int totalNumberOfTheBook
 */
/*movieName, movieReleasedYear, directorName, rating
Gone With the Wind ,(1939), Victor Fleming
Star Wars: Episode IV - A New Hope (1977),George Lucas
Titanic (1997), James Cameron
The Dark Knight (2008),Christopher Nolan
E. T. The Extra-Terrestrial (1982), Steven Spielberg
Jurassic Park (1993),Steven Spielberg
Harry Potter and the Deathly Hallows, Part 2 (2011),David Yates
Forrest Gump (1994),Robert Zemeckis
Avatar (2009)James Cameron,
Alice in Wonderland (2010), Tim Burton
 */

public class Library {
    private HashMap<String, Book> allBooks = new HashMap<>();
    private HashMap<String, Movie> allMovies = new HashMap<>();

    public Library() {
        initialLibraryBook();
        initialLibraryMovie();
    }

    private void initialLibraryBook() {
        Book book01 = new Book("0001", "Middlemarch", "George Eliot", 1874, 1);
        Book book02 = new Book("0002", "To the Lighthouse", "Virginia Woolf", 1927, 1);
        Book book03 = new Book("0003", "Mrs Dalloway", "Virginia Woolf", 1925, 1);
        Book book04 = new Book("0004", "Great Expectations", "Charles Dickens", 1861, 1);
        Book book05 = new Book("0005", "Jane Eyre", "Charlotte Bronte", 1847, 1);
        Book book06 = new Book("0006", "leak House", "Charles Dickens", 1853, 1);
        Book book07 = new Book("0007", "Wuthering Heights", "Emily Bronte", 1847, 1);
        Book book08 = new Book("0008", "David Copperfield", "Charles Dickens", 1850, 1);
        Book book09 = new Book("0009", "Frankenstein", "Mary Shelley", 1818, 1);
        Book book10 = new Book("0010", "Vanity Fair", "William Makepeace Thackeray", 1848, 1);
        allBooks.put(book01.getBookISBN(), book01);
        allBooks.put(book02.getBookISBN(), book02);
        allBooks.put(book03.getBookISBN(), book03);
        allBooks.put(book04.getBookISBN(), book04);
        allBooks.put(book05.getBookISBN(), book05);
        allBooks.put(book06.getBookISBN(), book06);
        allBooks.put(book07.getBookISBN(), book07);
        allBooks.put(book08.getBookISBN(), book08);
        allBooks.put(book09.getBookISBN(), book09);
        allBooks.put(book10.getBookISBN(), book10);
    }

    private void initialLibraryMovie() {
        Movie movie01 = new Movie("90001","Titanic", 1997, "James Cameron", 1);
        Movie movie02 = new Movie("90002", "Gone With the Wind", 1939, "Victor Fleming", "9.9", 1);
        Movie movie03 = new Movie("90003","Star Wars: Episode IV - A New Hope", 1977, "George Lucas", "9", 1);
        Movie movie04 = new Movie("90004","The Dark Knight", 2008, "Christopher Nolan", "9.1", 1);
        Movie movie05 = new Movie("90005","Jurassic Park", 1993, "Steven Spielberg", "8.9", 1);
        Movie movie06 = new Movie("90006","E. T. The Extra-Terrestrial", 1982, "Steven Spielberg", 1);
        Movie movie07 = new Movie("90007","Harry Potter and the Deathly Hallows, Part 2", 2011, "David Yates", "8.8", 1);
        Movie movie08 = new Movie("90008", "Forrest Gump", 1994, "Robert Zemeckis", "9.4", 1);
        Movie movie09 = new Movie("90009","Avatar", 2009, "James Cameron", "9.2", 1);
        Movie movie10 = new Movie("90010","Alice in Wonderland", 2010, "Tim Burton", "8.7", 1);
        allMovies.put(movie01.getMovieIMDbNumber(), movie01);
        allMovies.put(movie02.getMovieIMDbNumber(), movie02);
        allMovies.put(movie03.getMovieIMDbNumber(), movie03);
        allMovies.put(movie04.getMovieIMDbNumber(), movie04);
        allMovies.put(movie05.getMovieIMDbNumber(), movie05);
        allMovies.put(movie06.getMovieIMDbNumber(), movie06);
        allMovies.put(movie07.getMovieIMDbNumber(), movie07);
        allMovies.put(movie08.getMovieIMDbNumber(), movie08);
        allMovies.put(movie09.getMovieIMDbNumber(), movie09);
        allMovies.put(movie10.getMovieIMDbNumber(), movie10);
    }
    public void getAllBookList() {
        String title = String.format("%-10s%-20s%-30s%-10s", "ISBN", "BookName", "Author", "PublishedYear");
        System.out.println(title);
        allBooks.forEach((bookISBN, oneBook) -> {
            if (oneBook.getLeftNumberOfTheBook() != 0) {
                String oneBookDetail = String.format("%-10s%-20s%-30s%-10d",
                        bookISBN,
                        oneBook.getBookName(),
                        oneBook.getAuthor(),
                        oneBook.getYearPublished());
                System.out.println(oneBookDetail);
            }
        });
    }
    public void getAllMovieList() {
        String title = String.format("%-10s%-50s%-20s%-20s%-10s","No.", "MovieName", "ReleasedYear", "Director", "Rating");
        System.out.println(title);
        allMovies.forEach((movieName, oneMovie) -> {
            if (oneMovie.getLeftNumberOfTheMovie() != 0) {
                String oneMovieDetail = String.format("%-10s%-50s%-20d%-20s%-10s",
                        oneMovie.getMovieIMDbNumber(),
                        oneMovie.getMovieName(),
                        oneMovie.getMovieReleasedYear(),
                        oneMovie.getDirectorName(),
                        oneMovie.getMovieRating());
                System.out.println(oneMovieDetail);
            }
        });
    }

    public boolean ifBookExist(String bookISBN) {
        return allBooks.containsKey(bookISBN);
    }

    public boolean ifMovieExist(String movieIMDb) {
        return allMovies.containsKey(movieIMDb);
    }
    public String getOneBookDetailByName(String bookISBN) {
        if (allBooks.containsKey(bookISBN)) {
            Book foundBook = allBooks.get(bookISBN);
            String bookDetail = String.format("%-0s%-30s%-10d",
                    foundBook.getBookName(), foundBook.getAuthor(), foundBook.getYearPublished());
            return bookDetail;
        }else {
            return null;
        }
    }

    public Book checkoutOneBookByBookName(String bookName) {
        Book[] books = new Book[1];
        allBooks.forEach((bookisbn, oneBook) -> {
            if (oneBook.getLeftNumberOfTheBook()!=0 && oneBook.getBookName() == bookName) {
                books[0] = new Book(oneBook.getBookISBN(),
                        oneBook.getBookName(),
                        oneBook.getAuthor(),
                        oneBook.getYearPublished(),
                        oneBook.getTotalNumberOfTheBook());
                oneBook.setLeftNumberOfTheBook(oneBook.getLeftNumberOfTheBook()-1);
            }else {
                books[0] = null;
            }
        });
        return books[0];
    }

    public Book checkoutOneBookByBookISBN(String bookIsbn) {
        if (allBooks.containsKey(bookIsbn) && allBooks.get(bookIsbn).getLeftNumberOfTheBook() != 0) {
            Book originBook = allBooks.get(bookIsbn);
            originBook.setLeftNumberOfTheBook(originBook.getLeftNumberOfTheBook() - 1);
            return new Book(originBook.getBookISBN(), originBook.getBookName(),
                    originBook.getAuthor(), originBook.getYearPublished());
        }
        return null;

    }

    public boolean returnOneBookByBookISBN(String bookIsbn) {
        if (allBooks.containsKey(bookIsbn)) {
            Book originBook = allBooks.get(bookIsbn);
            originBook.setLeftNumberOfTheBook(originBook.getLeftNumberOfTheBook() + 1);
            return true;
        }
        return false;

    }

    public Movie checkoutOneMovieByMovieIMDb(String movieIMDb) {
        if (allMovies.containsKey(movieIMDb) && allMovies.get(movieIMDb).getLeftNumberOfTheMovie() != 0) {
            Movie originMovie = allMovies.get(movieIMDb);
            originMovie.setLeftNumberOfTheMovie(originMovie.getLeftNumberOfTheMovie() - 1);
            return new Movie(originMovie.getMovieIMDbNumber(), originMovie.getMovieName(),
                    originMovie.getMovieReleasedYear(), originMovie.getDirectorName(), originMovie.getMovieRating());
        }
        return null;

    }

    public boolean returnOneMovieByMovieIMDb(String movieIMDb) {
        if (allMovies.containsKey(movieIMDb)) {
            Movie originMovie = allMovies.get(movieIMDb);
            originMovie.setLeftNumberOfTheMovie(originMovie.getLeftNumberOfTheMovie() + 1);
            return true;
        }
        return false;
    }

}
