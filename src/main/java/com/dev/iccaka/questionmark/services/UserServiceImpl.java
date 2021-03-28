package com.dev.iccaka.questionmark.services;

import com.dev.iccaka.questionmark.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class UserServiceImpl implements UserService{

    private JpaRepository<User, Long> repository;

    public UserServiceImpl(JpaRepository<User, Long> repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getUsers() {
        return this.repository.findAll();
    }
}
