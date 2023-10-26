package com.example.lbms.models;

import com.example.lbms.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String externalId;

    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;

    private double payment;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Student student;

    @CreationTimestamp
    private Date createdOn;

}
