package com.twu.biblioteca;

public class BibliotecaApp {
    {
        System.out.println("Welcome to the library!");
        System.out.println("------------------");
        Library publicLibrary = new Library();
        publicLibrary.getAllBookList();
    }
    public static void main(String[] args) {
        System.out.println("Welcome to the library!");
    }
}
