package com.example.validation.annotation;

import com.example.validation.validator.PhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {PhoneNumberValidator.class}) // 어떤 클래스로 검증할 것인지 지정
@Target({ElementType.FIELD}) // 어디에 적용할 것인지.
// ElementType.FIELD : 변수에다가만 붙일 것이기 때문에
@Retention(RetentionPolicy.RUNTIME ) // 언제 실행시킬건지
// RetentionPolicy.RUNTIME // 실행할 때만
public @interface PhoneNumber {
    String message() default "핸드폰 번호 양식에 맞지 않습니다. (ex) 000-0000-0000";
    String reqexp() default "^\\d{2,3}-\\d{3,4}-\\d{4}$";

    // @NotNull 을 command+클릭 해서 아래의 두가지 옵션을 복붙한다.
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
