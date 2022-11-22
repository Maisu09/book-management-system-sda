package com.sda.mihai.bookmanagement.service;

import com.sda.mihai.bookmanagement.model.Book;
import com.sda.mihai.bookmanagement.service.exception.EntityNotFoundException;
import com.sda.mihai.bookmanagement.service.exception.InvalidParametreException;

import java.util.List;

public interface BookService {
    void createBook(String title, String description, int authorId) throws EntityNotFoundException;

    void deleteBook(int bookId) throws EntityNotFoundException;

    void updateBook(int bookId, int newBookId, String title, String description) throws InvalidParametreException, EntityNotFoundException;
    List<Book> getAllBooks();


}
