package com.nodo.retobackend.mapper;

import com.nodo.retobackend.dto.UserRequestDto;
import com.nodo.retobackend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserRequestDto userRequestDto);
}