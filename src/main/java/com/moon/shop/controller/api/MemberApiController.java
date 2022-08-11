package com.moon.shop.controller.api;

import com.moon.shop.domain.member.Member;
import com.moon.shop.dto.ResponseDto;
import com.moon.shop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberApiController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/joinProc") //회원가입
    public ResponseDto<Integer> save(@RequestBody Member member){
        member.setRoles("ROLE_USER");
        memberService.signup(member);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PutMapping("/member")
    public ResponseDto<Integer> update(@RequestBody Member member){
        memberService.memberUpdate(member);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    /*jwt 테스트*/
    @GetMapping("/api/jwt/member")
    public String member(){
        System.out.println("member");
        return "member";
    }

    @GetMapping("/api/jwt/admin")
    public String admin(){
        return "admin";
    }


}
