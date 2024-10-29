package com.nodo.retobackend.service;

import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.dto.user.UserAuthenticationDto;
import com.nodo.retobackend.dto.user.UserRequestDto;
import com.nodo.retobackend.dto.user.UserResponseDto;
import com.nodo.retobackend.exception.CoreException;

public interface IUserService {
    ResponseDto<UserResponseDto> findUserByMailAndPassword(UserAuthenticationDto userAuthenticationDto) throws CoreException;

    ResponseDto<Boolean> register(UserRequestDto payload) throws CoreException;
}
