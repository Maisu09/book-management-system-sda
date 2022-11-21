package com.sda.mihai.bookmanagement.controller;

import com.sda.mihai.bookmanagement.service.BookService;
import com.sda.mihai.bookmanagement.service.exception.EntityNotFoundException;

import java.util.Scanner;

public class BookController {
    private final Scanner scanner = new Scanner(System.in);
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public void createBook() {
        System.out.println("please insert a title");
        String title = scanner.nextLine();
        System.out.println("Insert descrip");
        String description = scanner.nextLine();
        System.out.println("Please insert an author id");
        int authorId = Integer.parseInt(scanner.nextLine());

        try {
            bookService.createBook(title, description, authorId);
            System.out.println("Book was created!");
        } catch (NumberFormatException e) {
            System.out.println("Please insert a numberic value for author id!");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IllegalAccessError e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Internal system error!");
        }
    }

    public void showAllBooks() {
        bookService.getAllBooks().stream()
                .forEach(book ->
                        System.out.println(
                                "Book id: " + book.getId()
                                        + " title: " + book.getTitle()
                                        + " author " + book.getAuthor().getFirstName()
                                        + " " + book.getAuthor().getLastName()
                        )
                );
    }
}
