package com.nazyli.chatappservices.service;

import com.nazyli.chatappservices.entity.ChatRoom;
import com.nazyli.chatappservices.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatRoomService {
    @Autowired
    ChatRoomRepository repository;

    public Optional<String> getChatId(
            String senderId, String recipientId, boolean createIfNotExist) {

        return repository
                .findBySenderIdAndRecipientId(senderId, recipientId)
                .map(ChatRoom::getChatId)
                .or(() -> {
                    if (!createIfNotExist) {
                        return Optional.empty();
                    }
                    var chatId =
                            String.format("%s_%s", senderId, recipientId);

                    ChatRoom senderRecipient = ChatRoom
                            .builder()
                            .chatId(chatId)
                            .senderId(senderId)
                            .recipientId(recipientId)
                            .build();

                    ChatRoom recipientSender = ChatRoom
                            .builder()
                            .chatId(chatId)
                            .senderId(recipientId)
                            .recipientId(senderId)
                            .build();
                    repository.save(senderRecipient);
                    repository.save(recipientSender);

                    return Optional.of(chatId);
                });
    }
}
