package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {
    private ArrayList<String> allCommands = new ArrayList<>();
    private Library publicLibrary;

    public Menu() {
        allCommands.add("List Books");
        allCommands.add("Quit");
    }

    public Menu(Library publicLibrary) {
        allCommands.add("List Books");
        allCommands.add("Quit");
        this.publicLibrary = publicLibrary;
    }

    public boolean ifCommandExist(String customerCommand) {
        return allCommands.contains(customerCommand);
    }

    public void getAllMenuList() {
        System.out.println("----Menu----");
        for (int i = 0; i < allCommands.size(); i++) {
            System.out.println(allCommands.get(i));
        }
    }

    public void afterChooseOneCommand(String customerCommand) {
        if ("Quit".equals(customerCommand)) {
            System.exit(1);
        }else if ("List Books".equals(customerCommand)) {
            publicLibrary.getAllBookList();
        }else {
            System.out.println("NoCommand");
        }


    }

}
