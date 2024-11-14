package com.nodo.retobackend.service.impl;

import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.dto.user.UserAuthenticationDto;
import com.nodo.retobackend.dto.user.UserRequestDto;
import com.nodo.retobackend.dto.user.UserResponseDto;
import com.nodo.retobackend.exception.CoreException;
import com.nodo.retobackend.mapper.UserMapper;
import com.nodo.retobackend.model.User;
import com.nodo.retobackend.repository.IUserRepository;
import com.nodo.retobackend.service.IJwtService;
import com.nodo.retobackend.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IJwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseDto<UserResponseDto> findUserByMailAndPassword(UserAuthenticationDto userAuthenticationDto) throws CoreException {
        log.info("Ingresando al método UserServiceImpl.findUserByMailAndPassword");

        User user = userRepository.findByMail(userAuthenticationDto.getMail())
                .orElseThrow(() ->
                        new CoreException("No se encontró el usuario.", HttpStatus.UNAUTHORIZED.value()));

        if (!passwordEncoder.matches(userAuthenticationDto.getPassword(), user.getPassword())) {
            throw new CoreException("Contraseña incorrecta.", HttpStatus.UNAUTHORIZED.value());
        }

        String token = jwtService.generateToken(user);

        UserResponseDto userResponseDto = userMapper.userToUserResponseDto(user);
        userResponseDto.setToken(token);

        log.info("Finalizando el método UserServiceImpl.findUserByMailAndPassword");

        return ResponseDto.<UserResponseDto>builder()
                .status(HttpStatus.OK.value())
                .data(userResponseDto)
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

        User user = userMapper.userRequestDtoToUser(payload);
        user.setPassword(passwordEncoder.encode(payload.getPassword()));

        userRepository.save(user);

        return ResponseDto.<Boolean>builder()
                .status(HttpStatus.CREATED.value())
                .message("Usuario creado con éxito")
                .data(true)
                .build();
    }
}

