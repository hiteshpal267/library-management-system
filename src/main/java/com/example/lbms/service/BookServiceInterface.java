package com.example.lbms.service;

import com.example.lbms.enums.BookFilterType;
import com.example.lbms.models.Book;
import com.example.lbms.requests.BookCreateRequest;

import java.util.List;

public interface BookServiceInterface {
    Book create(BookCreateRequest bookCreateRequest);
    // Book save(Book book);
     Book save(BookCreateRequest bookCreateRequest);

    Book findById(Integer id);
    List<Book> findBooks(BookFilterType bookFilterType, String value);
}
