package com.example.apidiemdanh.service;

import com.example.apidiemdanh.entity.Attendance;

import java.util.Date;
import java.util.List;

public interface AttendanceService {
    List<Attendance> getAll();
    List<Attendance> getByStudentId(Long studentId);
    Attendance getById(Long id);
    List<Attendance> getByTime(Date startTime, Date endTime);
    void create(Attendance attendance);
    void update(Attendance attendance);
}
