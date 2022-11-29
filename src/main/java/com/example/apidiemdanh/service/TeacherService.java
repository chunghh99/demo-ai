package com.example.apidiemdanh.service;

import com.example.apidiemdanh.entity.Teacher;

import java.util.List;

public interface TeacherService {
List<Teacher> getAll();
void create(Teacher teacher);
void update(Teacher teacher);
Teacher findById(Long teacherId);
}
