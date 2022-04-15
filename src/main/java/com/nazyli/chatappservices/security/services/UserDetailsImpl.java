package com.nazyli.chatappservices.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nazyli.chatappservices.entity.MasterUser;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private String userId;

    private String username;

    private String email;

    private String roleName;

    @JsonIgnore
    private String password;

    private boolean active;

    private String pictureUrl;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(String userId, String username, String email, String password, String roleName, boolean active, String pictureUrl,
                           Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.roleName = roleName;
        this.active = active;
        this.pictureUrl = pictureUrl;
    }

    public static UserDetailsImpl build(MasterUser user) {
        List<GrantedAuthority> authorities = new ArrayList<>();

//        String[] listScope = user.getScope().split(",");
//        for (String a : listScope) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + a));
//        }

        authorities.add((new SimpleGrantedAuthority("ROLE_" + user.getRoleName())));
        return new UserDetailsImpl(
                user.getUserId(),
                user.getUserName(),
                user.getEmail(),
                user.getPassword(),
                user.getRoleName(),
                user.isActive(),
                user.getPictureUrl(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
