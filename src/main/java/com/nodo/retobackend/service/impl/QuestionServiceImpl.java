package com.nodo.retobackend.service.impl;

import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.model.Question;
import com.nodo.retobackend.repository.IQuestionRepository;
import com.nodo.retobackend.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements IQuestionService {

    private final IQuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(IQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public ResponseDto<List<Question>> getAllQuestions() {
        List<Question> questions = questionRepository.findAll();

        return new ResponseDto<>("Success", questions);
    }
}


