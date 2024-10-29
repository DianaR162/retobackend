package com.nodo.retobackend.controller;

import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.dto.user.UserAuthenticationDto;
import com.nodo.retobackend.dto.user.UserResponseDto;
import com.nodo.retobackend.exception.CoreException;
import com.nodo.retobackend.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(name = "User Api", description = "Servicios para la gestión de usuarios.")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @Operation(summary = "Consulta la existencia de un usuario por correo y contraseña.",
            description = "Consulta la existencia de un usuario por correo y contraseña.")
    @PostMapping(value = "/login")
    public ResponseDto<UserResponseDto> findUserByMailAndPassword(
            @RequestBody UserAuthenticationDto userAuthenticationDto
    ) throws CoreException {
        return iUserService.findUserByMailAndPassword(userAuthenticationDto);
    }
}
