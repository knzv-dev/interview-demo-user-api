package com.inteerview.demo.dao;

import com.inteerview.demo.domain.User;
import com.inteerview.demo.repository.H2UserRepository;
import com.inteerview.demo.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class H2UserDao implements UserDao {

    private final H2UserRepository repository;

    @Override
    public void save(User user) {
        repository.save(toEntity(user));
    }

    @Override
    public Optional<User> findOneByEmail(String email) {
        return repository.findById(email)
                .map(this::toModel);
    }

    private UserEntity toEntity(User user) {
        return new UserEntity()
                .setDateOfBirth(user.getDateOfBirth())
                .setName(user.getName())
                .setEmail(user.getEmail());
    }

    private User toModel(UserEntity entity) {
        return User.builder()
                .name(entity.getName())
                .dateOfBirth(entity.getDateOfBirth())
                .email(entity.getEmail())
                .build();
    }
}
