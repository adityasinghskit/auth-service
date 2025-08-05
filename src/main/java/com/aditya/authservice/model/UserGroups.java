package com.aditya.authservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class UserGroups extends Auditable {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(length = 50)
    private String id;
    @Column(unique = true)
    private String name;
    private String description;
    @JsonIgnoreProperties("userGroup")
    @OneToMany(mappedBy = "userGroup", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Privileges> privileges;
}
