package com.nodo.retobackend.mapper;

import com.nodo.retobackend.dto.user.UserResponseDto;
import com.nodo.retobackend.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDto userToUserResponseDto(User user);
}
