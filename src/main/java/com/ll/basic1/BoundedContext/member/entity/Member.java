package com.ll.basic1.BoundedContext.member.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Member {

    @Id // PRIMARY KEY
    @GeneratedValue(strategy = IDENTITY) // AUTO_INCREMENT
    private long id;
    @CreatedDate
    private LocalDateTime createDate; // 데이터 생성 날짜
    @LastModifiedDate
    private LocalDateTime modifyDate; // 데이터 수정 날짜
    @Column(unique = true)
    private String username;
    private String password;

}
