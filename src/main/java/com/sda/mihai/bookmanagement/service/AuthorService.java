package com.sda.mihai.bookmanagement.service;

import com.sda.mihai.bookmanagement.model.Author;
import com.sda.mihai.bookmanagement.service.exception.EntityNotFoundException;
import com.sda.mihai.bookmanagement.service.exception.InvalidParametreException;

import java.security.InvalidParameterException;
import java.util.List;

public interface AuthorService {

    void createAuthor(String firstName, String lastName) throws InvalidParameterException;

    void updateAuthor(int authorId, String firstName, String lastName) throws InvalidParameterException, EntityNotFoundException;

    void deleteAuthor(int authorId) throws EntityNotFoundException;

    List<Author> getAllAuthors();


}
