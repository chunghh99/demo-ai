package com.example.apidiemdanh.service;

import com.example.apidiemdanh.entity.Teacher;
import com.example.apidiemdanh.repository.TeacherRepo;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepo teacherRepo;


    @Override
    public List<Teacher> getAll() {
        return teacherRepo.findAll();
    }

    @Override
    public void create(Teacher teacher) {
        teacherRepo.save(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        teacherRepo.save(teacher);
    }

    @Override
    public Teacher findById(Long teacherId) {
        Optional<Teacher> teacher = teacherRepo.findById(teacherId);
        if(teacher.isPresent()){
            return teacher.get();
        }
        return null;
    }
}
