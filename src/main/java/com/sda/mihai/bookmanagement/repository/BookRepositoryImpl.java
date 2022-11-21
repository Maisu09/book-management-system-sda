package com.sda.mihai.bookmanagement.repository;

import com.sda.mihai.bookmanagement.model.Book;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book> implements BookRepository {
    public BookRepositoryImpl() {
        super(Book.class);
    }
}
