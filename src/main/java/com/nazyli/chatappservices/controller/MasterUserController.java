package com.nazyli.chatappservices.controller;

import com.nazyli.chatappservices.dto.response.UserSummary;
import com.nazyli.chatappservices.security.services.UserDetailsImpl;
import com.nazyli.chatappservices.service.MasterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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
                .map(UserSummary::new));
    }


    @GetMapping("/findAllConversation")
    public ResponseEntity<?> findAllConversation(
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok(service
                .findAll()
                .stream()
                .filter(user -> !user.getUserName().equals(userDetails.getUsername()))
                .map(UserSummary::new));
    }

    @GetMapping("/me")
    public UserSummary getCurrentUser(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return UserSummary
                .builder()
                .userId(userDetails.getUserId())
                .userName(userDetails.getUsername())
                .email(userDetails.getEmail())
                .pictureUrl(userDetails.getPictureUrl())
                .build();
    }
}
