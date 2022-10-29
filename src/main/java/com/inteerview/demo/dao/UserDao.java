package com.inteerview.demo.dao;


import com.inteerview.demo.domain.User;

import java.util.Optional;

public interface UserDao {

    void save(User user);

    Optional<User> findOneByEmail(String email);
}
