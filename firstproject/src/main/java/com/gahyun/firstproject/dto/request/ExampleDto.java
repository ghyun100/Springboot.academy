package com.gahyun.firstproject.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Data
public class ExampleDto {
    @NotNull
    private String parameter1;
    @Length(min = 0, max = 20)
    private String parameter2;
    private String parameter3;


}
