package com.qs.sboot.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;


@Configuration
//通过该注解开启使用STOMP协议来传输基于代理（message broker）的详细，这时控制使用
// @MessageMapping注解就和使用@RequestMapping注解一样；
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/endpointWisely").withSockJS();
        registry.addEndpoint("/endpointChat").withSockJS();
    }


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //广播式配置一个/topic消息处理
        //registry.enableSimpleBroker("/topic");

        //配置点对点式应增加一个/queue消息代理
        //registry.enableSimpleBroker("/queue", "/topic");
    }
}
