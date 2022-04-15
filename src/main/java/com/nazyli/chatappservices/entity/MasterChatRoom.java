package com.nazyli.chatappservices.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "master_chat_room")
@Where(clause = "deleted = 0")
public class MasterChatRoom {
    @Id
    @Column(name = "room_id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String roomId;

    @Column(name = "chat_room_id")
    private String chatRoomId;

    private String senderId;

    private String recipientId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    private boolean deleted;

    @LastModifiedDate
    private Date modifiedDate;

    @PrePersist
    public void prePersist() {
        this.createdDate = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        this.modifiedDate = new Date();
    }
}
