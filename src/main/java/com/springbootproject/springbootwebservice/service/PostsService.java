package com.springbootproject.springbootwebservice.service;

import com.springbootproject.springbootwebservice.domain.posts.PostsRepository;
import com.springbootproject.springbootwebservice.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    //회원가입을 하고 회원 PK를 리턴
    @Transactional
    public Long save(PostsSaveRequestDto postsSaveRequestDto) {
        return postsRepository.save(postsSaveRequestDto.toEntity()).getId();
    }
}
