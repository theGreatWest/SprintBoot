package com.example.validation.annotation;

import com.example.validation.validator.PracticeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {PracticeValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface PracticeAnnotation {
    String msg() default "날짜 형식이 올바르지 않습니다. (ex) YYYY-MM-DD";
    String regexp() default "^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}$";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
