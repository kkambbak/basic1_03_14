package com.ll.basic1.BoundedContext.member.article.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Entity
@Builder
@AllArgsConstructor
public class Article {

    @Id //primary key
    @GeneratedValue(strategy = IDENTITY) //Auto increment
    private Long id;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private String title;

    private String body;

}
