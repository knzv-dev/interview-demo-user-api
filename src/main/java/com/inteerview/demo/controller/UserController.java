package com.inteerview.demo.controller;

import com.inteerview.demo.domain.User;
import com.inteerview.demo.controller.dto.SearchRequest;
import com.inteerview.demo.controller.dto.UserDTO;
import com.inteerview.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "user")
    public void createUser(@Validated UserDTO dto) {
        userService.save(convertToModel(dto));
    }

    @GetMapping(value = "user")
    public UserDTO searchUser(SearchRequest request) {
        return convertToDto(userService.search(request.getEmail()));
    }

    private User convertToModel(UserDTO dto) {
        return User.builder()
                .email(dto.getEmail())
                .dateOfBirth(dto.getDateOfBirth())
                .name(dto.getName())
                .build();
    }

    private UserDTO convertToDto(User user) {
        return UserDTO.builder()
                .email(user.getEmail())
                .name(user.getName())
                .dateOfBirth(user.getDateOfBirth())
                .build();
    }
}
