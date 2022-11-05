package com.inteerview.demo.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private final String name;
    private final String dateOfBirth;
    private final String email;
}
