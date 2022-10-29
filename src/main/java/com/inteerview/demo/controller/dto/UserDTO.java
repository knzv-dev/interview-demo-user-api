package com.inteerview.demo.controller.dto;

import com.inteerview.demo.validation.Age;
import lombok.Data;

@Data
public class UserDTO {
    private final String name;
    @Age(minAge = 15)
    private final String dateOfBirth;
    private final String email;
}
