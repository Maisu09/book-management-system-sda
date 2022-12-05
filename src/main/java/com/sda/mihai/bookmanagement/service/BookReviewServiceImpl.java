package com.sda.mihai.bookmanagement.service;

import com.sda.mihai.bookmanagement.model.Book;
import com.sda.mihai.bookmanagement.model.Review;
import com.sda.mihai.bookmanagement.repository.BookRepository;
import com.sda.mihai.bookmanagement.repository.BookReviewRepository;
import com.sda.mihai.bookmanagement.service.exception.EntityNotFoundException;
import com.sda.mihai.bookmanagement.service.exception.InvalidParametreException;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

public class BookReviewServiceImpl implements BookReviewService {
    private final BookReviewRepository bookReviewRepository;
    private final BookRepository bookRepository;

    public BookReviewServiceImpl(BookReviewRepository bookReviewRepository, BookRepository bookRepository) {
        this.bookReviewRepository = bookReviewRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void createBookReview(String bookTitle, int score, String comment) throws InvalidParameterException, EntityNotFoundException {
        if (bookTitle == null || bookTitle.isBlank() || bookTitle.length() < 3) {
            throw new InvalidParameterException("Provided value for book title: " + bookTitle + " is invalid");
        }
        if (comment == null || comment.isBlank() || comment.length() < 10) {
            throw new InvalidParameterException("Provided value for comment: " + comment + " is invalid");
        }
        if (score < 1 || score > 5) {
            throw new InvalidParameterException("Provided value for score: " + score + " is invalid");
        }

        Optional<Book> bookOptional = bookRepository.findByTitle(bookTitle);
        if (bookOptional.isEmpty()) {
            throw new EntityNotFoundException("Book not found for provided title: " + bookTitle);
        }

        Book book = bookOptional.get();

        Review review = new Review(score, comment);
        review.setBook(book);


        bookReviewRepository.create(review);
    }

    @Override
    public List<Review> getReviewByTitle(String title) throws InvalidParametreException {
        if (title == null || title.isBlank() || title.length() < 3) {
            throw new InvalidParametreException("Provided title: " + title + " not valid");
        }

        Optional<Book> bookOptional = bookRepository.findByTitle(title);



        Book book = bookOptional.get();
        List<Review> bookReviews = book.getBookReviews();
        return bookReviews;
    }
}
