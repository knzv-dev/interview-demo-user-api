package com.inteerview.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Duration;
import java.time.LocalDate;

public class AgeValidator implements ConstraintValidator<Age, String> {

    private int minAge;

    @Override
    public void initialize(Age meta) {
        minAge = meta.minAge();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //todo timezone
        LocalDate curr = LocalDate.parse(value);
        LocalDate now = LocalDate.now();
        Duration diff = Duration.between(curr.atStartOfDay(), now.atStartOfDay());
        long diffDays = diff.toDays() / 365;

        return minAge <= diffDays;
    }
}
