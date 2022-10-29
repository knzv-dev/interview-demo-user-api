package com.inteerview.demo.repository;

import com.inteerview.demo.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface H2UserRepository extends JpaRepository<UserEntity, String> {
}
