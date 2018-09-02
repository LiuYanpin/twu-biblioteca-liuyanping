package com.twu.biblioteca;

import java.util.Scanner;
import java.util.regex.Pattern;

public class BibliotecaApp {
    private Menu allMenu;
    private Librarian librarian;

    {
        System.out.println("Welcome to the library!");
        Library publicLibrary = new Library();
        allMenu = new Menu(publicLibrary);
        librarian = new Librarian(publicLibrary);
    }

    public BibliotecaApp() {

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

    public String getNewLibraryNumber() {
        return librarian.generatorOneNewLibraryNumber();
    }

    public boolean createOneNewCustomer(String customerLibraryNumber,
                                         String customerLibraryPassword,
                                         String customerName,
                                         String customerEmailAddress,
                                         String customerPhoneNumber) {
        return librarian.createOneCustomer(customerLibraryNumber,
                customerLibraryPassword, customerName, customerEmailAddress, customerPhoneNumber);

    }

    public void getMenuList() {
        allMenu.getAllMenuList();
    }

    public boolean ifOptionExist(String customerOption) {
        return allMenu.ifCommandExist(customerOption);
    }

    public boolean afterChooseOneOption(String customerOption) {
        return allMenu.afterChooseOneCommand(customerOption);
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

    public boolean returnOneBook(String bookISBN) {
        return librarian.returnOneBook(bookISBN);
    }

    public boolean returnOneMovie(String movieIMDb) {
        return librarian.returnOneMovie(movieIMDb);
    }

    public void startLibraryApp(BibliotecaApp app) {
        Customer currentCustomer;
        while (true) {
            System.out.println("Please input your LibraryNumber: (input \"Quit\" to exit the system)");
            Scanner scanner = new Scanner(System.in);
            String customerLibraryNumber = scanner.nextLine();
            if (app.ifCustomerLibraryNumberExist(customerLibraryNumber)) {
                while (true) {
                    System.out.println("Please input your password: ");
                    String customerPassword = scanner.nextLine();
                    if (app.ifCustomerPasswordCorrect(customerLibraryNumber, customerPassword)) {
                        currentCustomer = app.getOneCustomerByLibraryNumber(customerLibraryNumber);
                        currentCustomer.getCustomerDetail();
                        break;
                    }else {
                        System.out.println("Your password is not correct!");
                        continue;
                    }
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
                System.out.println("-------------------------------------");
                System.out.println("Please input one of the options: (Input \"Quit\" to log out)");
                app.getMenuList();
                String customerOption = optionScanner.nextLine();
                if ("Quit".equals(customerOption)) {
                    System.out.println("You have logged out! Goodbye! See you later!");
                    break;
                }
                if (!app.ifOptionExist(customerOption)) {
                    System.out.println("Select a valid option!");
                    continue;
                }
                if (!app.afterChooseOneOption(customerOption)) {
                    continue;
                }
                String customerCheckOption = optionScanner.nextLine();
                String checkoutPattern = "^(Checkout|Return)\\s(Book|Movie)\\s\\d{4,5}$";

                if (!Pattern.matches(checkoutPattern, customerCheckOption)) {
                    System.out.println("Not right.Please input a valid option!");
                    continue;
                }
                if ("Checkout".equals(customerCheckOption.split(" ")[0])){
                    if ("Book".equals(customerCheckOption.split(" ")[1])) {
                        String bookISBN = customerCheckOption.split(" ")[2];
                        Book borrowedBook = app.checkOneBookFormLibrary(bookISBN);
                        if (borrowedBook != null) {
                            currentCustomer.borrowOneBook(borrowedBook);
                            System.out.println("Thank you! Enjoy the book!");
                        }else {
                            System.out.println("That book is not available.");
                        }
                        continue;
                    }else if ("Movie".equals(customerCheckOption.split(" ")[1])) {
                        String movieIMDb = customerCheckOption.split(" ")[2];
                        Movie borrowedMovie = app.checkOneMovieFormLibrary(movieIMDb);
                        if (borrowedMovie != null) {
                            currentCustomer.borrowOneMovie(borrowedMovie);
                            System.out.println("Thank you! Enjoy the movie!");
                        }else {
                            System.out.println("That movie is not available.");
                        }
                        continue;
                    }else {
                        System.out.println("Please input a valid option!");
                    }
                    continue;
                }else if ("Return".equals(customerCheckOption.split(" ")[0])) {
                    if ("Book".equals(customerCheckOption.split(" ")[1])) {
                        String bookISBN = customerCheckOption.split(" ")[2];
                        if (!app.ifCustomerCanReturnOneBook(currentCustomer, bookISBN)) {
                            System.out.println("You didn't borrow this book, so you don't need to return this book.");
                            continue;
                        }
                        if (app.returnOneBook(bookISBN)) {
                            System.out.println("Thank you for returning the book.");
                        }else {
                            System.out.println("That is not a valid book to return.");
                        }
                    }else if ("Movie".equals(customerCheckOption.split(" ")[1])) {
                        String movieIMDb = customerCheckOption.split(" ")[2];
                        if (!app.ifCustomerCanReturnOneMovie(currentCustomer, movieIMDb)) {
                            System.out.println("You didn't borrow this movie, so you don't need to return this movie.");
                            continue;
                        }
                        if (app.returnOneMovie(movieIMDb)) {
                            System.out.println("Thank you for returning the movie.");
                        }else {
                            System.out.println("That is not a valid movie to return.");
                        }
                    }else {
                        System.out.println("Please input a valid option!");
                    }
                    continue;
                }else if ("Quit".equals(customerCheckOption)) {
                    continue;
                }
                System.out.println("Please input a valid option!");
                continue;
            }
        }
    }

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.startLibraryApp(app);
    }
}
