package com.example.lbms.serviceImpl;

import com.example.lbms.enums.TransactionType;
import com.example.lbms.exception.TransactionServiceException;
import com.example.lbms.models.Book;
import com.example.lbms.models.Student;
import com.example.lbms.models.Transaction;
import com.example.lbms.repository.TransactionRepositoryInterface;
import com.example.lbms.service.BookServiceInterface;
import com.example.lbms.service.StudentServiceInterface;
import com.example.lbms.service.TransactionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class TransactionServiceImpl implements TransactionServiceInterface {
    @Autowired
    TransactionRepositoryInterface transactionRepositoryInterface;

    @Autowired
    StudentServiceInterface studentServiceInterface;

    @Autowired
    BookServiceInterface bookServiceInterface;

    @Override
    public String issueTransaction(int studentId, int bookId) throws TransactionServiceException {
        // Check if the book is present and also available
        // Create transaction instance with appropriate method invokes
        // Make the book unavailable

        // Check if the student has already issued the book or not - Assuming we have only one copy of that book
        // Later on I will add multiple copies of the book
        Student student = studentServiceInterface.findById(studentId);

        if(student == null) {
            throw new TransactionServiceException("Student not present in the library.");
        }

        Book book = bookServiceInterface.findById(bookId);
        if(book == null || book.getStudent() != null)
            throw new TransactionServiceException("Book not available in the library for issue");

        Transaction transaction = Transaction.builder()
                .externalId(UUID.randomUUID().toString())
                .transactionType(TransactionType.ISSUE)
                .payment(book.getCost())
                .student(student)
                .build();

        transactionRepositoryInterface.save(transaction);

        // Update the book details
        // Make it unavailable
        book.setStudent(student);
        bookServiceInterface.save(book);

        return transaction.getExternalId();
    }

    @Override
    public String returnTransaction(int studentId, int bookId) throws TransactionServiceException {
        // Check student
        // Check book if it's already issued
        Student student = studentServiceInterface.findById(studentId);
        if(student == null) {
            throw new TransactionServiceException("Student not present in the library");
        }

        Book book = bookServiceInterface.findById(bookId);
        if(book == null || book.getStudent() == null || !book.getStudent().equals(student)) {
            throw new TransactionServiceException("Book return is not valid for this student");
        }

        Transaction transaction = Transaction.builder()
                .externalId(UUID.randomUUID().toString())
                .transactionType(TransactionType.RETURN)
                .payment(0)
                .student(student)
                .build();

        transactionRepositoryInterface.save(transaction);

        // Update the book details
        // Make it available again
        book.setStudent(null);
        bookServiceInterface.save(book);

        return transaction.getExternalId();
    }
}
