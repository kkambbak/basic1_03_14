package com.ll.basic1.BoundedContext.member.service;

import com.ll.basic1.BoundedContext.member.entity.Member;
import com.ll.basic1.BoundedContext.member.repository.MemberRepository;
import com.ll.basic1.base.RsData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

//Component 아래 클래스는 IOC 컨테이너에 의해 생사소멸이 관리된다.
//Service 가독성
@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public RsData tryLogin(String username, String password) {

        Member member = memberRepository.findByUsername(username).orElse(null);
        if (member==null){
            return RsData.of("F-2", "%s(은)는 존재하지 않는 회원입니다.".formatted(username));
        }
        else if (!password.equals(member.getPassword())) {
            return RsData.of("F-1", "비밀번호가 일치하지 않습니다.");
        }
        return RsData.of("S-1", "%s 님 환영합니다.".formatted(username), member);
    }

    public Member findByUsername(String username) {
        return memberRepository.findByUsername(username).orElse(null);
    }


    public Member findById(long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public Member join(String username, String password) {
        Member member = Member.builder()
                .username(username)
                .password(password)
                .build();

        memberRepository.save(member);

        return member;
    }
}
