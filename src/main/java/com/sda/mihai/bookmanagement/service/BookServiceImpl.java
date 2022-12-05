package com.sda.mihai.bookmanagement.service;

import com.sda.mihai.bookmanagement.model.Author;
import com.sda.mihai.bookmanagement.model.Book;
import com.sda.mihai.bookmanagement.repository.AuthorRepository;
import com.sda.mihai.bookmanagement.repository.BookRepository;
import com.sda.mihai.bookmanagement.service.exception.EntityNotFoundException;
import com.sda.mihai.bookmanagement.service.exception.InvalidParametreException;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void createBook(String title, String description, int authorId) throws EntityNotFoundException {
        if (title == null || title.isBlank() || title.length() < 4) {
            throw new InvalidParameterException("Provided value for title: " + title + " is invalid");
        }
        if (description == null || description.isBlank() || description.length() < 3) {
            throw new InvalidParameterException("Provided value for description: " + description + " is invalid");
        }
        if (authorId < 1) {
            throw new InvalidParameterException("Provided value for author id: " + authorId + " is invalid");
        }
        Optional<Author> authorOptional = authorRepository.findById(authorId);
        if (authorOptional.isEmpty()) {
            throw new EntityNotFoundException("Author with provided id: " + authorId + "not existent!");
        }
        Author author = authorOptional.get();

        Book book = new Book(title, description);
        book.setAuthor(author);
        bookRepository.create(book);

    }

    @Override
    public void updateBook(int bookId, int authorId ,String title, String description) throws InvalidParametreException, EntityNotFoundException {
        if (bookId <1 ) {
            throw new InvalidParametreException("The provided book id: " + bookId + " is invalid!");

        }
        if (authorId < 1) {
            throw new InvalidParametreException("The provided book id: " + authorId + " is invalid!");
        }
        if (title == null || title.isBlank() || title.length() < 4) {
            throw new InvalidParametreException("Provided value for title: " + title + " is invalid");
        }
        if (description == null || description.isBlank() || description.length() < 10){
            throw new InvalidParametreException("Provided value for description: " + title + " is invalid");
        }
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if(bookOptional.isEmpty()) {
            throw new EntityNotFoundException("Book with id: " + bookId + " was not found");
        }

        Optional<Author> authorOptional = authorRepository.findById(authorId);
        Book book = bookOptional.get();
        book.setTitle(title);
        book.setDescription(description);

        Author author = authorOptional.get();
        book.setAuthor(author);

        bookRepository.update(book);
    }

    @Override
    public void deleteBook(int bookId) throws EntityNotFoundException, InvalidParameterException {
        if (bookId < 1) {
            throw new InvalidParameterException("Provided book id: " + bookId + "is invalid");
        }

        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if(bookOptional.isEmpty()){
            throw new EntityNotFoundException("Book with id: " + bookId + " was not found!");
        }
        Book book = bookOptional.get();

        bookRepository.delete(book);

    }


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
