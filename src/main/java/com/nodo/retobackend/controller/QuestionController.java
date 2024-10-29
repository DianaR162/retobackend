package com.nodo.retobackend.controller;

import com.nodo.retobackend.dto.QuestionResponseDto;
import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.service.IQuestionOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "*")
public class QuestionController {

    @Autowired
    private IQuestionOptionService questionOptionService;

    @GetMapping("/all")
    public ResponseDto<List<QuestionResponseDto>> getAll() {
        return questionOptionService.getAll();
    }
}
