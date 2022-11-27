package com.example.apidiemdanh.repository;

import com.example.apidiemdanh.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    public User findByUsernameAndPassword(String username, String password);
    public User findByUsername(String username);
}
