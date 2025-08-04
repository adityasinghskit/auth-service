package com.aditya.authservice.repository;

import com.aditya.authservice.model.UserGroups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupsRepository extends JpaRepository<UserGroups, String> {
}
