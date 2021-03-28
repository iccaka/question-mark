package com.dev.iccaka.questionmark.controllers;

import com.dev.iccaka.questionmark.entities.User;
import com.dev.iccaka.questionmark.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UserService userService;

    @GetMapping("/listAll")
    public List<User> listUsers(){
        return userService.listUsers();
    }
}
