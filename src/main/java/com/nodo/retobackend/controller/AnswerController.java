package com.nodo.retobackend.controller;

import com.nodo.retobackend.dto.AnswerUserRequestDto;
import com.nodo.retobackend.dto.ResponseDto;
import com.nodo.retobackend.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private IAnswerService answerService;

    @PostMapping
    public ResponseDto<Boolean> save(@RequestBody AnswerUserRequestDto payload) {
        return answerService.save(payload);
    }
}
