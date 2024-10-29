package com.nodo.retobackend.controller;

import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.dto.user.UserAuthenticationDto;
import com.nodo.retobackend.dto.user.UserRequestDto;
import com.nodo.retobackend.dto.user.UserResponseDto;
import com.nodo.retobackend.exception.CoreException;
import com.nodo.retobackend.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*")
@Tag(name = "User Api", description = "Servicios para la gestión de usuarios.")
public class UserController {
    @Autowired
    private IUserService userService;

    @Operation(summary = "Consulta la existencia de un usuario por correo y contraseña.",
            description = "Consulta la existencia de un usuario por correo y contraseña.")
    @PostMapping(value = "/login")
    public ResponseDto<UserResponseDto> findUserByMailAndPassword(
            @RequestBody UserAuthenticationDto userAuthenticationDto
    ) throws CoreException {
        return userService.findUserByMailAndPassword(userAuthenticationDto);
    }

    @PostMapping
    public ResponseEntity<ResponseDto<Boolean>> register(@RequestBody UserRequestDto payload) throws CoreException {
        return new ResponseEntity<>(userService.register(payload), HttpStatus.CREATED);
    }
}
