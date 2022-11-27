package com.example.apidiemdanh.service;

import com.example.apidiemdanh.entity.ClassEntity;
import com.example.apidiemdanh.entity.Teacher;
import com.example.apidiemdanh.repository.ClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpl implements ClassService{


    @Autowired
    private ClassRepo classRepo;

    @Override
    public List<ClassEntity> getAll() {
        return classRepo.findAll();
    }

    @Override
    public void create(ClassEntity classEntity) {
        classRepo.save(classEntity);
    }

    @Override
    public ClassEntity findById(Long classId) {
        Optional<ClassEntity> classEntity = classRepo.findById(classId);
        if(classEntity.isPresent()){
            return classEntity.get();
        }
        return null;
    }
}
