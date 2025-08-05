package com.aditya.authservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Privileges extends Auditable {
    @Id
    private String name;
    private String description;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "privilege")
    private List<ApiPrivileges> apiPrivileges;
    @JsonIgnoreProperties("privileges")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userGroup", referencedColumnName = "name")
    private UserGroups userGroup;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userId", referencedColumnName = "userId")
//    private Users user;
}
