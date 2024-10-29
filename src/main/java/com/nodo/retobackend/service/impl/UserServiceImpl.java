package com.nodo.retobackend.service.impl;

import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.dto.user.UserAuthenticationDto;
import com.nodo.retobackend.dto.user.UserRequestDto;
import com.nodo.retobackend.dto.user.UserResponseDto;
import com.nodo.retobackend.exception.CoreException;
import com.nodo.retobackend.mapper.UserMapper;
import com.nodo.retobackend.model.User;
import com.nodo.retobackend.repository.IUserRepository;
import com.nodo.retobackend.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseDto<UserResponseDto> findUserByMailAndPassword(UserAuthenticationDto userAuthenticationDto) throws CoreException {
        log.info("Ingresando al método UserServiceImpl.findUserByMailAndPassword");

        User user = userRepository.findByMailAndPassword(userAuthenticationDto.getMail(), userAuthenticationDto.getPassword())
                .orElseThrow(() ->
                        new CoreException("No se encontró el usuario.", HttpStatus.UNAUTHORIZED.value()));

        log.info("Finalizando el método UserServiceImpl.findUserByMailAndPassword");

        return ResponseDto.<UserResponseDto>builder()
                .status(HttpStatus.OK.value())
                .data(userMapper.userToUserResponseDto(user))
                .build();
    }

    @Override
    public ResponseDto<Boolean> register(UserRequestDto payload) throws CoreException {
        if (!payload.getPassword().equals(payload.getPasswordConfirm())) {
            throw new CoreException("Las contraseñas no coinciden", HttpStatus.BAD_REQUEST.value());
        }

        if (userRepository.findByMail(payload.getMail()).isPresent()) {
            throw new CoreException("Usuario ya existente", HttpStatus.BAD_REQUEST.value());
        }

        userRepository.save(userMapper.userRequestDtoToUser(payload));

        return ResponseDto.<Boolean>builder()
                .status(HttpStatus.CREATED.value())
                .message("Usuario creado con éxito")
                .data(true)
                .build();
    }
}

