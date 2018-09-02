package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    private Menu allMenu;
    private Librarian librarian;

    {
        System.out.println("Welcome to the library!");
        Library publicLibrary = new Library();
        allMenu = new Menu(publicLibrary);
        allMenu.getAllMenuList();
        librarian = new Librarian(publicLibrary);
    }

    public BibliotecaApp() {

    }

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        Customer customer = new Customer();
        System.out.println("Please input one of the options:");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String customerOption = scanner.nextLine();
            if ("Quit".equals(customerOption)) {
                System.out.println("Goodbye! See you later!");
                break;
            }
            if (app.allMenu.ifCommandExist(customerOption)) {
                app.allMenu.afterChooseOneCommand(customerOption);
                System.out.println("If you want to borrrow a book, " +
                        "please input \"Checkout ISBN\", " +
                        "e.g. \"Checkout 0006\"");
                System.out.println("If you want to Return a book, " +
                        "please input \"Return ISBN\", " +
                        "e.g. \"Return 0006\"");
                continue;
            }else if ("Checkout".equals(customerOption.split(" ")[0])){
                String bookISBN = customerOption.split(" ")[1];
                Book borrowedBook = app.librarian.checkoutOneBook(bookISBN);
                if (borrowedBook != null) {
                    customer.borrowOneBook(borrowedBook);
                    System.out.println("Thank you! Enjoy the book");
                }else {
                    System.out.println("That book is not available.");
                }
                System.out.println("Please input one of the options:");
                continue;
            }else if ("Return".equals(customerOption.split(" ")[0])){
                String bookISBN = customerOption.split(" ")[1];
                if (!app.librarian.customerCanReturnOneBook(customer, bookISBN)) {
                    System.out.println("Sorry, you didn't borrow this book!");
                    continue;
                }
                if (app.librarian.returnOneBook(bookISBN)) {
                    System.out.println("Thank you for returning the book.");
                }else {
                    System.out.println("That is not a valid book to return.");
                }
                System.out.println("Please input one of the options:");
                continue;
            }
            System.out.println("Select a valid option!");

        }

    }
}
