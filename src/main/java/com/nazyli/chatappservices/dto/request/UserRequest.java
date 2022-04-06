package com.nazyli.chatappservices.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String name;
    private String username;
    private String email;
    private String password;
    private String pictureUrl;
}
