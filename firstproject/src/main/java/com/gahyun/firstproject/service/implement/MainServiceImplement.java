package com.gahyun.firstproject.service.implement;

import org.springframework.stereotype.Service;

import com.gahyun.firstproject.service.MainService;

@Service
public class MainServiceImplement implements MainService {
    
    @Override
    public String hello() {
        return "Hello";
    }


}
