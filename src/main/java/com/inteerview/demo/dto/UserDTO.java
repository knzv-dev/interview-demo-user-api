package com.inteerview.demo.dto;

import com.inteerview.demo.validation.Age;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private final String name;
    @Age()
    private final String dateOfBirth;
    private final String email;
}
