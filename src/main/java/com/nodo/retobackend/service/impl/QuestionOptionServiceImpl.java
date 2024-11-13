package com.nodo.retobackend.service.impl;

import com.nodo.retobackend.dto.QuestionResponseDto;
import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.model.Option;
import com.nodo.retobackend.model.QuestionOption;
import com.nodo.retobackend.repository.IQuestionOptionRepository;
import com.nodo.retobackend.service.IQuestionOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class QuestionOptionServiceImpl implements IQuestionOptionService {

    @Autowired
    private IQuestionOptionRepository questionOptionRepository;

    public ResponseDto<List<QuestionResponseDto>> getAll() {
        List<QuestionOption> questionOptions = questionOptionRepository.findAll();

        Map<Long, List<QuestionOption>> groupedByQuestion = questionOptions.stream()
                .collect(Collectors.groupingBy(qo -> qo.getQuestion().getId()));

        List<QuestionResponseDto> questionResponseDtos = groupedByQuestion.values().stream()
                .map(questionOptionList -> {
                    QuestionOption firstQuestionOption = questionOptionList.get(0);
                    List<Option> options = questionOptionList.stream()
                            .map(QuestionOption::getOption)
                            .collect(Collectors.toList());

                    return QuestionResponseDto.builder()
                            .id(firstQuestionOption.getQuestion().getId())
                            .section(firstQuestionOption.getQuestion().getSection())
                            .subsection(firstQuestionOption.getQuestion().getSubsection())
                            .question(firstQuestionOption.getQuestion().getQuestion())
                            .options(options)
                            .build();
                })
                .collect(Collectors.toList());

        return ResponseDto.<List<QuestionResponseDto>>builder()
                .status(HttpStatus.OK.value())
                .data(questionResponseDtos)
                .build();
    }
}
