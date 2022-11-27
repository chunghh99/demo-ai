package com.example.apidiemdanh.repository;

import com.example.apidiemdanh.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findByUserId(Long userId);
}
