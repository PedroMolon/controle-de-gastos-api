package com.pedromolon.controledegastosapi.infrastructure.persistence.repository;

import com.pedromolon.controledegastosapi.infrastructure.persistence.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
    Boolean existsByEmail(String email);
    Boolean existsUserById(Long userId);
}
