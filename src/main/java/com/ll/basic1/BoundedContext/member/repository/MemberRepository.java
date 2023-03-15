package com.ll.basic1.BoundedContext.member.repository;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
@Getter
public class MemberRepository {
    HashMap<String, String> mapMember = new HashMap<>();
    public MemberRepository(){
        mapMember.put("user1", "1234");
        mapMember.put("abc", "12345");
        mapMember.put("test", "12346");
        mapMember.put("love", "12347");
        mapMember.put("like", "12348");
        mapMember.put("giving", "12349");
        mapMember.put("thanks", "123410");
        mapMember.put("hello", "123411");
        mapMember.put("good", "123412");
        mapMember.put("peace", "123413");
    }
}
