package com.nodo.retobackend.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private String name;
    private String lastName;
    private String personType;
    private String documentType;
    private String documentNumber;
    private String companyName;
    private String sector;
    private String otherSector;
    private String mail;
    private String password;
    private String passwordConfirm;
}
