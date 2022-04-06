package com.nazyli.chatappservices.service;

import com.nazyli.chatappservices.dto.UserRequest;
import com.nazyli.chatappservices.entity.MasterUser;
import com.nazyli.chatappservices.repository.MasterUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class MasterUserService {
    @Autowired
    private MasterUserRepository masterUserRepository;

    public MasterUser registerUser(UserRequest req) {

        log.info("registering user {}", req.getUsername());

        if (masterUserRepository.existsByUsername(req.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "username " + req.getUsername() + " already exists");
        }

        if (masterUserRepository.existsByEmail(req.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "email " + req.getEmail() + " already exists");
        }

        MasterUser user = new MasterUser();
        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        user.setPictureUrl(req.getPictureUrl());
        user.setActive(true);
        user.setRoleName("USER");

        return masterUserRepository.save(user);
    }
}
