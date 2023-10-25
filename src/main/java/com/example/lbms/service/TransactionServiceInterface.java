package com.example.lbms.service;

import com.example.lbms.exception.TransactionServiceException;

public interface TransactionServiceInterface {
    String issueTransaction(int studentId, int bookId) throws TransactionServiceException;
    String returnTransaction(int studentId, int bookId) throws TransactionServiceException;
}
