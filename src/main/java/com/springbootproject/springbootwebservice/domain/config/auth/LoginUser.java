package com.springbootproject.springbootwebservice.domain.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) //메서드의 파라미터로 선언된 객체에만 사용할 수 있음
@Retention(RetentionPolicy.RUNTIME) //어노테이션 클래스로 지정 : @LoginUser 어노테이션이 생성되었다고 생각하면 됨.
public @interface LoginUser {
}
