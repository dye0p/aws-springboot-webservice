package com.springbootproject.springbootwebservice.web;

import com.springbootproject.springbootwebservice.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") //@RequestParam : 외부에서 "name"이란 이름으로 넘긴 파라미터를 가져옴
                                     String name, //name 변수에 저장
                                     @RequestParam("amount")
                                     int amount) {
        return new HelloResponseDto(name, amount); //받은 값을 생성자로 하여 HelloResponseDto 객체를 새로 생성하여 리턴
    }
}
