package com.example.lbms.repository;

import com.example.lbms.enums.TransactionType;
import com.example.lbms.models.Book;
import com.example.lbms.models.Student;
import com.example.lbms.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepositoryInterface extends JpaRepository<Transaction, Integer> {
    Transaction findTopByBookAndStudentAndTransactionTypeOrderByIdDesc(Book book, Student student, TransactionType issue);
}
