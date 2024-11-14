package com.nodo.retobackend.service.impl;

import com.nodo.retobackend.dto.AnswerRequestDto;
import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.exception.CoreException;
import com.nodo.retobackend.model.*;
import com.nodo.retobackend.repository.IAnswerRepository;
import com.nodo.retobackend.repository.IQuestionOptionRepository;
import com.nodo.retobackend.repository.IUserRepository;
import com.nodo.retobackend.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AnswerServiceImpl implements IAnswerService {
    @Autowired
    private IQuestionOptionRepository questionOptionRepository;
    @Autowired
    private IAnswerRepository answerRepository;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public ResponseDto<Boolean> save(List<AnswerRequestDto> payload) throws CoreException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByMail(authentication.getName())
                .orElseThrow(() ->
                        new CoreException("Usuario no existente", HttpStatus.BAD_REQUEST.value()));

        payload.forEach(answerRequest -> {
            Answer answerExist = answerRepository.findByUserDocumentAndQuestionId(user.getDocumentNumber(), answerRequest.getIdQuestion()).orElse(null);
            Option option = Option.builder()
                    .id(answerRequest.getIdOption())
                    .build();

            if (Objects.nonNull(answerExist)) {
                QuestionOption questionOption = questionOptionRepository.findByQuestionAndOption(answerExist.getQuestionOption().getQuestion(), option).get();

                answerRepository.updateQuestionOption(questionOption, answerExist.getId());
            } else {
                Question question = Question.builder()
                        .id(answerRequest.getIdQuestion())
                        .build();

                QuestionOption questionOption = questionOptionRepository.findByQuestionAndOption(question, option).get();

                Answer answerToSave = Answer.builder()
                        .user(user)
                        .questionOption(questionOption)
                        .build();

                answerRepository.save(answerToSave);
            }
        });

        return ResponseDto.<Boolean>builder()
                .data(true)
                .status(HttpStatus.CREATED.value())
                .message("Respuestas guardadas con éxito")
                .build();
    }
}
