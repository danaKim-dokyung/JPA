package com.moon.shop.config.auth;

import com.moon.shop.domain.member.Member;
import com.moon.shop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*Member principal = memberRepository.findByMemberUsername(username)
                .orElseThrow(()->{
                    return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다");
                });
        return new PrincipalDetail(principal);*/

        Member memberEntity = memberRepository.findByMemberUsername(username);
        return new PrincipalDetail(memberEntity);
    }
}
