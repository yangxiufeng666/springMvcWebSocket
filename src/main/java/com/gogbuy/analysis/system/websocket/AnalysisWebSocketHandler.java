package com.gogbuy.analysis.system.websocket;

import org.apache.commons.collections.MapUtils;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by Mr.Yangxiufeng on 2016/5/27.
 * 09
 * 23
 * SpringWebApp
 */
public class AnalysisWebSocketHandler extends TextWebSocketHandler{
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        System.out.println("afterConnectionEstablished");
        String userId = MapUtils.getString(session.getAttributes(),"userId");
        System.out.println("afterConnectionEstablished userId = "+userId);
        WebSocketSessionUtils.add(userId,session);
        TextMessage returnMessage = new TextMessage("Hi everyone:"+userId+" is join,be careful");
        WebSocketSessionUtils.sendMessageToAllTarget(returnMessage);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        super.handleMessage(session, message);
        System.out.println("handleMessage");
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        System.out.println("handleTextMessage");
        String userId = MapUtils.getString(session.getAttributes(),"userId");
        TextMessage returnMessage = new TextMessage("Hi:"+userId+"..your message:"+message.getPayload()+" I have received,now I tell you");
        WebSocketSessionUtils.sendMessageToTarget(userId,returnMessage);
    }

    @Override
    protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
        super.handlePongMessage(session, message);
        System.out.println("handlePongMessage");
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        super.handleTransportError(session, exception);
        System.out.println("handleTransportError");
        String userId = MapUtils.getString(session.getAttributes(),"userId");
        WebSocketSessionUtils.remove(userId);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        System.out.println("afterConnectionClosed");
        String userId = MapUtils.getString(session.getAttributes(),"userId");
        WebSocketSessionUtils.remove(userId);
    }

    @Override
    public boolean supportsPartialMessages() {
        System.out.println("supportsPartialMessages");
        return super.supportsPartialMessages();
    }
}
