package com.ll.basic1.BoundedContext.member.controller;

import com.ll.basic1.BoundedContext.member.entity.Member;
import com.ll.basic1.BoundedContext.member.service.MemberService;
import com.ll.basic1.base.RsData;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member/login")
    @ResponseBody
    public RsData Login(String username, String password, HttpServletResponse resp){
        if( username == null || username.trim().length() == 0 ){
            return RsData.of("F-3", "Username을 입력해주세요");
        }
        if( username == null || password.trim().length() == 0 ){
            return RsData.of("F-4", "password를 입력해주세요");
        }
        RsData tryLoginData= memberService.tryLogin(username,password);
        if(tryLoginData.isSuccess()){
            long memberId  = (long) tryLoginData.getData();
            resp.addCookie(new Cookie("loginedMemberId", memberId+""));
        }
        return tryLoginData;
    }

    @GetMapping("/member/me")
    @ResponseBody
    public RsData showMe(HttpServletRequest req){
        long loginedMemberId = 0;
        if(req.getCookies() == null){
            return RsData.of("F-1", "로그인 후 이용해 주세요!");
        }
        loginedMemberId = Arrays.stream(req.getCookies())
                .filter(cookie -> cookie.getName().equals("loginedMemberId"))
                .map(cookie -> cookie.getValue())
                .mapToInt(Integer::parseInt)
                .findFirst()
                .orElse(0);

        boolean isLogined = loginedMemberId > 0;

        if (isLogined == false)
            return RsData.of("F-1", "로그인 후 이용해주세요.");

        Member member = memberService.findById(loginedMemberId);

        return RsData.of("S-1", "당신의 username(은)는 %s 입니다.".formatted(member.getUsername()));

    }

    @GetMapping("/member/logout")
    @ResponseBody
    public RsData loggout(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getCookies() != null) {
            Arrays.stream(req.getCookies())
                    .filter(e->e.getName().equals("loginedMemberId"))
                    .forEach(e -> {
                        e.setMaxAge(0);
                        resp.addCookie(e);
                    });
        }
        return RsData.of("S-1", "로그아웃되었습니다.");
    }
}