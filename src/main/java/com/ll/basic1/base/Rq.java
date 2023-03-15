package com.ll.basic1.base;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public class Rq {
    private HttpServletRequest req;
    private HttpServletResponse resp;

    public void setCookie(String name, String value){
        resp.addCookie(new Cookie(name+"", value+""));
    }
    public void setCookie(String name, Long value){
        resp.addCookie(new Cookie(name+"", value+""));
    }

    public String getCookie(String name, String value){
        return Arrays.stream(req.getCookies())
                .filter(cookie -> cookie.getName().equals(name))
                .map(Cookie::getValue)
                .findFirst()
                .orElse(value);
    }

    public Long getCookieAsLong(String name, int value){
        return Arrays.stream(req.getCookies())
                .filter(cookie -> cookie.getName().equals(name))
                .map(Cookie::getValue)
                .mapToLong(Long::parseLong)
                .findFirst()
                .orElse((long)value);

    }

    public void removeCookie(String name){
        if (req.getCookies() != null) {
            Arrays.stream(req.getCookies())
                    .filter(e->e.getName().equals("loginedMemberId"))
                    .forEach(e -> {
                        e.setMaxAge(0);
                        resp.addCookie(e);
                    });
        }
    }

}