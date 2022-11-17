package com.sda.mihai.bookmanagement.controller;

import com.sda.mihai.bookmanagement.model.Author;
import com.sda.mihai.bookmanagement.repository.AuthorRepository;
import com.sda.mihai.bookmanagement.service.AuthorService;
import com.sda.mihai.bookmanagement.service.exception.InvalidParametreException;

import java.util.Scanner;

public class AuthorController {
    private final AuthorService authorService;
    private final Scanner scanner = new Scanner(System.in);

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    public void createAuthor() {

        try {
            System.out.println("Please insert a author first name: ");
            String firstName = scanner.nextLine();
            System.out.println("Please insert a author last name: ");

            String lastName = scanner.nextLine();
            authorService.createAuthor(firstName, lastName);

        } catch (InvalidParametreException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println("Internal server error!");
        }

    }
}
