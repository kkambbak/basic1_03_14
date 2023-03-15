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

        return memberService.tryLogin(username,password);
    }
}