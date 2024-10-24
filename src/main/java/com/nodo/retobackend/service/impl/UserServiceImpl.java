package com.nodo.retobackend.service.impl;

import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.dto.UserRequestDto;
import com.nodo.retobackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Override
    public ResponseDto<Boolean> register(UserRequestDto payload) {
        return null;
    }
}
