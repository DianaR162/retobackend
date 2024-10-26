package com.nodo.retobackend.service;

import com.nodo.retobackend.dto.user.UserAuthenticationDto;
import com.nodo.retobackend.exception.CoreException;
import com.nodo.retobackend.model.User;

public interface IUserService {
    User findUserByMailAndPassword(UserAuthenticationDto userAuthenticationDto) throws CoreException;
}
