package com.bonjok.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/commons")
public class CommonController {

    @GetMapping("signin")
    public String signin() {
        return "./commons/signin";
    }


}
