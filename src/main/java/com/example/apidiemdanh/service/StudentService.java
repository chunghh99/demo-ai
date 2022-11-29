package com.example.apidiemdanh.service;

import com.example.apidiemdanh.entity.Student;

import java.util.List;

public interface StudentService {
    Student findByUserId(Long userId);
    List<Student> getAll();
    Student getById(Long id);
    void create(Student student);
    void update(Student student);
}
