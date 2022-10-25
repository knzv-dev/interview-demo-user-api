package com.inteerview.demo.service;

import com.inteerview.demo.domain.User;
import com.inteerview.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User search(String email) {

    }

    @Override
    public void save(User user) {
        repository.save(user);
    }
}
