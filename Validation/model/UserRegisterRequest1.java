//package com.example.validation.model;
//
//import com.fasterxml.jackson.databind.PropertyNamingStrategies;
//import com.fasterxml.jackson.databind.annotation.JsonNaming;
//import jakarta.validation.Valid;
//import jakarta.validation.constraints.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
//public class UserRegisterRequest {
//    @NotBlank
//    private String name;
//
//    @NotBlank
//    @Size(min=1, max = 12) // 1~ 12 자리여야 한다.
//    private String password;
//
//    @Min(1)
//    @Max(100)
//    private Integer age;
//
//    @Email
//    private String email;
//
//    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호가 양식에 맞지 않습니다.")
//    private String phoneNumber;
//
//    @FutureOrPresent
//    private LocalDateTime registerAt;
//}
