package com.springbootproject.springbootwebservice.web.dto;

import com.springbootproject.springbootwebservice.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor //매개변수가 없는 기본생성자 생성
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder //클래스에서 생성한 모든 필드를 포함한 생성자가 있어야함
    public PostsSaveRequestDto(String author, String content, String title) {
        this.author = author;
        this.content = content;
        this.title = title;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
