package com.example.apidiemdanh.controller;

import com.example.apidiemdanh.entity.ClassEntity;
import com.example.apidiemdanh.entity.Student;
import com.example.apidiemdanh.entity.User;
import com.example.apidiemdanh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        List<Student> listStudent = studentService.getAll();
        return new ResponseEntity<List<Student>>(listStudent, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Student student){

        try {
            studentService.create(student);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>("Thêm tạch!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Thành công", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Student student){

        try {
            studentService.update(student);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>("update tạch!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Thành công", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id) {
        Student student = studentService.getById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }



}
