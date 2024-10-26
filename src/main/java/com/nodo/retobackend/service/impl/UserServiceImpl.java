package com.nodo.retobackend.service.impl;

import com.nodo.retobackend.dto.user.UserAuthenticationDto;
import com.nodo.retobackend.exception.CoreException;
import com.nodo.retobackend.model.User;
import com.nodo.retobackend.repository.IUserRepository;
import com.nodo.retobackend.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final IUserRepository iUserRepository;

    @Override
    public User findUserByMailAndPassword(UserAuthenticationDto userAuthenticationDto) throws CoreException {
        log.info("Ingresando al método UserServiceImpl.findUserByMailAndPassword");

        Optional<User> user = iUserRepository.findByMailAndPassword(userAuthenticationDto.getMail(), userAuthenticationDto.getPassword());

        if (user.isEmpty()) {
            throw new CoreException("No se encontró el usuario.", HttpStatus.UNAUTHORIZED.value());
        }

        log.info("Finalizando el método UserServiceImpl.findUserByMailAndPassword");

        return user.get();
    }
}
