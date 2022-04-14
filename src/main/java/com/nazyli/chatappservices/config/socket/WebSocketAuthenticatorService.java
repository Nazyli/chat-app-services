package com.nazyli.chatappservices.config.socket;

import com.nazyli.chatappservices.security.jwt.JwtUtils;
import com.nazyli.chatappservices.security.services.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

@Component
public class WebSocketAuthenticatorService {
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtUtils jwtUtils;
    private static final Logger logger = LoggerFactory.getLogger(WebSocketAuthenticatorService.class);

    public WebSocketAuthenticatorService(UserDetailsServiceImpl userDetailsService, JwtUtils jwtUtils) {
        this.userDetailsService = userDetailsService;
        this.jwtUtils = jwtUtils;
    }


    // This method MUST return a UsernamePasswordAuthenticationToken instance, the spring security chain is testing it with 'instanceof' later on. So don't use a subclass of it or any other class
    public UsernamePasswordAuthenticationToken getAuthenticatedOrFail(String token) throws AuthenticationException {
        if (token == null || token.trim().isEmpty()) {
            throw new AuthenticationCredentialsNotFoundException("Token was null or empty.");
        }
        UsernamePasswordAuthenticationToken authentication = null;
        try {
            if (jwtUtils.validateJwtToken(token)) {
                String username = jwtUtils.getUserNameFromJwtToken(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource());
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e);
            throw new AuthenticationCredentialsNotFoundException("Cannot set user authentication");
        }
        return authentication;
    }
}