package com.example.lbms.models;

import com.example.lbms.enums.Genre;
import com.example.lbms.response.BookSearchResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@Column(name = "name")
    private String name;

    //@Column(name = "cost")
    private int cost;

    //@Column(name = "isbn")
    private String isbn;

    //@Column(name = "genre")
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn
    private Student student;

    // Due to bidirectional relation everytime in the book table author is fetched book list needs to be ignored there
    // is a high chance of the application to go into IllegalStateException which leads to StackOverflow. Solution to
    // this condition is that we need to suppress the serialization of the property
    @ManyToOne
    @JsonIgnoreProperties({"bookList"})
    private Author author;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<Transaction> transactionList;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    public BookSearchResponse toBookSearchResponse() {
        return BookSearchResponse.builder()
                .id(id)
                .name(name)
                .cost(cost)
                .isbn(isbn)
                .genre(genre)
                .author(author)
                .createdOn(createdOn)
                .updatedOn(updatedOn)
                .build();
    }
}
