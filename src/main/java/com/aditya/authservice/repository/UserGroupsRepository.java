package com.aditya.authservice.repository;

import com.aditya.authservice.model.UserGroups;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserGroupsRepository extends JpaRepository<UserGroups, String> {
    Optional<UserGroups> findByName(String name);
}
