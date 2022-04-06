package com.nazyli.chatappservices.controller;

import com.nazyli.chatappservices.dto.response.UserSummary;
import com.nazyli.chatappservices.security.services.UserDetailsImpl;
import com.nazyli.chatappservices.service.MasterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/rest/users")
public class MasterUserController {

    @Autowired
    private MasterUserService service;

//    @GetMapping("/findAll")
//    public ResponseEntity<?> getAll() {
//        return ResponseEntity.ok(service.findAll());
//    }

    @GetMapping("/summaries")
    public ResponseEntity<?> findAllUserSummaries(
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok(service
                .findAll()
                .stream()
                .filter(user -> !user.getUsername().equals(userDetails.getUsername()))
                .map(UserSummary::new));
    }

    @GetMapping("/me")
    public UserSummary getCurrentUser(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return UserSummary
                .builder()
                .userId(userDetails.getUserId())
                .username(userDetails.getUsername())
                .email(userDetails.getEmail())
                .pictureUrl(userDetails.getPictureUrl())
                .build();
    }


//    @GetMapping("/summaries/{username}")
//    public ResponseEntity<?> getUserSummary(@PathVariable String username) {
//        return service.findByUsername(username)
//                .map(user -> ResponseEntity.ok(new UserSummary(user)))
//                .orElseThrow(() -> new EntityNotFoundException(username));
//    }
}
