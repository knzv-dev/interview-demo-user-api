package com.inteerview.demo.repository;

import com.inteerview.demo.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class H2UserRepository implements UserRepository {

    @Override
    public void save(User user) {

    }

    @Override
    public User findOneByEmail(String email) {
        return null;
    }
}
