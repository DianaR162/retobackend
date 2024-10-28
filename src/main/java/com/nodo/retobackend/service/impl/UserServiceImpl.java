package com.nodo.retobackend.service.impl;

import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.dto.UserRequestDto;
import com.nodo.retobackend.model.User;
import com.nodo.retobackend.repository.IUserRepository;
import com.nodo.retobackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nodo.retobackend.mapper.UserMapper;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository _userRepository;

    @Override
    public ResponseDto<Boolean> register(UserRequestDto payload) {
        Optional<User> existingUser = _userRepository.findByMail(payload.getMail());
        if (existingUser.isPresent()) {
            return new ResponseDto<>(400, "Email already registered", false);
        }

        User user = UserMapper.INSTANCE.toUser(payload);

        _userRepository.save(user);

        return new ResponseDto<>(201, "User registered successfully", true);
    }
}

