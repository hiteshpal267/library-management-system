package com.example.lbms.service;

import com.example.lbms.models.Student;
import com.example.lbms.requests.StudentCreateRequest;

public interface StudentServiceInterface {
    Student save(StudentCreateRequest studentCreateRequest);
    Student findById(int id);
}
