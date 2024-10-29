package com.nodo.retobackend.service;

import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.dto.user.UserRequestDto;

public interface IUserService {
    ResponseDto<Boolean> register(UserRequestDto payload);
}
