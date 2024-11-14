package com.nodo.retobackend.mapper;

import com.nodo.retobackend.dto.user.UserRequestDto;
import com.nodo.retobackend.dto.user.UserResponseDto;
import com.nodo.retobackend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "token", ignore = true)
    UserResponseDto userToUserResponseDto(User user);

    User userRequestDtoToUser(UserRequestDto userRequestDto);
}
