package com.inteerview.demo.controller;

import com.inteerview.demo.controller.dto.SearchRequestDTO;
import com.inteerview.demo.controller.dto.UserDTO;
import com.inteerview.demo.converter.UserConverter;
import com.inteerview.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping(value = "users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserConverter converter;

    @PostMapping
    public void createUser(@Valid @RequestBody UserDTO dto) {
        userService.save(converter.toModel(dto));
    }

    @GetMapping
    public Optional<UserDTO> searchUser(SearchRequestDTO request) {
        return userService.search(request.getEmail()).map(converter::toDTO);
    }
}
