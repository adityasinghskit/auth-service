package com.aditya.authservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ApiPrivileges extends Auditable {
    @Id
    @Column(insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String moduleName;
    private String endpointName;
    private String uri;

    @ManyToOne
    @JoinColumn(name = "privilege")
    private Privileges privilege;

}
