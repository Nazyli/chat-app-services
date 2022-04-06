package com.nazyli.chatappservices.controller;

import com.nazyli.chatappservices.dto.UserRequest;
import com.nazyli.chatappservices.service.MasterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class MasterUserController {

    @Autowired
    private MasterUserService service;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody UserRequest req) {
        try {
            service.registerUser(req);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(req.getUsername()).toUri();

        Map<String, Object> output = new HashMap<>();
        output.put("success", true);
        output.put("message", "User registered successfully");
        return ResponseEntity
                .created(location)
                .body(output);
    }
}
