package com.ll.basic1.BoundedContext.article.controller;


import com.ll.basic1.BoundedContext.article.entity.Article;
import com.ll.basic1.base.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/write")
    @ResponseBody
    public RsData write(String title, String body) {
        if(title ==null || title.trim().length() == 0)
            return RsData.of("F-1", "title(을)를 입력해주세요.");

        if(body ==null || body.trim().length() == 0)
            return RsData.of("F-2", "body(을)를 입력해주세요.");

        Article createdArticle = articleService.write(title, body);
        return RsData.of("S-1", "%d번 글이 생성되었습니다.".formatted(createdArticle.getId()), createdArticle);
    }
}
