package com.dev.iccaka.questionmark.services;

import com.dev.iccaka.questionmark.dtos.UserDto;
import com.dev.iccaka.questionmark.entities.User;
import com.dev.iccaka.questionmark.exceptions.UserAlreadyExistsException;

import java.util.List;
import java.util.Optional;


public interface IUserService {

    List<User> listUsers();

    Optional<User> findById(Long id);

    User registerUser(UserDto userDto) throws UserAlreadyExistsException;
}
