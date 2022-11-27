package com.example.apidiemdanh.service;

import com.example.apidiemdanh.entity.Student;
import com.example.apidiemdanh.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student findByUserId(Long userId) {

        return studentRepo.findByUserId(userId);
    }
}
