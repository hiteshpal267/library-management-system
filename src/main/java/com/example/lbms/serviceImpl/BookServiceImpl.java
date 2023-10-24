package com.example.lbms.serviceImpl;

import com.example.lbms.enums.BookFilterType;
import com.example.lbms.models.Author;
import com.example.lbms.repository.BookRepositoryInterface;
import com.example.lbms.models.Book;
import com.example.lbms.requests.BookCreateRequest;
import com.example.lbms.service.AuthorServiceInterface;
import com.example.lbms.service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookServiceInterface {
    @Autowired
    BookRepositoryInterface bookRepositoryInterface;

    @Autowired
    AuthorServiceInterface authorServiceInterface;

    @Override
    public Book create(BookCreateRequest bookCreateRequest) {
        Book book = bookCreateRequest.toBook();
//        String email = book.getAuthor().getEmail();
        Author authorFromDb = authorServiceInterface.findByEmail(book.getAuthor().getEmail());
        if(authorFromDb == null) {
            authorFromDb = authorServiceInterface.createAuthor(bookCreateRequest.getAuthor());
        }
        book.setAuthor(authorFromDb);
        authorServiceInterface.createAuthor(bookCreateRequest.getAuthor());
        return bookRepositoryInterface.save(book);
    }

    @Override
    public Book save(BookCreateRequest bookCreateRequest) {
        return create(bookCreateRequest);
    }

    @Override
    public Book findById(Integer id) {
        return null;
    }

    @Override
    public List<Book> findBooks(BookFilterType bookFilterType, String value) {
        return switch (bookFilterType) {
            case NAME -> bookRepositoryInterface.findByName(value);
            case GENRE -> bookRepositoryInterface.findByGenre(value);
            case AUTHOR_NAME -> bookRepositoryInterface.findByAuthor_name(value);
            case COST -> bookRepositoryInterface.findByCost(Integer.parseInt(value));
            case ID -> bookRepositoryInterface.findAllById(new ArrayList<>(Integer.parseInt(value)));
        };
    }
}
