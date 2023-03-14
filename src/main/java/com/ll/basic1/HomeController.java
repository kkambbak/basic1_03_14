package com.ll.basic1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //스프링부트에게 이게 컨트롤러다 라고 알려줌
public class HomeController {
    @GetMapping("/home/main") //home/main 이런 요청이 오면
    @ResponseBody //아래 메서드를 실행 후 리턴값을 응답으로 삼음
    public String showMain(){
        return "안녕하세요.";
    }

    @GetMapping("/home/main2")
    @ResponseBody
    public String showMain2(){
        return "반갑습니다.";
    }

    @GetMapping("/home/main3")
    @ResponseBody
    public String showMain3(){
        return "즐거웠습니다.";
    }
    int num = 0;
    @GetMapping("/home/increase")
    @ResponseBody
    public int showIncrease(){
        return num++;
    }


    @GetMapping("/home/plus")
    @ResponseBody
    //int a 는 쿼리스트링에서 a,b 파라미터의 값을 얻은 후 정수화한 값이어야한다.
    //쿼리스트링은 순서가 없다.
    public int showPlus(@RequestParam(defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b) {
        return a + b;
    }
}
