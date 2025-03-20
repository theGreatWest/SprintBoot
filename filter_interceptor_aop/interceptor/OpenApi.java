package com.example.filter.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.METHOD, ElementType.TYPE}) // ElementType.class 가 없어서 Type 으로 사용
@Retention(RetentionPolicy.RUNTIME)
public @interface OpenApi {


}
