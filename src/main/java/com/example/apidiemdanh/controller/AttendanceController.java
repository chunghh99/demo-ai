package com.example.apidiemdanh.controller;

import com.example.apidiemdanh.entity.Attendance;
import com.example.apidiemdanh.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<Attendance> attendances = attendanceService.getAll();
        return new ResponseEntity<>(attendances, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Attendance attendance) {

        try {
            attendanceService.create(attendance);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity<>("Thêm tạch!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Thành công", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Attendance attendance) {

        try {
            attendanceService.update(attendance);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity<>("Sửa tạch!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Thành công", HttpStatus.OK);
    }

    @GetMapping("/getByStudent/{studentId}")
    public ResponseEntity<?> getByStudentId(@PathVariable(name = "studentId") Long studentId) {
        List<Attendance> attendances = attendanceService.getByStudentId(studentId);
        return new ResponseEntity<>(attendances, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id) {
       Attendance attendances = attendanceService.getById(id);
        return new ResponseEntity<>(attendances, HttpStatus.OK);
    }

}
