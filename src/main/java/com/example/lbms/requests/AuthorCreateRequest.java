package com.example.lbms.requests;

import com.example.lbms.models.Author;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorCreateRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String country;

    @NotBlank
    @Positive
    private int age;

    @NotNull
    private String email;

    private Author toAuthor() {
        return Author.builder()
                .age(age)
                .email(email)
                .country(country)
                .name(name)
                .build();
    }
}
