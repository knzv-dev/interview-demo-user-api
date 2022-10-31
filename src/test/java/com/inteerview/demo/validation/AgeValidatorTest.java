package com.inteerview.demo.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import javax.validation.ConstraintValidatorContext;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

class AgeValidatorTest {

    @ParameterizedTest
    @CsvSource({
            "2018-01-01,2000-01-01,18,true",
            "2018-01-01,2000-01-02,18,false",
            "2015-01-01,2000-01-01,15,true",
            "2015-01-01,2000-01-02,15,false"
    })
    public void should_validate_based_on_date_diff(String currDate, String dateOfBirth, int minAge, boolean expected) {
        var validator = new AgeValidator();

        var annotation = Mockito.mock(Age.class);
        var ctx = Mockito.mock(ConstraintValidatorContext.class);

        Mockito.when(ctx.getClockProvider()).thenReturn(() ->
                Clock.fixed(
                        Instant.parse(String.format("%sT00:00:00.00Z", currDate)),
                        ZoneId.systemDefault()));

        Mockito.when(annotation.minAge()).thenReturn(minAge);

        validator.initialize(annotation);

        //when
        var result = validator.isValid(dateOfBirth, ctx);

        //then
        Assertions.assertEquals(result, expected);
    }


}