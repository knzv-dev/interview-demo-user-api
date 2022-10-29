package com.inteerview.demo.validation;

import javax.validation.Constraint;

@Constraint(validatedBy = AgeValidator.class)
public @interface Age {

    int minAge() default 18;
}
