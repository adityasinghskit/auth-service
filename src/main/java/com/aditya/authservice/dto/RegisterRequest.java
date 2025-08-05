package com.aditya.authservice.dto;

import com.aditya.authservice.common.annotation.EnumCheck;
import com.aditya.authservice.common.annotation.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import static com.aditya.authservice.common.regex.Regex.email_regex;

@Data
public class RegisterRequest {
    @NotEmpty
    @Email(regexp = email_regex, message = "enter valid email")
    private String email;
    @ValidPassword(message = "password not secure")
    @NotEmpty
    private String password;

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

}
