package com.example.lbms.serviceImpl;

import com.example.lbms.repository.AuthorRepositoryInterface;
import com.example.lbms.models.Author;
import com.example.lbms.service.AuthorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorServiceInterface {
    @Autowired
    AuthorRepositoryInterface authorRepositoryInterface;

    @Override
    public Author createAuthor(Author author) {
        authorRepositoryInterface.save(author);
        return author;
    }

    @Override
    public Author findByEmail(String email) {
        return authorRepositoryInterface.findByEmail(email);
    }
}
