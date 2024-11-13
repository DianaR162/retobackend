package com.nodo.retobackend.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private String name;
    private String lastName;
    private String personType;
    private String documentType;
    private String documentNumber;
    private String companyName;
    private String sector;
    private String otherSector;
    private String mail;
    private String token;
}
