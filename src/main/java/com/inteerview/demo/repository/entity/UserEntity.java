package com.inteerview.demo.repository.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity(name = "USERS")
public class UserEntity {
    @Id
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;
}
