package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu {
    private ArrayList<String> allCommands = new ArrayList<>();
    public Menu() {
        allCommands.add("List Books");
        allCommands.add("Quit");
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
        if (customerCommand == "Quit") {
            System.exit(1);
        }else {
            System.out.println(customerCommand);
        }
    }

}
