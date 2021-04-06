package com.dev.iccaka.questionmark.controllers;

import com.dev.iccaka.questionmark.dtos.UserDto;
import com.dev.iccaka.questionmark.entities.User;
import com.dev.iccaka.questionmark.exceptions.UserAlreadyExistsException;
import com.dev.iccaka.questionmark.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UsersController {

    ModelAndView modelAndView;

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
    public ModelAndView registerUser(@ModelAttribute("user") @Validated UserDto userDto,
                                          HttpServletRequest request, Errors errors){

        try{
            User registered = userService.registerUser(userDto);
        }
        catch (UserAlreadyExistsException uaeEx){
            modelAndView.addObject("message", "An account for that username/email already exists!")
            return modelAndView;
        }

        return ResponseEntity.ok("");
    }
}
