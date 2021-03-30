package com.dev.iccaka.questionmark.services;

import com.dev.iccaka.questionmark.entities.User;
import java.util.List;
import java.util.Optional;


public interface UserService {

    List<User> listUsers();

    Optional<User> findById(Long id);
}
