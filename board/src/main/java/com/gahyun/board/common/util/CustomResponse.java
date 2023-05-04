package com.gahyun.board.common.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.gahyun.board.dto.response.ResponseDto;

public class CustomResponse {
    
    public static ResponseEntity<ResponseDto> success() {
        ResponseDto body = new ResponseDto("SU", "SUCCESS");
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    public static ResponseEntity<ResponseDto> databaseError() {
        
            ResponseDto errorBody = 
            new ResponseDto("DE", "Database Error");
            return ResponseEntity.status(HttpStatus.OK).body(errorBody);
    }  

    public static ResponseEntity<ResponseDto> validationFaild() {
        ResponseDto errorBody = new ResponseDto("VF", "Request Parameter Validation Failed");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }

    public static ResponseEntity<ResponseDto> exsitUserEmail() {
        ResponseDto errorBody = new ResponseDto("EU", "Existent User Email");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }

    public static ResponseEntity<ResponseDto> exsitUserNickname() {
        ResponseDto errorBody = new ResponseDto("EN", "Existent User Nickname");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }

    public static ResponseEntity<ResponseDto> exsitUserPhoneNumber() {
        ResponseDto errorBody = new ResponseDto("EP", "Existent User Phone Number");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }

    public static ResponseEntity<ResponseDto> notExsitBoardNumber() {
        ResponseDto errorBody = new ResponseDto("NB", "Non-Existent Board Number");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }
    
    public static ResponseEntity<ResponseDto> signInFailed() {
        ResponseDto errorBody = new ResponseDto("SF", "Sign In Failed");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
    }

    public static ResponseEntity<ResponseDto> notExsitUserEmail() {
        ResponseDto errorBody = new ResponseDto("NU", "Non-Existent User Email");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorBody);
    }// 인증불가

    public static ResponseEntity<ResponseDto> noPermissions() {
        ResponseDto errorBody = new ResponseDto("NP", "No Permissions");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorBody);
    }// 인가불가
}
