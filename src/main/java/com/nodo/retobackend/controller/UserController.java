package com.nodo.retobackend.controller;

import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.dto.user.UserAuthenticationDto;
import com.nodo.retobackend.dto.user.UserRequestDto;
import com.nodo.retobackend.dto.user.UserResponseDto;
import com.nodo.retobackend.exception.CoreException;
import com.nodo.retobackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private IUserService userService;

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
