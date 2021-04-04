package com.dev.iccaka.questionmark.controllers;

import com.dev.iccaka.questionmark.entities.User;
import com.dev.iccaka.questionmark.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UsersController {

    @Autowired
    IUserService userService;

    @GetMapping("/listAll")
    public List<User> listUsers(){
        return userService.listUsers();
    }

    @GetMapping("/find/id")
    public ResponseEntity<?> findUserById(@RequestParam Long id){
        if(id <= 0){
            return ResponseEntity.badRequest().body("IDs cannot be negative or equal to zero!");
        }

        Optional<User> result = userService.findById(id);

        return result.isPresent() ? ResponseEntity.ok(result) : ResponseEntity.badRequest().body("User with such ID not found!");
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(){
        
    }
}
