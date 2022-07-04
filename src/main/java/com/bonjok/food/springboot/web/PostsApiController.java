package com.bonjok.food.springboot.web;

import com.bonjok.food.springboot.service.posts.PostsService;
import com.bonjok.food.springboot.web.dto.PostsResponseDto;
import com.bonjok.food.springboot.web.dto.PostsSaveRequestDto;
import com.bonjok.food.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
        //id값에 맞춰서 타이틀 콘텐츠 업데이트.
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }
}
