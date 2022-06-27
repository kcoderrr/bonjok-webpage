package com.bonjok.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/commons")
public class CommonController {

    @GetMapping("signin")
    public String signin() {
        return "./commons/signin";
    }

    @PostMapping("signin")
    public String signin(Model model) {
        return "";
    }

}
