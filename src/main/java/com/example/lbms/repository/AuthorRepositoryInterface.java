package com.example.lbms.repository;

import com.example.lbms.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepositoryInterface extends JpaRepository<Author, Integer> {
    Author findByEmail(String email);
}
