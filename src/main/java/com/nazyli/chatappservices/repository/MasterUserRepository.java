package com.nazyli.chatappservices.repository;

import com.nazyli.chatappservices.entity.MasterUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MasterUserRepository extends JpaRepository<MasterUser, String> {
    Page<MasterUser> findAllByUserIdIsNotLikeOrderByCreatedDateAsc(String userId, Pageable pageable);

    Optional<MasterUser> findByUserName(String username);

    boolean existsByEmail(String email);

    boolean existsByUserName(String username);
}
