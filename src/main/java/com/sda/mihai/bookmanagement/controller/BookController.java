package com.sda.mihai.bookmanagement.controller;

import com.sda.mihai.bookmanagement.service.BookService;
import com.sda.mihai.bookmanagement.service.exception.EntityNotFoundException;
import com.sda.mihai.bookmanagement.service.exception.InvalidParametreException;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class BookController {
    private final Scanner scanner = new Scanner(System.in);
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public void createBook() {
        try {
            System.out.println("please insert a title");
            String title = scanner.nextLine();
            System.out.println("Insert descrip");
            String description = scanner.nextLine();
            System.out.println("Please insert an author id");
            int authorId = Integer.parseInt(scanner.nextLine());
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

    public void updateBook() {

        try {
            System.out.println("Please insert the books old id: ");
            int oldId = Integer.parseInt(scanner.nextLine());

            System.out.println("Please insert the new title: ");
            String title = scanner.nextLine();

            System.out.println("Please insert the new id: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.println("Please insert the new description: ");
            String description = scanner.nextLine();

            bookService.updateBook(oldId, id, title, description);
        } catch (InvalidParametreException e) {
            System.out.println(e.getMessage());
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR");
        }

    }

    public void deleteBook() {

        try {
            System.out.println("Please insert the book Id:");
            int bookId = Integer.parseInt(scanner.nextLine());

            bookService.deleteBook(bookId);
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());;
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Internal server error!");
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
