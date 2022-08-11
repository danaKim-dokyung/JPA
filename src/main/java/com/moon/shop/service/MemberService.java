package com.moon.shop.service;

import com.moon.shop.domain.member.Member;
import com.moon.shop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public void signup(Member member){
        String rawPassword = member.getPassword();
        String encPassword = encoder.encode(rawPassword);
        member.setPassword(encPassword);
        member.setRoles("ROLE_USER");
        memberRepository.save(member);
    }

    @Transactional
    public void memberUpdate(Member member){
        Member persistence = memberRepository.findById(member.getId())
                .orElseThrow(()->{
                    return new IllegalArgumentException("해당 회원을 찾을 수 없습니다");
                });
        //String rawPassword = member.getPassword();
        //String encPassword = encoder.encode(rawPassword);
        //persistence.setPassword(encPassword);
        persistence.setMemberName(member.getMemberName());
        persistence.setMemberPhone(member.getMemberPhone());
    }



}
