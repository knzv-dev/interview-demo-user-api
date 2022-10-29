package com.inteerview.demo.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class User {
    private final String name;
    private final LocalDate dateOfBirth;
    private final String email;
}
