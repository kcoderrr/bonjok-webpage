package com.bonjok.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class CommonController {

    @GetMapping("/signup")
    public String singup() {
        return "view/commons/signup";
    }

    @GetMapping("/signin")
    public String singin() {
        return "view/commons/signin";
    }
}
