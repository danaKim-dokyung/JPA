package com.moon.shop.repository;

import com.moon.shop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    public Member findByMemberUsername(String memberUsername);

}
