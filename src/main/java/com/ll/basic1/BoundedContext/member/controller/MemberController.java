package com.ll.basic1.BoundedContext.member.controller;

import com.ll.basic1.BoundedContext.member.service.MemberService;
import com.ll.basic1.base.RsData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class MemberController {
    private final MemberService memberService;

    public MemberController() {
        memberService = new MemberService();
    }

    @GetMapping("/member/login")
    @ResponseBody
    public RsData Login(String username, String password){
        if( username == null || username.trim().length() == 0 ){
            return RsData.of("F-3", "Username을 입력해주세요");
        }
        if( username == null || password.trim().length() == 0 ){
            return RsData.of("F-4", "password를 입력해주세요");
        }
        return memberService.tryLogin(username,password);
    }
}