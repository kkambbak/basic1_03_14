package com.ll.basic1.BoundedContext.member.service;

import com.ll.basic1.BoundedContext.member.repository.MemberRepository;
import com.ll.basic1.base.RsData;

import java.util.HashMap;

public class MemberService {
    MemberRepository memberRepository = new MemberRepository();

    public RsData tryLogin(String username, String password) {
        if (!password.equals(memberRepository.getMapMember().get(username))) {
            return RsData.of("F-1", "비밀번호가 일치하지 않습니다.");
        } else if (!memberRepository.getMapMember().containsKey(username)){
            return RsData.of("F-2", "%s(은)는 존재하지 않는 회원입니다.".formatted(username));
        }

        return RsData.of("S-1", "%s 님 환영합니다.".formatted(username));
    }


}
