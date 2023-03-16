package com.ll.basic1.BoundedContext.member.controller;

import com.ll.basic1.BoundedContext.member.entity.Member;
import com.ll.basic1.BoundedContext.member.service.MemberService;
import com.ll.basic1.base.Rq;
import com.ll.basic1.base.RsData;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;

@Controller
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final Rq rq;

    @PostMapping("/member/login")
    @ResponseBody
    public RsData Login(String username, String password){
        if( username == null || username.trim().length() == 0 ){
            return RsData.of("F-3", "Username을 입력해주세요");
        }
        if( password == null || password.trim().length() == 0 ){
            return RsData.of("F-4", "password를 입력해주세요");
        }
        RsData tryLoginData= memberService.tryLogin(username,password);
        if(tryLoginData.isSuccess()){
            Member member  = (Member)tryLoginData.getData();
            rq.setSession("loginedMemberId", member.getId());
        }
        return tryLoginData;
    }

    @GetMapping("/member/login")
    public String showLogin() {
        return "usr/member/login";
    }

    @GetMapping("/member/me")
    public String showMe(Model model){
        long loginedMemberId = rq.getLoginedMemberId();
        Member member = memberService.findById(loginedMemberId);

        model.addAttribute("member", member);

        return "usr/member/me";
    }

    @GetMapping("/member/logout")
    @ResponseBody
    public RsData logout() {
        boolean cookieRemoved = rq.removeSession("loginedMemberId");

        if (!cookieRemoved) {
            return RsData.of("S-2", "이미 로그아웃 상태입니다.");
        }
        return RsData.of("S-1", "로그아웃 되었습니다.");
    }

    @GetMapping("/member/session")
    @ResponseBody
    public String showSession() {
        return rq.getSessionDebugContents().replaceAll("\n", "<br>");
    }

}