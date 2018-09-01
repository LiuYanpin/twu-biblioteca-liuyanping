package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    private Menu allMenu = new Menu();

    {
        System.out.println("Welcome to the library!");
        allMenu.getAllMenuList();
    }


    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        System.out.println("Please input one of the options:");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String customerOption = scanner.nextLine();
            if ("Quit".equals(customerOption)) {
                break;
            }
            if (app.allMenu.ifCommandExist(customerOption)) {
                app.allMenu.afterChooseOneCommand(customerOption);
            }else {
                System.out.println("Select a valid option!");
            }
        }

    }
}
