package com.nazyli.chatappservices.controller;

import com.nazyli.chatappservices.dto.request.ChatMessageRequest;
import com.nazyli.chatappservices.dto.response.NotificationResponse;
import com.nazyli.chatappservices.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private ChatMessageService chatMessageService;

    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessageRequest req) {

        NotificationResponse notificationResponse = chatMessageService.save(req);
        messagingTemplate.convertAndSendToUser(
                req.getRecipientId(), "/queue/messages", notificationResponse);
    }
}