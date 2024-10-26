package com.nodo.retobackend.controller;

import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.dto.user.UserAuthenticationDto;
import com.nodo.retobackend.exception.CoreException;
import com.nodo.retobackend.model.User;
import com.nodo.retobackend.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(name = "User Api", description = "Servicios para la gestión de usuarios.")
public class UserController {
    private final IUserService iUserService;

    @Operation(summary = "Consulta la existencia de un usuario por correo y contraseña.",
            description = "Consulta la existencia de un usuario por correo y contraseña.")
    @PostMapping(value = "/login")
    public ResponseDto<Object> findUserByMailAndPassword(
            @RequestBody UserAuthenticationDto userAuthenticationDto
    ) throws CoreException {
        User user = iUserService.findUserByMailAndPassword(userAuthenticationDto);

        return ResponseDto.builder().status(200).message("Se encontró el usuario.").data(user).build();
    }
}
