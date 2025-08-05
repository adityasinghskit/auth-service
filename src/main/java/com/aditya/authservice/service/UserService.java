package com.aditya.authservice.service;

import com.aditya.authservice.common.annotation.LogEntryExit;
import com.aditya.authservice.common.error.BadRequestException;
import com.aditya.authservice.dto.RegisterRequest;
import com.aditya.authservice.model.Privileges;
import com.aditya.authservice.model.Users;
import com.aditya.authservice.repository.PrivilegesRepository;
import com.aditya.authservice.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UsersRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PrivilegesRepository privilegesRepository;
    @LogEntryExit
    public Users createUserWithPassword(RegisterRequest registerRequest) {
        Optional<Users> user = userRepository.findByEmail(registerRequest.getEmail());
        if (user.isPresent() && user.get().getPassword() != null) {
            throw new BadRequestException("You have already signed up");
        }
        if (!user.isPresent()) {
            user = Optional.of(new Users());
        }
        Users newUser = user.get();
        newUser.setEmail(registerRequest.getEmail());
        newUser.setUsername(registerRequest.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        newUser.setPrivilege(List.of(getPrivilegeByName("CONSOLE_ACCESS")));
        newUser = userRepository.save(newUser);
        return newUser;
    }

    public Privileges getPrivilegeByName(String privilegeName) {
        return privilegesRepository.findByName(privilegeName)
                .orElseThrow(() -> new BadRequestException("Privilege not found: " + privilegeName));
    }
}
