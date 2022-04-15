package com.nazyli.chatappservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "master_user")
public class MasterUser {

    public MasterUser(MasterUser user) {
        this.userId = user.userId;
        this.userName = user.userName;
        this.password = user.password;
        this.email = user.email;
        this.createdDate = user.getCreatedDate();
        this.modifiedDate = user.getModifiedDate();
        this.active = user.active;
        this.pictureUrl = user.getPictureUrl();
        this.roleName = user.roleName;
    }

    @Id
    @Column(name = "userId")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String userId;

    private String userName;

    private String password;

    private String email;

    private boolean active;

    private String pictureUrl;

    private String roleName;

    @CreatedDate
    private Date createdDate;

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
