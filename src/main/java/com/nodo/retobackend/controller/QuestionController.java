package com.nodo.retobackend.controller;

import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.model.Question;
import com.nodo.retobackend.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final IQuestionService questionService;

    // Inyección de dependencias por constructor
    @Autowired
    public QuestionController(IQuestionService questionService) {
        this.questionService = questionService;
    }

    // Endpoint para obtener todas las preguntas
    @GetMapping
    public ResponseEntity<ResponseDto<List<Question>>> getAllQuestions() {
        ResponseDto<List<Question>> response = questionService.getAllQuestions();
        return ResponseEntity.ok(response);
    }
}
