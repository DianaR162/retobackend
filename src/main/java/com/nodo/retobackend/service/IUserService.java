package com.nodo.retobackend.service;

import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.dto.UserRequestDto;

public interface IUserService {
    ResponseDto<Boolean> register(UserRequestDto payload);
}
