package com.example.lbms.repository;

import com.example.lbms.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepositoryInterface extends JpaRepository<Book, Integer> {
    List<Book> findByName(String name);
    List<Book> findByAuthor_name(String name);
    List<Book> findByGenre(String genre);
    List<Book> findByCost(int cost);
}
