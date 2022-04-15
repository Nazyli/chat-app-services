package com.nazyli.chatappservices.service;

import com.nazyli.chatappservices.dto.request.LoginRequest;
import com.nazyli.chatappservices.dto.request.UserRequest;
import com.nazyli.chatappservices.dto.response.JwtResponse;
import com.nazyli.chatappservices.dto.response.UserConversationResponse;
import com.nazyli.chatappservices.entity.MasterUser;
import com.nazyli.chatappservices.entity.TransChatMessage;
import com.nazyli.chatappservices.repository.MasterUserRepository;
import com.nazyli.chatappservices.repository.TransChatMessageRepository;
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

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    private TransChatMessageRepository transChatMessageRepository;
    @Autowired
    ChatRoomService chatRoomService;
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

    public List<UserConversationResponse> findAllConversation(String userId) {
        return masterUserRepository.findAllByUserIdIsNotLikeOrderByCreatedDateAsc(userId, null).getContent()
                .stream().map(e -> {
                    UserConversationResponse res = new UserConversationResponse(e);
                    String chatRoomId = chatRoomService.getChatRoomId(userId, e.getUserId(), false).orElse(null);
                    if (chatRoomId != null) {
                        TransChatMessage transChatMessage = transChatMessageRepository.findFirstByChatRoomIdOrderByCreatedDateDesc(chatRoomId).orElse(null);
                        res.setNewMessage(transChatMessage != null ? transChatMessage.getContent() : null);
                        res.setReceivedDate(transChatMessage != null ? transChatMessage.getCreatedDate() : null);
                    }
                    return res;
                }).sorted(Comparator.comparing(UserConversationResponse::getReceivedDate, Comparator.nullsFirst(Date::compareTo)).reversed()).collect(Collectors.toList());
    }

    public List<MasterUser> findAll() {
        return masterUserRepository.findAll();
    }

    public Optional<MasterUser> findByUsername(String username) {
        return masterUserRepository.findByUserName(username);
    }
}
