package com.example.apidiemdanh.service;

import com.example.apidiemdanh.entity.Student;
import com.example.apidiemdanh.entity.User;
import com.example.apidiemdanh.repository.StudentRepo;
import com.example.apidiemdanh.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public User getByUserNameAndPassWord(String userName, String password) {

        return userRepo.findByUsernameAndPassword(userName, password);
//            return null;
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
//        return null;

    }

    @Override
    public User getByUserName(String userName) {
        return userRepo.findByUsername(userName);
    }

    @Override
    public void create(User user) {
            userRepo.save(user);
            Student student = new Student();
            student.setUserId(user.getUserId());
            studentRepo.save(student);
    }

    @Override
    public void update(User user) {
            userRepo.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepo.findById(id).get();
    }
}
