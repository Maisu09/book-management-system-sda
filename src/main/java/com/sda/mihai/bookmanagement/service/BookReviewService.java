package com.sda.mihai.bookmanagement.service;

import com.sda.mihai.bookmanagement.service.exception.EntityNotFoundException;
import com.sda.mihai.bookmanagement.service.exception.InvalidParametreException;


public interface BookReviewService {
    void createBookReview(String bookTitle, int score, String comment) throws EntityNotFoundException, InvalidParametreException;
}
