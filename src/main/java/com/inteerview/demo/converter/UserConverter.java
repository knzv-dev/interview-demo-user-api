package com.inteerview.demo.converter;

import com.inteerview.demo.controller.dto.UserDTO;
import com.inteerview.demo.domain.User;
import com.inteerview.demo.repository.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserConverter {

    public User toModel(UserDTO dto) {
        return User.builder()
                .email(dto.getEmail())
                .dateOfBirth(LocalDate.parse(dto.getDateOfBirth()))
                .name(dto.getName())
                .build();
    }

    public User toModel(UserEntity entity) {
        return User.builder()
                .name(entity.getName())
                .dateOfBirth(entity.getDateOfBirth())
                .email(entity.getEmail())
                .build();
    }

    public UserDTO toDTO(User user) {
        return new UserDTO()
                .setEmail(user.getEmail())
                .setDateOfBirth(user.getDateOfBirth().toString())
                .setName(user.getName());
    }

    public UserEntity toEntity(User user) {
        return new UserEntity()
                .setDateOfBirth(user.getDateOfBirth())
                .setName(user.getName())
                .setEmail(user.getEmail());
    }

}
