# [Refactoring] 월하합작: 전국 8도 명주를 찾아서

<월하합작 - 전국 8도 명주를 찾아서> 리팩토링 프로젝트입니다.


1. 프로젝트 목적
    - HTTP API 아키텍쳐 기반으로 개발
    - Spring MVC 활용한 월하합작 프로젝트에서 프론트단과 백단을 분리
    - Spring Data JPA 를 사용, 기존 MyBatis 환경을 배제함
    - AWS, Linux instance로 배포 진행
    
2. 설계의 주안점
    - HTTP API 아키텍처 기반
    - 사용자 인증 방식은 JWT 기반의 Bearer 을 사용
     - JWT 토큰을 발급 받은 뒤 Authorizion 헤더로 인증정보를 보냄
    - JSON을 직렬화 포맷으로 사용
    - Spring Security 를 사용해 권한을 관리
    - Postman 을 활용한 API 테스트 진행
    - 기존 Mysql 환경에서 AWS RDS database로 전환

## 1. 기술스택



### 1) Backend

- Spring Boot
- Apache Tomcat
- Spring Security
- JWT

### 2) Database

- AWS RDS Database - MySQL 8.0.ver

### 3) Server

- AWS EC2 Linux instance
    - Ubuntu

# 2. ERD



![Untitled](https://user-images.githubusercontent.com/83184270/184529406-81a5c97a-db28-4516-ae07-bc5558c5cf30.png)

[https://www.erdcloud.com/d/2NLWyySrcZmB4g5LG](https://www.erdcloud.com/d/2NLWyySrcZmB4g5LG)

# 3. API 설계서



API 설계서 스프레드 시트 주소 첨부: 

설계

- HTTP API 설계 원칙을 따르게 함
- 반환타입은 JSON으로 통일
- JWT 기반의 Bearer 사용
- 토큰을 발급 받은 뒤 Authorizion 헤더로 인증정보를 보냄

# 4. Postman API Document


[https://documenter.getpostman.com/view/21589114/VUjSG49E](https://documenter.getpostman.com/view/21589114/VUjSG49E)

User 권한이 필요한 페이지 접근 방법 

- Join 진행 후 해당 ID, PW로 Login
- Login 성공 시 Header에 Authorization으로 인증정보 응답
- User 권한이 있는 사용자가 접근할 수 있는 페이지 API 실행 시 Authorization을 Key, 발급받은 토큰을 value 로 Header에 넣어 보냄

# 5. 추가 정보


Refactoring 대상이 된 Spring MVC 프로젝트에 관한 추가적인 정보는 아래에서 확인해주세요 

- 월하합작 Spring MVC 프로젝트 
    https://github.com/danaKim-dokyung/Under_the_Moon/blob/master/README.md
