package com.sda.mihai.bookmanagement.controller;

import com.sda.mihai.bookmanagement.service.BookReviewService;
import com.sda.mihai.bookmanagement.service.exception.EntityNotFoundException;
import com.sda.mihai.bookmanagement.service.exception.InvalidParametreException;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class ReviewController {
    private final Scanner scanner = new Scanner(System.in);
    private final BookReviewService bookReviewService;

    public ReviewController(BookReviewService bookReviewService) {
        this.bookReviewService = bookReviewService;
    }

    public void createReview() {
        try {
            System.out.println("Please insert book title : ");
            String title = scanner.nextLine();

            System.out.println("Please insert a score: ");
            int score = Integer.parseInt(scanner.nextLine());

            System.out.println("Please insert a comment");
            String comment = scanner.nextLine();

            bookReviewService.createBookReview(title, score, comment);
            System.out.println("Review was created!");
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

    public void getReviewsByTitle() {
        try {
            System.out.println("Please insert book title for the reviews: ");
            String title = scanner.nextLine();

            System.out.println(bookReviewService.getReviewByTitle(title));
        } catch (InvalidParametreException e) {
            System.out.println(e.getMessage());
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Internal system error!");
        }
    }
}
