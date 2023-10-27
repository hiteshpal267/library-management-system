package com.example.lbms.models;

import com.example.lbms.enums.AccountStatus;
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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@Column(name = "name")
    private String name;

    @Column(unique = true)
    private String email;

    @Column(/*name = "contact",*/ unique = true, nullable = false)
    private String contact;

    //@Column(name = "address")
    private String address;

    //@Column(name = "account_status")
    @Enumerated(value = EnumType.STRING)
    private AccountStatus accountStatus;

    @OneToMany(mappedBy = "student")
    private List<Book> bookList;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<Transaction> transactionList;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;
}
