package com.nodo.retobackend.service;

import com.nodo.retobackend.dto.AnswerRequestDto;
import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.exception.CoreException;

import java.util.List;

public interface IAnswerService {
    ResponseDto<Boolean> save(List<AnswerRequestDto> payload) throws CoreException;
}
