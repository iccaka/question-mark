package com.dev.iccaka.questionmark.repositories;

import com.dev.iccaka.questionmark.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
