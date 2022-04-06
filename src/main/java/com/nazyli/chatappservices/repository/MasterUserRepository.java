package com.nazyli.chatappservices.repository;

import com.nazyli.chatappservices.entity.MasterUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterUserRepository extends JpaRepository<MasterUser, String> {
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
}
