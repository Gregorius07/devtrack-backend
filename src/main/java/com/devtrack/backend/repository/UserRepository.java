package com.devtrack.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devtrack.backend.entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmailIgnoreCase(String email);
    Optional<User> findByEmailIgnoreCase(String email);
    Optional<User> findById(Long id);
}