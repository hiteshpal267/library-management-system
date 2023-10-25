package com.example.lbms.serviceImpl;

import com.example.lbms.exception.TransactionServiceException;
import com.example.lbms.repository.TransactionRepositoryInterface;
import com.example.lbms.service.TransactionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionServiceImpl implements TransactionServiceInterface {
    @Autowired
    TransactionRepositoryInterface transactionRepositoryInterface;

    @Override
    public String issueTransaction(int studentId, int bookId) throws TransactionServiceException {
        return null;
    }

    @Override
    public String returnTransaction(int studentId, int bookId) throws TransactionServiceException {
        return null;
    }
}
