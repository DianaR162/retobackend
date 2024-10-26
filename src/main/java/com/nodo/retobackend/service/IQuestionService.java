package com.nodo.retobackend.service;

import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.model.Question;

import java.util.List;

public interface IQuestionService {
    ResponseDto<List<Question>> getAllQuestions();
}
