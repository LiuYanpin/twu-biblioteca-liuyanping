package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {
    @Test
    public void should_get_an_command() {
        Menu actualMenu = new Menu();
        assertTrue(actualMenu.ifCommandExist("List Books"));
        assertFalse(actualMenu.ifCommandExist("List"));
    }

    @Test
    public void should_get_all_menulist() {
        Menu actualMenu = new Menu();
        actualMenu.getAllMenuList();
    }

}