package com.inteerview.demo.controller;

import com.inteerview.demo.controller.dto.SearchRequest;
import com.inteerview.demo.controller.dto.UserDTO;
import com.inteerview.demo.domain.User;
import com.inteerview.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController(value = "users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //fixme empty request
    @PostMapping
    public void createUser(@Validated UserDTO dto) {
        userService.save(convertToModel(dto));
    }

    @GetMapping
    public Optional<UserDTO> searchUser(SearchRequest request) {
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
