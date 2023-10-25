package com.example.lbms.response;

import com.example.lbms.enums.Genre;
import com.example.lbms.models.Author;
import com.example.lbms.models.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@Builder
public class BookSearchResponse {
    private int id;
    private String name;
    private int cost;
    private String isbn;
    private Genre genre;
    private Student student;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @JsonIgnoreProperties({"bookList"})
    private Author author;
}
