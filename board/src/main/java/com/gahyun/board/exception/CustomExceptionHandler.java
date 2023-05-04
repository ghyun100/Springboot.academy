package com.gahyun.board.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gahyun.board.common.util.CustomResponse;
import com.gahyun.board.dto.response.ResponseDto;

@RestControllerAdvice
public class CustomExceptionHandler {
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDto> handlerHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        return CustomResponse.validationFaild();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return CustomResponse.validationFaild();
    }
    
}
