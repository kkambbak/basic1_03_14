package com.ll.basic1.BoundedContext.member.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member {
    private static long lastid;
    private final long id;
    private final String username;
    private final String password;

    static{
        lastid=0;
    }

    public Member(String username, String password) {
        this(++lastid,username,password);
    }

}
