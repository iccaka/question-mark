package com.dev.iccaka.questionmark.services;

import com.dev.iccaka.questionmark.dtos.UserRegisterDto;
import com.dev.iccaka.questionmark.entities.User;
import com.dev.iccaka.questionmark.exceptions.UserAlreadyExistsException;
import com.dev.iccaka.questionmark.repositories.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UsersRepository repository;

    public UserService(UsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> listUsers() {
        return this.repository.findAll();
    }

    @Override
    public Optional<User> getById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return  this.repository.getByUsername(username);
    }

    @Override
    public User registerUser(UserRegisterDto userRegisterDto) throws UserAlreadyExistsException {
        if (this.emailExist(userRegisterDto.getEmail())) {
            throw new UserAlreadyExistsException("There's an account with that email address: " + userRegisterDto.getEmail());
        }
        if(this.usernameExist(userRegisterDto.getUsername())){
            throw new UserAlreadyExistsException("There's an account with that username: " + userRegisterDto.getUsername());
        }

        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userRegisterDto, User.class);

        return this.repository.save(user);
    }

    private boolean emailExist(String email) {
        return this.repository.findByEmail(email).isPresent();
    }

    private boolean usernameExist(String username){
        return this.repository.findByUsername(username).isPresent();
    }
}
