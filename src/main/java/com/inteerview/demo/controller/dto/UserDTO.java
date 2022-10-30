package com.inteerview.demo.controller.dto;

import com.inteerview.demo.validation.Age;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDTO {

    private String name;
    @Age(minAge = 15)
    private String dateOfBirth;
    @NotBlank
    private String email;
}
