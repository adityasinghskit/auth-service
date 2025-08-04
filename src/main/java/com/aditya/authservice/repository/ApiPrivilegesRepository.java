package com.aditya.authservice.repository;

import com.aditya.authservice.model.ApiPrivileges;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiPrivilegesRepository extends JpaRepository<ApiPrivileges, Integer> {
}
