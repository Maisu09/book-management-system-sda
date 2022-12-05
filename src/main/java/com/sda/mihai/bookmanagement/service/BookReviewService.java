package com.sda.mihai.bookmanagement.service;

import com.sda.mihai.bookmanagement.model.Review;
import com.sda.mihai.bookmanagement.service.exception.EntityNotFoundException;
import com.sda.mihai.bookmanagement.service.exception.InvalidParametreException;

import java.util.List;


public interface BookReviewService {
    void createBookReview(String bookTitle, int score, String comment) throws EntityNotFoundException, InvalidParametreException;

    List<Review> getReviewByTitle(String title) throws InvalidParametreException, EntityNotFoundException;
}


