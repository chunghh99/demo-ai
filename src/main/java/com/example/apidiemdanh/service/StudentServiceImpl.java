package com.example.apidiemdanh.service;

import com.example.apidiemdanh.entity.Student;
import com.example.apidiemdanh.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student findByUserId(Long userId) {

        return studentRepo.findByUserId(userId);
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student getById(Long id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public void create(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void update(Student student) {
        studentRepo.save(student);
    }
}
