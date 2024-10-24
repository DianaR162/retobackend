package com.nodo.retobackend.controller;

import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.dto.UserRequestDto;
import com.nodo.retobackend.service.IUserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/user")
    public ResponseDto<Boolean> register(@RequestBody UserRequestDto payload) {
        return this.userService.register(payload);
    }
}
