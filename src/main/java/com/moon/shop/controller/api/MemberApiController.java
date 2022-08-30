package com.moon.shop.controller.api;

import com.moon.shop.domain.Member;
import com.moon.shop.dto.ResponseDto;
import com.moon.shop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/joinProc") //회원가입
    public ResponseDto<Integer> save(@RequestBody Member member){
        member.setRoles("ROLE_USER");
        memberService.signup(member);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PutMapping("/api/user/member") //회원 정보 수정
    public ResponseDto<Integer> update(@RequestBody Member member){
        memberService.memberUpdate(member);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @GetMapping("/api/user/member/{id}") //회원 정보 조회
    public Member memberDetail(@PathVariable int id){
        return memberService.memberDetail(id);
    }

    @DeleteMapping("/api/user/member/{id}") //회원 정보 수정
    public ResponseDto<Integer> delete(@PathVariable int id){
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }




}
