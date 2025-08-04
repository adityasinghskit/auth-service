package com.aditya.authservice.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Data
public class Users extends Auditable {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(length = 50)
    private String userId;
    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String password;

    private String latestJwt;

    private String mobile;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "userPrivilege")
    private List<Privileges> privilege;

}
