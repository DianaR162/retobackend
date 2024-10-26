package com.nodo.retobackend.exception;

import com.nodo.retobackend.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Throwable.class)
    protected ResponseEntity<ResponseDto<Void>> handleException(Throwable ex) {
        log.error("GlobalExceptionHandler.handleException: Error inesperado.", ex);
        ResponseDto<Void> response = new ResponseDto<>();
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(response);
    }

    @ExceptionHandler(CoreException.class)
    protected ResponseEntity<ResponseDto<Void>> handleCoreException(CoreException ex) {
        log.error("GlobalExceptionHandler.handleCoreException: {}", ex.getMessage(), ex);
        ResponseDto<Void> responseDto = new ResponseDto<>();
        responseDto.setStatus(ex.getStatus());
        responseDto.setMessage(ex.getUserMessage());
        return ResponseEntity.status(ex.getStatus()).body(responseDto);
    }
}
