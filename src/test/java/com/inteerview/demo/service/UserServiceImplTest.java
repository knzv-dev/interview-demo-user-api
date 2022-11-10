package com.inteerview.demo.service;

import com.inteerview.demo.dao.UserDao;
import com.inteerview.demo.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

class UserServiceImplTest {

    @Mock
    UserDao userDao;

    @InjectMocks
    UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_call_dao_when_save() {
        //given
        User user = User.builder()
                .dateOfBirth(LocalDate.now())
                .name("name")
                .email("email")
                .build();

        //when
        userService.save(user);

        //then
        Mockito.verify(userDao).save(user);
    }

    @Test
    public void should_call_dao_when_search() {
        //given
        String email = "email";

        //when
        userService.search(email);

        //then
        Mockito.verify(userDao).findOneByEmail(email);
    }
}