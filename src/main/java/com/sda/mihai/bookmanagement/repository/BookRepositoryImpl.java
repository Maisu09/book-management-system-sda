package com.sda.mihai.bookmanagement.repository;


import com.sda.mihai.bookmanagement.model.Book;
import com.sda.mihai.bookmanagement.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book> implements BookRepository {
    public BookRepositoryImpl() {
        super(Book.class);
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            Query<Book> query = session.createQuery("FROM Book b WHERE b.title = :bookTitle", Book.class);
            query.setParameter("bookTitle", title);

            List<Book> books = query.list();
            if (!books.isEmpty()) {
                return Optional.of(books.get(0));
            } else {
                return Optional.empty();
            }

        }
    }
}
