package com.sda.mihai.bookmanagement.repository;


import com.sda.mihai.bookmanagement.model.Book;

import java.util.Optional;

public interface BookRepository extends BaseRepository<Book> {
    Optional<Book> findByTitle(String title);
}
