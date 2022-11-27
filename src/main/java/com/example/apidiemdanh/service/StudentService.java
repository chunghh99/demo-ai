package com.example.apidiemdanh.service;

import com.example.apidiemdanh.entity.Student;

public interface StudentService {
    Student findByUserId(Long userId);
}
