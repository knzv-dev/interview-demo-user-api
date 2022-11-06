package com.inteerview.demo.controller;

import com.inteerview.demo.domain.User;
import com.inteerview.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration(classes = UserController.class)
class UserControllerIntegTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    public void should_search() throws Exception {
        Mockito.when(userService.search("e@mail.org"))
                .thenReturn(Optional.of(User.builder()
                        .email("e@mail.org")
                        .name("John")
                        .dateOfBirth(LocalDate.of(1967, 12, 12))
                        .build()));

        mockMvc.perform(get("/users?email=e@mail.org")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.dateOfBirth").value("1967-12-12"))
                .andExpect(jsonPath("$.email").value("e@mail.org"));
    }

    @Test
    public void should_save() throws Exception {
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Sam\", \"dateOfBirth\": \"1990-01-01\", \"email\": \"sam@mail.org\"}"))
                .andExpect(status().isOk());

        Mockito.verify(userService).save(User.builder()
                .dateOfBirth(LocalDate.of(1990, 1, 1))
                .name("Sam")
                .email("sam@mail.org")
                .build());
    }

    @Test
    public void should_throw_4xx_exception() throws Exception {
        String json = String.format(
                "{\"name\": \"Sam\", \"dateOfBirth\": \"%s\", \"email\": \"sam@mail.org\"}",
                LocalDate.now().minusYears(14));


        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().is4xxClientError());

        Mockito.verifyNoInteractions(userService);
    }
}