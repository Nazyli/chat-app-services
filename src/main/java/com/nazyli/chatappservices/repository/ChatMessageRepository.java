package com.nazyli.chatappservices.repository;

import com.nazyli.chatappservices.entity.ChatMessage;
import com.nazyli.chatappservices.util.MessageStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, String> {

    long countBySenderIdAndRecipientIdAndStatus(String senderId, String recipientId, MessageStatus status);

    List<ChatMessage> findByChatIdOrderByTimestampAsc(String chatId);

    List<ChatMessage> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
