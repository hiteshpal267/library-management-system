package com.example.lbms.requests;

import com.example.lbms.enums.Genre;
import com.example.lbms.models.Author;
import com.example.lbms.models.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookCreateRequest {
    @NotBlank
    private String name;

    @Positive
    private int cost;

    @NotBlank
    private String isbn;

    @NotNull
    private Genre genre;

    @NotNull
    private Author author;

    public Book toBook() {
        return Book.builder()
                .cost(cost)
                .name(name)
                .isbn(isbn)
                .genre(genre)
                .author(author)
                .build();
    }
}
