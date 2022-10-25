package com.inteerview.demo.service;

import com.inteerview.demo.domain.User;

public interface UserService {

    public User search(String email);

    public void save(User user);
}
