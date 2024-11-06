package com.nodo.retobackend.service.impl;

import com.nodo.retobackend.dto.AnswerUserRequestDto;
import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.model.*;
import com.nodo.retobackend.repository.IAnswerRepository;
import com.nodo.retobackend.repository.IQuestionOptionRepository;
import com.nodo.retobackend.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements IAnswerService {
    @Autowired
    private IQuestionOptionRepository questionOptionRepository;
    @Autowired
    private IAnswerRepository answerRepository;

    @Override
    public ResponseDto<Boolean> save(AnswerUserRequestDto payload) {
        User user = User.builder()
                .documentNumber(payload.getDocumentNumber())
                .build();

        payload.getAnswers().forEach(answerRequest -> {
            Question question = Question.builder()
                    .id(answerRequest.getIdQuestion())
                    .build();

            Option option = Option.builder()
                    .id(answerRequest.getIdOption())
                    .build();

            QuestionOption questionOption = questionOptionRepository.findByQuestionAndOption(question, option).get();

            Answer answerToSave = Answer.builder()
                    .user(user)
                    .questionOption(questionOption)
                    .build();

            answerRepository.save(answerToSave);
        });

        return ResponseDto.<Boolean>builder()
                .data(true)
                .status(HttpStatus.CREATED.value())
                .message("Respuestas guardadas con éxito")
                .build();
    }
}
