package com.gahyun.firstproject.service.implement;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gahyun.firstproject.service.RestApiService;

@Service
public class RestApiServiceImplement implements RestApiService {
    
    public String getMethod() {
        return "Return to Service Layer";
    }

}
