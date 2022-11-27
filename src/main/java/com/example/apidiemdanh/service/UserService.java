package com.example.apidiemdanh.service;

import com.example.apidiemdanh.entity.User;

import java.util.List;

public interface UserService {

    public User getByUserNameAndPassWord(String userName, String password);
    public User getByUserName(String userName);

    public List<User> getAll();
    void create(User user);

}
