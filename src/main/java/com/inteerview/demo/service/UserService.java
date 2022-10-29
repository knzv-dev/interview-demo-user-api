package com.inteerview.demo.service;

import com.inteerview.demo.domain.User;

import java.util.Optional;

public interface UserService {

    public Optional<User> search(String email);

    public void save(User user);
}
