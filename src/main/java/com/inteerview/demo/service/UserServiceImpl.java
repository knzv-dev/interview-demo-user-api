package com.inteerview.demo.service;

import com.inteerview.demo.domain.User;
import com.inteerview.demo.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao repository;

    @Override
    public Optional<User> search(String email) {
        return repository.findOneByEmail(email);
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }
}
