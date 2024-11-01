package com.nodo.retobackend.service;

import com.nodo.retobackend.dto.AnswerUserRequestDto;
import com.nodo.retobackend.dto.ResponseDto;

public interface IAnswerService {
    ResponseDto<Boolean> save(AnswerUserRequestDto payload);
}
