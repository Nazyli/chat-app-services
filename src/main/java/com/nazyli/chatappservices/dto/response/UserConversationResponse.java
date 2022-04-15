package com.nazyli.chatappservices.dto.response;

import com.nazyli.chatappservices.entity.MasterUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserConversationResponse {
    private String userId;
    private String userName;
    private String email;
    private String pictureUrl;
    private String newMessage;
    private Date receivedDate;

    public UserConversationResponse(MasterUser user){
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.pictureUrl = user.getPictureUrl();
    }
}
