package com.example.apidiemdanh.service;

import com.example.apidiemdanh.entity.Attendance;
import com.example.apidiemdanh.repository.AttendanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService{

    @Autowired
    private AttendanceRepo attendanceRepo;

    @Override
    public List<Attendance> getAll() {
        return attendanceRepo.findAll();
    }

    @Override
    public List<Attendance> getByStudentId(Long studentId) {
        return attendanceRepo.findByStudentId(studentId);
    }

    @Override
    public List<Attendance> getByTime(Date startTime, Date endTime) {
        return null;
    }

    @Override
    public void create(Attendance attendance) {
        attendanceRepo.save(attendance);
    }

    @Override
    public void update(Attendance attendance) {
    if(attendance.getAttendanceId() != null){
        attendanceRepo.save(attendance);
    }
    }
}
