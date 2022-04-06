package com.nazyli.chatappservices.dto.response;

import com.nazyli.chatappservices.security.services.UserDetailsImpl;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String userId;
    private String username;
    private String email;
    private String token;
    private String roleName;
    private String type = "Bearer";

    public JwtResponse(UserDetailsImpl impl, String token){
        this.userId = impl.getUserId();
        this.username = impl.getUsername();
        this.email = impl.getEmail();
        this.token = token;
        this.roleName = impl.getRoleName();


    }
}