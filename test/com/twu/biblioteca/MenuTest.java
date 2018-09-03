package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {
    @Test
    public void should_get_an_command() {
        Library library = new Library();
        Menu actualMenu = new Menu(library);
        assertTrue(actualMenu.ifCommandExist("List Books"));
        assertFalse(actualMenu.ifCommandExist("List"));
        assertTrue(actualMenu.ifCommandExist("List Movies"));
        assertFalse(actualMenu.ifCommandExist("Listsss"));
    }

    @Test
    public void should_get_all_menulist() {
        Library library = new Library();
        Menu actualMenu = new Menu(library);
        String actual = actualMenu.getAllMenuList();
        String expect = "List Books\n" +
                "List Movies\n" +
                "Checkout Book\n" +
                "Checkout Movie\n" +
                "Return Book\n" +
                "Return Movie\n" +
                "Quit\n";
        assertEquals(expect, actual);
    }

    @Test
    public void should_get_command_after_choose_one() {
        Library library = new Library();
        Menu menu = new Menu(library);
        menu.afterChooseOneCommand("Quit");
        menu.afterChooseOneCommand("List Books");
        menu.afterChooseOneCommand("List Movies");
        menu.afterChooseOneCommand("Checkout Movie");
        menu.afterChooseOneCommand("Checkout Book");
        menu.afterChooseOneCommand("Return Movie");
        menu.afterChooseOneCommand("Return Book");
    }

}