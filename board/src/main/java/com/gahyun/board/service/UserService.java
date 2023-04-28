package com.gahyun.board.service;

import org.springframework.http.ResponseEntity;

import com.gahyun.board.dto.request.user.PostUserRequestDto;
import com.gahyun.board.dto.response.ResponseDto;

public interface UserService {
    
    public ResponseEntity<ResponseDto> postUser(PostUserRequestDto dto);

}
