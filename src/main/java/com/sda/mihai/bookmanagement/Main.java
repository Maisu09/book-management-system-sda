package com.sda.mihai.bookmanagement;

import com.sda.mihai.bookmanagement.controller.AuthorController;
import com.sda.mihai.bookmanagement.controller.BookController;
import com.sda.mihai.bookmanagement.controller.ReviewController;
import com.sda.mihai.bookmanagement.menu.UserOption;
import com.sda.mihai.bookmanagement.repository.AuthorRepositoryImpl;
import com.sda.mihai.bookmanagement.repository.BookRepositoryImpl;
import com.sda.mihai.bookmanagement.repository.BookRepositoryReviewImpl;
import com.sda.mihai.bookmanagement.service.AuthorServiceImpl;
import com.sda.mihai.bookmanagement.service.BookReviewServiceImpl;
import com.sda.mihai.bookmanagement.service.BookServiceImpl;
import com.sda.mihai.bookmanagement.utils.SessionManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionManager.getSessionFactory();
        AuthorController authorController = new AuthorController(new AuthorServiceImpl(new AuthorRepositoryImpl()));
        BookController bookController = new BookController(new BookServiceImpl(new BookRepositoryImpl(), new AuthorRepositoryImpl()));
        ReviewController reviewController = new ReviewController(new BookReviewServiceImpl(new BookRepositoryReviewImpl(), new BookRepositoryImpl()));
        Scanner scanner = new Scanner(System.in);



        UserOption userOption;
        do {
            UserOption.printAllOptions();
            System.out.println("Please select an option!");
            try {
                int numericOption = Integer.parseInt(scanner.nextLine());
                userOption = UserOption.findUserOption(numericOption);
            } catch (NumberFormatException e) {
                userOption = UserOption.UNKNOWN;
            }

            switch (userOption) {
                case CREATE_AUTHOR:
                    authorController.createAuthor();
                    break;
                case SHOW_ALL_AUTHORS:
                    authorController.showAllAuthors();
                    break;
                case UPDATE_AUTHOR:
                    authorController.updateAuthor();
                    break;
                case DELETE_AUTHOR:
                    authorController.deleteAuthor();
                    break;
                case CREATE_BOOK:
                    bookController.createBook();
                    break;
                case UPDATE_BOOK:
                    bookController.updateBook();
                case DELETE_BOOK:
                    bookController.deleteBook();
                case VIEW_ALL_BOOKS:
                    bookController.showAllBooks();
                    break;
                case CREATE_REVIEW:
                    reviewController.createReview();
                    break;
                case GET_REVIEW_BY_TITLE:
                    reviewController.getReviewsByTitle();
                    break;
                case EXIT:
                    System.out.println("Goodbye!");
                    break;
                case UNKNOWN:
                    System.out.println("Option unknown");
                    break;
                default:
                    System.out.println("User option " + userOption + " is not implemented");
                    break;
            }
        } while (userOption != UserOption.EXIT);
        SessionManager.shutDown();
    }
}
