package com.sda.mihai.bookmanagement.repository;

import com.sda.mihai.bookmanagement.model.Review;

public class BookRepositoryReviewImpl extends BaseRepositoryImpl<Review> implements BookReviewRepository{
    public BookRepositoryReviewImpl() {
        super(Review.class);
    }
}
