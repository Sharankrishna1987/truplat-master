package com.truplat.usermanagement.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = CountryValidator.class)
public @interface CountryValid {
    String message() default "{error.countryInvalid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
