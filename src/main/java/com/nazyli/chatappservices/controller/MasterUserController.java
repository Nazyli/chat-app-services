package com.nazyli.chatappservices.controller;

import com.nazyli.chatappservices.service.MasterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/users")
public class MasterUserController {

    @Autowired
    private MasterUserService service;

    @GetMapping("/findAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
