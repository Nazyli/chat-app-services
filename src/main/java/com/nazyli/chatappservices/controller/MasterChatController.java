package com.nazyli.chatappservices.controller;

import com.nazyli.chatappservices.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("rest/messages")
public class MasterChatController {
    @Autowired
    private ChatMessageService chatMessageService;

//    @GetMapping("findAll")
//    public ResponseEntity<?> findChatMessages(@RequestParam String senderId,
//                                              @RequestParam String recipientId) {
//        return ResponseEntity
//                .ok(chatMessageService.findChatMessages(senderId, recipientId));
//    }

    @GetMapping("/findDateGroup")
    public ResponseEntity<?> findDateGroup(@RequestParam String senderId,
                                           @RequestParam String recipientId) {
        return ResponseEntity.ok(chatMessageService.findByChatRoomIdAndGroupByDate(senderId, recipientId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findChatMessages(@RequestParam String senderId,
                                              @RequestParam String recipientId,
                                              @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") String chatDate) throws ParseException {

        DateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        if (chatDate == null || chatDate.equals("")) {
            chatDate = ft.format(new Date());
        }

        return ResponseEntity
                .ok(chatMessageService.findChatMessages(senderId, recipientId, ft.parse(chatDate)));
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
