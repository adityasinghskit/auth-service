package com.aditya.authservice.repository;

import com.aditya.authservice.model.Privileges;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegesRepository extends JpaRepository<Privileges, String> {

    Privileges findByName(String name);
}
