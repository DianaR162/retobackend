package com.nodo.retobackend.controller;

import com.nodo.retobackend.dto.AnswerUserRequestDto;
import com.nodo.retobackend.dto.ResponseDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/answer")
public class AnswerController {
    public ResponseDto<Boolean> save(@RequestBody AnswerUserRequestDto payload) {

    }

}
