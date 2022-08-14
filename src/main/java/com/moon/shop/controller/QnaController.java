package com.moon.shop.controller;

import com.moon.shop.service.QnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class QnaController {

    private final QnaService qnaService;

    @GetMapping("/qna/qnaSaveForm") //문의글 작성 폼 이동
    public String qnaSaveForm(){
        return "qna/qnaSaveForm";
    }

    /*
    @GetMapping("/api/user/qna/qnaList") //문의글 리스트 조회
    public String list(Model model){
        model.addAttribute("qnaList", qnaService.qnaList());
        return "qna/qnaList";
    }

    */

    /*
    @GetMapping("/qna/qnaList/{id}") //문의글 상세 조회
    public String findById(@PathVariable int id, Model model){
        model.addAttribute("qnaDetails", qnaService.qnaDetail(id));
        return "qna/qnaDetail";
    }*/

    @GetMapping("/qna/{id}/updateForm") //문의글 수정 폼 이동
    public String updateForm(@PathVariable int id, Model model){
        model.addAttribute("qna", qnaService.qnaDetail(id));
        return "qna/qnaUpdateForm";
    }




}
