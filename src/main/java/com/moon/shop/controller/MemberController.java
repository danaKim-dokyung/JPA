package com.moon.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MemberController {

    @GetMapping("/auth/signupForm")
    public String signupForm(){
        return "signupForm";
    }

    @GetMapping("/auth/signinForm")
    public String signinForm(){
        return "signinForm";
    }

    @GetMapping("/member/updateForm")
    public String updateForm(){
     return "member/updateForm";
    }





}
