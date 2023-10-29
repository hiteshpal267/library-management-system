package com.example.lbms.controller;

import com.example.lbms.enums.BookFilterType;
import com.example.lbms.enums.BookSearchOperationType;
import com.example.lbms.requests.BookCreateRequest;
import com.example.lbms.response.BookSearchResponse;
import com.example.lbms.service.BookServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookServiceInterface bookServiceInterface;

    @PostMapping("/saveBook")
    public ResponseEntity<?> saveBook(@Valid @RequestBody BookCreateRequest bookCreateRequest) {
        return new ResponseEntity<>(bookServiceInterface.save(bookCreateRequest), HttpStatus.CREATED);
    }

    @GetMapping("/books/search")
    public List<BookSearchResponse> findBooks(@RequestParam("filter") BookFilterType bookFilterType,
                                              @RequestParam("value") String value) {
        return bookServiceInterface.findFilteredBooks(bookFilterType, value);
    }

    @GetMapping("/books/search/robust")
    public List<BookSearchResponse> findBooks(@RequestParam("filter") BookFilterType bookFilterType,
                                              @RequestParam("value") String value,
                                              @RequestParam("bookSearchOperationType") BookSearchOperationType bookSearchOperationType) {
        return bookServiceInterface.findFilteredBooks(bookFilterType, value);
    }



}
