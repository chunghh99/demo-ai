package com.example.apidiemdanh.controller;

import com.example.apidiemdanh.entity.Attendance;
import com.example.apidiemdanh.entity.Student;
import com.example.apidiemdanh.entity.User;
import com.example.apidiemdanh.service.StudentService;
import com.example.apidiemdanh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll(){
        List<User> listStudent = userService.getAll();
        return new ResponseEntity<List<User>>(listStudent, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        User userEntity = userService.getByUserNameAndPassWord(user.getUsername(), user.getPassword());
        if(userEntity == null ){
            return new ResponseEntity<>(userEntity, HttpStatus.BAD_REQUEST);
        }
        Student student = studentService.findByUserId(userEntity.getUserId());
        if(student == null ){
            return new ResponseEntity<>(student, HttpStatus.BAD_REQUEST);
        }
        student.setUserName(userEntity.getUsername());

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        User userEntity = userService.getByUserName(user.getUsername());
        if(userEntity != null ){
            return new ResponseEntity<>("Tên đăng nhập đã tồn tại!", HttpStatus.BAD_REQUEST);
        }
        try {
            userService.create(user);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>("Đăng ký thất bại!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Đăng ký thành công", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id) {
        User user = userService.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPass(@RequestBody User user){
        User userEntity = userService.getByUserName(user.getUsername());
        if(userEntity == null ){
            return new ResponseEntity<>("Tên đăng nhập khoong tồn tại!", HttpStatus.BAD_REQUEST);
        }
        try {
            userEntity.setPassword("123456");
            userService.update(userEntity);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>("quên pass thất bại!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("pass mới: 123456", HttpStatus.OK);
    }




}
