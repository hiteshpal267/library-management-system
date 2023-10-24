package com.example.lbms.controller;

import com.example.lbms.requests.StudentCreateRequest;
import com.example.lbms.service.StudentServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    StudentServiceInterface studentServiceInterface;

    @PostMapping("/saveStudent")
    public ResponseEntity<?> saveStudent(@Valid @RequestBody StudentCreateRequest studentCreateRequest) {
        return new ResponseEntity<>(studentServiceInterface.save(studentCreateRequest), HttpStatus.CREATED);
    }
}
