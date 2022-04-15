package com.nazyli.chatappservices.entity;

import com.nazyli.chatappservices.util.MessageStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trans_chat_message")
@Where(clause = "deleted = 0")
public class TransChatMessage {
    @Id
    @Column(name = "trans_message_id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String transMessageId;

    @Column(name = "chat_room_id")
    private String chatRoomId;

    private String senderId;

    private String recipientId;

    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    private boolean deleted;

    @Column(columnDefinition = "ENUM('RECEIVED', 'DELIVERED')")
    @Enumerated(EnumType.STRING)
    private MessageStatus status;

    @PrePersist
    public void prePersist() {
        this.createdDate = new Date();
    }
}
