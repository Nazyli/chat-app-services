package com.nazyli.chatappservices.repository;

import com.nazyli.chatappservices.dto.response.GroupDateMessageRes;
import com.nazyli.chatappservices.entity.TransChatMessage;
import com.nazyli.chatappservices.util.MessageStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TransChatMessageRepository extends JpaRepository<TransChatMessage, String> {

    long countBySenderIdAndRecipientIdAndStatus(String senderId, String recipientId, MessageStatus status);

    List<TransChatMessage> findByChatRoomIdOrderByCreatedDateAsc(String chatId);

    @Query(value = "SELECT tcm.* FROM trans_chat_message tcm WHERE tcm.chat_room_id = :chatRoomId AND DATE(tcm.created_date) =:chatDate AND tcm.deleted = 0 ORDER BY tcm.created_date ASC", nativeQuery = true)
    List<TransChatMessage> findByCreatedDateAndChatRoomIdOrderByCreatedDateAsc(Date chatDate, String chatRoomId);

    @Query(value = "SELECT tcm.chat_room_id AS chatRoomId, DATE(tcm.created_date) AS messageDate FROM trans_chat_message tcm WHERE " +
            "tcm.chat_room_id =:chatRoomId AND tcm.deleted = 0 GROUP BY DATE(tcm.created_date)", nativeQuery = true)
    List<GroupDateMessageRes> findByChatRoomIdAndGroupByDate(String chatRoomId);

    List<TransChatMessage> findBySenderIdAndRecipientId(String senderId, String recipientId);

    Optional<TransChatMessage> findFirstByChatRoomIdOrderByCreatedDateDesc(String chatId);
}
