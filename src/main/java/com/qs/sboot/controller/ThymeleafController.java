package com.qs.sboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {
    @RequestMapping(value = "/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name", "Hello Thymeleaf");
        return "/thymeleaf/hello";
    }
}
