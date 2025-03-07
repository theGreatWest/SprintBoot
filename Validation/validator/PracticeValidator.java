package com.example.validation.validator;

import com.example.validation.annotation.PracticeAnnotation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PracticeValidator implements ConstraintValidator<PracticeAnnotation, String> {
    private String regexp;

    @Override
    public void initialize(PracticeAnnotation constraintAnnotation) {
        this.regexp = constraintAnnotation.regexp();
    }

    // 입력값(value)가 정규식에 부합하는지 판단
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return Pattern.matches(regexp, value);
    }
}
