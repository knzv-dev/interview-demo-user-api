package com.inteerview.demo.dao;

import com.inteerview.demo.converter.UserConverter;
import com.inteerview.demo.domain.User;
import com.inteerview.demo.repository.H2UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class H2UserDao implements UserDao {

    private final H2UserRepository repository;
    private final UserConverter converter;

    @Override
    public void save(User user) {
        repository.save(converter.toEntity(user));
    }

    @Override
    public Optional<User> findOneByEmail(String email) {
        return repository.findById(email)
                .map(converter::toModel);
    }
}
