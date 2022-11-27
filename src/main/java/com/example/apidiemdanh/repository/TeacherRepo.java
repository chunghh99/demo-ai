package com.example.apidiemdanh.repository;

import com.example.apidiemdanh.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {
}
