package com.gogbuy.analysis.system.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by Mr.Yangxiufeng on 2016/6/2.
 * Time:13:52
 * ProjectName:SpringWebApp
 */
@Configuration
@EnableWebSocketMessageBroker
@EnableWebMvc
public class WebSocketBrokerConfig extends AbstractWebSocketMessageBrokerConfigurer{
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //webSocket连接url
        stompEndpointRegistry.addEndpoint("sockjs/portfolio").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        super.configureMessageBroker(registry);
        //这句表示在makePair和queue这两个域上可以向客户端发消息；
        registry.enableSimpleBroker("/makePair","/padMsg","screenMsg");
        //这句表示客户端向服务端发送时的主题上面需要加"/app"作为前缀
        registry.setApplicationDestinationPrefixes("/app");
        //这句表示给指定用户发送（一对一）的主题前缀是“/user/”
        registry.setUserDestinationPrefix("/user");
    }

}
