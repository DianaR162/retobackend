package com.nodo.retobackend.service;

import com.nodo.retobackend.dto.QuestionResponseDto;
import com.nodo.retobackend.dto.ResponseDto;

import java.util.List;

public interface IQuestionOptionService {
    ResponseDto<List<QuestionResponseDto>> getAll();
}
