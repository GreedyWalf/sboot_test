package com.qs.sboot.controller;

//import com.mystarter.HelloService;
import com.qs.sboot.controller.entity.AuthorSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @Resource
    private AuthorSetting authorSetting;

    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello(){
        return "hello: name=" + authorSetting.getName() + "; age=" + authorSetting.getAge();
    }

    @RequestMapping(value = "/hello")
    public String hello(HttpServletRequest request, Model model){
        request.setAttribute("msg","helloWorld");
        model.addAttribute("message", "Hello World");
        return "hello";
    }
}
