package com.example.apidiemdanh.repository;

import com.example.apidiemdanh.entity.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentClassRepo extends JpaRepository<StudentClass, Long> {
}
