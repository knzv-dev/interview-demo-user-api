package com.inteerview.demo.repository;


import com.inteerview.demo.domain.User;

public interface UserRepository {

    void save(User user);

    User findOneByEmail(String email);
}
