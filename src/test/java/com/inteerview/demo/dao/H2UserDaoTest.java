package com.inteerview.demo.dao;

import com.inteerview.demo.converter.UserConverter;
import com.inteerview.demo.domain.User;
import com.inteerview.demo.repository.H2UserRepository;
import com.inteerview.demo.repository.entity.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class H2UserDaoTest {

    @Mock
    private H2UserRepository repository;

    @Spy
    private UserConverter converter;

    @InjectMocks
    private H2UserDao userDao;


    @BeforeEach
    private void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void save() {
        userDao.save(User.builder()
                .email("email")
                .name("name")
                .dateOfBirth(LocalDate.of(1990, 1, 1))
                .build());

        Mockito.verify(repository).save(new UserEntity()
                .setEmail("email")
                .setName("name")
                .setDateOfBirth(LocalDate.of(1990, 1, 1)));
    }

    @Test
    void findOneByEmail() {
        Mockito.when(repository.findById("email"))
                .thenReturn(Optional.of(new UserEntity()
                        .setEmail("email")
                        .setName("name")
                        .setDateOfBirth(LocalDate.of(1990, 1, 1))));

        Optional<User> result = userDao.findOneByEmail("email");

        assertTrue(result.isPresent());

        result.ifPresent(user -> {
            assertEquals("email", user.getEmail());
            assertEquals("name", user.getName());
            assertEquals(LocalDate.of(1990, 1, 1), user.getDateOfBirth());
        });
    }
}