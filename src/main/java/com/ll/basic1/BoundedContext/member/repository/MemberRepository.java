package com.ll.basic1.BoundedContext.member.repository;


import com.ll.basic1.BoundedContext.member.entity.Member;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
@Getter
public class MemberRepository {
    HashMap<String, String> idPW = new HashMap<>();
    ArrayList<Member> members = new ArrayList<>();

    public MemberRepository(){
        members.add(new Member("user1", "1234"));
        members.add(new Member("abc", "12345"));
        members.add(new Member("test", "12346"));
        members.add(new Member("love", "12347"));
        members.add(new Member("like", "12348"));
        members.add(new Member("giving", "12349"));
        members.add(new Member("thanks", "123410"));
        members.add(new Member("hello", "123411"));
        members.add(new Member("good", "123412"));
        members.add(new Member("peace", "123413"));
    }

    public Member findByUsername(String username) {
        return members.stream()
                .filter(m -> m.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public Member findByid(long id){
        return members.stream()
                .filter(i -> i.getId()==id)
                .findFirst()
                .orElse(null);
    }
}
