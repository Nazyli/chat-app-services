package com.nazyli.chatappservices.config.socket;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

@Component
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map attributes) {
        ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
//        HttpSession session = servletRequest.getServletRequest().getSession();
        String token = servletRequest.getServletRequest().getParameter("access_token");
        if (token == null || token.trim().isEmpty()) {
            throw new AuthenticationCredentialsNotFoundException("Token was null or empty.");
        }
        attributes.put("access_token", token);
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

    }
}