package com.inteerview.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Duration;
import java.time.LocalDate;

public class AgeValidator implements ConstraintValidator<Age, LocalDate> {

    private int minAge;

    @Override
    public void initialize(Age meta) {
        minAge = meta.minAge();
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        //todo timezone
        LocalDate now = LocalDate.now();
        Duration diff = Duration.between(value.atStartOfDay(), now.atStartOfDay());
        long diffDays = diff.toDays();

        return minAge >= diffDays;
    }
}
