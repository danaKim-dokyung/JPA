package com.moon.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


/*
* Api request 에 대한 response 코드*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto<T>{
    int status;
    T data;
}
