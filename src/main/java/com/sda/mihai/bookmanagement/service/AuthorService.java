package com.sda.mihai.bookmanagement.service;

import com.sda.mihai.bookmanagement.service.exception.InvalidParametreException;

public interface AuthorService {
    void createAuthor(String firstName, String lastName) throws InvalidParametreException;


}
