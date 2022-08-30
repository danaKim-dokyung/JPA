package com.moon.shop.service;

import com.moon.shop.domain.Member;
import com.moon.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final BCryptPasswordEncoder encoder;

    @Transactional
    public void signup(Member member){ //회원가입
        String rawPassword = member.getPassword();
        String encPassword = encoder.encode(rawPassword);
        member.setPassword(encPassword);
        member.setRoles("ROLE_USER");
        memberRepository.save(member);
    }

    @Transactional
    public void memberUpdate(Member member){ //회원정보 수정
        Member persistence = memberRepository.findByMemberUsername(member.getMemberUsername())
                /*.orElseThrow(()->{
                    System.out.println(member.getId());
                    return new IllegalArgumentException("해당 회원을 찾을 수 없습니다");
                })*/;
        String rawPassword = member.getPassword();
        String encPassword = encoder.encode(rawPassword);
        persistence.setPassword(encPassword);
        persistence.setMemberName(member.getMemberName());
        persistence.setMemberPhone(member.getMemberPhone());
    }

    public Member memberDetail(int id){
        return memberRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("해당 회원을 찾을 수 없습니다");
        });
    }

    public void memberDelete(int id){
        memberRepository.deleteById(id);
    }



}
