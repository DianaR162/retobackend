package com.nodo.retobackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 40, nullable = false, name = "last_name")
    private String lastName;
    @Column(nullable = false, name = "person_type")
    private String personType;
    @Column(nullable = false, name = "document_type")
    private String documentType;
    @Id
    @Column(length = 15, nullable = false, name = "document_number")
    private String documentNumber;
    @Column(nullable = false, name = "company_name")
    private String companyName;
    @Column(nullable = false)
    private String sector;
    @Column(name = "other_sector")
    private String otherSector;
    @Column(nullable = false)
    private String mail;
    @Column(nullable = false)
    private String password;
}
