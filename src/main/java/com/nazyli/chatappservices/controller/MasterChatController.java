package com.nazyli.chatappservices.controller;

import com.nazyli.chatappservices.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest/messages")
public class MasterChatController {
    @Autowired
    private ChatMessageService chatMessageService;

    @GetMapping("findAll")
    public ResponseEntity<?> findChatMessages(@RequestParam String senderId,
                                              @RequestParam String recipientId) {
        return ResponseEntity
                .ok(chatMessageService.findChatMessages(senderId, recipientId));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countNewMessages(
            @RequestParam String senderId,
            @RequestParam String recipientId) {

        return ResponseEntity
                .ok(chatMessageService.countNewMessages(senderId, recipientId));
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        return ResponseEntity
                .ok(chatMessageService.findById(id));
    }
}
