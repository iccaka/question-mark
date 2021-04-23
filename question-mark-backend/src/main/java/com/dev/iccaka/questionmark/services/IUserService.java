package com.dev.iccaka.questionmark.services;

import com.dev.iccaka.questionmark.dtos.UserRegisterDto;
import com.dev.iccaka.questionmark.entities.User;
import com.dev.iccaka.questionmark.exceptions.UserAlreadyExistsException;

import java.util.List;
import java.util.Optional;


public interface IUserService {

    List<User> listUsers();

    Optional<User> getById(Long id);

    Optional<User> getByUsername(String username);

    User registerUser(UserRegisterDto userRegisterDto) throws UserAlreadyExistsException;
}
