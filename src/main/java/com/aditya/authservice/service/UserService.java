package com.aditya.authservice.service;

import com.aditya.authservice.common.annotation.LogEntryExit;
import com.aditya.authservice.model.Users;
import com.aditya.authservice.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UsersRepository userRepository;
    @LogEntryExit
    public Users createUserWithPassword(RegisterRequest registerRequest) {
        Optional<User> user = userRepository.findByEmail(registerRequest.getEmail());

        if (user.isPresent() && Boolean.TRUE.equals(user.get().getAppRegistration())) {
            logger.error("You are already registered on app");
            throw new EntityFoundException("You are already registered on app");
        }

        if (user.isPresent() && user.get().getPassword() != null) {
            logger.error("You have already signed up");
            throw new BadRequestException("You have already signed up");
        }
        if (!user.isPresent()) {
            user = Optional.of(new User());
        }

        Users newUser = user.get();
        newUser.setEmail(registerRequest.getEmail());
        newUser.setUsername(registerRequest.getEmail());
        boolean isReferralValid = false;
        if(StringUtils.isNotBlank(registerRequest.getStudentReferralId())){
            isReferralValid = studentIpcService.checkIfReferralIdValid(registerRequest.getStudentReferralId());
        }
        newUser.setReferred(isReferralValid);
        passwordService.setPassword(newUser, registerRequest.getPassword());
        RoleType roleType = registerRequest.getRole() == null ? null : RoleType.valueOf(registerRequest.getRole());
        UserRole userRole = new UserRole(roleType, newUser);
        newUser.setUserRoles(Collections.singletonList(userRole));
        newUser = userRepository.save(newUser);
        if(isReferralValid){
            createStudentReferee(registerRequest.getEmail(), registerRequest.getStudentReferralId(), newUser);
        }
        return newUser;
    }
}
