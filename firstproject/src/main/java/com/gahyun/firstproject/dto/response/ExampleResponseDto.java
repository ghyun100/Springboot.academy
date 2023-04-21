package com.gahyun.firstproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
@AllArgsConstructor

public class ExampleResponseDto {

    private String data1;
    private String data2;
    private String data3;
    
}
