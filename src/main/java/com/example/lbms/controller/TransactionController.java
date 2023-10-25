package com.example.lbms.controller;

import com.example.lbms.exception.TransactionServiceException;
import com.example.lbms.service.TransactionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    @Autowired
    TransactionServiceInterface transactionServiceInterface;

    @PostMapping("/transaction/issue")
    public ResponseEntity<?> issueTxn(@RequestParam("studentId") int studentId,
                                      @RequestParam("bookId") int bookId) throws TransactionServiceException {

        return new ResponseEntity<>(transactionServiceInterface.issueTransaction(studentId, bookId), HttpStatus.OK);
    }

    @PostMapping("/transaction/return")
    public ResponseEntity<?> returnTxn(@RequestParam("studentId") int studentId,
                                      @RequestParam("bookId") int bookId) throws TransactionServiceException {

        return new ResponseEntity<>(transactionServiceInterface.returnTransaction(studentId, bookId), HttpStatus.OK);
    }
}
