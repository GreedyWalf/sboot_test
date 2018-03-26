package com.qs.sboot.controller;

import com.qs.sboot.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ThymeleafController {
    @RequestMapping(value = "/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name", "Hello Thymeleaf");

        User user = new User();
        user.setUserName("zhangsan");
        user.setEmail("695830237@qq.com");
        model.addAttribute(user);

        User user2 = new User();
        user2.setUserName("lisi");
        user2.setEmail("1234@qq.com");

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        //注意：直接调用addAttribute方法，会默认生成一个name值，实体名称List
        // 即等价于model.addAttribute("userList",userList);
        model.addAttribute(userList);


        Map<String, User> resultMap = new HashMap<>();
        resultMap.put("1111", user);
        resultMap.put("2222", user2);
        model.addAttribute("resultMap", resultMap);
        return "/thymeleaf/hello";
    }
}
