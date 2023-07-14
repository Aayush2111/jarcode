package com.backend.dao;

import com.backend.entity.UserID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserID, Integer> {

    Optional<UserID> findByName(String name);
}
