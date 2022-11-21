package com.sda.mihai.bookmanagement.service;

import com.sda.mihai.bookmanagement.repository.AuthorRepository;
import com.sda.mihai.bookmanagement.repository.BookRepository;

public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void createBook(String title, String description, int authorId) {

    }
}
