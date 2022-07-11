package com.bonjok.food.springboot.web;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/mem/")
@Controller
public class MemberController {

    @GetMapping("signin")
    public String signin(Model model) {
        return "/mem/signin";
    }

}
