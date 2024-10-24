package com.nodo.retobackend.service.impl;

import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.dto.UserRequestDto;
import com.nodo.retobackend.model.User;
import com.nodo.retobackend.repository.UserRepository;
import com.nodo.retobackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;  // Para encriptar la contraseña

    @Override
    public ResponseDto<Boolean> register(UserRequestDto payload) {
        // 1. Validar si el correo ya está registrado
        Optional<User> existingUser = userRepository.findByMail(payload.getMail());
        if (existingUser.isPresent()) {
            return new ResponseDto<>(false, "Email already registered", false);
        }

        // 2. Crear el objeto User a partir de UserRequestDto
        User user = new User();
        user.setName(payload.getName());
        user.setLastName(payload.getLastName());
        user.setPersonType(payload.getPersonType());
        user.setDocumentType(payload.getDocumentType());
        user.setDocumentNumber(payload.getDocumentNumber());
        user.setCompanyName(payload.getCompanyName());
        user.setSector(payload.getSector());
        user.setOtherSector(payload.getOtherSector());
        user.setMail(payload.getMail());

        // 4. Guardar el usuario en la base de datos
        userRepository.save(user);

        // 5. Retornar una respuesta de éxito
        return new ResponseDto<>(true, "User registered successfully", true);
    }
}

