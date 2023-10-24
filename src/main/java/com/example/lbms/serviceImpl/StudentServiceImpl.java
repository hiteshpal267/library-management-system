package com.example.lbms.serviceImpl;

import com.example.lbms.models.Student;
import com.example.lbms.repository.StudentRepositoryInterface;
import com.example.lbms.requests.StudentCreateRequest;
import com.example.lbms.service.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentServiceInterface {
    @Autowired
    StudentRepositoryInterface studentRepositoryInterface;

    @Override
    public Student save(StudentCreateRequest studentCreateRequest) {
        return saveFromStudent(studentCreateRequest.toStudent());
    }

    public Student saveFromStudent(Student student) {
        return studentRepositoryInterface.save(student);
    }

    @Override
    public Student findById(int studentId) {
        return studentRepositoryInterface.findById(studentId).get();
    }
}
