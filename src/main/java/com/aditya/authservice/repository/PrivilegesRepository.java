package com.aditya.authservice.repository;

import com.aditya.authservice.model.Privileges;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PrivilegesRepository extends JpaRepository<Privileges, String> {

    Optional<Privileges> findByName(String name);
    List<Privileges> findByNameIn(List<String> names);
}
