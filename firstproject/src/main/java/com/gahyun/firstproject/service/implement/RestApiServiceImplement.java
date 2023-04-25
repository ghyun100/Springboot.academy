package com.gahyun.firstproject.service.implement;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gahyun.firstproject.entity.ExampleEntity;
import com.gahyun.firstproject.repository.ExampleRepository;
import com.gahyun.firstproject.service.RestApiService;

@Service
public class RestApiServiceImplement implements RestApiService {
    
    private ExampleRepository exampleRepository;

    @Autowired
    public RestApiServiceImplement(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }
    
    public String postMethod() {// http://localhost:4040/api/post-method
        // 데이터 삽입 
        // 1. Entity 인스턴스 ( = 데이터베이스 테이블의 레코드 )생성
        ExampleEntity exampleEntity = 
            ExampleEntity.builder()
            .exampleColumn2("string1")
            .exampleColumn3(false)
            .build();

        // 2. Repository를 거쳐서 Entity 인스턴스를 저장
        exampleRepository.save(exampleEntity);

        return null;
    }

    public String getMethod() {// http://localhost:4040/api/get-method
        // 데이터 조회
        // 1. JpaRepository에 있는 findBy 메서드로 Entity 조회
        // ExampleEntity exampleEntity = exampleRepository.findById(1).get();
        ExampleEntity exampleEntity = exampleRepository.findByPk(1);

        return exampleEntity == null ? "null" : exampleEntity.toString();
    }

    public String patchMethod() {// http://localhost:4040/api/patch-method
        // 데이터 수정
        // 1. 특정 조건으로 Entity 조회(얘는 Patch)
        ExampleEntity exampleEntity = exampleRepository.findById(1).get();
        // 2. 데이터 수정
        exampleEntity.setExampleColumn2("string2");
        // 3.Entity 인스턴스 저장
        exampleRepository.save(exampleEntity);

        // 1. Entity 인스턴스 생성(얘는 Put - 전체를 바꾸는 것)
        ExampleEntity exampleEntity2 = 
            new ExampleEntity(2, "string3", true);
        // 2. Entity 인스턴스 저장
        exampleRepository.save(exampleEntity2);

        return null;
    }

    public String deleteMethod() {
        // 데이터 삭제
        // 1. JpaRepository에 있는 deleteBy 메서드로 Entity 삭제
        exampleRepository.deleteById(1);
        return null;
    }

}
