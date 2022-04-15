package com.nazyli.chatappservices.repository;

import com.nazyli.chatappservices.entity.TransChatMessage;
import com.nazyli.chatappservices.util.MessageStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<TransChatMessage, String> {

    long countBySenderIdAndRecipientIdAndStatus(String senderId, String recipientId, MessageStatus status);

    List<TransChatMessage> findByChatRoomIdOrderByCreatedDateAsc(String chatId);

    List<TransChatMessage> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
