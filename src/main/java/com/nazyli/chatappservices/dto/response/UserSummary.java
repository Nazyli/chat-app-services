package com.nazyli.chatappservices.dto.response;

import com.nazyli.chatappservices.entity.MasterUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSummary {
    private String userId;
    private String userName;
    private String email;
    private String pictureUrl;

    public UserSummary(MasterUser user){
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.pictureUrl = user.getPictureUrl();
    }
}
