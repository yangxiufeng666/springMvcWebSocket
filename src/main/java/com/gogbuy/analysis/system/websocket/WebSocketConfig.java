package com.gogbuy.analysis.system.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by Mr.Yangxiufeng on 2016/5/27.
 * Time:9:40
 * ProjectName:SpringWebApp
 */
//@Configuration
//@EnableWebSocket
//@EnableWebMvc
public class WebSocketConfig implements WebSocketConfigurer{
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(myHandler(),"/myHandler").addInterceptors(new HandshakeInterceptor());
        webSocketHandlerRegistry.addHandler(myHandler(),"/sockjs/myHandler").addInterceptors(new HandshakeInterceptor()).withSockJS();
    }
    @Bean
    public WebSocketHandler myHandler(){
        return new AnalysisWebSocketHandler();
    }
}
