package com.ll.basic1.BoundedContext.member.article.repository;

import com.ll.basic1.BoundedContext.member.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
