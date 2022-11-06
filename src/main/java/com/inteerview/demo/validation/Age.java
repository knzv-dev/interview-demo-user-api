package com.inteerview.demo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Retention(RUNTIME)
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {

    String message() default "Invalid age";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int minAge() default 18;
}
