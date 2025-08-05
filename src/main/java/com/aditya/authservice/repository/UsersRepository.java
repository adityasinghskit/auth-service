package com.aditya.authservice.repository;

import com.aditya.authservice.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, String> {
    Optional<Users> findByEmail(String email);
}
