package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {
    private ArrayList<String> allCommands = new ArrayList<>();
    private Library publicLibrary;

    public Menu(Library publicLibrary) {
        allCommands.add("List Books");
        allCommands.add("List Movies");
        allCommands.add("Checkout Book");
        allCommands.add("Checkout Movie");
        allCommands.add("Return Book");
        allCommands.add("Return Movie");
        allCommands.add("Quit");
        this.publicLibrary = publicLibrary;
    }

    public boolean ifCommandExist(String customerCommand) {
        return allCommands.contains(customerCommand);
    }

    public String getAllMenuList() {
        StringBuilder menuList = new StringBuilder();
        allCommands.forEach((item) -> menuList.append(item).append("\n"));
        return menuList.toString();
    }

    public void afterChooseOneCommand(String customerCommand) {
        switch (customerCommand) {
            case "Quit":
                break;
            case "List Books":
                System.out.println(publicLibrary.getAllBookList());
                break;
            case "List Movies":
                System.out.println(publicLibrary.getAllMovieList());
                break;
            case "Checkout Book":
                System.out.println("Please input ISBN of the book. e.g. \"0001\"");
                break;
            case "Checkout Movie":
                System.out.println("Please input number of the movie. e.g. \"90001\"");
                break;
            case "Return Book":
                System.out.println("Please input ISBN of the book. e.g. \"0001\"");
                break;
            case "Return Movie":
                System.out.println("Please input number of the movie. e.g. \"90001\"");
                break;
            default:
                break;
        }
    }

}
