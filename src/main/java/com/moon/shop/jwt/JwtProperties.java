package com.moon.shop.jwt;

public interface JwtProperties {
    String SECRET = "cos"; //서버 비밀 키
    int EXPIRATION_TIME = 60000*30000; //Token 요휴시간 10분
    String TOKEN_PREFIX="Bearer ";
    String HEADER_STRING = "Authorization";
}
