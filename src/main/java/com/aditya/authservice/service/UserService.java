package com.aditya.authservice.service;

import com.aditya.authservice.common.annotation.LogEntryExit;
import com.aditya.authservice.common.error.BadRequestException;
import com.aditya.authservice.dto.RegisterGroup;
import com.aditya.authservice.dto.RegisterPrivilege;
import com.aditya.authservice.dto.RegisterRequest;
import com.aditya.authservice.model.Privileges;
import com.aditya.authservice.model.UserGroups;
import com.aditya.authservice.model.Users;
import com.aditya.authservice.repository.PrivilegesRepository;
import com.aditya.authservice.repository.UserGroupsRepository;
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
//    private final PasswordEncoder passwordEncoder;
    private final PrivilegesRepository privilegesRepository;
    private final UserGroupsRepository userGroupsRepository;

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
        newUser.setPassword(registerRequest.getPassword());
        newUser.setPrivilege(List.of(getPrivilegeByName("CONSOLE_ACCESS")));
        newUser = userRepository.save(newUser);
        return newUser;
    }

    public Privileges getPrivilegeByName(String privilegeName) {
        return privilegesRepository.findByName(privilegeName)
                .orElseThrow(() -> new BadRequestException("Privilege not found: " + privilegeName));
    }

    public void createUserGroup(RegisterGroup registerGroup){
        UserGroups userGroup;
        if(userGroupsRepository.findByName(registerGroup.getName()).isPresent()){
            userGroup = userGroupsRepository.findByName(registerGroup.getName()).get();
        }else{
            userGroup = new UserGroups();
        }
        userGroup.setName(registerGroup.getName());
        userGroup.setDescription(registerGroup.getDescription());
        userGroup.setPrivileges(privilegesRepository.findByNameIn(registerGroup.getPrivileges()));
        userGroupsRepository.save(userGroup);
    }

    public void createPrivilege(RegisterPrivilege registerPrivilege){
        if(privilegesRepository.findByName(registerPrivilege.getName()).isPresent()){
            throw new BadRequestException("Privilege already exists: " + registerPrivilege.getName());
        }
        Privileges privileges = new Privileges();
        privileges.setName(registerPrivilege.getName());
        privileges.setDescription(registerPrivilege.getDescription());
        privilegesRepository.save(privileges);
    }

    private List<Privileges> getPrivilegesByNames(List<String> privilegeNames) {
        return privilegesRepository.findAllById(privilegeNames);
    }
}
