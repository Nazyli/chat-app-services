package com.nazyli.chatappservices.service;

import com.nazyli.chatappservices.entity.MasterChatRoom;
import com.nazyli.chatappservices.repository.MasterChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChatRoomService {
    @Autowired
    MasterChatRoomRepository repository;

    public Optional<String> getChatRoomId(
            String senderId, String recipientId, boolean createRoom) {

        Optional<String> chatRoomId = repository.findBySenderIdAndRecipientId(senderId, recipientId).map(MasterChatRoom::getChatRoomId);
        if (chatRoomId.isEmpty()) {
            if (createRoom) {
                String newChatRoomId =
                        String.format("%s_%s", UUID.randomUUID(), new Date().getTime());

                MasterChatRoom senderRecipient = MasterChatRoom
                        .builder()
                        .chatRoomId(newChatRoomId)
                        .senderId(senderId)
                        .recipientId(recipientId)
                        .build();

                MasterChatRoom recipientSender = MasterChatRoom
                        .builder()
                        .chatRoomId(newChatRoomId)
                        .senderId(recipientId)
                        .recipientId(senderId)
                        .build();
                repository.save(senderRecipient);
                repository.save(recipientSender);

                return Optional.of(newChatRoomId);
            } else {
                return Optional.empty();

            }
        }
        return chatRoomId;
    }
}
