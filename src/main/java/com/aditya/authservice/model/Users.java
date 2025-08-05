package com.aditya.authservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_privileges",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_name")
    )
    @NotEmpty(message = "Privileges cannot be empty")
    private List<Privileges> privilege;
}
