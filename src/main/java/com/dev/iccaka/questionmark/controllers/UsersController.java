package com.dev.iccaka.questionmark.controllers;

import com.dev.iccaka.questionmark.entities.User;
import com.dev.iccaka.questionmark.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/listAll")
    public List<User> getUsers(){
        return usersRepository.findAll();
    }
}
