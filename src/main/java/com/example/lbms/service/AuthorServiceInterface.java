package com.example.lbms.service;

import com.example.lbms.models.Author;

public interface AuthorServiceInterface {
    Author createAuthor(Author author);

    Author findByEmail(String email);
}
