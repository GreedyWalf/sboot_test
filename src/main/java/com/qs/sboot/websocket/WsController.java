package com.qs.sboot.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class WsController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/welCome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws InterruptedException {
        Thread.sleep(3000);
        return new WiselyResponse("Welcome, " + message.getName() + "!");
    }



    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {
        if(principal.getName().equals("admin")){
            //通过SimpMessagingTemplate向浏览器发送消息
            simpMessagingTemplate.convertAndSendToUser("qinyupeng", "/queue/notifications", principal.getName() + "--send:" + msg);
        }else{
            simpMessagingTemplate.convertAndSendToUser("admin", "/queue/notifications", principal.getName() + "--send:" + msg);
        }
    }


}
