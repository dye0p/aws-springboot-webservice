package com.springbootproject.springbootwebservice.web;

import com.springbootproject.springbootwebservice.service.PostsService;
import com.springbootproject.springbootwebservice.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    //홈
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDese());
        return "index";
    }

    //저장
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    //수정
    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
