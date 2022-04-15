package com.nazyli.chatappservices.controller;

import com.nazyli.chatappservices.dto.response.UserConversationResponse;
import com.nazyli.chatappservices.security.services.UserDetailsImpl;
import com.nazyli.chatappservices.service.MasterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class MasterUserController {

    @Autowired
    private MasterUserService service;

    @GetMapping("/findAllUser")
    public ResponseEntity<?> findAllUser(
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok(service
                .findAll()
                .stream()
                .filter(user -> !user.getUserName().equals(userDetails.getUsername()))
                .map(UserConversationResponse::new));
    }


    @GetMapping("/findAllConversation")
    public ResponseEntity<List<UserConversationResponse>> findAllConversation(
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok(service
                .findAllConversation(userDetails.getUserId()));
    }

    @GetMapping("/me")
    public UserConversationResponse getCurrentUser(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return UserConversationResponse
                .builder()
                .userId(userDetails.getUserId())
                .userName(userDetails.getUsername())
                .email(userDetails.getEmail())
                .pictureUrl(userDetails.getPictureUrl())
                .build();
    }
}
