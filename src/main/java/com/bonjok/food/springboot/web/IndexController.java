package com.bonjok.food.springboot.web;

import com.bonjok.food.config.auth.LoginUser;
import com.bonjok.food.config.auth.dto.SessionUser;
import com.bonjok.food.springboot.service.posts.PostsService;
import com.bonjok.food.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if(user != null) {
            model.addAttribute("userName",user.getName());
        }
        System.out.println(user);
        return "index";
    }

    @GetMapping("/posts/list")
    public String postsList(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if(user != null) {
            model.addAttribute("userName",user.getName());
        }
        return "posts-list";
    }

    @GetMapping("/posts/save")
    public String postsSave(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if(user != null) {
            model.addAttribute("userName",user.getName());
        }
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model, @LoginUser SessionUser user) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        if(user != null) {
            model.addAttribute("userName",user.getName());
        }
        return "posts-update";
    }


}
