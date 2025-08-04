package com.aditya.authservice.repository;

import com.aditya.authservice.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {
}
