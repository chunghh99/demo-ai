package com.example.apidiemdanh.repository;

import com.example.apidiemdanh.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
    List<Attendance> findByStudentId(Long studentId);
}
