package com.devtrack.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devtrack.backend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}