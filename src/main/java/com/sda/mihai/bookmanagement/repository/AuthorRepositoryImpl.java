package com.sda.mihai.bookmanagement.repository;

import com.sda.mihai.bookmanagement.model.Author;

public class AuthorRepositoryImpl extends BaseRepositoryImpl<Author> implements AuthorRepository  {

    public AuthorRepositoryImpl() {
        super(Author.class);
    }
}
