package com.springbootproject.springbootwebservice.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class) //Junit5 테스트 어노테이션
@WebMvcTest(controllers = HelloController.class) //MVC 컨트롤러 테스트
class HelloControllerTest {

    @Autowired
    private MockMvc mvc; //HTTP, GET, POST API 테스트 가능

    @Test
    void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // '/hello' 주소로 HTTP GET 요청
                .andExpect(status().isOk()) //HTTP 응답이 200인지 확인
                .andExpect(content().string(hello)); //응답의 본문이 "hello"인지 확인
    }
}