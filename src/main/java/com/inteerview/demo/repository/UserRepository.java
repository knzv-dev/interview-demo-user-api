package com.inteerview.demo.repository;


import com.inteerview.demo.domain.User;

public interface UserRepository {

    public User search(String email);

    public void save(User user);
}
