package com.dev.iccaka.questionmark.controllers;

import com.dev.iccaka.questionmark.dtos.UserRegisterDto;
import com.dev.iccaka.questionmark.entities.User;
import com.dev.iccaka.questionmark.exceptions.UserAlreadyExistsException;
import com.dev.iccaka.questionmark.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/users")
public class UsersController {

    ModelAndView modelAndView;

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public List<User> listUsers() {
        return userService.listUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable Long id){
        if(id <= 0){
            return ResponseEntity.badRequest().body("IDs cannot be negative or equal to zero!");
        }

        Optional<User> result = userService.getById(id);

        return result.isPresent() ? ResponseEntity.ok(result) : ResponseEntity.badRequest().body("User with such ID not found!");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getByUsername(@RequestParam(value = "username") String username){
        if(username.isBlank() || username == null){
            return ResponseEntity.badRequest().body("You haven't entered anything to search for!");
        }

        Optional<User> result = userService.getByUsername(username.toLowerCase());
        return result.isPresent() ? ResponseEntity.ok(result) : ResponseEntity.ok("There's no user with such username.");
    }

    @RequestMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@Valid UserRegisterDto userRegisterDto) {
        try {
            User registered = userService.registerUser(userRegisterDto);
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok("Registration successful!");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();

            errors.put(fieldName, errorMessage);
        });

        return errors;
    }
}
