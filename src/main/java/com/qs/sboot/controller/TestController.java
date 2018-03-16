package com.qs.sboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/testA")
    public String testA(){
        return "testA";
    }

    @RequestMapping("/testB")
    public String testB(){
        return "testB";
    }
}
