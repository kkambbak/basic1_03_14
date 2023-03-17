package com.ll.basic1.BoundedContext.member.article.controller;

import com.ll.basic1.BoundedContext.member.article.entity.Article;
import com.ll.basic1.BoundedContext.member.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public Article write(String title, String body) {
        Article article = Article
                .builder()
                .createDate(LocalDateTime.now())
                .modifyDate(LocalDateTime.now())
                .title(title)
                .body(body)
                .build();

        articleRepository.save(article);
        return article;
    }
}
