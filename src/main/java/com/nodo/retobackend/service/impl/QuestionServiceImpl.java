package com.nodo.retobackend.service.impl;

import com.nodo.retobackend.repository.IQuestionRepository;
import com.nodo.retobackend.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    private IQuestionRepository questionRepository;
}


