package test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/hello")
    public String hello(Model model){
        model.addAttribute("name", "Hello Thymeleaf");
        return "test";
    }
}
