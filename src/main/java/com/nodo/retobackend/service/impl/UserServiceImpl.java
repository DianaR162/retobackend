package com.nodo.retobackend.service.impl;

import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.dto.user.UserRequestDto;
import com.nodo.retobackend.mapper.UserMapper;
import com.nodo.retobackend.repository.IUserRepository;
import com.nodo.retobackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseDto<Boolean> register(UserRequestDto payload) {
        if (!payload.getPassword().equals(payload.getPasswordConfirm())) return null;

        if (userRepository.findByMail(payload.getMail()).isPresent()) return null;

        userRepository.save(userMapper.userRequestDtoToUser(payload));

        return ResponseDto.<Boolean>builder()
                .status(HttpStatus.CREATED.value())
                .message("Usuario creado con éxito")
                .data(true)
                .build();
    }
}

