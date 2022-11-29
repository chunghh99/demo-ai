package com.example.apidiemdanh.service;

import com.example.apidiemdanh.entity.ClassEntity;
import com.example.apidiemdanh.entity.Teacher;

import java.util.List;

public interface ClassService {
    List<ClassEntity> getAll();
    void create(ClassEntity classEntity);
    void update(ClassEntity classEntity);
    ClassEntity findById(Long classId);

}
