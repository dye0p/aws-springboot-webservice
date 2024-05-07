package com.springbootproject.springbootwebservice.service;

import com.springbootproject.springbootwebservice.domain.posts.Posts;
import com.springbootproject.springbootwebservice.domain.posts.PostsRepository;
import com.springbootproject.springbootwebservice.web.dto.PostsListResponseDto;
import com.springbootproject.springbootwebservice.web.dto.PostsResponseDto;
import com.springbootproject.springbootwebservice.web.dto.PostsSaveRequestDto;
import com.springbootproject.springbootwebservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    //등록
    @Transactional
    public Long save(PostsSaveRequestDto postsSaveRequestDto) {
        return postsRepository.save(postsSaveRequestDto.toEntity()).getId();
    }

    //특정 게시글 조회
    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id =" + id));
        return new PostsResponseDto(posts);
    }

    //수정
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id =" + id));
        //비즈니스 로직 호출
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    //전체 조회
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDese() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());

    }
}

