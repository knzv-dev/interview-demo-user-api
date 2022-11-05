package com.inteerview.demo.controller;

import com.inteerview.demo.controller.dto.SearchRequestDTO;
import com.inteerview.demo.controller.dto.UserDTO;
import com.inteerview.demo.domain.User;
import com.inteerview.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@RequestMapping(value = "users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public void createUser(@Valid @RequestBody UserDTO dto) {
        userService.save(convertToModel(dto));
    }

    @GetMapping
    public Optional<UserDTO> searchUser(SearchRequestDTO request) {
        return userService.search(request.getEmail()).map(this::convertToDto);
    }

    private User convertToModel(UserDTO dto) {
        return User.builder()
                .email(dto.getEmail())
                .dateOfBirth(LocalDate.parse(dto.getDateOfBirth()))
                .name(dto.getName())
                .build();
    }

    private UserDTO convertToDto(User user) {
        return new UserDTO()
                .setEmail(user.getEmail())
                .setDateOfBirth(user.getDateOfBirth().toString())
                .setName(user.getName());
    }
}
