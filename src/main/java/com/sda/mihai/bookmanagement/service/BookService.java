package com.sda.mihai.bookmanagement.service;

import com.sda.mihai.bookmanagement.service.exception.EntityNotFoundException;

public interface BookService {
    void createBook(String title, String description, int authorId) throws EntityNotFoundException;
}
