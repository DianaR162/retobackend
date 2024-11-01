package com.nodo.retobackend.service.impl;

import com.nodo.retobackend.dto.AnswerUserRequestDto;
import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.model.Option;
import com.nodo.retobackend.model.Question;
import com.nodo.retobackend.repository.*;
import com.nodo.retobackend.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements IAnswerService {
    @Autowired
    private IQuestionOptionRepository questionOptionRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IAnswerRepository answerRepository;

    @Override
    public ResponseDto<Boolean> save(AnswerUserRequestDto payload) {

        return null;
    }
}
