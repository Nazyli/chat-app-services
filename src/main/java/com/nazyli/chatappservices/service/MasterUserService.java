package com.nazyli.chatappservices.service;

import com.nazyli.chatappservices.dto.request.LoginRequest;
import com.nazyli.chatappservices.dto.request.UserRequest;
import com.nazyli.chatappservices.dto.response.JwtResponse;
import com.nazyli.chatappservices.entity.MasterUser;
import com.nazyli.chatappservices.repository.MasterUserRepository;
import com.nazyli.chatappservices.security.jwt.JwtUtils;
import com.nazyli.chatappservices.security.services.UserDetailsImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MasterUserService {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    private MasterUserRepository masterUserRepository;
    @Autowired
    JwtUtils jwtUtils;

    public JwtResponse loginUser(LoginRequest req) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return new JwtResponse(userDetails, jwt);
    }

    public MasterUser registerUser(UserRequest req) {
        log.info("registering user {}", req.getUsername());

        if (masterUserRepository.existsByUserName(req.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "username " + req.getUsername() + " already exists");
        }

        if (masterUserRepository.existsByEmail(req.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "email " + req.getEmail() + " already exists");
        }

        MasterUser user = new MasterUser();
        user.setUserName(req.getUsername());
        user.setEmail(req.getEmail());
        user.setPictureUrl(req.getPictureUrl());
        user.setActive(true);
        user.setPassword(encoder.encode(req.getPassword()));
        user.setRoleName("USER");

        return masterUserRepository.save(user);
    }

    public List<MasterUser> findAll() {
        return masterUserRepository.findAll();
    }

    public Optional<MasterUser> findByUsername(String username) {
        return masterUserRepository.findByUserName(username);
    }
}
