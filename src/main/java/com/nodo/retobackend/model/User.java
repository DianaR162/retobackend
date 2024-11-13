package com.nodo.retobackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
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
    @Column(nullable = false, unique = true)
    private String mail;
    @Column(nullable = false)
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return this.getMail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
