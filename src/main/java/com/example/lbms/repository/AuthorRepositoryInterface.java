package com.example.lbms.repository;

import com.example.lbms.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepositoryInterface extends JpaRepository<Author, Integer> {
    Author findByEmail(String email);

    // Age >=, Country, name starting with
    // 1st - JPQL Query
    @Query("SELECT a FROM Author a WHERE a.age >= ?1 AND a.country = ?2 AND a.name LIKE %?3%")


    // 2nd - Native SQL Query
    // @Query(value = "SELECT * FROM author a WHERE a.age >= ?1 AND a.country = ?2 AND a.name LIKE %?3", nativeQuery = true)

    // 3rd - Writing JPA function

    List<Author> findByAgeGreaterThanEqualAndCountryAndNameStartingWith(int age, String name, String prefix);
}
