package com.example.lbms.requests;

import com.example.lbms.enums.AccountStatus;
import com.example.lbms.models.Student;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentCreateRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotNull
    private String contact;

    @NotNull
    private AccountStatus accountStatus;

    @NotBlank
    private String address;

    private Student toStudent() {
        return Student.builder()
                .name(name)
                .address(address)
                .email(email)
                .contact(contact)
                .accountStatus(accountStatus)
                .build();
    }
}
