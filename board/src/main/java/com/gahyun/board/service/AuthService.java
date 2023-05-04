package com.gahyun.board.service;

import org.springframework.http.ResponseEntity;

import com.gahyun.board.dto.request.auth.SignInRequestDto;
import com.gahyun.board.dto.request.auth.SignUpRequestDto;
import com.gahyun.board.dto.response.ResponseDto;
import com.gahyun.board.dto.response.auth.SignInResponseDto;

public interface AuthService {
    public ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto);
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto); 
}
