package com.nazyli.chatappservices.repository;

import com.nazyli.chatappservices.entity.MasterUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MasterUserRepository extends JpaRepository<MasterUser, String> {
    Optional<MasterUser> findByUserName(String username);

    boolean existsByEmail(String email);

    boolean existsByUserName(String username);
}
