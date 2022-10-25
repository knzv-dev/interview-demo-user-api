package com.inteerview.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Duration;
import java.time.LocalDate;

public class AgeValidator implements ConstraintValidator<Age, String> {

    private int age;

    @Override
    public void initialize(Age annotation) {
        age = annotation.minAge;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //ISO format
        LocalDate date = LocalDate.parse(value);
        //todo timezone
        LocalDate now = LocalDate.now();
        Duration diff = Duration.between(date.atStartOfDay(), now.atStartOfDay());
        long diffDays = diff.toDays();

        return age >= diffDays;
    }
}
