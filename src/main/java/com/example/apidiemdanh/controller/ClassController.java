package com.example.apidiemdanh.controller;

import com.example.apidiemdanh.entity.ClassEntity;
import com.example.apidiemdanh.entity.Teacher;
import com.example.apidiemdanh.service.ClassService;
import com.example.apidiemdanh.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("class")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        List<ClassEntity> teachers = classService.getAll();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @PutMapping("/create")
    public ResponseEntity<?> create(@RequestBody ClassEntity classEntity){

        try {
            classService.create(classEntity);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>("Thêm tạch!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Thành công", HttpStatus.OK);
    }
}
