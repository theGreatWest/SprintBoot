package com.example.validation.model;

import com.example.validation.annotation.PhoneNumber;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {
    private String name;

    private String nickName; // name || nickName 하나라도 있으면 통과 시켜주는 코드

    // 이런 기능의 어노테이션은 존재하지 않기 때문에 function을 만들어 줄 것
    @AssertTrue(message = "name or nickName 은 존재해야 합니다.") // 해당 리턴값이 트루일 때 실행되는 것
    public boolean isNameCheck(){
        if(Objects.nonNull(name) && !name.isBlank()) return true;
        if(Objects.nonNull(nickName) && !nickName.isBlank()) return true;

        return false;
    }

    @NotBlank
    @Size(min=1, max = 12) // 1~ 12 자리여야 한다.
    private String password;

    @Min(1)
    @Max(100)
    private Integer age;

    @Email
    private String email;

    @NotNull
    @PhoneNumber // annotation -> PhoneNumber.interfage 직접 만들어 준 것
//    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호가 양식에 맞지 않습니다.")
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt;
}
