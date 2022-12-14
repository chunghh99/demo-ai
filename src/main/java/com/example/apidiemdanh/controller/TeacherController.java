package com.example.apidiemdanh.controller;

import com.example.apidiemdanh.entity.Student;
import com.example.apidiemdanh.entity.Teacher;
import com.example.apidiemdanh.entity.User;
import com.example.apidiemdanh.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        List<Teacher> teachers = teacherService.getAll();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Teacher teacher){

        try {
            teacherService.create(teacher);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>("Thêm tạch!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Thành công", HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Teacher teacher){

        try {
            teacherService.update(teacher);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>("update tạch!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Thành công", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id) {
        Teacher teacher = teacherService.findById(id);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }
}
