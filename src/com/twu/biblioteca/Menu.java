package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {
    private ArrayList<String> allCommands = new ArrayList<>();
    private Library publicLibrary;

    public Menu() {
        allCommands.add("List Books");
        allCommands.add("List Movies");
        allCommands.add("Quit");
    }

    public Menu(Library publicLibrary) {
        allCommands.add("List Books");
        allCommands.add("List Movies");
        allCommands.add("Quit");
        this.publicLibrary = publicLibrary;
    }

    public boolean ifCommandExist(String customerCommand) {
        return allCommands.contains(customerCommand);
    }

    public void getAllMenuList() {
        for (int i = 0; i < allCommands.size(); i++) {
            System.out.println(allCommands.get(i));
        }
    }

    public boolean afterChooseOneCommand(String customerCommand) {
        if ("Quit".equals(customerCommand)) {
            System.exit(1);
            return false;
        }else if ("List Books".equals(customerCommand)) {
            publicLibrary.getAllBookList();
            System.out.println("If you want to Checkout a book, " +
                    "please input \"Checkout Book ISBN\", " +
                    "e.g. \"Checkout Book 0006\"");
            System.out.println("If you want to Return a book, " +
                    "please input \"Return Book ISBN\", " +
                    "e.g. \"Return Book 0006\"");
            System.out.println("Input \"Quit\" to the options page.");
            return true;
        }else if ("List Movies".equals(customerCommand)) {
            publicLibrary.getAllMovieList();
            System.out.println("If you want to Checkout a movie, " +
                    "please input \"Checkout Movie No.\", " +
                    "e.g. \"Checkout Movie 90001\"");
            System.out.println("If you want to Return a movie, " +
                    "please input \"Return Movie No.\", " +
                    "e.g. \"Return Movie 90001\"");
            System.out.println("Input \"Quit\" to the options page.");
            return true;
        }else {
            System.out.println("Select a valid option!");
            return false;
        }


    }

}
