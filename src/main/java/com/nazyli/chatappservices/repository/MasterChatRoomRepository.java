package com.nazyli.chatappservices.repository;

import com.nazyli.chatappservices.entity.MasterChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MasterChatRoomRepository extends JpaRepository<MasterChatRoom, String> {
    Optional<MasterChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);

}
