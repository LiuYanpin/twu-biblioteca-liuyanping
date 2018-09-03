package com.twu.biblioteca;

import java.util.Scanner;
import java.util.regex.Pattern;

public class BibliotecaApp {
    private Menu allMenu;
    private Librarian librarian;

    public BibliotecaApp() {
        System.out.println("*********************************");
        System.out.println("     Welcome to the library!");
        System.out.println("*********************************\n");
        Library publicLibrary = new Library();
        this.allMenu = new Menu(publicLibrary);
        this.librarian = new Librarian(publicLibrary);
    }

    public boolean ifCustomerLibraryNumberExist(String customerLibraryNumber) {
        return librarian.checkIfCustomerExist(customerLibraryNumber);
    }

    public boolean ifCustomerPasswordCorrect(String customerLibraryNumber, String customerPassword) {
        return librarian.checkIfCustomerPasswordCorrect(customerLibraryNumber, customerPassword);
    }

    public Customer getOneCustomerByLibraryNumber(String customerLibraryNumber) {
        return librarian.getOneCustomerByLibraryNumber(customerLibraryNumber);
    }

    public void getCustomerDetail(Customer currentCustomer) {
        System.out.println(librarian.getCustomerDetail(currentCustomer));
    }

    public void getMenuList() {
        System.out.println(allMenu.getAllMenuList());
    }

    public boolean ifOptionExist(String customerOption) {
        return allMenu.ifCommandExist(customerOption);
    }

    public void afterChooseOneOption(String customerOption) {
        allMenu.afterChooseOneCommand(customerOption);
    }

    public Book checkOneBookFormLibrary(String bookISBN) {
        return librarian.checkoutOneBook(bookISBN);
    }

    public Movie checkOneMovieFormLibrary(String movieIMDb) {
        return librarian.checkoutOneMovie(movieIMDb);
    }

    public boolean ifCustomerCanReturnOneBook(Customer customer, String bookISBN) {
        return librarian.ifCustomerCanReturnOneBook(customer, bookISBN);
    }

    public boolean ifCustomerCanReturnOneMovie(Customer customer, String movieIMDb) {
        return librarian.ifCustomerCanReturnOneMovie(customer, movieIMDb);
    }

    public boolean returnOneBook(Customer currentCustomer, String bookISBN) {
        return librarian.returnOneBook(currentCustomer, bookISBN);
    }

    public boolean returnOneMovie(Customer currentCustomer, String movieIMDb) {
        return librarian.returnOneMovie(currentCustomer, movieIMDb);
    }

    public void startLibraryApp(BibliotecaApp app) {
        Customer currentCustomer;
        while (true) {
            System.out.println("Please input your LibraryNumber: (input \"Quit\" to exit the system)");
            Scanner scanner = new Scanner(System.in);
            String customerLibraryNumber = scanner.nextLine();
            String libraryNumberPattern = "^\\d{3}-\\d{4}$";
            if (Pattern.matches(libraryNumberPattern, customerLibraryNumber) &&
                    app.ifCustomerLibraryNumberExist(customerLibraryNumber)) {
                System.out.println("Please input your password: ");
                String customerPassword = scanner.nextLine();
                if (app.ifCustomerPasswordCorrect(customerLibraryNumber, customerPassword)) {
                    currentCustomer = app.getOneCustomerByLibraryNumber(customerLibraryNumber);
                    app.getCustomerDetail(currentCustomer);
                }else {
                    System.out.println("Your password is NOT correct! Please try again.\n");
                    continue;
                }
            }else if ("Quit".equals(customerLibraryNumber)) {
                System.out.println("Goodbye!");
                break;
            }else {
                System.out.println("LibraryNumber does not exit.");
                continue;
            }

            while (true) {
                Scanner optionScanner = new Scanner(System.in);
                System.out.println("------------------------------------------------------------");
                System.out.println("Please input one of the options: (Input \"Quit\" to log out)");
                app.getMenuList();
                String customerOption = optionScanner.nextLine();
                if ("Quit".equals(customerOption)) {
                    System.out.println("You have logged out! Goodbye! See you later!");
                    break;
                }else if (!app.ifOptionExist(customerOption)) {
                    System.out.println("Select a valid option!");
                    continue;
                }
                app.afterChooseOneOption(customerOption);
                if ("List Books".equals(customerOption) || "List Movies".equals(customerOption)) {
                    continue;
                }
                String customerInputNumber = optionScanner.nextLine();
                String checkoutPattern = "^\\d{4,5}$";
                if (!Pattern.matches(checkoutPattern, customerInputNumber)) {
                    System.out.println("Please input a valid number!");
                    continue;
                }
                if ("Checkout Book".equals(customerOption) && Pattern.matches("^\\d{4}$", customerInputNumber)) {
                    Book borrowedBook = app.checkOneBookFormLibrary(customerInputNumber);
                    if (borrowedBook != null) {
                        currentCustomer.borrowOneBook(borrowedBook);
                        System.out.println("Thank you! Enjoy the book!");
                    }else {
                        System.out.println("That book is not available.");
                    }
                    continue;
                }else if ("Checkout Movie".equals(customerOption) && Pattern.matches("^\\d{5}$", customerInputNumber)) {
                    Movie borrowedMovie = app.checkOneMovieFormLibrary(customerInputNumber);
                    if (borrowedMovie != null) {
                        currentCustomer.borrowOneMovie(borrowedMovie);
                        System.out.println("Thank you! Enjoy the movie!");
                    }else {
                        System.out.println("That movie is not available.");
                    }
                    continue;
                }else if ("Return Book".equals(customerOption) && Pattern.matches("^\\d{4}$", customerInputNumber)) {
                    if (!app.ifCustomerCanReturnOneBook(currentCustomer, customerInputNumber)) {
                        System.out.println("You didn't borrow this book, so you don't need to return this book.");
                        continue;
                    }
                    if (app.returnOneBook(currentCustomer, customerInputNumber)) {
                        System.out.println("Thank you for returning the book.");
                    }else {
                        System.out.println("That is not a valid book to return.");
                    }
                    continue;
                }else if ("Return Movie".equals(customerOption) && Pattern.matches("^\\d{5}$", customerInputNumber)) {
                    if (!app.ifCustomerCanReturnOneMovie(currentCustomer, customerInputNumber)) {
                        System.out.println("You didn't borrow this movie, so you don't need to return this movie.");
                        continue;
                    }
                    if (app.returnOneMovie(currentCustomer, customerInputNumber)) {
                        System.out.println("Thank you for returning the movie.");
                    }else {
                        System.out.println("That is not a valid movie to return.");
                    }
                    continue;
                }
            }
        }
    }

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.startLibraryApp(app);
    }
}
