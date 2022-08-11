package com.moon.shop.controller.api;


import com.moon.shop.config.auth.PrincipalDetail;
import com.moon.shop.domain.QnaResponse;
import com.moon.shop.domain.member.Member;
import com.moon.shop.domain.qna.Qna;
import com.moon.shop.dto.ResponseDto;
import com.moon.shop.service.MemberService;
import com.moon.shop.service.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@RestController
public class QnaApiController {

    @Autowired
    private QnaService qnaService;

    @PostMapping("/api/user/qna") //문의글 작성
    public ResponseDto<Integer> save(@RequestBody Qna qna, @AuthenticationPrincipal PrincipalDetail principal){
        qnaService.saveQna(qna, principal.getMember());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @DeleteMapping("/api/user/qna/{id}") //문의글 삭제
    public ResponseDto<Integer> deleteById(@PathVariable int id){
        qnaService.deleteById(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PutMapping("/api/user/qna/{id}") //문의글 수정
    public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Qna qna){
        qnaService.updateQna(id,qna);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    //null exception 확인
    @PostMapping("/api/user/qna/{qnaId}/response") //문의글 답변 작성
    public ResponseDto<Integer> responseSave(@PathVariable int qnaId, @RequestBody QnaResponse qnaResponse, @AuthenticationPrincipal PrincipalDetail principal){
        qnaService.saveResponse(principal.getMember(), qnaId, qnaResponse);
        System.out.println(qnaId);
        System.out.println(qnaResponse);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }









}
