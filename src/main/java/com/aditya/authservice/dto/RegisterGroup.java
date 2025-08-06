package com.aditya.authservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class RegisterGroup {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotEmpty
    private List<String> privileges;
}
