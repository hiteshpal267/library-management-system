package com.example.lbms.repository;

import com.example.lbms.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositoryInterface extends JpaRepository<Student, Integer> {

}
