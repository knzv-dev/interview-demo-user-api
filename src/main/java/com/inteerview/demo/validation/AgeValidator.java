package com.inteerview.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AgeValidator implements ConstraintValidator<Age, String> {

    private int minAge;

    @Override
    public void initialize(Age meta) {
        minAge = meta.minAge();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        var clockProvider = context.getClockProvider();
        var clock = clockProvider.getClock();

        // assuming that we have received data in clock timezone
        LocalDate curr = LocalDate.parse(value);
        LocalDate now = LocalDate.now(clock);
        var diff = ChronoUnit.YEARS.between(curr, now);

        return minAge <= diff;
    }
}
