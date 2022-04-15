package com.nazyli.chatappservices.service;

import com.nazyli.chatappservices.dto.request.ChatMessageRequest;
import com.nazyli.chatappservices.dto.response.NotificationResponse;
import com.nazyli.chatappservices.entity.TransChatMessage;
import com.nazyli.chatappservices.entity.MasterUser;
import com.nazyli.chatappservices.repository.ChatMessageRepository;
import com.nazyli.chatappservices.repository.MasterUserRepository;
import com.nazyli.chatappservices.util.MessageStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ChatMessageService {
    @Autowired
    ChatMessageRepository repository;
    @Autowired
    MasterUserRepository masterUserRepository;
    @Autowired
    ChatRoomService chatRoomService;

    public NotificationResponse save(ChatMessageRequest req) {
        String chatRoomId = chatRoomService.getChatId(req.getSenderId(), req.getRecipientId(), true).orElse(null);

        TransChatMessage transChatMessage = new TransChatMessage();
        transChatMessage.setRecipientId(req.getRecipientId());
        transChatMessage.setSenderId(req.getSenderId());
        transChatMessage.setContent(req.getContent());
        transChatMessage.setChatRoomId(chatRoomId);
        transChatMessage.setStatus(MessageStatus.RECEIVED);

        transChatMessage = repository.save(transChatMessage);
        MasterUser masterUser = masterUserRepository.findById(transChatMessage.getSenderId()).orElse(null);
        return new NotificationResponse(
                transChatMessage.getTransMessageId(),
                transChatMessage.getSenderId(),
                masterUser != null ? masterUser.getUserName() : null);
    }

    public long countNewMessages(String senderId, String recipientId) {
        return repository.countBySenderIdAndRecipientIdAndStatus(
                senderId, recipientId, MessageStatus.RECEIVED);
    }

    public List<TransChatMessage> findChatMessages(String senderId, String recipientId) {
        String chatId = chatRoomService.getChatId(senderId, recipientId, false).orElse(null);

        List<TransChatMessage> messages = repository.findByChatRoomIdOrderByCreatedDateAsc(chatId);

        if (messages.size() > 0) {
            updateStatuses(senderId, recipientId, MessageStatus.DELIVERED);
        }

        return messages;
    }

    public TransChatMessage findById(String id) {
        return repository
                .findById(id)
                .map(chatMessage -> {
                    chatMessage.setStatus(MessageStatus.DELIVERED);
                    return repository.save(chatMessage);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "can't find message (" + id + ")"));
    }

    public void updateStatuses(String senderId, String recipientId, MessageStatus status) {
        for (TransChatMessage cm : repository.findBySenderIdAndRecipientId(senderId, recipientId)) {
            cm.setStatus(status);
            repository.save(cm);
        }
    }

}
